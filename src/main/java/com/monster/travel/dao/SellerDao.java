package com.monster.travel.dao;

import com.monster.travel.domain.Seller;

public interface SellerDao {

    /**
     * 根据id 查询
     * @param id
     * @return
     */
    public Seller findById(int id);
}
