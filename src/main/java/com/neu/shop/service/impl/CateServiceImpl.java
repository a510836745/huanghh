package com.neu.shop.service.impl;

import com.neu.shop.dao.CategoryMapper;
import com.neu.shop.pojo.Category;
import com.neu.shop.pojo.CategoryExample;
import com.neu.shop.service.CateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("cateService")
public class CateServiceImpl implements CateService {

    @Autowired(required = false)
    CategoryMapper categoryMapper;

    @Override
    public List<Category> selectByExample(CategoryExample example) {
        return categoryMapper.selectByExample(example);
    }

    @Override
    public void insertSelective(Category category) {
        categoryMapper.insertSelective(category);
    }

    @Override
    public List<Category> selectByExampleLimit(CategoryExample digCategoryExample) {
        return categoryMapper.selectByExampleLimit(digCategoryExample);
    }

    @Override
    public Category selectById(Integer category) {
        return categoryMapper.selectByPrimaryKey(category);
    }

    @Override
    public void updateByPrimaryKeySelective(Category category) {
        categoryMapper.updateByPrimaryKeySelective(category);
    }

    @Override
    public void updateByPrimaryKey(Integer cateid,String btnState) {
        categoryMapper.updateByPrimaryKey(cateid,btnState);
    }

    @Override
    public void updateSaleNum(Integer cateId, Integer saleNum) {
        categoryMapper.updateSaleNum(cateId,saleNum);
    }

    @Override
    public List<Category> findCategory() throws Exception {
        List<Category> list = categoryMapper.findCategory();
        if(list!=null && list.size()>0){
            return list;
        }
        return null;
    }

    @Override
    public String findCateName(Integer cateId) {
        Category c =categoryMapper.selectByPrimaryKey(cateId);
        String cateName = c.getCatename();
        return cateName;
    }
}
