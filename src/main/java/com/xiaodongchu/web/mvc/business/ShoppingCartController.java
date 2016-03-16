package com.xiaodongchu.web.mvc.business;

import com.xiaodongchu.component.response.RespCode;
import com.xiaodongchu.component.response.RespJSON;
import com.xiaodongchu.entity.business.Order;
import com.xiaodongchu.entity.business.Product;
import com.xiaodongchu.entity.business.ShoppingCart;
import com.xiaodongchu.entity.user.User;
import com.xiaodongchu.service.business.product.OrderService;
import com.xiaodongchu.service.business.product.ShoppingCartService;
import com.xiaodongchu.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by 37343 on 2016/3/16.
 */
@RequestMapping("/sc")
@Controller
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartServiceImpl;
    @Autowired
    private UserService userServiceImpl;
    @Autowired
    private OrderService orderServiceImpl;

    @RequestMapping("/list")
    public String getListByUser(Model model) {
        User user = userServiceImpl.getCurrentUser();
        List<ShoppingCart> shoppingCarts = shoppingCartServiceImpl.getListByUser(user);
        model.addAttribute("list", shoppingCarts);
        return "business/product/shoppingcart/list";
    }

    @RequestMapping("/save")
    @ResponseBody
    public RespJSON<Object> save(Long productId) {
        User user = userServiceImpl.getCurrentUser();
        if(shoppingCartServiceImpl.save(user, productId) > 0) {
            return new RespJSON<>(RespCode.SUCCESS);
        }
        return new RespJSON<>(RespCode.FAIL);
    }

    @RequestMapping("/removeProduct")
    @ResponseBody
    public RespJSON<Object> removeProduct(String productId) {
        User user = userServiceImpl.getCurrentUser();
        if( shoppingCartServiceImpl.removeProduct(user, productId) > 0) {
            return new RespJSON<>(RespCode.SUCCESS);
        }
        return new RespJSON<>(RespCode.FAIL);
    }

    @RequestMapping("/increaseAmount")
    @ResponseBody
    public RespJSON<Object> increaseAmount(String productId,
                                           @RequestParam(value = "productAmount", defaultValue = "1") Integer productAmount) {
        User user = userServiceImpl.getCurrentUser();
        if(shoppingCartServiceImpl.updateAmount(user, productId, productAmount) > 0) {
            return new RespJSON<>(RespCode.SUCCESS);
        }
        return new RespJSON<>(RespCode.FAIL);
    }

    @RequestMapping("/checkout")
    public String checkout(Model model) {
        User user = userServiceImpl.getCurrentUser();
        Order order = shoppingCartServiceImpl.checkout(user);
        if(order == null) {
            throw new RuntimeException("结算失败！");
        }

        model.addAttribute("order", order);
        return "business/product/shoppingcart/pay";
    }

    @RequestMapping("/pay")
    public String checkout(Order orderExample, String pwd) {
        User user = userServiceImpl.getCurrentUser();
        if(orderServiceImpl.pay(user, orderExample , pwd) > 0) {
            return "redirect:/order/list";
        } else {
            return "redirect:list";
        }
    }

}
