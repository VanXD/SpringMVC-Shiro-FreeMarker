package com.xiaodongchu.dao.business.product;

import com.xiaodongchu.entity.business.ShoppingCart;
import com.xiaodongchu.entity.user.User;

import java.util.List;

/**
 * Created by 37343 on 2016/3/16.
 */
public interface ShoppingCartDao {

    public List<ShoppingCart> selectListByUser(User user);

    public Integer insert(User user, Long productId);

    public Integer deleteByUserAndProductId(User user, String productId);

    public Integer updateAmount(ShoppingCart shoppingCart,Integer productVector);

    ShoppingCart selectByUserIdAndProductId(Long userId, String productId);

    Integer clear(User user);
}
