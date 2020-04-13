package com.monster.travel.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.monster.travel.domain.Category;
import com.monster.travel.service.CategoryService;
import com.monster.travel.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/category/*")
public class CategoryServlet extends BaseServlet {

    private CategoryService service = new CategoryServiceImpl();

    public void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Category> list = service.findAll();
        writeValue(list, resp);
    }
}
