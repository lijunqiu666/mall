package whut.mall.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import whut.mall.entity.Product;
import whut.mall.entity.ProductQuery;

import java.util.List;

public interface ProductService {
    //更新
    Product updateProduct(Long id,Product product);
    //保存
    Product save (Product product);
    //
    Product getProductByID(Long id);
    //分页全查
    Page<Product> listProduct(Pageable pageable);

    // 根据分类的id 查找 对应的新闻
    Page<Product> listProduct(Long id, Pageable pageable);
    //商品展示
    List<Product> ShowAll();
    //分类查询
    Page<Product> listProduct(Pageable pageable, ProductQuery productQuery);



}
