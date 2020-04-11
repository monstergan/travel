package com.monster.travel.service.impl;

import com.monster.travel.dao.UserDao;
import com.monster.travel.dao.impl.UserDaoImpl;
import com.monster.travel.domain.User;
import com.monster.travel.service.UserService;
import com.monster.travel.util.MailUtils;
import com.monster.travel.util.UuidUtil;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    /**
     * 注册用户
     *
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
        //保存用户信息
        user.setCode(UuidUtil.getUuid());

        user.setStatus("N");
        userDao.save(user);

        //发送激活邮件
        String content = "<a href='http://localhost/travel/activeUserServlet?code=" + user.getCode() + "'>点击激活【旅游网】</a>";
        MailUtils.sendMail(user.getEmail(), content, "激活邮件");
        return true;
    }

    /**
     * 激活用户
     *
     * @param code
     * @return
     */
    @Override
    public boolean active(String code) {
        User user = userDao.findByCode(code);
        if (user != null) {
            userDao.updateStatus(user);
            return true;
        }else {
            return false;
        }
    }

    /**
     * 登录
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        return userDao.findByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

}
