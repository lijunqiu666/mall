package whut.mall.entity;


import javax.persistence.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="t_product")
public class Product {
    @Id
    @GeneratedValue
    private long product_id;
    private String product_name;  //产品名称
    private long price;           //产品价格
    private boolean status;       //产品审核状态
    private String image;         //产品配图
    private String introduction;  //产品简介

    @ManyToOne
    private Shop shops;          //产品商家

    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<Stock> stock=new ArrayList<>();      //产品种类

    @OneToMany(mappedBy = "products")
    private List<Colour> colour=new ArrayList<>();          //产品颜色

    @OneToMany(mappedBy = "products")
    private List<Comment> comments = new ArrayList<>(); // 产品评论

    public Product() {
    }


}
