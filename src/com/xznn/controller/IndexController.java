package com.xznn.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexController implements Controller {

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        ModelAndView mav = new ModelAndView("index.jsp");
//        mav.addObject("message", "Hello Spring MVC");
//        return mav;

//        request.setAttribute("message", "Hello Spring MVC 2");
//        request.getRequestDispatcher("index.jsp").forward(request, response);
//        return null;

        ModelAndView mav = new ModelAndView("index");
        mav.addObject("message", "Hello Spring MVC 3");
        return mav;
    }

}
