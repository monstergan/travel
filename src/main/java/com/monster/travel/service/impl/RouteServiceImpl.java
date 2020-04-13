package com.monster.travel.service.impl;

import com.monster.travel.dao.RouteDao;
import com.monster.travel.dao.impl.RouteDaoImpl;
import com.monster.travel.domain.PageBean;
import com.monster.travel.domain.Route;
import com.monster.travel.service.RouteService;

import java.util.List;

public class RouteServiceImpl implements RouteService {

    private RouteDao routeDao = new RouteDaoImpl();

    @Override
    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize) {
        //封装PageBean
        PageBean<Route> pb = new PageBean<>();

        //设置当前码
        pb.setCurrentPage(currentPage);

        //设置每页显示条数
        pb.setPageSize(pageSize);

        //设置总记录数
        int totalCount = routeDao.findTotalCount(cid);
        pb.setTotalCount(totalCount);

        //设置当前页显示的数据集合
        int start = (currentPage - 1) * pageSize;
        List<Route> list = routeDao.findByPage(cid, start, pageSize);
        pb.setList(list);

        //设置总页数 = 总记录数/每页显示条数
        int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : (totalCount / pageSize) + 1;
        pb.setTotalPage(totalPage);


        return pb;
    }
}
