package whut.mall.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * mall
 * 2020/8/24 18:22
 * 购买记录对象
 *
 * @author 李俊秋
 **/

public class PurchaseHistory {
    Long userid;
    BigDecimal pay;
    Timestamp order_time;
    Long id;
    Integer quantity;
    Long orderid;
    Long productid;

    public PurchaseHistory(Long userid, BigDecimal pay, Timestamp order_time, Long id, Integer quantity, Long orderid, Long productid) {
        this.userid = userid;
        this.pay = pay;
        this.order_time = order_time;
        this.id = id;
        this.quantity = quantity;
        this.orderid = orderid;
        this.productid = productid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public BigDecimal getPay() {
        return pay;
    }

    public void setPay(BigDecimal pay) {
        this.pay = pay;
    }

    public Timestamp getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Timestamp order_time) {
        this.order_time = order_time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getOrderid() {
        return orderid;
    }

    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }

    public Long getProductid() {
        return productid;
    }

    public void setProductid(Long productid) {
        this.productid = productid;
    }

    @Override
    public String toString() {
        return "PurchaseHistory{" +
                "userid=" + userid +
                ", pay=" + pay +
                ", order_time=" + order_time +
                ", id=" + id +
                ", quantity=" + quantity +
                ", orderid=" + orderid +
                ", productid=" + productid +
                '}';
    }
}
