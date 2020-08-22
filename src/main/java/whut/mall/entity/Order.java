package whut.mall.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @ClassName Order
 * @Description TODO
 * @Author liaowenhua
 * Date 2020/8/22 18:51
 **/
public class Order {
    @Id
    @GeneratedValue
    int id;
    @ManyToOne
    User user;
    Double pay;
    @Temporal(TemporalType.TIMESTAMP)
    Date order_time;
    Boolean status;

}
