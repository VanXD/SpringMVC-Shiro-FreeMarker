package com.xiaodongchu.service.business.product;

import com.xiaodongchu.dao.business.product.ProductDao;
import com.xiaodongchu.entity.business.Product;
import com.xiaodongchu.vo.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2016/3/10.
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductDao productDaoImpl;

    @Override
    public List<Product> pageByExample(Product productExample, Page page) {
        return productDaoImpl.pageByExample(productExample, page);
    }

    @Override
    public Integer save(Product product) {
        product.setProductStatus(0);
        return productDaoImpl.insert(product);
    }

    @Override
    public Integer update(Product product) {
        Product updateProduct = productDaoImpl.findById(product.getId());
        if(updateProduct == null) {
            return 0;
        }
        updateProduct.setProductAvatar(product.getProductAvatar());
        updateProduct.setProductContent(product.getProductContent());
        updateProduct.setProductPrice(product.getProductPrice());
        updateProduct.setProductTitle(product.getProductTitle());
        return productDaoImpl.update(updateProduct);
    }

    @Override
    public Integer delete(Product product) {
        return productDaoImpl.delete(product);
    }

    @Override
    public Product findById(Long id) {
        return productDaoImpl.findById(id);
    }

}
