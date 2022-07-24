package com.liu.blog2.mapper;

import com.liu.blog2.dao.pojo.Tag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author lwz18
* @description 针对表【ms_tag】的数据库操作Mapper
* @createDate 2022-05-29 17:55:33
* @Entity com.liu.blog2.dao.pojo.Tag
*/
@Mapper
public interface TagMapper extends BaseMapper<Tag> {

    List<Tag> findTagByArticleId(Long id);

    List<Long> findHotsTagIds(int limit);

    List<Tag> findTagsByTagIds(List<Long> hotsTagIds);
}




