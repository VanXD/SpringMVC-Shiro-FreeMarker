package com.xiaodongchu.web.mvc.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * Created by wyd on 2016/3/3.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 进入登陆界面
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }
}
