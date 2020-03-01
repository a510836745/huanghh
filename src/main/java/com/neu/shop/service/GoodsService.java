package com.neu.shop.service;

import com.neu.shop.pojo.*;

import java.util.List;

public interface GoodsService {
    public Integer addGoods(Goods goods);

    public void addImagePath(ImagePath imagePath);

    public List<Goods> selectByExample(GoodsExample example);

    public List<Goods> selectGoodsAndCateName(GoodsExample example);

    public void updateStateByGoodsId(Integer goodsid,String btnState);

    public void updateStatByCateId(Integer cateId,String btnState);

    public void updateGoodsById(Goods goods);

    public void updateGoodsNum(Integer goodsId,Integer goodsNewNum);

    public void updateGoodsAfterDeleteActivity(Integer activityId);

    public List<ImagePath> findImagePath(Integer goodsid);

    public Goods selectById(Integer goodsid);

    public Goods selectGoodsOrder(Integer goodsid);

    public List<Goods> selectByExampleLimit(GoodsExample digGoodsExample);

    public void addFavorite(Favorite favorite);

    public Favorite selectFavByKey(FavoriteKey favoriteKey);

    public void deleteFavByKey(FavoriteKey favoriteKey);

    public List<Favorite> selectFavByExample(FavoriteExample favoriteExample);
}
