package com.xiaodongchu.web.mvc.user;

import com.xiaodongchu.entity.Permission;
import com.xiaodongchu.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Administrator on 2016/3/8.
 */
@RequestMapping("/permission")
@Controller
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/list")
    public String list(Model model) {
        List<Permission> permissions = permissionService.findAll();
        model.addAttribute("list", permissions);
        return "business/user/permission/list";
    }
}
