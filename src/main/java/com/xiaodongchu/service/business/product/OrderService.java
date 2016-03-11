package com.xiaodongchu.service.business.product;

import com.xiaodongchu.entity.business.Order;
import com.xiaodongchu.vo.business.product.ProductOrderVO;
import com.xiaodongchu.vo.page.Page;

import java.util.List;

/**
 * Created by Administrator on 2016/3/11.
 */
public interface OrderService {

    public List<Order> pageByExample(Order orderExample, Page page);

    public Integer insert (Order order);

    public Integer update (Order order);

    public Integer delete (Order order);

    Order findById(Long id);

    ProductOrderVO detailById(Long orderId);

    Integer deliver(Long orderId);

    public Integer updateOrderStatus(Long orderId, Integer status);
}
