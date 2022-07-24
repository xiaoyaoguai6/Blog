package com.liu.blog_admin.controller;

import com.liu.blog_admin.dao.pojo.Permission;
import com.liu.blog_admin.dao.pojo.SysUser;
import com.liu.blog_admin.model.params.PageParam;
import com.liu.blog_admin.service.PermissionService;
import com.liu.blog_admin.service.SysUserService;
import com.liu.blog_admin.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private PermissionService permissionService;
    @Autowired
    private SysUserService sysUserService;

    @PostMapping("sysUser/sysUserList")
    public Result sysUserList(@RequestBody PageParam pageParam){
        return sysUserService.listSysUser(pageParam);
    }

    @GetMapping("sysUser/delete/{id}")
    public Result deleteSysUser(@PathVariable("id") Long id1){
        return sysUserService.delete(id1);
    }

    @PostMapping("sysUser/update")
    public Result update(@RequestBody SysUser sysUser){
        return sysUserService.update(sysUser);
    }

    @PostMapping("sysUser/add")
    public Result add(@RequestBody SysUser sysUser){
        return sysUserService.add(sysUser);
    }

    @PostMapping("permission/permissionList")
    public Result permissionList(@RequestBody PageParam pageParam){
        return permissionService.listPermission(pageParam);
    }

    @PostMapping("permission/add")
    public Result add(@RequestBody Permission permission){
        return permissionService.add(permission);
    }

    @PostMapping("permission/update")
    public Result update(@RequestBody Permission permission){
        return permissionService.update(permission);
    }

    @GetMapping("permission/delete/{id}")
    public Result delete(@PathVariable("id") Long id){
        return permissionService.delete(id);
    }
}
