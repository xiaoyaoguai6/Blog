package com.liu.blog_admin.service;

import com.liu.blog_admin.dao.pojo.Permission;
import com.baomidou.mybatisplus.extension.service.IService;
import com.liu.blog_admin.model.params.PageParam;
import com.liu.blog_admin.vo.Result;

/**
* @author lwz18
* @description 针对表【ms_permission】的数据库操作Service
* @createDate 2022-07-16 20:21:01
*/
public interface PermissionService extends IService<Permission> {

    Result listPermission(PageParam pageParam);

    Result add(Permission permission);

    Result update(Permission permission);

    Result delete(Long id);
}
