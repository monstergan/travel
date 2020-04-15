package com.monster.travel.dao;

import com.monster.travel.domain.RouteImg;

import java.util.List;

public interface RouteImgDao {

    /**
     * 根据route的id 查询图片
     * @param rid
     * @return
     */
    public List<RouteImg> findByRid(int rid);
}
