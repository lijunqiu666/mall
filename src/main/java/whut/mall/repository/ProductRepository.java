package whut.mall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import whut.mall.entity.Product;

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
}
