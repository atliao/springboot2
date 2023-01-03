package com.la.springboot.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author LA
 * @date 2022-09-26-10:21
 * 原生组件注入
 * 注入servlet
 * 原生组件注入需要在主程序上添加注解 @ServletComponentScan 进行扫描
 * servlet不会经过spring的拦截器
 */
@WebServlet(urlPatterns = "/myServlet")
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("66666");
    }
}
