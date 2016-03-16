package com.xiaodongchu.dao.business.product;

import com.alibaba.druid.util.StringUtils;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.deser.std.NumberDeserializers;
import com.xiaodongchu.dao.JdbcDaoSupportAbstract;
import com.xiaodongchu.entity.business.ShoppingCart;
import com.xiaodongchu.entity.user.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Created by 37343 on 2016/3/16.
 */
@Repository
public class ShoppingCartDaoImpl extends JdbcDaoSupportAbstract implements ShoppingCartDao {


    @Override
    public List<ShoppingCart> selectListByUser(User user) {
        StringBuilder sql = new StringBuilder("SELECT bsc.id, bsc.user_id, bsc.username, bsc.product_id, bsc.product_amount, bsc.create_time ,bp.product_price, bp.product_title FROM b_shoping_cart bsc LEFT JOIN b_product bp ON bsc.product_id = bp.id WHERE 1 = 1");
        String orderSQL = " ORDER BY bsc.create_time DESC";
        List<Object> params = new LinkedList<>();
        if(user.getId() != null) {
            sql.append(" AND bsc.user_id = ?");
            params.add(user.getId());
        } else if (!StringUtils.isEmpty(user.getUsername())) {
            sql.append(" AND bsc.username = ?");
            params.add(user.getUsername());
        }
        return getJdbcTemplate().query(sql.append(orderSQL).toString(), params.toArray(), BeanPropertyRowMapper.newInstance(ShoppingCart.class));
    }

    @Override
    public Integer insert(User user, Long productId) {
        String sql = "INSERT INTO b_shoping_cart (user_id, username, product_id, product_amount, create_time) VALUES (?,?,?,?,?)";
        if(!exists(user.getId(), productId)) {
            return getJdbcTemplate().update(sql, new Object[]{user.getId(), user.getUsername(), productId, 1, new Date()});
        }
        return 0;
    }

    private boolean exists(Long userId, Long productId) {
        String sql = "SELECT COUNT(1) FROM b_shoping_cart WHERE user_id = ? AND product_id = ?";
        return getJdbcTemplate().queryForObject(sql, new Object[]{userId, productId}, Integer.class) > 0;
    }


    @Override
    public Integer deleteByUserAndProductId(User user, String productId) {
        String sql = "DELETE FROM b_shoping_cart WHERE user_id = ? AND product_id = ?";
        return getJdbcTemplate().update(sql, new Object[]{user.getId(), productId});
    }

    @Override
    public Integer updateAmount(ShoppingCart shoppingCart, Integer productVector) {
        String sql = "UPDATE b_shoping_cart SET product_amount = product_amount + ? WHERE user_id = ? AND product_id = ?";
        return getJdbcTemplate().update(sql, new Object[]{productVector, shoppingCart.getUserId(), shoppingCart.getProductId()});
    }

    @Override
    public ShoppingCart selectByUserIdAndProductId(Long userId, String productId) {
        String sql = "SELECT bsc.id, bsc.user_id, bsc.username, bsc.product_id, bsc.product_amount, bsc.create_time, bp.product_price, bp.product_title FROM b_shoping_cart bsc LEFT JOIN b_product bp ON bsc.product_id = bp.id WHERE bsc.user_id = ? AND bsc.product_id = ?";
        return getJdbcTemplate().queryForObject(sql, new Object[]{userId, productId}, BeanPropertyRowMapper.newInstance(ShoppingCart.class));
    }

    @Override
    public Integer clear(User user) {
        String sql = "DELETE FROM b_shoping_cart WHERE user_id = ?";
        return getJdbcTemplate().update(sql, new Object[]{user.getId()});
    }
}
