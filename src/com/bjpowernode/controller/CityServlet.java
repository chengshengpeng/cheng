package com.bjpowernode.controller;

import com.bjpowernode.entity.City;
import com.bjpowernode.model.service.CityService;
import com.bjpowernode.model.service.ICityService;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @ProjectName: ssm
 * @Package: com.bjpowernode.controller
 * @Description: java类作用描述
 * @Author: admin
 * @CreateDate: 2020/12/6 14:35
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
//@WebServlet("/city/CityServlet?id=2")
public class CityServlet extends HttpServlet {

    ICityService cityService = new CityService();


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /**
         * 1.接收请求当中的参数
         *
         * 2.调用模型层
         *
         * 3.往作用域放值(reqeust,session)
         *
         * 4.响应用户(请求转发，重定向，下载，json)
         *
         */

        //1.接收请求当中的参数
       String id = req.getParameter("id=");

       //2.调用模型层
        List<City> list = cityService.list();

        //3.往作用域放值(reqeust,session)
        req.setAttribute("list",list);

        // 4.响应用户(请求转发，重定向，下载，json)
        req.getRequestDispatcher("xx.jsp").forward(req,resp);
    }
}
