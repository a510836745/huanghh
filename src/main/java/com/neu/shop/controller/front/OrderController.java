package com.neu.shop.controller.front;

import com.neu.shop.pojo.*;
import com.neu.shop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
public class OrderController {


    @Autowired
    private AddressService addressService;

    @Autowired
    private ShopCartService shopCartService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ActivityService activityService;

    @Autowired
    private CateService cateService;

    @RequestMapping("/order")
    public String showOrder(HttpSession session, Model model) {

        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }

        //查询当前用户的收货地址
        AddressExample addressExample = new AddressExample();
        addressExample.or().andUseridEqualTo(user.getUserid());
        List<Address> addressList = addressService.getAllAddressByExample(addressExample);

        model.addAttribute("address", addressList);

        //订单信息
        //获取当前用户的购物车信息
        ShopCartExample shopCartExample = new ShopCartExample();
        shopCartExample.or().andUseridEqualTo(user.getUserid());
        List<ShopCart> shopCart = shopCartService.selectByExample(shopCartExample);

        //获取购物车中的商品信息
        List<Goods> goodsAndImage = new ArrayList<>();

        Float totalPrice = new Float(0);
        Integer oldTotalPrice = 0;

        for (ShopCart cart:shopCart) {
            Goods goods = goodsService.selectById(cart.getGoodsid());
            //获取商品库存
            int goodsNum = goods.getNum();
            //判断库存是否充足
            if(goodsNum>=cart.getGoodsnum()){
                List<ImagePath> imagePathList = goodsService.findImagePath(goods.getGoodsid());
                goods.setImagePaths(imagePathList);
                goods.setPayNum(cart.getGoodsnum());


                //活动信息
                Activity activity = activityService.selectByKey(goods.getActivityid());
                goods.setActivity(activity);
                //优惠计算方式
                float normalPrice = (float) (goods.getPrice()*goods.getPayNum());       //原价
                float discountPrice;    //折扣后价格
                float fullNumPrice;     //满免后价格
                float fullMoneyPrice;   //满减后价格
                if(activity.getDiscount() != 1) {
                    discountPrice = (float)goods.getPrice()*goods.getPayNum()* activity.getDiscount();
                    //goods.setNewPrice(goods.getPrice()*goods.getPayNum()* activity.getDiscount());
                }else {
                    discountPrice =normalPrice;
                    //goods.setNewPrice((float) (goods.getPrice()*goods.getPayNum()));
                }
                if(activity.getFullnum() != null) {
                    if (goods.getPayNum() >= activity.getFullnum()) {
                        fullNumPrice = (float) (goods.getPrice()*(goods.getPayNum()-activity.getReducenum()));
                        //goods.setNewPrice((float) (goods.getPrice()*(goods.getPayNum()-activity.getReducenum())));
                    } else {
                        fullNumPrice = normalPrice;
                       //goods.setNewPrice((float) (goods.getPrice()*goods.getPayNum()));
                    }
                } else {
                    fullNumPrice = normalPrice;
                    //goods.setNewPrice((float) (goods.getPrice()*goods.getPayNum()));
                }
                if(activity.getFullprice() != null){
                    if(normalPrice>activity.getFullprice()){
                        fullMoneyPrice = normalPrice - activity.getReduceprice();
                    }else {
                        fullMoneyPrice = normalPrice;
                    }
                }else {
                    fullMoneyPrice = normalPrice;
                }
                //判断三种优惠金额 取最小的
                float minPrice = (discountPrice > fullNumPrice) ? fullNumPrice : discountPrice;
                minPrice = (minPrice > fullMoneyPrice) ? fullMoneyPrice : minPrice;
                goods.setNewPrice(minPrice);
                totalPrice = totalPrice + goods.getNewPrice();
                oldTotalPrice = oldTotalPrice + goods.getPayNum() * goods.getPrice();
                goodsAndImage.add(goods);
            }else{
                continue;
            }
        }

        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("oldTotalPrice", oldTotalPrice);
        model.addAttribute("goodsAndImage", goodsAndImage);

        return "orderConfirm";
    }

    @RequestMapping("/orderFinish")
    @ResponseBody
    public Msg orderFinish(Float oldPrice, Float newPrice, Boolean isPay, Integer addressid,HttpSession session) {
        User user = (User) session.getAttribute("user");

        //获取订单信息
        ShopCartExample shopCartExample = new ShopCartExample();
        shopCartExample.or().andUseridEqualTo(user.getUserid());
        List<ShopCart> shopCart = shopCartService.selectByExample(shopCartExample);
        //把订单信息写入数据库
        Order order = new Order(null, user.getUserid(),new Date(), oldPrice, newPrice, isPay, false, false, false, addressid,null,null);
        orderService.insertOrder(order);
        //插入的订单号
        Integer orderId = order.getOrderid();

        for (ShopCart cart : shopCart) {
            //获取购物车商品的预购数量
            int payNum = cart.getGoodsnum();
            //获取商品的库存
            Goods goods = goodsService.selectById(cart.getGoodsid());
            int goodsNum = goods.getNum();
            if(goodsNum>=payNum){
                //把订单项写入orderitem表中
                orderService.insertOrderItem(new OrderItem(null, orderId, cart.getGoodsid(), cart.getGoodsnum()));

                //库存减少
                int goodsNewNum = goodsNum - payNum;
                int cateId = goods.getCategory();
                goodsService.updateGoodsNum(cart.getGoodsid(),goodsNewNum);
                //该类商品销售总量增加
                Category category = cateService.selectById(cateId);
                int saleNum = category.getSaleNum();
                int newSaleNum = saleNum + payNum;
                cateService.updateSaleNum(cateId,newSaleNum);
                //删除相应购物车商品
                shopCartService.deleteByKey(new ShopCartKey(cart.getUserid(),cart.getGoodsid()));
            }else{
                continue;
            }
        }
        return Msg.success("购买成功");
    }

}
