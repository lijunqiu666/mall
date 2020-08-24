package whut.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import whut.mall.entity.Cart;
import whut.mall.entity.Product;
import whut.mall.entity.User;
import whut.mall.service.implement.CartServiceImpl;

import javax.servlet.http.HttpSession;

/**
 * @ClassName CartController
 * @Description TODO
 * @Author liaowenhua
 * Date 2020/8/22 20:53
 **/
@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartServiceImpl cartService;


    @PostMapping("/add_to_cart.do")
    @ResponseBody//反回的是数据
    /*
     *@author liaowenhua
     *@Description 新增购物车
     *@Date 21:44 2020/8/22
     *@Param [s, product：产品, quantity： 数量]
     *@Return
     **/
    public String addToCard(HttpSession s, Product product, int quantity)//不用全部字段输全，部分字段即可，实在不行传给我相关实体类的id就可以
    // 不知道能不能得到
    {
//看你的前端是要返回一个状态码吗，是一个对应的数据就好吗，不用命名什么的，要什么规则吗
    int i=cartService.addCart((User)s.getAttribute("user"),product,quantity);
//你要我返回啥
    return "添加成功";}

    /*
     *@author liaowenhua
     *@Description 分页显示所有购物车
     *@Date 23:08 2020/8/22
     *@Param []
     *@Return Page<Cart>
     **/
    @GetMapping("/list")
    public Page<Cart> showCart(@PageableDefault(size = 10, sort = "update_time", direction = Sort.Direction.DESC) Pageable pageable, HttpSession session) {
        User user = (User) session.getAttribute("user");//找到该用户下的，分页的所有list
        return cartService.listCart(pageable, user);
    }

    @GetMapping("/add_count")
    public int addPrice(@RequestParam("id") Long id)//购物车id
    {
        return cartService.addCount(id);//相应的购物车商品数量加一?
    }


    @GetMapping("/reduce_count")
    public int reduceCount(@RequestParam("id") Long id) {//返回状态码？
        return cartService.deleteCount(id);

    }
}
