package com.liu.blog_admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liu.blog_admin.dao.pojo.Permission;
import com.liu.blog_admin.dao.pojo.SysUser;
import com.liu.blog_admin.model.params.PageParam;
import com.liu.blog_admin.service.SysUserService;
import com.liu.blog_admin.mapper.SysUserMapper;
import com.liu.blog_admin.vo.PageResult;
import com.liu.blog_admin.vo.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author lwz18
* @description 针对表【ms_sys_user】的数据库操作Service实现
* @createDate 2022-07-17 17:19:11
*/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
    implements SysUserService{

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public Result listSysUser(PageParam pageParam) {
        Page<SysUser> page = new Page<>(pageParam.getCurrentPage(),pageParam.getPageSize());
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(pageParam.getQueryString())) {
            queryWrapper.eq(SysUser::getAccount,pageParam.getQueryString());
        }
        Page<SysUser> sysUserPage = this.sysUserMapper.selectPage(page, queryWrapper);
        PageResult<SysUser> pageResult = new PageResult<>();
        pageResult.setList(sysUserPage.getRecords());
        pageResult.setTotal(sysUserPage.getTotal());
        return Result.success(pageResult);
    }

    @Override
    public Result add(SysUser sysUser) {
        this.sysUserMapper.insert(sysUser);
        return Result.success(null);
    }

    @Override
    public Result update(SysUser sysUser) {
        this.sysUserMapper.updateById(sysUser);
        return Result.success(null);
    }

    @Override
    public Result delete(Long id) {
        this.sysUserMapper.deleteById(id);
        return Result.success(null);
    }
}




