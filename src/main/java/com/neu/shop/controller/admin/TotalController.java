package com.neu.shop.controller.admin;



import com.neu.shop.pojo.Admin;
import com.neu.shop.pojo.Category;
import com.neu.shop.pojo.CategoryExample;
import com.neu.shop.service.CateService;
import com.neu.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/admin/total")
public class TotalController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private CateService cateService;

    @RequestMapping("/show")
    public String tatolCateOrder(Model model, HttpSession session)throws Exception{
        Admin admin = (Admin) session.getAttribute("admin");
        if (admin == null) {
            return "redirect:/admin/login";
        }
        CategoryExample category = new CategoryExample();
        List<Category> totalList = cateService.selectByExample(category);

        model.addAttribute("totalList",totalList);
        return "total";
    }

}
