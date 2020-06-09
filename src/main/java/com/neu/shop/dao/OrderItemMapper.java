package com.neu.shop.dao;

import com.neu.shop.pojo.OrderItem;
import com.neu.shop.pojo.OrderItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

public interface OrderItemMapper {
    long countByExample(OrderItemExample example);

    int deleteByExample(OrderItemExample example);

    int deleteByPrimaryKey(Integer itemid);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    List<OrderItem> selectByExample(OrderItemExample example);

    List<OrderItem> selectHotGoodsList();

    List<OrderItem> totalCateOrder();

    OrderItem selectByPrimaryKey(Integer itemid);

    int updateByExampleSelective(@Param("record") OrderItem record, @Param("example") OrderItemExample example);

    int updateByExample(@Param("record") OrderItem record, @Param("example") OrderItemExample example);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);

    int requestRefund(@Param("orderid")Integer orderid, @Param("goodsid")Integer goodsid);

    int confirmRefund(@Param("orderid")Integer orderid, @Param("goodsid")Integer goodsid);
}