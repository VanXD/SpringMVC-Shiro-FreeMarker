package com.xiaodongchu.entity.business;

import java.util.Date;

/**
 * Created by Administrator on 2016/3/10.
 */
public class Order {
    private Long id;
    private Date orderCreateTime;
    /**
     * 0：新，1：发货 2：完成 3：待付款 4：已付款
     */
    private Integer orderStatus;
    private String orderReceiveAddress;
    private String orderReceiveTel;
    private String orderExpressNumber;
    private Double orderTotalPrice;
    private Long userId;
    private String username;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
