package com.neu.shop.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neu.shop.pojo.*;
import com.neu.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/showjson")
    @ResponseBody
    public Msg getAllUser(@RequestParam(value = "page",defaultValue = "1") Integer pn, HttpServletResponse response, Model model) {
        //一页显示几个数据
        PageHelper.startPage(pn, 10);

        List<User> userList = userService.selectByExample(new UserExample());

        //显示几个页号
        PageInfo page = new PageInfo(userList,5);


        return Msg.success("查询成功!").add("pageInfo", page);
    }

    @RequestMapping("/userSearch")
    public Msg getUserByCondition(@RequestParam(value = "page",defaultValue = "1") Integer pn,@RequestParam(value = "userName") String userName, HttpServletResponse response, Model model){
        PageHelper.startPage(pn,10);
        List<User> userList = new ArrayList<>();
        if(userName!=null&&!userName.isEmpty()){
            userName = "%" + userName + "%";
            UserExample userExample = new UserExample();
            UserExample.Criteria criteria = userExample.createCriteria();
            criteria.andUsernameLike(userName);
            userList = userService.selectByExample(userExample);
        }

        PageInfo page = new PageInfo(userList,5);
        return Msg.success("查询成功!").add("pageInfo", page);

    }

    @RequestMapping("/show")
    public String userManage() {
        return "userManage";
    }

    @RequestMapping(value = "/delete/{userid}", method = RequestMethod.DELETE)
    @ResponseBody
    public Msg deleteUser(@PathVariable("userid")Integer userid) {
//        goodsService.deleteGoodsById(goodsid);
        userService.deleteUserById(userid);
        return Msg.success("删除成功!");
    }
}
