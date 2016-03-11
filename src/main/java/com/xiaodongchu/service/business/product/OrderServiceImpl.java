package com.xiaodongchu.service.business.product;

import com.xiaodongchu.dao.business.product.OrderDao;
import com.xiaodongchu.dao.business.product.ProductOrderDao;
import com.xiaodongchu.entity.business.Order;
import com.xiaodongchu.entity.business.ProductOrderDetail;
import com.xiaodongchu.vo.business.product.ProductOrderVO;
import com.xiaodongchu.vo.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public List<Order> pageByExample(Order orderExample, Page page) {
        return orderDaoImpl.pageByExample(orderExample, page);
    }

    @Override
    public Integer insert(Order order) {
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
}
