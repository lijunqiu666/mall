package whut.mall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import whut.mall.entity.Product;
import whut.mall.entity.ProductQuery;
import whut.mall.repository.ProductRepository;
import whut.mall.service.ProductService;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRespositiry;
    @Override
    public Product save(Product product){
        return productRespositiry.save(product);

    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product n = productRespositiry.getOne(id);
        if (n == null) {
            System.out.println("不存在");
            return null;
        }

        return productRespositiry.save(product);
    }

    @Override
    public Product getProductByID(Long id) {
        return productRespositiry.getOne(id);
    }


    @Override
    public Page<Product> listProduct(Long id, Pageable pageable) {
        return null;
    }

    @Override
    public List<Product> ShowAll() {
      return productRespositiry.findAll();
    }

    @Override
    public Page<Product> listProduct(Pageable pageable) {
        return productRespositiry.findAll(pageable);
    }

    @Override
    public Page<Product> listProduct(Pageable pageable, ProductQuery productQuery) {
        // new一个接口  必须要实现他的抽象方法
        return productRespositiry.findAll(new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery cq, CriteriaBuilder cb) {
                // root             数据库中的字段名
                // CriteriaBuilder  构建查询条件
                // CriteriaQuery    执行查询条件

                // 1. 创建集合 存储查询条件
                List<Predicate> list = new ArrayList<>();
                // 2. 添加查询条件
                if (!"".equals(productQuery.getStockID()) && productQuery.getStockID() != null) {
                    // 当StockID不为空时, 向list中存储查询条件
                    list.add(cb.like(root.<String>get("stock"), "%" + productQuery.getStockID() + "%"));
                }


                // 3. 执行查询
                cq.where(list.toArray(new Predicate[list.size()]));
                return null;
            }
        }, pageable);
    }
}
