package com.monster.travel.dao.impl;

import com.monster.travel.dao.RouteDao;
import com.monster.travel.domain.Route;
import com.monster.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class RouteDaoImpl implements RouteDao {

    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public int findTotalCount(int cid) {
        String sql = "select count(*) from tab_route where cid = ?";

        return template.queryForObject(sql, Integer.class, cid);
    }

    @Override
    public List<Route> findByPage(int cid, int start, int pageSize) {
        String sql = "select * from tab_route where cid = ? limit ? , ?";

        return template.query(sql, new BeanPropertyRowMapper<Route>(Route.class), cid, start, pageSize);
    }
}
