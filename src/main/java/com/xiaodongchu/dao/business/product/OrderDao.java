package com.xiaodongchu.dao.business.product;

import com.xiaodongchu.entity.business.Order;
import com.xiaodongchu.vo.page.Page;

import java.util.List;

/**
 * Created by Administrator on 2016/3/10.
 */
public interface OrderDao {

    public List<Order> pageByExample(Order orderExample, Page page);

    public Integer insert (Order order);

    public Integer update (Order order);

    public Integer delete (Order order);

    Order findById(Long id);
}