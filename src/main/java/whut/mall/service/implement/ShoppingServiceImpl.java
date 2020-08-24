package whut.mall.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whut.mall.entity.*;
import whut.mall.repository.OrderItemRepository;
import whut.mall.repository.OrderRepository;
import whut.mall.repository.ProductRespositiry;
import whut.mall.service.ShoppingService;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @ClassName ShoppingServiceImpl
 * @Description TODO
 * @Author liaowenhua
 * Date 2020/8/24 11:01
 **/
@Service
public class ShoppingServiceImpl implements ShoppingService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderItemRepository orderItemRepository;
    @Autowired
    ProductRespositiry productRespositiry;
    @Override
    public Order createOrder(User user) {
        Order order=new Order();
        order.setStatus(false);//此时默认未付款吧
        order.setUser(user);
        order.setOrder_time(new Date());
        order.setPay(BigDecimal.valueOf(0));

        return orderRepository.save(order);
    }

    @Override
    public Order_item createOrderItem(Order order, Long ProId, int quantity) {//order一定要是数据库中存在的数据噢
        Order_item order_item=new Order_item();
        order_item.setOrder(order);
        order_item.setQuantity(quantity);
        Product product=productRespositiry.getOne(ProId);
        order_item.setProduct(product);
        orderItemRepository.save(order_item);
//        BigDecimal pay= order.getPay().add(BigDecimal.valueOf(product.getPrice()*quantity));//不可直接加
//        order.setPay(pay);
        orderRepository.save(order);//更新order
        return order_item;
    }

    @Override
    public int buyOne(User user, Long ProId, int quantity) {
        Order order=createOrder(user);
        Order_item order_item=createOrderItem(order,ProId,quantity);
        if(order_item==null)
        return 0;
        return 1;
    }

    @Override
    public int buyMany(List<Cart> cartList, User user) {
       Order order= createOrder(user);
        for (Cart c:cartList
             ) {

            Order_item order_item=createOrderItem(order,c.getProduct().getProduct_id(),c.getQuantity());
            if(order_item==null)
            {
                return errorHand(order);
            }
        }
        return 1;
    }
    private int errorHand(Order order)
    {
        orderItemRepository.deleteAllByOrder(order);
        orderRepository.delete(order);
        return 0;
    }
}
