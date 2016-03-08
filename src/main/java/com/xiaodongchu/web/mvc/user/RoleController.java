package com.xiaodongchu.web.mvc.user;

import com.xiaodongchu.component.response.RespJSON;
import com.xiaodongchu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
