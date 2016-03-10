package com.xiaodongchu.dao.business.product;

import com.xiaodongchu.dao.JdbcDaoSupportAbstract;
import com.xiaodongchu.entity.business.Product;
import com.xiaodongchu.vo.page.Page;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2016/3/10.
 */
@Repository
public class ProductDaoImpl extends JdbcDaoSupportAbstract implements ProductDao {
    @Override
    public List<Product> pageByExample(Product productExample, Page page) {
        StringBuilder sql = new StringBuilder("SELECT bp.id, bp.product_create_time, bp.product_status, bp.product_title, bp.product_content, bp.product_avatar, bp.product_price FROM b_product bp");
        StringBuilder orderSQL = new StringBuilder(" ORDER BY bp.product_create_time DESC");
        List<Object> params = new LinkedList<>();
        if(page != null) {
            setPageParams(page, sql.toString(), orderSQL, params);
        }
        return getJdbcTemplate().query(sql.append(orderSQL).toString(), params.toArray(), BeanPropertyRowMapper.newInstance(Product.class));
    }

    @Override
    public Integer insert(Product product) {
        String sql = "INSERT INTO b_product (product_create_time, product_status, product_title, product_content, product_avatar, product_price) VALUES(?,?,?,?,?,?)";
        return getJdbcTemplate().update(sql, new Object[]{new Date(), product.getProductStatus(), product.getProductTitle(), product.getProductContent(), product.getProductAvatar(), product.getProductPrice()});
    }

    @Override
    public Integer update(Product product) {
        String sql = "UPDATE b_product SET product_status = ?, product_title = ?, product_content = ?, product_avatar = ?, product_price = ? WHERE id = ?";
        return getJdbcTemplate().update(sql, new Object[]{product.getProductStatus(), product.getProductTitle(), product.getProductAvatar(), product.getProductPrice(), product.getId()});
    }

    @Override
    public Integer delete(Product product) {
        String sql = "DELETE FROM b_product WHERE id = ?";
        return getJdbcTemplate().update(sql, new Object[]{product.getId()});
    }
}
