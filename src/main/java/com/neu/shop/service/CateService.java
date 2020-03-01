package com.neu.shop.service;

import com.neu.shop.pojo.Category;
import com.neu.shop.pojo.CategoryExample;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("CateService")
public interface CateService {
    public List<Category> selectByExample(CategoryExample example);
    public void insertSelective(Category category);

    public List<Category> selectByExampleLimit(CategoryExample digCategoryExample);

    public Category selectById(Integer category);

    public void updateByPrimaryKeySelective(Category category);

    public void updateByPrimaryKey(Integer cateid,String btnState);

    public List<Category> findCategory() throws Exception;

    public String findCateName(Integer cateId);
}
