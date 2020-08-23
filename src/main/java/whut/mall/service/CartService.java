package whut.mall.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import whut.mall.entity.Cart;
import whut.mall.entity.Product;
import whut.mall.entity.User;

/**
 * @ClassName CartService
 * @Description TODO
 * @Author liaowenhua
 * Date 2020/8/22 21:53
 **/
public interface CartService {
    int addCart(User user, Product product, int quantity);

    Page<Cart> listCart(Pageable pageable, User user);

    int addCount(Long id);

    int deleteCount(Long id);

}
