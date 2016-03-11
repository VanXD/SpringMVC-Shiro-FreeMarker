package com.xiaodongchu.dao.business.product;

import com.xiaodongchu.entity.business.ProductOrderDetail;

import java.util.List;

/**
 * Created by Administrator on 2016/3/11.
 */
public interface ProductOrderDao {

    public List<ProductOrderDetail> selectByOrderId(Long orderId);
}
