package com.xiaodongchu.vo.business.product;

import java.util.Date;

/**
 * Created by Administrator on 2016/3/10.
 */
public class ProductOrderVO {
    private Long id;
    private Long orderId;
    private Date orderCreateTime;
    private Integer orderStatus;
    private String orderReceiveAddress;
    private String orderReceiveTel;
    private String orderExpressNumber;
    private Double orderTotalPrice;
    private Integer productId;
    private Integer productAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getOrderCreateTime() {
        return orderCreateTime;
    }

    public void setOrderCreateTime(Date orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderReceiveAddress() {
        return orderReceiveAddress;
    }

    public void setOrderReceiveAddress(String orderReceiveAddress) {
        this.orderReceiveAddress = orderReceiveAddress;
    }

    public String getOrderReceiveTel() {
        return orderReceiveTel;
    }

    public void setOrderReceiveTel(String orderReceiveTel) {
        this.orderReceiveTel = orderReceiveTel;
    }

    public String getOrderExpressNumber() {
        return orderExpressNumber;
    }

    public void setOrderExpressNumber(String orderExpressNumber) {
        this.orderExpressNumber = orderExpressNumber;
    }

    public Double getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(Double orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(Integer productAmount) {
        this.productAmount = productAmount;
    }
}
