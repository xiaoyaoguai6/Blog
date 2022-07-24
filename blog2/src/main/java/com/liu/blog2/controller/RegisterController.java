package com.liu.blog2.controller;


import com.liu.blog2.service.LoginService;
import com.liu.blog2.vo.Result;
import com.liu.blog2.vo.params.LoginParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("register")
public class RegisterController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public Result Register(@RequestBody LoginParams loginParams){

        return loginService.register(loginParams);
    }


}
