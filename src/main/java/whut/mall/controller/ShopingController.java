package whut.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import whut.mall.entity.Cart;
import whut.mall.entity.User;
import whut.mall.service.ShoppingService;
import whut.mall.service.implement.ShoppingServiceImpl;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/shoping")
public class ShopingController {

    @Autowired
    ShoppingServiceImpl shoppingService;
@GetMapping("/one")
    int shoping( Long i,int quantity, HttpSession session)//获得商品的id和数量
    {
    int i1=shoppingService.buyOne((User) session.getAttribute("user"),i,quantity);
    return i1;//返回成功与否1 0r 0

    }
    @PostMapping("/many")
    int shopping(List<Cart> listcart,HttpSession session)//可以给我一个购物车的list吗，cart属性里面至少要有Cart的id
    {
        int i=shoppingService.buyMany(listcart, (User) session.getAttribute("user"));
        return i;//返回成与否
    }
}
