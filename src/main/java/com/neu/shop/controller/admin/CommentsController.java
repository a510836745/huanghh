package com.neu.shop.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neu.shop.pojo.Admin;
import com.neu.shop.pojo.Comment;
import com.neu.shop.pojo.CommentExample;
import com.neu.shop.pojo.Msg;
import com.neu.shop.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin/comments")
public class CommentsController {

    @Autowired
    private CommentService commentService;

    @RequestMapping("/show")
    public String ShowAllComments(@RequestParam(value = "page",defaultValue = "1") Integer pn, Model model, HttpSession session){
        Admin admin = (Admin) session.getAttribute("admin");
        if(admin == null){
            return "redirect:/admin/login";
        }
        //一页显示几个数据
        PageHelper.startPage(pn,10);
        CommentExample commentExample = new CommentExample();
        List<Comment> commentList = commentService.getCommentAndGoodsAndUser();

        PageInfo page = new PageInfo(commentList,5);
        model.addAttribute("pageInfo", page);

        return "comment";
    }
    @RequestMapping("/delete")
    @ResponseBody
    public Msg deleteComment(Comment comment){
        int commentId = comment.getCommentid();
        int result = commentService.deleteComment(commentId);
        if(result == 1){
            return Msg.success("删除成功");
        }else {
            return Msg.success("删除错误");
        }
    }
}
