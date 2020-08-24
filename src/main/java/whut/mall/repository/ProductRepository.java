package whut.mall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import whut.mall.entity.Product;

import java.math.BigDecimal;
import java.util.List;

/**
 * mall
 * 2020/8/24 13:19
 *
 * @author 李俊秋
 **/

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(nativeQuery = true, value = "select count(*) from t_product")
    int getTotal(String productName);


    @Query(nativeQuery = true, value = "select product_id,image,introduction,kind,price,product_name,shops_id,status from t_product limit ?1, ?2")
    List<Product> findAllByPage(int start, int size, String productName);


    @Query(nativeQuery = true, value = "select product_id,image,introduction,kind,price,product_name,shops_id,status  from t_product where product_id=?1")
    Product findProductById(Long id);


    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update t_product set product_name=?2,kind=?3,price=?4,introduction=?5 where product_id=?1")
    int updateProduct(Long product_id, String product_name, String kind, BigDecimal price, String introduction);


    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "insert into t_product(product_name,kind,price,introduction) values (?1,?2,?3,?4)")
    void addProduct(String product_name, String kind, BigDecimal price, String introduction);



}
