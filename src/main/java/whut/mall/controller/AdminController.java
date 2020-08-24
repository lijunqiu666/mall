package whut.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import whut.mall.entity.Admin;
import whut.mall.entity.PageInfo;
import whut.mall.entity.Product;
import whut.mall.entity.User;
import whut.mall.service.AdminService;
import whut.mall.util.MD5Utils;

import javax.servlet.http.HttpSession;

/**
 * mall
 * 2020/8/23 17:18
 * 管理员登陆
 *
 * @author 李俊秋
 **/
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @GetMapping
    //返回到登陆页面
    public String loginPage() {
        return "user/login";
    }

    @PostMapping("/login")
    //从前端得到用户名和密码
    public String login(String username, String password, HttpSession session, RedirectAttributes redirectAttributes) {

        //与加密后的密码相比较
        Admin admin = adminService.checkUser(username, MD5Utils.code(password));
        if (admin != null) {
            admin.setPassword(null);
            session.setAttribute("adminname", username);
//            model.addAttribute("adminname",username);

            return "admin/index";
        } else {
            // 重定向之后返回数据
            redirectAttributes.addFlashAttribute("message", "用户名或者密码错误");

            //重定向请求
            return "redirect:/admin";
        }


    }

    @GetMapping("/findAllProduct")
    public String findAllProduct(@RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "0") int flag, String productName, HttpSession session, Model model) {
        if (flag == 1) {
            System.out.println("条件查询");
            session.setAttribute("keywords", productName);
        } else {
            System.out.println("不是条件查询");
            session.setAttribute("keywords", null);
        }
        int size = 5;
        PageInfo<Product> pageInfo = adminService.findAllByPage(currentPage, size, productName);
        System.out.println(pageInfo);
        model.addAttribute("pageInfo", pageInfo);


        return "admin/productList";
    }


    @GetMapping("/findPurchaseHistory")
    public String findPurchaseHistory() {


        return "admin/purchaseHistory";
    }




    @GetMapping("/{id}/toUpdate.do")
    public String toUpdate(@PathVariable Long id,Model model) {
        Product product = adminService.findProductById(id);
        model.addAttribute("product",product);



        return "admin/product-update";

    }

    @PostMapping("/update.do")
    public String update(){




        return "redirect:findAllProduct";

    }























    @GetMapping("/header")
    public String header() {
        return "admin/header";
    }

    @GetMapping("/aside")
    public String aside() {
        return "admin/aside";
    }

}
