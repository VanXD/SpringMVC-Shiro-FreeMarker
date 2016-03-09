package com.xiaodongchu.web.mvc.user;

import com.xiaodongchu.component.response.RespCode;
import com.xiaodongchu.component.response.RespJSON;
import com.xiaodongchu.entity.Role;
import com.xiaodongchu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by Administrator on 2016/3/8.
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/list")
    @ResponseBody
    public RespJSON list(Map<String, Object> map) {
        map.put("list", roleService.list());
        return new RespJSON(map);
    }

    @RequestMapping("/listModel")
    public String listModel(Model model) {
        model.addAttribute("list", roleService.list());
        return "business/user/role/list";
    }

    @RequestMapping("/save")
    @ResponseBody
    public RespJSON<Object> save(Role role) throws UnsupportedEncodingException {
        roleService.createRole(role);
        return new RespJSON<>(RespCode.SUCCESS);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public RespJSON<Object> delete(Role role) {
        roleService.deleteRole(role.getId());
        return new RespJSON<>(RespCode.SUCCESS);
    }
}
