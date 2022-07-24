package com.liu.blog2.controller;


import com.liu.blog2.service.SysUserService;
import com.liu.blog2.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {


    @Autowired
    private SysUserService sysuserService;

    @GetMapping("currentUser")
    public Result currentUser(@RequestHeader("Authorization") String token){
        return sysuserService.getUserInfoByToken(token);
    }
}
