package com.xiaodongchu.dao;


import com.xiaodongchu.component.util.PageUtil;
import com.xiaodongchu.vo.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Vanxd on 2016/1/11.
 */
public abstract class JdbcDaoSupportAbstract {
    /**
     * jdbcTemplate
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 设置分页对象
     * @param p 分页对象，包含当前页，和页大小
     * @param sql select count 语句
     * @param orderSQL  order语句
     * @param params  参数列表
     */
    protected void setPageParams(Page p, String sql , StringBuilder orderSQL, List<Object> params) throws DataAccessException {
        String alias = null;
        Pattern pattern = Pattern.compile("^SELECT[\\s\\S\\s]+FROM");
        Matcher matcher = pattern.matcher(sql);
        String selectCountSQL = matcher.replaceAll("SELECT COUNT(1) FROM");

        Integer count = getJdbcTemplate().queryForObject(selectCountSQL, params.toArray(), Integer.class);
        p.setDataCount(count);
        p.setPageCount(PageUtil.getPageCount(count, p.getPageSize()));
        orderSQL.append(" limit ?,?");
        params.add((p.getPageNo() - 1) * p.getPageSize());
        params.add(p.getPageSize());
    }
}