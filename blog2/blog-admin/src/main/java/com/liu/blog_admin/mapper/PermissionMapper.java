package com.liu.blog_admin.mapper;

import com.liu.blog_admin.dao.pojo.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author lwz18
* @description 针对表【ms_permission】的数据库操作Mapper
* @createDate 2022-07-16 20:21:01
* @Entity com.liu.blog_admin.dao.pojo.Permission
*/
public interface PermissionMapper extends BaseMapper<Permission> {

    List<Permission> findPermissionsByAdminId(Long adminId);
}




