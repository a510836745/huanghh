package com.neu.shop.service.impl;

import com.neu.shop.dao.FavoriteMapper;
import com.neu.shop.dao.GoodsMapper;
import com.neu.shop.dao.ImagePathMapper;
import com.neu.shop.pojo.*;
import com.neu.shop.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

    @Autowired(required = false)
    GoodsMapper goodsMapper;

    @Autowired(required = false)
    ImagePathMapper imagePathMapper;

    @Autowired(required = false)
    FavoriteMapper favoriteMapper;

    @Override
    public Integer addGoods(Goods goods) {
        goodsMapper.insertSelective(goods);
        return goods.getGoodsid();
    }

    @Override
    public void addImagePath(ImagePath imagePath) {
        imagePathMapper.insertSelective(imagePath);
    }

    @Override
    public List<Goods> selectByExample(GoodsExample example) {
        return goodsMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public List<Goods> selectGoodsAndCateName(GoodsExample example) {
        return goodsMapper.selectGoodsAndCateName();
    }

    @Override
    public List<Goods> selectNewGoods() {
        return goodsMapper.selectNewGoods();
    }

    @Override
    public void updateStateByGoodsId(Integer goodsid,String btnState) {
        goodsMapper.updateStateByGoodsId(goodsid,btnState);
    }

    @Override
    public void updateStatByCateId(Integer cateId,String btnState) {
        goodsMapper.updateStatByCateId(cateId,btnState);
    }

    @Override
    public void updateGoodsById(Goods goods) {
        goodsMapper.updateByPrimaryKeySelective(goods);
    }

    @Override
    public void updateGoodsNum(Integer goodsId, Integer goodsNewNum) {
        goodsMapper.updateGoodsNum(goodsId,goodsNewNum);
    }

    @Override
    public void updateGoodsAfterDeleteActivity(Integer activityId) {
        goodsMapper.updateGoodsAfterDeleteActivity(activityId);
    }

    @Override
    public List<ImagePath> findImagePath(Integer goodsid) {
        ImagePathExample imagePathExample = new ImagePathExample();
        imagePathExample.or().andGoodidEqualTo(goodsid);

        return imagePathMapper.selectByExample(imagePathExample);
    }

    @Override
    public Goods selectById(Integer goodsid) {
        return goodsMapper.selectByPrimaryKey(goodsid);
    }

    @Override
    public Goods selectGoodsOrder(Integer goodsid) {
        return goodsMapper.selectGoodsOrder(goodsid);
    }

    @Override
    public List<Goods> selectByExampleLimit(GoodsExample digGoodsExample) {
        return goodsMapper.selectByExampleWithBLOBsLimit(digGoodsExample);
    }

    @Override
    public void addFavorite(Favorite favorite) {
        favoriteMapper.insertSelective(favorite);
    }

    @Override
    public Favorite selectFavByKey(FavoriteKey favoriteKey) {
        return favoriteMapper.selectByPrimaryKey(favoriteKey);
    }

    @Override
    public void deleteFavByKey(FavoriteKey favoriteKey) {
        favoriteMapper.deleteByPrimaryKey(favoriteKey);
    }

    @Override
    public List<Favorite> selectFavByExample(FavoriteExample favoriteExample) {
        return favoriteMapper.selectByExample(favoriteExample);
    }
}
