package com.xiaodongchu.service.business.stat;

import com.xiaodongchu.entity.business.Order;
import com.xiaodongchu.entity.business.OrderState;
import com.xiaodongchu.service.business.product.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by 37343 on 2016/4/25.
 */
@Service
@Transactional
public class OrderStatService {
    @Autowired
    private OrderService orderService;

    public OrderState orderState() {
        Map day = getWeekDay();
        Calendar cal = Calendar.getInstance();

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-01 00:00:00");
        Date now = new Date();
        String month = df.format(now.getTime());
        OrderState orderState = new OrderState();
        Double weekTotal = orderService.getPriceCountByTime((String) day.get("mon"));
        Double monthTotal = orderService.getPriceCountByTime(month);
        Double total = orderService.getPriceCountByTime(null);
        Integer weekOrderCount = orderService.getOrderCountByTime((String) day.get("mon"));
        Integer monthOrderCount = orderService.getOrderCountByTime(month);
        Integer totalOrderCount = orderService.getOrderCountByTime(null);
        orderState.setWeekPrice(weekTotal);
        orderState.setMonthPrice(monthTotal);
        orderState.setTotalPrice(total);
        orderState.setWeekOrderCount(weekOrderCount);
        orderState.setMonthOrderCount(monthOrderCount);
        orderState.setTotalOrderCount(totalOrderCount);
        return orderState;
    }

    private double getTotalPrice(List<Order> currentWeekOrders) {
        double total = 0;
        for(Order order : currentWeekOrders) {
            total += order.getOrderTotalPrice();
        }
        return total;
    }

    public static Map getWeekDay() {
        Map<String,String> map = new HashMap<String,String>();
        Calendar cal =Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY); //获取本周一的日期
        map.put("mon", df.format(cal.getTime()));
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        cal.add(Calendar.WEEK_OF_YEAR, 1);
        map.put("sun", df.format(cal.getTime()));
        return map;
    }
}
