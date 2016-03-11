package com.xiaodongchu.dao.business.product;

import com.xiaodongchu.dao.JdbcDaoSupportAbstract;
import com.xiaodongchu.entity.business.Order;
import com.xiaodongchu.vo.page.Page;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2016/3/10.
 */
@Repository
public class OrderDaoImpl extends JdbcDaoSupportAbstract implements OrderDao {

    @Override
    public List<Order> pageByExample(Order orderExample, Page page) {
        StringBuilder sql = new StringBuilder("SELECT bo.id, bo.order_create_time, bo.order_status, bo.order_receive_address, bo.order_receive_tel, bo.order_express_number, bo.order_total_price FROM b_order bo");
        StringBuilder orderSQL = new StringBuilder(" ORDER BY bo.order_create_time DESC");
        List<Object> params = new LinkedList<>();
        if(page != null) {
            setPageParams(page, sql.toString(), orderSQL, params);
        }
        return getJdbcTemplate().query(sql.append(orderSQL).toString(), params.toArray(), BeanPropertyRowMapper.newInstance(Order.class));
    }

    @Override
    public Integer insert(Order order) {
        String sql = "INSERT INTO b_order (order_create_time, order_status, order_receive_address, order_receive_tel, order_express_number, order_total_price) VALUES(?,?,?,?,?,?)";
        return getJdbcTemplate().update(sql, new Object[]{order.getOrderCreateTime(),
                                             order.getOrderStatus(),
                                             order.getOrderReceiveAddress(),
                                             order.getOrderReceiveTel(),
                                             order.getOrderExpressNumber(),
                                             order.getOrderTotalPrice()});
    }

    @Override
    public Integer update(Order order) {
        String sql = "UPDATE b_order SET order_status = ?, order_receive_address = ?, order_receive_tel = ?, order_express_number = ?, order_total_price = ? WHERE id = ?";
        return getJdbcTemplate().update(sql, new Object[]{order.getOrderStatus(),
                                             order.getOrderReceiveAddress(),
                                             order.getOrderReceiveTel(),
                                             order.getOrderExpressNumber(),
                                             order.getOrderTotalPrice(),
                                             order.getId()});
    }

    @Override
    public Integer delete(Order order) {
        String sql = "DELETE FROM b_order WHERE id = ?";
        return getJdbcTemplate().update(sql, new Object[]{order.getId()});
    }

    @Override
    public Order findById(Long id) {
        String sql = "SELECT bo.id, bo.order_create_time, bo.order_status, bo.order_receive_address, bo.order_receive_tel, bo.order_express_number, bo.order_total_price FROM b_order bo WHERE bo.id=?";
        return getJdbcTemplate().queryForObject(sql, new Object[]{id}, BeanPropertyRowMapper.newInstance(Order.class));
    }
}
