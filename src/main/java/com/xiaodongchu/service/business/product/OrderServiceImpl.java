package com.xiaodongchu.service.business.product;

import com.alibaba.druid.util.StringUtils;
import com.xiaodongchu.dao.business.product.OrderDao;
import com.xiaodongchu.dao.business.product.ProductDao;
import com.xiaodongchu.dao.business.product.ProductOrderDao;
import com.xiaodongchu.dao.user.UserDao;
import com.xiaodongchu.entity.business.Order;
import com.xiaodongchu.entity.business.Product;
import com.xiaodongchu.entity.business.ProductOrderDetail;
import com.xiaodongchu.entity.user.User;
import com.xiaodongchu.service.PasswordHelper;
import com.xiaodongchu.vo.business.product.ProductOrderVO;
import com.xiaodongchu.vo.page.Page;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/3/11.
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderDao orderDaoImpl;
    @Autowired
    private ProductOrderDao productOrderDaoImpl;
    @Autowired
    private ProductDao productDaoImp;
    @Autowired
    private UserDao userDaoImpl;
    @Autowired
    private PasswordHelper passwordHelper;
    @Override
    public List<Order> pageByExample(Order orderExample, Page page) {
        return orderDaoImpl.pageByExample(orderExample, page);
    }

    @Override
    public Order insert(Order order) {
        return orderDaoImpl.insert(order);
    }

    @Override
    public Integer update(Order order) {
        return orderDaoImpl.update(order);
    }

    @Override
    public Integer delete(Order order) {
        return orderDaoImpl.delete(order);
    }

    @Override
    public Order findById(Long id) {
        return orderDaoImpl.findById(id);
    }

    @Override
    public ProductOrderVO detailById(Long orderId) {
        Order order = findById(orderId);
        if(order == null) {
            return null;
        }
        List<ProductOrderDetail> productOrderDetails = productOrderDaoImpl.selectByOrderId(orderId);
        ProductOrderVO productOrderVO = new ProductOrderVO(order, productOrderDetails);
        return productOrderVO;
    }

    @Override
    public Integer deliver(Long orderId) {
        return updateOrderStatus(orderId, 1);
    }

    @Override
    public Integer updateOrderStatus(Long orderId, Integer status) {
        Order order = findById(orderId);
        if(order == null) {
            return 0;
        }
        order.setOrderStatus(status);
        return orderDaoImpl.update(order);
    }

    @Override
    public Order generateOrder(Order order, Long[] productIds) {
        if(StringUtils.isEmpty(order.getUsername())) {
            return null;
        }
        User user = userDaoImpl.findByUsername(order.getUsername());
        if(null == user) {
            return null;
        }
        order.setUserId(user.getId());
        order.setUsername(user.getUsername());
        order.setOrderCreateTime(new Date());
        order.setOrderStatus(3);
        return orderDaoImpl.insert(order);
    }

    @Override
    public Integer checkout(Order order, Long[] productIds, Integer[] productAmount) {
        Order updateOrder = findById(order.getId());
        ProductOrderDetail productOrderDetail = null;
        double totalPrice = 0;
        for(int i = 0;i < productIds.length ;i++) {
            Product product = productDaoImp.findById(productIds[i]);
            if(product != null) {
                totalPrice += (product.getProductPrice() * productAmount[i]);
                productOrderDetail = new ProductOrderDetail();
                productOrderDetail.setOrderId(order.getId());
                productOrderDetail.setProductId(product.getId());
                productOrderDetail.setProductAmount(productAmount[i]);
                productOrderDaoImpl.insert(productOrderDetail);
            }
        }
        updateOrder.setOrderTotalPrice(totalPrice);
        updateOrder.setOrderReceiveAddress(order.getOrderReceiveAddress());
        updateOrder.setOrderReceiveTel(order.getOrderReceiveTel());

        return orderDaoImpl.update(updateOrder);
    }

    @Override
    public void pay(Long orderId, String password) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        String username = (String) subject.getPrincipal();
        User user = userDaoImpl.findByUsername(username);
        User tmpUser = new User();
        tmpUser.setUsername(username);
        tmpUser.setPassword(password);
        tmpUser.setSalt(user.getSalt());
        if(user.getCredentialsSalt().equals(tmpUser.getCredentialsSalt())) {
            System.out.println(1);
        }
        tmpUser.setId(user.getId());
        passwordHelper.encryptPassword(tmpUser, true);
        if(!user.getPassword().equals(tmpUser.getPassword())) {
            throw new RuntimeException("密码不正确！");
        }
        Order order = findById(orderId);
        order.setOrderStatus(4);
        orderDaoImpl.update(order);
    }

}
