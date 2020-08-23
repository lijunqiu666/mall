package whut.mall.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * mall
 * 2020/8/22 17:23
 * 用户实体类
 *
 * @author 李俊秋
 **/
@Entity
@Table(name = "user")


public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private String sex;
    private String email;
    private String avatar;
    private String phone;
    private String address;//售货地址

    //用户和商品之间的关系
    @ManyToMany(mappedBy = "users")
    private List<Product> productList = new ArrayList<>();


    //用户和订单之间的关系
    @OneToMany(mappedBy = "user")
    private List<Order> orderList = new ArrayList<>();

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", avatar='" + avatar + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", productList=" + productList +
                ", orderList=" + orderList +
                '}';
    }
}
