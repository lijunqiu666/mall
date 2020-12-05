package whut.mall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import whut.mall.entity.Order;

/**
 * @ClassName ShopRepository
 * @Description TODO
 * @Author liaowenhua
 * Date 2020/8/24 11:22
 **/
public interface OrderRepository extends JpaRepository<Order,Long> {

}
