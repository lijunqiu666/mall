package whut.mall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import whut.mall.entity.Product;

public interface ProductRespositiry extends JpaRepository<Product, Long>, JpaSpecificationExecutor {
    Product save(Product product);
}
