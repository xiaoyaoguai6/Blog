package com.liu.blog2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liu.blog2.dao.pojo.Category;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
}
