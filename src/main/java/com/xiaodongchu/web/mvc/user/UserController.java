package com.xiaodongchu.web.mvc.user;

import com.xiaodongchu.component.response.RespCode;
import com.xiaodongchu.component.response.RespDataCode;
import com.xiaodongchu.component.response.RespJSON;
import com.xiaodongchu.component.util.PageUtil;
import com.xiaodongchu.entity.user.User;
import com.xiaodongchu.service.user.UserService;
import com.xiaodongchu.vo.page.Page;
import com.xiaodongchu.vo.page.vo.user.UserRoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *
 * Created by wyd on 2016/3/3.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 进入登陆界面
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping("/correlationRoles")
    @ResponseBody
    public RespJSON<Object> correlationRoles(Long userId, Long[] roleIds) {
        if(roleIds == null || roleIds.length < 1) {
            return new RespJSON<>(RespDataCode.USER_ROLE_CHOOSE);
        }
        userService.correlationRoles(userId, roleIds);
        return new RespJSON<>(RespCode.SUCCESS);
    }

    @RequestMapping("/uncorrelationRoles")
    @ResponseBody
    public RespJSON<Object> unCorrelationRoles(Long userId, Long[] roleIds) {
        if(roleIds == null || roleIds.length < 1) {
            return new RespJSON<>(RespDataCode.USER_ROLE_CHOOSE);
        }
        userService.uncorrelationRoles(userId, roleIds);
        return new RespJSON<>(RespCode.SUCCESS);
    }


    @RequestMapping("/roleList")
    public String list(HttpServletRequest request, Model model,User userExample,
                       @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                       @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        Page page = new Page(pageNo, pageSize);
        List<UserRoleVO> userRoleVOList =  userService.roleList(userExample, page);
        model.addAttribute("list", userRoleVOList);
        String url = PageUtil.getRequestGetUrl(request);
        model.addAttribute("pageNavBar", PageUtil.getPageNavBar(page, url));
        return "user/user/user_role";
    }


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "user/user/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(User user) {
        userService.createUser(user);
        return "redirect:/index";
    }
}
