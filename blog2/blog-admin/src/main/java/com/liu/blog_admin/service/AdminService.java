package com.liu.blog_admin.service;

import com.liu.blog_admin.dao.pojo.Admin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.liu.blog_admin.dao.pojo.Permission;

import java.util.List;

/**
* @author lwz18
* @description 针对表【ms_admin】的数据库操作Service
* @createDate 2022-07-16 20:56:17
*/
public interface AdminService extends IService<Admin> {

    Admin findAdminByUserName(String username);

    List<Permission> findPermissionsByAdminId(Long id);
}
