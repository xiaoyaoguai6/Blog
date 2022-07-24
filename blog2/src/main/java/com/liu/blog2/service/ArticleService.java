package com.liu.blog2.service;

import com.liu.blog2.dao.pojo.Article;
import com.baomidou.mybatisplus.extension.service.IService;
import com.liu.blog2.vo.ArticleVo;
import com.liu.blog2.vo.Result;
import com.liu.blog2.vo.params.ArticleParam;
import com.liu.blog2.vo.params.PageParams;

import java.util.List;

/**
* @author lwz18
* @description 针对表【ms_article】的数据库操作Service
* @createDate 2022-05-29 17:54:45
*/
public interface ArticleService extends IService<Article> {

    List<ArticleVo> listArticlesPage(PageParams pageParams);

    Result hotArticle(int limit);

    Result newArticle(int limit);

    Result listArchives();

    ArticleVo findArticleById(Long id);

    Result publish(ArticleParam articleParam);

    Result delAllthingArticle(Long articleId);

}
