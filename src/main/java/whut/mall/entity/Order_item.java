package whut.mall.entity;

import javax.persistence.*;

/**
 * @ClassName Order_item
 * @Description TODO
 * @Author liaowenhua
 * Date 2020/8/22 19:04
 **/
public class Order_item {
   @Id
   @GeneratedValue
    int id;
   @ManyToOne
   Order order;
   @OneToOne
   Product product;
   int quantity;//商品数量

   /*
   *@author liaowenhua
   *@Description 获得总金额
   *@Date 20:21 2020/8/22
   *@Param
   *@Return
   **/
    long getTotalmoney()
    {
        return quantity*product.getPrice();
    }


}

