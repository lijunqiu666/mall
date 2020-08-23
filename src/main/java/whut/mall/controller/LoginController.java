package whut.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import whut.mall.service.UserService;

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
public class LoginController {
    @Autowired
    UserService userService;

    @GetMapping
    //返回到登陆页面
    public String loginPage() {
        return "user/login";
    }
    @PostMapping("/login")
    //从前端得到用户名和密码
    public String login(String username, String password, HttpSession session, RedirectAttributes redirectAttributes){
        return "";


    }


}
