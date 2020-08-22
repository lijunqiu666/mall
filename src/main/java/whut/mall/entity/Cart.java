package whut.mall.entity;

import javax.persistence.*;



/**
 *购物车实体类
 * @Description TODO
 *  @Author liaowenhua
 *  Date 2020/8/22 18:51
 */
@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue
    Long id;//id

    Product product;//产品
    Integer quantity;//数量
    @ManyToOne
    User user;//用户

    public Cart() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", product=" + product +
                ", quantity=" + quantity +
                ", user=" + user +
                '}';
    }
}
