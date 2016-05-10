package com.xiaodongchu.web.mvc.business;

import com.xiaodongchu.entity.business.OrderState;
import com.xiaodongchu.service.business.stat.OrderStatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 37343 on 2016/4/25.
 */
@Controller
@RequestMapping("/orderStat")
public class OrderStatisticsController {
    @Autowired
    private OrderStatService orderStatService;

    @RequestMapping("/stat")
    public String weekStat(Model model) {
        OrderState orderState = orderStatService.orderState();
        model.addAttribute("entity", orderState);
        return "business/stat/list";
    }
}
