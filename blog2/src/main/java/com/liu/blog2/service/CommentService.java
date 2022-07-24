package com.liu.blog2.service;

import com.liu.blog2.vo.Result;
import com.liu.blog2.vo.params.CommentParam;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentService {
    Result commentsByArticleId(Long id);

    Result comment(CommentParam commentParam);
}
