package com.liu.blog2.controller;

import com.liu.blog2.common.aop.LogAnnotation;
import com.liu.blog2.common.cache.Cache;
import com.liu.blog2.service.ArticleService;
import com.liu.blog2.vo.ArticleVo;
import com.liu.blog2.vo.Result;
import com.liu.blog2.vo.params.ArticleParam;
import com.liu.blog2.vo.params.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("articles")
@RestController
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @PostMapping
    @LogAnnotation(module = "文章",operation = "文章详情列表")
    @Cache(expire = 5 * 60 * 1000,name = "listArticle")
    public Result listArticle(@RequestBody PageParams pageParams) {
        //ArticleVo 页面接收的数据
        List<ArticleVo> articles = articleService.listArticlesPage(pageParams);
        return Result.success(articles);
    }

    @PostMapping("hot")
    @Cache(expire = 5 * 60 * 1000,name = "hot_article")
    public Result hotArticle() {
        int limit = 5;
        return articleService.hotArticle(limit);

    }

    @PostMapping("new")
    @Cache(expire = 5 * 60 * 1000,name = "new_article")
    public Result newArticle() {
        int limit = 5;
        return articleService.newArticle(limit);
    }


    @PostMapping("listArchives")
    public Result listArchives() {
        return articleService.listArchives();
    }

    @PostMapping("view/{id}")
    public Result findArticleById(@PathVariable("id") Long id) {
        ArticleVo articleVo = articleService.findArticleById(id);
        return Result.success(articleVo);
    }

    @PostMapping("publish")
    public Result publish(@RequestBody ArticleParam articleParam){
        return articleService.publish(articleParam);
    }

    @PostMapping("{id}")
    public Result articleById(@PathVariable("id") Long articleId){
        return Result.success(articleService.findArticleById(articleId));
    }

    @PostMapping("del/{id}")
    public Result delAllthingByArticle(@PathVariable("id") Long id){
        return Result.success(articleService.delAllthingArticle(id));
    }
}
