package whut.mall.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import whut.mall.entity.Cart;


/**
 * @ClassName CartRepositiry
 * @Description TODO
 * @Author liaowenhua
 * Date 2020/8/23 10:29
 **/

public interface CartRepository extends JpaRepository<Cart, Long> , JpaSpecificationExecutor {

}
