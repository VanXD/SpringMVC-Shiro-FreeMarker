package com.xiaodongchu.component.util;

import com.xiaodongchu.vo.page.Page;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2016/3/8.
 */
public class PageUtil {

    /**
     * 获取页总数
     * @param totalCount
     * @param pageSize
     * @return
     */
    public static int getPageCount(int totalCount, int pageSize) {
        int pageCount = (totalCount - 1) / pageSize;
        return pageCount + 1;
    }

    /**
     * 取得带参服务器调用地址 传入参数为name,value键值对的多组或0组数据
     *
     * @Example : getRequestGetUrl(request, "username", username)
     * 或getRequestGetUrl(request, "username", username, "userpass", userpass);
     * @param request
     * @param object
     * @return
     */
    public static String getRequestGetUrl(HttpServletRequest request, Object... object) {

        if (object == null || object.length == 0) {
            return "";
        }
        if (object.length % 2 != 0) {
            throw new RuntimeException("传入参数长度不正确");
        }
        StringBuilder url = new StringBuilder(request.getContextPath()+request.getServletPath());
        // 每次执行取两个数字，所以
        for (int i = 0; i < object.length; i += 2) {
            if (object[i + 1] != null) {
                if (url.indexOf("?") == -1) {
                    url.append("?");
                }
                if (i != object.length - 2) {
                    url.append(object[i]).append("=").append(object[i + 1]).append("&");
                } else {
                    url.append(object[i]).append("=").append(object[i + 1]);
                }
            }
        }
        return url.toString();
    }

    /**
     * 封装分页HTML代码
     *
     * @param page	页数
     * @param url	地址
     *            通过StringUtil.getRequestGetUrl()方式取得的url地址
     * @return	返回数据
     */
    public static String getPageNavBar(Page page, String url) {
        if (url.indexOf("?") == -1) {
            url += "?";
        }
        int len = url.substring(url.indexOf("?") + 1, url.length()).length();
        if (len > 0) {
            url += "&pageNo=";
        } else {
            url += "pageNo=";
        }
        StringBuilder pageToolBarStart = new StringBuilder("<div class='pagination pagination-centered'><ul>");
        StringBuilder pageToolBarEnd = new StringBuilder("</ul></div>");

        pageToolBarStart.append("<li title='首页'><a href='").append(url).append("1").append("&pageSize=")
                .append(page.getPageSize()).append("'>← Previous</a></li>");
        int length = 0;
        int startpage = 0;
        if(page.getPageNo()<=3)
            startpage = 1;
        else if(page.getPageNo()>page.getPageCount()-3)
            startpage = page.getPageCount()-4;
        else
            startpage = page.getPageNo()-2;
        for (int i=startpage; i <= page.getPageCount(); i++) {
            if(length==5)
                break;
            if (i == page.getPageNo()) {
                pageToolBarStart.append("<li class='active'><a>").append(i).append("</a></li>");
            } else {
                pageToolBarStart.append("<li><a href='").append(url).append(i).append("&pageSize=")
                        .append(page.getPageSize()).append("'>").append(i).append("</a></li>");
            }
            length++;
        }
        pageToolBarStart.append("<li title='末页'><a href='").append(url).append(page.getPageCount())
                .append("&pageSize=").append(page.getPageSize()).append("'>Next → </a></li>");
        pageToolBarStart.append(pageToolBarEnd);
        return pageToolBarStart.toString();
    }
}
