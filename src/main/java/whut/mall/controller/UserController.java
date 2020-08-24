package whut.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import whut.mall.entity.User;
import whut.mall.service.UserService;
import whut.mall.util.MD5Utils;

import javax.servlet.http.HttpSession;

/**
 * mall
 * 2020/8/23 10:14
 * 登陆控制器
 *
 * @author 李俊秋
 **/
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    //返回到登陆页面
    public String loginPage() {
        return "user/login";
    }

    @PostMapping("/login")
    //从前端得到用户名和密码
    public String login(String username, String password, HttpSession session, RedirectAttributes redirectAttributes) {
        System.out.println(username+"-----"+password);
        //与加密后的密码相比较
        User user = userService.checkUser(username, MD5Utils.code(password));
        if (user != null) {
            user.setPassword(null);
            session.setAttribute("user", user);
            return "user/index";
        } else {
            // 重定向之后返回数据
            redirectAttributes.addFlashAttribute("message", "用户名或者密码错误");

            //重定向请求
            return "redirect:/user";
        }


    }

    @PostMapping("/register")
    public String register(String username, String password, String email, String phone, RedirectAttributes redirectAttributes) {
        Integer i = userService.register(username, MD5Utils.code(password), email, phone);
        System.out.println(i);
        if (i > 0) {
            redirectAttributes.addFlashAttribute("message", "注册成功");
            return "user/login";


        } else {
            redirectAttributes.addFlashAttribute("message", "注册失败");
            return "redirect:/user/jump_to_register";

        }


    }

    //登陆页面的href跳转到注册页面
    @GetMapping("/jump_to_register")
    public String jumpToRegister() {
        return "user/register";
    }


}
