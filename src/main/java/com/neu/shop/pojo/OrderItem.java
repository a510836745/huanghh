package com.neu.shop.pojo;

public class OrderItem {
    private Integer itemid;

    private Integer orderid;

    private Integer goodsid;

    private Integer num;

    private Integer isRefund;

    private Integer totalNum;

    private Integer category;

    public OrderItem() {
    }

    public OrderItem(Integer itemid, Integer orderid, Integer goodsid, Integer num, Integer isRefund) {

        this.itemid = itemid;
        this.orderid = orderid;
        this.goodsid = goodsid;
        this.num = num;
        this.isRefund = isRefund;
    }

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getIsRefund() {
        return isRefund;
    }

    public void setIsRefund(Integer isRefund) {
        this.isRefund = isRefund;
    }
}