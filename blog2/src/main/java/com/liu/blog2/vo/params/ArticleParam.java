package com.liu.blog2.vo.params;

import com.liu.blog2.vo.CategoryVo;
import com.liu.blog2.vo.TagVo;
import lombok.Data;

import java.util.List;

@Data
public class ArticleParam {

    private Long id;

    private ArticleBodyParam body;

    private CategoryVo category;

    private String summary;

    private List<TagVo> tags;

    private String title;
}
