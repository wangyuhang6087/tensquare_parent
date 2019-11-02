package com.zhiyou100.util;

import java.util.List;

/**
 * @author:Rain
 * @date 2019/10/31 11:28
 * @desc
 */
public class PageResult<T> {
    private Integer total;
    private List<T> rows;

    public PageResult() {
    }

    public PageResult(Integer total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
