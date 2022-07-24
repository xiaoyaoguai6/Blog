package com.liu.blog2.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.liu.blog2.dao.pojo.Category;
import com.liu.blog2.mapper.CategoryMapper;
import com.liu.blog2.service.CategoryService;
import com.liu.blog2.vo.CategoryVo;
import com.liu.blog2.vo.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;


    @Override
    public CategoryVo findCategory(Integer categoryId) {

        Category category=categoryMapper.selectById(categoryId);
        CategoryVo categoryVo =new CategoryVo();
        BeanUtils.copyProperties(category,categoryVo);

        return categoryVo;
    }

    @Override
    public Result findAll() {
        LambdaQueryWrapper<Category> queryWrapper =new LambdaQueryWrapper<>();
        queryWrapper.select(Category::getId,Category::getCategoryName);
        List<Category> categoryList =this.categoryMapper.selectList(queryWrapper);
        return Result.success(copyList(categoryList));

    }

    @Override
    public Result findAllDetail() {

        List<Category> categoryList =categoryMapper.selectList(new LambdaQueryWrapper<>());
        return Result.success(copyList(categoryList));
    }

    @Override
    public Result findDetailById(Long id) {

        Category category =categoryMapper.selectById(id);
        CategoryVo categoryVo =copy(category);
        return Result.success(categoryVo);
    }

    private List<CategoryVo> copyList(List<Category> categoryList) {
        List<CategoryVo> categoryVos =new ArrayList<>();
        for (Category category:categoryList
             ) {
            categoryVos.add(copy(category));
        }
        return categoryVos;
    }

    private CategoryVo copy(Category category) {
        CategoryVo categoryVo =new CategoryVo();
        BeanUtils.copyProperties(category,categoryVo);

        return categoryVo;
    }
}
