package whut.mall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import whut.mall.entity.Order;
import whut.mall.entity.Order_item;

/**
 * @ClassName OrderItem
 * @Description TODO
 * @Author liaowenhua
 * Date 2020/8/24 11:38
 **/
public interface OrderItemRepository extends JpaRepository<Order_item,Long> {
    void deleteAllByOrder(Order order);

}
