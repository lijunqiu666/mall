package whut.mall.service;

import whut.mall.entity.Cart;
import whut.mall.entity.Order;
import whut.mall.entity.Order_item;
import whut.mall.entity.User;

import java.util.List;

/**
 * @ClassName ShoppingService
 * @Description TODO
 * @Author liaowenhua
 * Date 2020/8/24 11:01
 **/
public interface ShoppingService {
    /*
    *@author liaowenhua
    *@Description 创建订单
    *@Date 11:06 2020/8/24
    *@Param [ProId, user]
    *@Return whut.mall.entity.Order
    **/
Order createOrder( User user);
/*
*@author liaowenhua
*@Description 创建菜单项
*@Date 11:10 2020/8/24
*@Param [order, ProId, quantity]
*@Return whut.mall.entity.Order_item
**/
Order_item createOrderItem(Order order,Long ProId,int quantity);
/*
*@author liaowenhua
*@Description 下单
*@Date 11:12 2020/8/24
*@Param [user, ProId, quantity]
*@Return int
**/
int buyOne(User user, Long ProId, int quantity);//购买一个商品

int buyMany(List<Cart> cartList,User user);

}
