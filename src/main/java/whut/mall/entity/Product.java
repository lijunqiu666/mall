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

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Shop getShops() {
        return shops;
    }

    public void setShops(Shop shops) {
        this.shops = shops;
    }

    public List<Stock> getStock() {
        return stock;
    }

    public void setStock(List<Stock> stock) {
        this.stock = stock;
    }

    public List<Colour> getColour() {
        return colour;
    }

    public void setColour(List<Colour> colour) {
        this.colour = colour;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

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
