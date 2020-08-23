package whut.mall.entity;

import javax.persistence.*;

/**
 * @ClassName Address
 * @Description 地址实体
 * @Author liaowenhua
 * Date 2020/8/23 14:47
 **/
@Entity
@Table(name = "t_address")
public class Address {
@Id
@GeneratedValue
    private Long id;
         @ManyToOne
//         @Column(name = "user_id")
    User user;//创建人
    String PostName;//收获人
    /**省*/
    private String province;//省的code
    /**市*/
    private String city;
    /**区*/
    private String area;
    /**邮编*/
    private String post;
    /**详细地址*/
    private String address;//末尾的详细地址
    /**手机*/
    private String phone;
    /**固定电话*/
    private String tel;
    /**标签*/
    private String tag;
    /**是否默认，0-非默认，1-默认*/
    private Boolean isDefault;

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

 public String getProvince() {
  return province;
 }

 public void setProvince(String province) {
  this.province = province;
 }

 public String getCity() {
  return city;
 }

 public void setCity(String city) {
  this.city = city;
 }

 public String getArea() {
  return area;
 }

 public void setArea(String area) {
  this.area = area;
 }

 public String getPost() {
  return post;
 }

 public void setPost(String post) {
  this.post = post;
 }

 public String getAddress() {
  return address;
 }

 public void setAddress(String address) {
  this.address = address;
 }

 public String getPhone() {
  return phone;
 }

 public void setPhone(String phone) {
  this.phone = phone;
 }

 public String getTel() {
  return tel;
 }

 public void setTel(String tel) {
  this.tel = tel;
 }

 public String getTag() {
  return tag;
 }

 public void setTag(String tag) {
  this.tag = tag;
 }

 public Boolean getDefault() {
  return isDefault;
 }

 public void setDefault(Boolean aDefault) {
  isDefault = aDefault;
 }
}
