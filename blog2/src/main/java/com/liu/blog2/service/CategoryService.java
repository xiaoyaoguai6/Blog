package com.liu.blog2.service;

import com.liu.blog2.vo.CategoryVo;
import com.liu.blog2.vo.Result;

public interface CategoryService {
    CategoryVo findCategory(Integer categoryId);

    Result findAll();

    Result findAllDetail();

    Result findDetailById(Long id);
}
