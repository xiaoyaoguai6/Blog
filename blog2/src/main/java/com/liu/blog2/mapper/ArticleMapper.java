package com.liu.blog2.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liu.blog2.dao.pojo.Archives;
import com.liu.blog2.dao.pojo.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author lwz18
* @description 针对表【ms_article】的数据库操作Mapper
* @createDate 2022-05-29 17:54:45
* @Entity com.liu.blog2.dao.pojo.Article
*/
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

    List<Archives> listArchives();

    IPage<Article> listArticle(Page<Article> page, Long categoryId, Long tagId, String year, String month);
}




