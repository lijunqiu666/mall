package whut.mall.entity;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.apache.catalina.User;

import javax.persistence.*;

@Entity
@Table("t_cart")
/**
 *购物车实体类
 * @Description TODO
 *  @Author liaowenhua
 *  Date 2020/8/22 18:51
 */

public class Cart {

    @Id
    @GeneratedValue
    int id;//id
    @OneToOne
    Product product;//产品
    int quantity;//数量
    @ManyToOne
    User user;//用户

}
