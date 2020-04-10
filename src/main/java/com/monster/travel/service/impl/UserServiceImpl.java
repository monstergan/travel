package com.monster.travel.service.impl;

import com.monster.travel.dao.UserDao;
import com.monster.travel.dao.impl.UserDaoImpl;
import com.monster.travel.domain.User;
import com.monster.travel.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    /**
     * 注册用户
     * @param user
     * @return
     */
    @Override
    public boolean regist(User user) {
        User u = userDao.findByUsername(user.getUsername());
        if (u != null) {
            //用户名存在,注册失败
            return false;
        }
        userDao.save(user);
        return true;
    }
}
