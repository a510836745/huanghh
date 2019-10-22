package com.neu.shop.dao;

import com.neu.shop.pojo.Goods;
import com.neu.shop.pojo.GoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface GoodsMapper {
    long countByExample(GoodsExample example);

    int deleteByExample(GoodsExample example);

    int deleteByPrimaryKey(Integer goodsid);

    int insert(Goods record);

    int insertSelective(Goods record);

    List<Goods> selectByExampleWithBLOBs(GoodsExample example);

    List<Goods> selectByExample(GoodsExample example);

    Goods selectByPrimaryKey(Integer goodsid);

    int updateByExampleSelective(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByExampleWithBLOBs(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByExample(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKeyWithBLOBs(Goods record);

    int updateByPrimaryKey(Goods record);

    int updateStateByGoodsId(@Param("goodsid") Integer goodsid,@Param("btnState") String btnState);

    int updateStatByCateId(@Param("category") Integer category,@Param("btnState") String btnState);

    List<Goods> selectByExampleWithBLOBsLimit(GoodsExample digGoodsExample);

    List<Goods> selectGoodsAndCateName();

}