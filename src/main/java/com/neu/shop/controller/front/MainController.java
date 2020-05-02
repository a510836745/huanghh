package com.neu.shop.controller.front;

import com.neu.shop.pojo.*;
import com.neu.shop.service.CateService;
import com.neu.shop.service.GoodsService;
import com.neu.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private CateService cateService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private OrderService orderService;

    @RequestMapping("/main")
    public String showAllGoods(Model model, HttpSession session) throws Exception{

        Integer userid;
        Integer cId ;
        String cName;
        User user = (User) session.getAttribute("user");
        if (user == null) {
            userid = null;
        } else {
            userid = user.getUserid();
        }
        List<Category> categoryList = cateService.findCategory();
        model.addAttribute("cList",categoryList);
        List<Goods> list = new ArrayList<>();
//        for(Category c : categoryList){
//             cId = c.getCateid();
//             cName = c.getCatename();
//             list = getCateGoods(cId,userid);
//             model.addAttribute(cName,list);
//        }
        List<Goods> newGoodsAndImageList = new ArrayList<>();
        List<Goods> newGoodsList = goodsService.selectNewGoods();
        for (Goods goods : newGoodsList){
            List<ImagePath> imagePathList = goodsService.findImagePath(goods.getGoodsid());
            goods.setImagePaths(imagePathList);
            newGoodsAndImageList.add(goods);
        }
        model.addAttribute("newGoodsList",newGoodsAndImageList);

        List<Goods> hotGoodsAndImageList = new ArrayList<>();
        List<OrderItem> hotGoodsList = orderService.selectHotGoodsList();
        for (OrderItem o : hotGoodsList){
            Goods good = goodsService.selectById(o.getGoodsid());
            List<ImagePath> imagePathList = goodsService.findImagePath(o.getGoodsid());
            good.setImagePaths(imagePathList);
            hotGoodsAndImageList.add(good);
        }
        model.addAttribute("hotGoodsAndImageList",hotGoodsAndImageList);
        return "main";
    }

    public List<Goods> getCateGoods(Integer cid , Integer userid)throws Exception{

//        //查询属于刚查到的分类的商品
       GoodsExample digGoodsExample = new GoodsExample();
        List<Integer> digCateId = new ArrayList<Integer>();
        digCateId.add(cid);

        digGoodsExample.or().andCategoryIn(digCateId);

        List<Goods> goodsList = goodsService.selectByExampleLimit(digGoodsExample);

        List<Goods> goodsAndImage = new ArrayList<>();
        //获取每个商品的图片
        for (Goods goods:goodsList) {
            //判断是否为登录状态
            if (userid == null) {
                goods.setFav(false);
            } else {
                Favorite favorite = goodsService.selectFavByKey(new FavoriteKey(userid, goods.getGoodsid()));
                if (favorite == null) {
                    goods.setFav(false);
                } else {
                    goods.setFav(true);
                }
            }

            List<ImagePath> imagePathList = goodsService.findImagePath(goods.getGoodsid());
            goods.setImagePaths(imagePathList);
            goodsAndImage.add(goods);
        }
        return goodsAndImage;
    }
//    public List<Goods> getCateGoods(String cate , Integer userid)throws Exception{
//        //查询分类
//        CategoryExample digCategoryExample = new CategoryExample();
//        digCategoryExample.or().andCatenameLike(cate);
//        List<Category> digCategoryList = cateService.findCategory();
//        System.out.println(digCategoryList);
//        if (digCategoryList.size() == 0) {
//            return null;
//        }
//
//        //查询属于刚查到的分类的商品
//        GoodsExample digGoodsExample = new GoodsExample();
//        List<Integer> digCateId = new ArrayList<Integer>();
//        for (Category tmp:digCategoryList) {
//            digCateId.add(tmp.getCateid());
//        }
//        digGoodsExample.or().andCategoryIn(digCateId);
//
//        List<Goods> goodsList = goodsService.selectByExampleLimit(digGoodsExample);
//
//        List<Goods> goodsAndImage = new ArrayList<>();
//        //获取每个商品的图片
//        for (Goods goods:goodsList) {
//            //判断是否为登录状态
//            if (userid == null) {
//                goods.setFav(false);
//            } else {
//                Favorite favorite = goodsService.selectFavByKey(new FavoriteKey(userid, goods.getGoodsid()));
//                if (favorite == null) {
//                    goods.setFav(false);
//                } else {
//                    goods.setFav(true);
//                }
//            }
//
//            List<ImagePath> imagePathList = goodsService.findImagePath(goods.getGoodsid());
//            goods.setImagePaths(imagePathList);
//            goodsAndImage.add(goods);
//        }
//        return goodsAndImage;
//    }
}
