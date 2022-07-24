package com.liu.blog2.mapper;

import com.liu.blog2.dao.pojo.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author lwz18
* @description 针对表【ms_sys_user】的数据库操作Mapper
* @createDate 2022-05-29 17:55:14
* @Entity com.liu.blog2.dao.pojo.SysUser
*/
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

}




