package com.xiaodongchu.service.business.product;

import com.xiaodongchu.dao.business.product.OrderDao;
import com.xiaodongchu.dao.business.product.ProductOrderDao;
import com.xiaodongchu.dao.business.product.ShoppingCartDao;
import com.xiaodongchu.entity.business.Order;
import com.xiaodongchu.entity.business.ProductOrderDetail;
import com.xiaodongchu.entity.business.ShoppingCart;
import com.xiaodongchu.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by 37343 on 2016/3/16.
 */
@Transactional
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    private ShoppingCartDao shoppingCartDaoImpl;
    @Autowired
    private OrderDao orderDaoImpl;
    @Autowired
    private ProductOrderDao productOrderDaoImpl;


    @Override
    public List<ShoppingCart> getListByUser(User user) {
        return shoppingCartDaoImpl.selectListByUser(user);
    }

    @Override
    public Integer save(User user, Long productId) {
        return shoppingCartDaoImpl.insert(user, productId);
    }

    @Override
    public Integer removeProduct(User user, String productId) {
        return shoppingCartDaoImpl.deleteByUserAndProductId(user, productId);
    }

    @Override
    public Integer updateAmount(User user, String productId, Integer productAmountVector) {
        ShoppingCart shoppingCart = shoppingCartDaoImpl.selectByUserIdAndProductId(user.getId(), productId);
        if(shoppingCart.getProductAmount() + productAmountVector < 1) {
            productAmountVector = 0 - shoppingCart.getProductAmount();
        }
        return shoppingCartDaoImpl.updateAmount(shoppingCart, productAmountVector);
    }

    @Override
    public Order checkout(User user) {
        List<ShoppingCart> shoppingCarts = getListByUser(user);
        Order order = new Order();
        order.setOrderCreateTime(new Date());
        order.setOrderStatus(3);
        order.setUsername(user.getUsername());
        order.setUserId(user.getId());
        double totalPrice = 0;
        ProductOrderDetail productOrderDetail = null;
        Order saveOrder = orderDaoImpl.insert(order);
        for(ShoppingCart shoppingCart : shoppingCarts) {
            totalPrice += (shoppingCart.getProductPrice() * shoppingCart.getProductAmount());
            productOrderDetail = new ProductOrderDetail();
            productOrderDetail.setOrderId(order.getId());
            productOrderDetail.setProductId(shoppingCart.getProductId());
            productOrderDetail.setProductAmount(shoppingCart.getProductAmount());
            productOrderDaoImpl.insert(productOrderDetail);
        }
        order.setOrderTotalPrice(totalPrice);
        orderDaoImpl.update(order);
        return saveOrder;
    }
}
