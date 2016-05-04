package com.toysforshots.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PageController {

    @RequestMapping("/")
    public String home(){
        return "HelloWorld!";
    }

    @RequestMapping("/buggy-end-point")
    public void buggyEndPointV2() throws Exception {
        throw new IllegalArgumentException();
    }

    @RequestMapping("/buggy-end-point-generic")
    public void buggyEndPoint() throws Exception {
        throw new Exception();
    }
}
