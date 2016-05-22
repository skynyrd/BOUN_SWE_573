package com.bounfoodcoop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class NavigationViewController {

    public NavigationViewController() {
    }

    @RequestMapping("/about")
    public String about(){
        return "views/about";
    }

    @RequestMapping("/contact")
    public String contact(){
        return "views/contact";
    }
}
