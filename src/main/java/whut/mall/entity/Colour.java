package whut.mall.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_colour")
public class Colour {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToOne
    private Product products;

    public Colour() {
    }

    public Long getProduct_id() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Product getProducts() {
        return products;
    }

    public void setProduct_id(Long product_id) {
        this.id = product_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProducts(Product products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Colour{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
