package com.xiaodongchu.service.business.product;

import com.xiaodongchu.entity.business.Order;
import com.xiaodongchu.entity.business.ShoppingCart;
import com.xiaodongchu.entity.user.User;

import java.util.List;

/**
 * Created by 37343 on 2016/3/16.
 */
public interface ShoppingCartService {

    public List<ShoppingCart> getListByUser(User user);

    public Integer save(User user, Long productId);

    public Integer removeProduct(User user, String productId);

    Integer updateAmount(User user, String productId, Integer productAmountVector);

    Order checkout(User user);
}
