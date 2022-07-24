package com.liu.blog2.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.liu.blog2.dao.pojo.Article;
import com.liu.blog2.dao.pojo.Comment;
import com.liu.blog2.dao.pojo.SysUser;
import com.liu.blog2.mapper.ArticleMapper;
import com.liu.blog2.mapper.CommentMapper;
import com.liu.blog2.service.CommentService;
import com.liu.blog2.service.SysUserService;
import com.liu.blog2.utils.UserThreadLocal;
import com.liu.blog2.vo.CommentVo;
import com.liu.blog2.vo.Result;
import com.liu.blog2.vo.UserVo;
import com.liu.blog2.vo.params.CommentParam;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public Result commentsByArticleId(Long id) {
        LambdaQueryWrapper<Comment> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Comment::getArticleId,id)
                .eq(Comment::getLevel,1);
        List<Comment> comments = commentMapper.selectList(queryWrapper);
        List<CommentVo> commentVos =copyList(comments);
        return Result.success(commentVos);
    }

    @Override
    public Result comment(CommentParam commentParam) {
        SysUser sysUser = UserThreadLocal.get();
        Comment comment = new Comment();
        comment.setArticleId(commentParam.getArticleId());
        comment.setAuthorId(sysUser.getId());
        comment.setContent(commentParam.getContent());
        comment.setCreateDate(System.currentTimeMillis());
        Long parent = commentParam.getParent();
        if (parent == null || parent == 0) {
            comment.setLevel(1);
        }else{
            comment.setLevel(2);
        }
        comment.setParentId(parent == null ? 0 : parent);
        Long toUserId = commentParam.getToUserId();
        comment.setToUid(toUserId == null ? 0 : toUserId);
        this.commentMapper.insert(comment);
        LambdaQueryWrapper<Comment> queryWrapper =new LambdaQueryWrapper<>();
        queryWrapper.eq(Comment::getArticleId,comment.getArticleId());
        Article article = articleMapper.selectById(commentParam.getArticleId());
//        Article article = new Article();
        Long count =commentMapper.selectCount(queryWrapper);
        LambdaUpdateWrapper<Article> updateWrapper =new LambdaUpdateWrapper<>();
        updateWrapper.eq(Article::getId,comment.getArticleId())
                     .set(Article::getCommentCounts,count);
        articleMapper.update(article,updateWrapper);
        CommentVo commentVo = copy(comment);
        return Result.success(commentVo);
    }

    private List<CommentVo> copyList(List<Comment> comments) {

        List<CommentVo> commentVoList =new ArrayList<>();
        for (Comment comment:comments) {
            commentVoList.add(copy(comment));
        }
        return commentVoList;
    }

    private CommentVo copy(Comment comment) {

        CommentVo commentVo=new CommentVo();
        BeanUtils.copyProperties(comment,commentVo);
        //时间格式化
        commentVo.setCreateDate(new DateTime(comment.getCreateDate()).toString("yyyy-MM-dd HH:mm"));
        //作者信息
        Long authorID =comment.getAuthorId();
        UserVo userVo = this.sysUserService.findUserVoById(authorID);
        commentVo.setAuthor(userVo);
        //子评论
        Integer level =comment.getLevel();
        if(level ==1){
            Long id =comment.getId();
            List<CommentVo> commentVoList= findCommentsByParentId(id);
            commentVo.setChildrens(commentVoList);

        }
        //父评论
        if(level> 1){
            Long toUid =comment.getToUid();
            UserVo toUserVo =this.sysUserService.findUserVoById(toUid);
            commentVo.setToUser(toUserVo);
        }
        return commentVo;
    }

    private List<CommentVo> findCommentsByParentId(Long id) {

        LambdaQueryWrapper<Comment> queryWrapper =new LambdaQueryWrapper<>();
        queryWrapper.eq(Comment::getParentId,id)
                .eq(Comment::getLevel,2);
        return copyList(commentMapper.selectList(queryWrapper));

    }
}
