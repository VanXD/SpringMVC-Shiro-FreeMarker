package com.xiaodongchu.dao.business.product;

import com.alibaba.druid.util.StringUtils;
import com.xiaodongchu.component.util.DateUtil;
import com.xiaodongchu.dao.JdbcDaoSupportAbstract;
import com.xiaodongchu.entity.business.Order;
import com.xiaodongchu.vo.page.Page;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.InterruptibleBatchPreparedStatementSetter;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2016/3/10.
 */
@Repository
public class OrderDaoImpl extends JdbcDaoSupportAbstract implements OrderDao {

    @Override
    public List<Order> pageByExample(Order orderExample, Page page) {
        StringBuilder sql = new StringBuilder("SELECT bo.id, bo.order_create_time, bo.order_status, bo.order_receive_address, bo.order_receive_tel, bo.order_express_number, bo.order_total_price, su.id userId, su.username FROM b_order bo LEFT JOIN sys_users su ON bo.user_id = su.id");
        StringBuilder orderSQL = new StringBuilder(" ORDER BY bo.order_create_time DESC");
        List<Object> params = new LinkedList<>();
        if(page != null) {
            setPageParams(page, sql.toString(), orderSQL, params);
        }
        return getJdbcTemplate().query(sql.append(orderSQL).toString(), params.toArray(), BeanPropertyRowMapper.newInstance(Order.class));
    }

    @Override
    public Order insert(final Order order) {
        final String sql = "INSERT INTO b_order (order_create_time, order_status, user_id, user_name) VALUES(?,?,?,?)";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        getJdbcTemplate().update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement psst = connection.prepareStatement(sql, new String[]{"id"});
                psst.setString(1, DateUtil.dateToString(order.getOrderCreateTime()));
                psst.setInt(2, order.getOrderStatus());
                psst.setLong(3, order.getUserId());
                psst.setString(4, order.getUsername());
                return psst;
            }
        }, keyHolder);
        order.setId(keyHolder.getKey().longValue());

        return order;
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
        String sql = "SELECT bo.id, bo.order_create_time, bo.order_status, bo.order_receive_address, bo.order_receive_tel, bo.order_express_number, bo.order_total_price, bo.user_id, bo.user_name userName FROM b_order bo WHERE bo.id=?";
        return getJdbcTemplate().queryForObject(sql, new Object[]{id}, BeanPropertyRowMapper.newInstance(Order.class));
    }

    @Override
    public List<Order> selectOrdersByUserId(Long userId, Page page) {
        StringBuilder sql = new StringBuilder("SELECT bo.id, bo.order_create_time, bo.order_status, bo.order_receive_address, bo.order_receive_tel, bo.order_express_number, bo.order_total_price, bo.user_id, bo.user_name userName FROM b_order bo WHERE bo.user_id=?");
        StringBuilder orderSQL = new StringBuilder(" ORDER BY bo.order_create_time DESC");
        List<Object> params = new LinkedList<>();
        params.add(userId);
        if(page != null) {
            setPageParams(page, sql.toString(), orderSQL, params);
        }
        return getJdbcTemplate().query(sql.append(orderSQL).toString(), params.toArray(), BeanPropertyRowMapper.newInstance(Order.class));
    }

    @Override
    public List<Order> selectOrdersByUsername(String username, Page page) {
        StringBuilder sql = new StringBuilder("SELECT bo.id, bo.order_create_time, bo.order_status, bo.order_receive_address, bo.order_receive_tel, bo.order_express_number, bo.order_total_price, bo.user_id, bo.user_name userName FROM b_order bo WHERE bo.user_name=?");
        StringBuilder orderSQL = new StringBuilder(" ORDER BY bo.order_create_time DESC");
        List<Object> params = new LinkedList<>();
        params.add(username);
        if(page != null) {
            setPageParams(page, sql.toString(), orderSQL, params);
        }
        return getJdbcTemplate().query(sql.append(orderSQL).toString(), params.toArray(), BeanPropertyRowMapper.newInstance(Order.class));
    }

    @Override
    public Double countPriceByTime(String dateTime) {
        String sql = "SELECT SUM(order_total_price) from b_order WHERE 1 = 1 AND order_status = 1";
        List<Object> params = new LinkedList<>();
        if(!StringUtils.isEmpty(dateTime)) {
            params.add(dateTime);
            sql += " AND order_create_time >= ?";
        }
        return getJdbcTemplate().queryForObject(sql, params.toArray(), Double.class);
    }

    public Integer countOrderByTime(String dateTime) {
        String sql = "SELECT count(id) from b_order WHERE 1 = 1  AND order_status = 1";
        List<Object> params = new LinkedList<>();
        if(!StringUtils.isEmpty(dateTime)) {
            params.add(dateTime);
            sql += " AND order_create_time >= ?";
        }
        return getJdbcTemplate().queryForObject(sql, params.toArray(), Integer.class);
    }
}
