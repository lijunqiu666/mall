package whut.mall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import whut.mall.entity.*;

import java.util.List;

/**
 * mall
 * 2020/8/23 17:20
 *
 * @author 李俊秋
 **/

public interface AdminRepository extends JpaRepository<Admin, Long> {

    @Query(nativeQuery = true, value = "select * from admin where adminname=?1 and password=?2")
    Admin findByAdminnameAndPassword(String username, String password);



    //查询后买记录
    @Query(nativeQuery = true, value = "select t_order.user_id,pay,order_time,\n" +
            "orderitem.quantity,orderitem.product_product_id,orderitem.order_id,orderitem.id from t_order,orderitem\n" +
            "where orderitem.order_id=t_order.id")
    PurchaseHistory findallHistory();
}
