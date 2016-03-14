package com.xiaodongchu.vo.page;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/3/8.
 */
public class Page implements Serializable{
    private static final long serialVersionUID = 4763104762078097873L;
    private Integer pageNo;
    private Integer pageSize;
    private Integer pageCount;
    private Integer dataCount;

    public Page(Integer pageNo, Integer pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public Page() {
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getDataCount() {
        return dataCount;
    }

    public void setDataCount(Integer dataCount) {
        this.dataCount = dataCount;
    }
}
