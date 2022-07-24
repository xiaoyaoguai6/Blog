package com.liu.blog2.service;

import com.liu.blog2.dao.pojo.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.liu.blog2.vo.Result;
import com.liu.blog2.vo.UserVo;

/**
* @author lwz18
* @description 针对表【ms_sys_user】的数据库操作Service
* @createDate 2022-05-29 17:55:14
*/
public interface SysUserService extends IService<SysUser> {

    UserVo findUserVoById(Long id);

    SysUser findSysUserById(Long authorId);

    SysUser findUser(String account, String password);

    Result getUserInfoByToken(String token);

    SysUser findUserByAccount(String account);

    @Override
    boolean save(SysUser sysUser);
}
