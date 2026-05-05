package com.stschool.ecommerce.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class HelloController {

    @GetMapping("/hello")
    public String helloGet(){
        System.out.println("Http Get Request");
        return "Hello World!GET";
    }

    @PostMapping("/hello")
    public String helloPost(){
        System.out.println("Http Post Request");
        return "Hello World! POST";
    }

    @PatchMapping("/hello")
    public String helloPatch(){
        System.out.println("Http Patch Request");
        return "Hello World! PATCH";
    }

    @DeleteMapping("/hello")
    public String helloDelete(){
        System.out.println("Http Delete Request");
        System.out.println("Http Delete Request");
        return "Hello World! DELETE";
    }
}
