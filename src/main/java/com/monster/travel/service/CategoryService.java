package com.monster.travel.service;

import com.monster.travel.domain.Category;

import java.util.List;

public interface CategoryService {

    /**
     * 查询所有
     * @return
     */
    public List<Category> findAll();
}
