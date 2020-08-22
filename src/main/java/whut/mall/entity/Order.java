package whut.mall.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @ClassName Order
 * @Description TODO
 * @Author liaowenhua
 * Date 2020/8/22 18:51
 **/

@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue
    Long id;
    @ManyToOne
    User user;
    Double pay;
    @Temporal(TemporalType.TIMESTAMP)
    Date order_time;
    Boolean status;

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getPay() {
        return pay;
    }

    public void setPay(Double pay) {
        this.pay = pay;
    }

    public Date getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Date order_time) {
        this.order_time = order_time;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", pay=" + pay +
                ", order_time=" + order_time +
                ", status=" + status +
                '}';
    }
}
