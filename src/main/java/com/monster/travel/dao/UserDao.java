package com.monster.travel.dao;

import com.monster.travel.domain.User;

public interface UserDao {
    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    public User findByUsername(String username);

    /**
     * 用户保存
     * @param user
     */
    public void save(User user);

    /**
     * 通过code查找用户
     * @param code
     * @return
     */
    User findByCode(String code);

    /**
     * 修改用户激活状态
     * @param user
     */
    void updateStatus(User user);

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    User findByUsernameAndPassword(String username, String password);
}
