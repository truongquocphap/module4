package com.example.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BController {
    @GetMapping
    public String show(){
        return "list";
    }
}
