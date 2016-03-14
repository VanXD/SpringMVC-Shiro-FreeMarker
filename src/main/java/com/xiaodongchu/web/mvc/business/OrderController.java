package com.xiaodongchu.web.mvc.business;

import com.xiaodongchu.component.response.RespCode;
import com.xiaodongchu.component.response.RespJSON;
import com.xiaodongchu.component.util.PageUtil;
import com.xiaodongchu.entity.business.Order;
import com.xiaodongchu.service.business.product.OrderService;
import com.xiaodongchu.vo.business.product.ProductOrderVO;
import com.xiaodongchu.vo.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/3/11.
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderServiceImpl;

    @RequestMapping("/list")
    public String list(HttpServletRequest request, Model model, Order orderExample,
            @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize){
        Page page = new Page(pageNo, pageSize);
        List<Order> orders = orderServiceImpl.pageByExample(orderExample, page);
        model.addAttribute("list",orders);
        String url = PageUtil.getRequestGetUrl(request);
        model.addAttribute("pageNavBar", PageUtil.getPageNavBar(page, url));
        return "business/product/order/list";
    }

    @RequestMapping("/detailById")
    @ResponseBody
    public RespJSON<Map> detailById(Map map, Long orderId) {
        ProductOrderVO productOrderVO = orderServiceImpl.detailById(orderId);
        if(null == productOrderVO) {
            return new RespJSON<>(RespCode.FAIL);
        } else {
            map.put("orderDetail", productOrderVO);
            return new RespJSON<>(map);
        }
    }

    @RequestMapping("/deliver")
    @ResponseBody
    public RespJSON<Map> deliver(Long orderId) {
        if(orderServiceImpl.deliver(orderId) < 1) {
            return new RespJSON<>(RespCode.FAIL);
        } else {
            return new RespJSON<>(RespCode.SUCCESS);
        }
    }

    @RequestMapping("/buy")
    public void buy(Order order, String[] productIds, Integer[] productAmount) {
        orderServiceImpl.generateOrder(productIds, productAmount);
    }
}
