package whut.mall.entity;


import javax.persistence.*;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="t_product")
public class Product {
    @Id
    @GeneratedValue
    private Long product_id;
    private String product_name;  //产品名称
    private BigDecimal price;           //产品价格
    private Boolean status;       //产品审核状态
    private String image;         //产品配图
    private String introduction;  //产品简介
    private String kind;//产品种类


    @ManyToOne
    private Shop shops;          //产品商家

    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<Stock> stock=new ArrayList<>();      //产品库存

    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<User> users=new ArrayList<>();      //用户

    @OneToMany(mappedBy = "products")
    private List<Colour> colour=new ArrayList<>();          //产品颜色

    @OneToMany(mappedBy = "products")
    private List<Comment> comments = new ArrayList<>(); // 产品评论

    public Product() {
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
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

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
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

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", image='" + image + '\'' +
                ", introduction='" + introduction + '\'' +
                ", kind='" + kind + '\'' +
                ", shops=" + shops +
                ", users=" + users +
                ", colour=" + colour +
                ", comments=" + comments +
                '}';
    }
}
