package com.xiaodongchu.dao.business.product;

import com.xiaodongchu.entity.business.Product;
import com.xiaodongchu.vo.page.Page;

import java.util.List;

/**
 * Created by Administrator on 2016/3/10.
 */
public interface ProductDao {

    public List<Product> pageByExample(Product productExample, Page page);

    public Integer insert (Product product);

    public Integer update (Product product);

    public Integer delete (Product product);

    Product findById(Integer id);
}
