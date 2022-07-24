package com.liu.blog2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liu.blog2.dao.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {

}
