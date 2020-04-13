package com.monster.travel.dao;

import com.monster.travel.domain.Route;

import java.util.List;

public interface RouteDao {

    /**
     * 根据cid 查询总记录数
     *
     * @param cid
     * @return
     */
    public int findTotalCount(int cid);

    /**
     * 根据cid，start,pageSize查询当前页的数据集合
     * @param cid
     * @param start
     * @param pageSize
     * @return
     */
    public List<Route> findByPage(int cid, int start, int pageSize);
}