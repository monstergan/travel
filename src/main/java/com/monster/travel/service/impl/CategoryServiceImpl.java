package com.monster.travel.service.impl;

import com.monster.travel.dao.CategoryDao;
import com.monster.travel.dao.impl.CategoryDaoImpl;
import com.monster.travel.domain.Category;
import com.monster.travel.service.CategoryService;
import com.monster.travel.util.JedisUtil;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CategoryServiceImpl implements CategoryService {
    private CategoryDao dao = new CategoryDaoImpl();

    @Override
    public List<Category> findAll() {
        Jedis jedis = JedisUtil.getJedis();
        //使用sortedset排序查询
        Set<String> categorys = jedis.zrange("category", 0, -1);

        List<Category> cs = null;
        if (categorys == null || categorys.size() == 0) {
            System.out.println("查询的数据库....");
            cs = dao.findAll();
            for (int i = 0; i < cs.size(); i++) {
                jedis.zadd("category", cs.get(i).getCid(), cs.get(i).getCname());
            }
        } else {

            System.out.println("查询的缓存...");
            //如果不为空，将set的数据存入list
            cs = new ArrayList<Category>();
            for (String name : categorys) {
                Category c = new Category();
                c.setCname(name);
                cs.add(c);
            }
        }
        return cs;
    }
}
