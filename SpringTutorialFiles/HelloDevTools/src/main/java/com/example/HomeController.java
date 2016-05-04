package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Value("${homecontroller.msg}")
    private String message;

    @RequestMapping("/")
    public String home(){
        return message;
    }
}
