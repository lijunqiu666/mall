package whut.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import whut.mall.entity.Admin;
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
    public String login(String username, String password, HttpSession session, RedirectAttributes redirectAttributes){

        //与加密后的密码相比较
        Admin admin = adminService.checkUser(username, MD5Utils.code(password));
        if (admin != null) {
            admin.setPassword(null);
            session.setAttribute("admin", admin);
            return "admin/index";
        } else {
            // 重定向之后返回数据
            redirectAttributes.addFlashAttribute("message", "用户名或者密码错误");

            //重定向请求
            return "redirect:/admin";
        }



    }

}
