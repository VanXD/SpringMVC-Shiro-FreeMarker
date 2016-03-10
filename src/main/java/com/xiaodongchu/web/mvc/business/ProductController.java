package com.xiaodongchu.web.mvc.business;

import com.xiaodongchu.component.response.RespCode;
import com.xiaodongchu.component.response.RespDataCode;
import com.xiaodongchu.component.response.RespJSON;
import com.xiaodongchu.component.util.PageUtil;
import com.xiaodongchu.entity.business.Product;
import com.xiaodongchu.service.business.product.ProductService;
import com.xiaodongchu.vo.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/3/10.
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productServiceImpl;

    @RequestMapping("/list")
    public String list(HttpServletRequest request, Model model, Product productExample,
                       @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                       @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        Page page = new Page(pageNo, pageSize);
        List<Product> products = productServiceImpl.pageByExample(productExample, page);
        model.addAttribute("list", products);
        String url = PageUtil.getRequestGetUrl(request);
        model.addAttribute("pageNavBar", PageUtil.getPageNavBar(page, url));
        return "business/product/product/list";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public RespJSON<Object> save(Product product) {
        if(productServiceImpl.save(product) > 0) {
            return new RespJSON<>(RespCode.SUCCESS);
        } else {
            return new RespJSON<>(RespDataCode.PRODUCT_SAVE_FAIL);
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public RespJSON<Object> update(Product product) {
        if(productServiceImpl.update(product) > 0) {
            return new RespJSON<>(RespCode.SUCCESS);
        } else {
            return new RespJSON<>(RespDataCode.PRODUCT_UDPATE_FAIL);
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    public RespJSON<Object> delete(Product product) {
        if(productServiceImpl.delete(product) > 0) {
            return new RespJSON<>(RespCode.SUCCESS);
        } else {
            return new RespJSON<>(RespDataCode.PRODUCT_DELETE_FAIL);
        }
    }

    @RequestMapping("/findById")
    @ResponseBody
    public RespJSON<Map> getProductById(Map map, Integer id) {
        Product product = productServiceImpl.findById(id);
        if(product == null) {
            return new RespJSON<>(RespDataCode.PRODUCT_NOT_EXIST);
        } else {
            map.put("product", product);
            return new RespJSON<>(map);
        }
    }
}
