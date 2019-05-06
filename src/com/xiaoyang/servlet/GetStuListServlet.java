package com.xiaoyang.servlet;

import com.xiaoyang.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xiaoyang
 * @version v1.0
 * @date 2019/3/15/0015 23:36
 * @description TODO
 **/
@WebServlet(urlPatterns = "/getStuListServlet")
public class GetStuListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取数据
        //处理数据
        UserServiceImpl service = new UserServiceImpl();
        String str = service.queryAll();
        //响应数据
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println(str);

    }
}