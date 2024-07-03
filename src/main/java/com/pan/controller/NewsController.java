package com.pan.controller;

import com.pan.pojo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/news")
public class NewsController {

    @GetMapping("/list")
    public Result<String> list(){
        return Result.success("所有新闻...");
    }
}
