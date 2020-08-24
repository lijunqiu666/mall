package whut.mall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import whut.mall.entity.Cart;
import whut.mall.entity.Product;
import whut.mall.entity.User;


/**
 * @ClassName CartRepositiry
 * @Description TODO
 * @Author liaowenhua
 * Date 2020/8/23 10:29
 **/

public interface CartRepository extends JpaRepository<Cart, Long> , JpaSpecificationExecutor {
    Cart getOneByUserAndProduct(User user, Product p);//根据User和Product查询Cart
}
