package com.lyd.demo.controller;

import com.lyd.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class SampleController {          //这里出了点问题，是包名的问题 搞定了，但是不太懂原理 跟着视频  和start.spring.io
    //上的结合搞完的百度了好像是controller 目录结构问题
    /*public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }*/

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

@RequestMapping("/test")
    public Map<String,String> testMap(){
        Map<String,String> map = new HashMap<>();
        map.put("name","lyd");
        return map;
    }
    @GetMapping("/testjson")
    public Object testjson(){

        return new User(111,"abc123","10001000",new Date());
    }

@RequestMapping("/test/home")
    public  String home(){
        return "lyd";
}

}
