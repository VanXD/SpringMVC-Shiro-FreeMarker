package com.xiaodongchu.dao.business.product;

import com.xiaodongchu.dao.JdbcDaoSupportAbstract;
import com.xiaodongchu.entity.business.ProductOrderDetail;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2016/3/11.
 */
@Repository
public class ProductOrderDaoImpl extends JdbcDaoSupportAbstract implements ProductOrderDao {
    @Override
    public List<ProductOrderDetail> selectByOrderId(Long orderId) {
        StringBuilder sql = new StringBuilder("SELECT bpo.id, bp.id productId, bp.product_title, bp.product_avatar, bp.product_price, bpo.product_amount, bpo.order_id FROM b_product_order bpo LEFT JOIN b_product bp ON bpo.product_id = bp.id LEFT JOIN b_order bo ON bpo.order_id = bo.id WHERE bpo.order_id = ?");
        StringBuilder orderSQL = new StringBuilder(" ORDER BY bp.product_create_time DESC");
        List<Object> params = new LinkedList<>();
        params.add(orderId);
        return getJdbcTemplate().query(sql.append(orderSQL).toString(), params.toArray(), BeanPropertyRowMapper.newInstance(ProductOrderDetail.class));
    }

    @Override
    public Integer insert(ProductOrderDetail productOrderDetail) {
        String sql = "INSERT INTO b_product_order (product_id, product_amount, order_id) VALUES (?,?,?)";
        return getJdbcTemplate().update(sql, productOrderDetail.getProductId(), productOrderDetail.getProductAmount(), productOrderDetail.getOrderId());
    }
}
