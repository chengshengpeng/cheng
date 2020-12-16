package com.bjpowernode.controller;

import com.alibaba.fastjson.JSONObject;
import com.bjpowernode.entity.City;
import com.bjpowernode.model.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.util.List;

/**
 * @ProjectName: ssm
 * @Package: com.bjpowernode.controller
 * @Description: java类作用描述
 * @Author: admin
 * @CreateDate: 2020/12/16 9:56
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Controller
public class ObjectController {



    @Autowired
    private ICityService iCityService;


    @RequestMapping("/objectTest01")
    public void objectTest01(HttpServletResponse response) throws IOException {
        List<City> cities = iCityService.list();

        String citiesJson = JSONObject.toJSONString(cities);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println(citiesJson);
    }


    @RequestMapping("/objectTest02")
    public @ResponseBody List<City> objectTest02(HttpServletResponse response) throws IOException {
        List<City> cities = iCityService.list();
       return cities;
    }


    @RequestMapping("/objectTest03")
    public String objectTest03(HttpServletRequest request, Model model, ModelMap modelMap) throws IOException {

        //也是往request中放入值
        //model.addAttribute("","");
        //modelMap.addAttribute("","");
        List<City> cities = iCityService.list();
        request.setAttribute("cities",cities);
        return "../province";
    }


    @RequestMapping("/jsonToObject04")
    public void jsonToObject04(@RequestBody City city){
        System.out.println(city);
    }

}
