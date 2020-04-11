package com.monster.travel.web.servlet;

import com.monster.travel.service.UserService;
import com.monster.travel.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/activeUserServlet")
public class ActiveUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取激活码
        String code = req.getParameter("code");

        if (code != null) {
            //调用service完成激活
            UserService service = new UserServiceImpl();
            boolean flag = service.active(code);

            String msg = null;
            if (flag) {
                msg = "激活成功，请<a href='login.html'>登录</a>";
            } else {
                msg = "激活失败，请联系管理员.....";
            }
            resp.setContentType("text/html; charset=UTF-8");
            resp.getWriter().write(msg);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
