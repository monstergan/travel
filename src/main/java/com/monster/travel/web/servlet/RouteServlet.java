package com.monster.travel.web.servlet;

import com.monster.travel.domain.PageBean;
import com.monster.travel.domain.Route;
import com.monster.travel.service.RouteService;
import com.monster.travel.service.impl.RouteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/route/*")
public class RouteServlet extends BaseServlet {
    private RouteService routeService = new RouteServiceImpl();


    /**
     * 分页查询
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void pageQuery(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受参数
        String currentPageStr = req.getParameter("currentPage");
        String pageSizeStr = req.getParameter("pageSize");
        String cidStr = req.getParameter("cid");

        //处理参数
        int cid = 0;
        if (cidStr != null && cidStr.length() > 0) {
            cid = Integer.parseInt(cidStr);
        }

        //当前页码  如果不传递，则默认第一页
        int currentPage = 0;
        if (currentPageStr != null && currentPageStr.length() > 0) {
            currentPage = Integer.parseInt(currentPageStr);
        } else {
            currentPage = 1;
        }

        //每页显示条数 如果不传递 默认每页显示5条
        int pageSize = 0;
        if (pageSizeStr != null && pageSizeStr.length() > 0) {
            pageSize = Integer.parseInt(pageSizeStr);
        } else {
            pageSize = 5;
        }


        //调用Service查询PageBean对象
        PageBean<Route> pb = routeService.pageQuery(cid, currentPage, pageSize);

        //将pageBean对象序列化为json 返回
        writeValue(pb, resp);
    }
}
