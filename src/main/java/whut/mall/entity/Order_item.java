package whut.mall.entity;

import javax.persistence.*;

/**
 * @ClassName Order_item
 * @Description TODO
 * @Author liaowenhua
 * Date 2020/8/22 19:04
 **/
@Entity
@Table(name = "orderitem")
public class Order_item {
   @Id
   @GeneratedValue
    Long id;
   @ManyToOne
   Order order;
   @ManyToOne
   Product product;
   Integer quantity;//商品数量

    public Order_item() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order_item{" +
                "id=" + id +
                ", order=" + order +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}

