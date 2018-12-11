package com.example.demo.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/")
public class IndexController {

    @RequestMapping("hello")
    @ResponseBody
    public String index() {
        return "helloworld";
    }

}
