package com.xiaodongchu.entity.business;

import java.util.List;

/**
 * Created by 37343 on 2016/4/25.
 */
public class OrderState {
    private Double weekPrice;
    private Integer weekOrderCount;
    private Double monthPrice;
    private Integer monthOrderCount;
    private Double totalPrice;
    private Integer totalOrderCount;

    public Integer getWeekOrderCount() {
        return weekOrderCount;
    }

    public void setWeekOrderCount(Integer weekOrderCount) {
        this.weekOrderCount = weekOrderCount;
    }

    public Integer getMonthOrderCount() {
        return monthOrderCount;
    }

    public void setMonthOrderCount(Integer monthOrderCount) {
        this.monthOrderCount = monthOrderCount;
    }

    public Integer getTotalOrderCount() {
        return totalOrderCount;
    }

    public void setTotalOrderCount(Integer totalOrderCount) {
        this.totalOrderCount = totalOrderCount;
    }

    public Double getWeekPrice() {
        return weekPrice;
    }

    public void setWeekPrice(Double weekPrice) {
        this.weekPrice = weekPrice;
    }

    public Double getMonthPrice() {
        return monthPrice;
    }

    public void setMonthPrice(Double monthPrice) {
        this.monthPrice = monthPrice;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
