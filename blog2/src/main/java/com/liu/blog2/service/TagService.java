package com.liu.blog2.service;

import com.liu.blog2.dao.pojo.Tag;
import com.baomidou.mybatisplus.extension.service.IService;
import com.liu.blog2.vo.Result;
import com.liu.blog2.vo.TagVo;

import java.util.List;

/**
* @author lwz18
* @description 针对表【ms_tag】的数据库操作Service
* @createDate 2022-05-29 17:55:33
*/
public interface TagService extends IService<Tag> {

    List<TagVo> findTagsByArticleId(Long id);

    List<TagVo> hot(int limit);

    Result findAll();

    Result findAllDetail();

    Result findDetailById(Long id);
}
