package com.xiaodongchu.web.mvc.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/3/7.
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index() {
        return "api/index/index";
    }
}
