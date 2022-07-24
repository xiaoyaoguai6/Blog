package com.liu.blog_admin.service;

import com.liu.blog_admin.dao.pojo.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.liu.blog_admin.model.params.PageParam;
import com.liu.blog_admin.vo.Result;

/**
* @author lwz18
* @description 针对表【ms_sys_user】的数据库操作Service
* @createDate 2022-07-17 17:19:11
*/
public interface SysUserService extends IService<SysUser> {

    Result listSysUser(PageParam pageParam);

    Result add(SysUser sysUser);

    Result update(SysUser sysUser);

    Result delete(Long id);

}
