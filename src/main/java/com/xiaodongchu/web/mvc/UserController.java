package com.xiaodongchu.web.mvc;

import com.xiaodongchu.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * Created by wyd on 2016/3/3.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, User userExample) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userExample.getUsername(), userExample.getPassword());
        try {
            subject.login(usernamePasswordToken);
        } catch (UnknownAccountException e) {
            model.addAttribute("error", "用户名/密码错误");
            return "login";
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("error", "用户名/密码错误");
            return "login";
        } catch (AuthenticationException e) {
            model.addAttribute("error", "其他错误" + e.getMessage());
            return "login";
        }
        return "success";
    }

    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public String success() {
        return "success";
    }
}
