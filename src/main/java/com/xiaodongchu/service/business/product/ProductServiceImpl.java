package com.xiaodongchu.service.business.product;

import com.xiaodongchu.dao.business.product.ProductDao;
import com.xiaodongchu.entity.business.Product;
import com.xiaodongchu.vo.page.Page;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2016/3/10.
 */
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductDao productDaoImpl;

    @Override
    public List<Product> pageByExample(Product productExample, Page page) {
        return productDaoImpl.pageByExample(productExample, page);
    }

    @Override
    public Integer insert(Product product) {
        return productDaoImpl.insert(product);
    }

    @Override
    public Integer update(Product product) {
        return productDaoImpl.update(product);
    }

    @Override
    public Integer delete(Product product) {
        return productDaoImpl.delete(product);
    }
}
