package com.xiaodongchu.web.mvc;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AnnotationController {

    @RequestMapping("/hello1")
    public String hello1() {
        SecurityUtils.getSubject().checkRole("admin");
        return "success";
    }

    @RequiresRoles("admin")
    @RequestMapping("/hello2")
    public String hello2() {
        return "success";
    }
}
