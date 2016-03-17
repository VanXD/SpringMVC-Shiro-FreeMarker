package com.xiaodongchu.entity.business;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.xiaodongchu.component.json.CustomDateSerializer;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by wyd on 2016/3/11.
 */
public class Product implements Serializable{

    private static final long serialVersionUID = -2582759665686539196L;
    private Long id;
    private Date productCreateTime;
    private Integer productStatus;
    private String productTitle;
    private String productContent;
    private String productAvatar;
    private Double productPrice;
    private Integer productStock;
    private Integer productSales;
    private String productBrand;
    private String productModel;
    @JsonSerialize(using = CustomDateSerializer.class)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date productPublicTime;
    private Double productWeight;
    private Float productWorkingTemperature;

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel;
    }

    public Date getProductPublicTime() {
        return productPublicTime;
    }

    public void setProductPublicTime(Date productPublicTime) {
        this.productPublicTime = productPublicTime;
    }

    public Double getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(Double productWeight) {
        this.productWeight = productWeight;
    }

    public Float getProductWorkingTemperature() {
        return productWorkingTemperature;
    }

    public void setProductWorkingTemperature(Float productWorkingTemperature) {
        this.productWorkingTemperature = productWorkingTemperature;
    }

    public Integer getProductStock() {
        return productStock;
    }

    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }

    public Integer getProductSales() {
        return productSales;
    }

    public void setProductSales(Integer productSales) {
        this.productSales = productSales;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getProductCreateTime() {
        return productCreateTime;
    }

    public void setProductCreateTime(Date productCreateTime) {
        this.productCreateTime = productCreateTime;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getProductContent() {
        return productContent;
    }

    public void setProductContent(String productContent) {
        this.productContent = productContent;
    }

    public String getProductAvatar() {
        return productAvatar;
    }

    public void setProductAvatar(String productAvatar) {
        this.productAvatar = productAvatar;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductStatus() {
        return productStatus;
    }
}
