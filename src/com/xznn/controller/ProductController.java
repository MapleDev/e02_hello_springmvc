package com.xznn.controller;

import com.xznn.pojo.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ProductController {

    @RequestMapping("/addProduct")
    public ModelAndView addProduct(Product product) {
        ModelAndView mav = new ModelAndView("showProduct");
        return mav;
    }
}
