package whut.mall.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "t_Shop")
public class Shop {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    @OneToMany(mappedBy = "shops")
    private List<Product> products=new ArrayList<>();

    public Shop() {
    }

    public Long getProduct_id() {
        return id;
    }

    public String getProduct_name() {
        return name;
    }

    public List<Product> getProduct() {
        return products;
    }

    public void setProduct_id(Long product_id) {
        this.id = id;
    }

    public void setProduct_name(String product_name) {
        this.name = name;
    }

    public void setProduct(List<Product> product) {
        this.products = product;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
