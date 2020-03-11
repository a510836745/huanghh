package com.neu.shop.dao;

import com.neu.shop.pojo.Category;
import com.neu.shop.pojo.CategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CategoryMapper {
    long countByExample(CategoryExample example);

    int deleteByExample(CategoryExample example);

    int deleteByPrimaryKey(Integer cateid);

    int insert(Category record);

    int insertSelective(Category record);

    List<Category> findCategory();

    List<Category> selectByExample(CategoryExample example);

    List<Category> selectByExampleLimit(CategoryExample example);

    Category selectByPrimaryKey(Integer cateid);

    int updateByExampleSelective(@Param("record") Category record, @Param("example") CategoryExample example);

    int updateByExample(@Param("record") Category record, @Param("example") CategoryExample example);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(@Param("cateid") Integer cateid,@Param("btnState") String btnState);

    int updateSaleNum(@Param("cateid") Integer cateid,@Param("saleNum") Integer saleNum);

}