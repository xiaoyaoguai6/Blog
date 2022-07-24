package com.liu.blog2.service;

import com.liu.blog2.dao.pojo.SysUser;
import com.liu.blog2.vo.Result;
import com.liu.blog2.vo.params.LoginParams;
import org.springframework.stereotype.Service;

public interface LoginService  {

    Result login(LoginParams loginParams);

    Result logout(String token);

    Result register(LoginParams loginParams);

    SysUser checkToken(String token);
}
