package com.xiaodongchu.vo.business.product;

import com.xiaodongchu.entity.business.Order;
import com.xiaodongchu.entity.business.ProductOrderDetail;

import java.util.List;

/**
 * Created by Administrator on 2016/3/10.
 */
public class ProductOrderVO {
    private Order order;
    private List<ProductOrderDetail> productOrderDetails;

    public ProductOrderVO(Order order, List<ProductOrderDetail> productOrderDetails) {
        this.order = order;
        this.productOrderDetails = productOrderDetails;
    }

    public ProductOrderVO() {
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<ProductOrderDetail> getProductOrderDetails() {
        return productOrderDetails;
    }

    public void setProductOrderDetails(List<ProductOrderDetail> productOrderDetails) {
        this.productOrderDetails = productOrderDetails;
    }
}
