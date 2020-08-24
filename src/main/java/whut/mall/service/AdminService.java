package whut.mall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whut.mall.entity.Admin;
import whut.mall.entity.PageInfo;
import whut.mall.entity.Product;
import whut.mall.entity.User;
import whut.mall.repository.AdminRepository;
import whut.mall.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * mall
 * 2020/8/23 17:19
 *
 * @author 李俊秋
 **/
@Service
public class AdminService {
    @Autowired
    AdminRepository adminRepository;

    @Autowired
    ProductRepository productRepository;


    public Admin checkUser(String username, String password) {
        Admin admin = adminRepository.findByAdminnameAndPassword(username, password);
        return admin;

    }

    public PageInfo<Product> findAllByPage(Integer currentPage, int size, String productName) {


        PageInfo<Product> pageInfo = new PageInfo<>();
        // 完善pageinfo 的属性值

        // 指定每页的数据量
        pageInfo.setSize(size);

        // 指定总数据量
        int totalCount = productRepository.getTotal(productName);

        System.out.println(totalCount);

        pageInfo.setTotalCount(totalCount);

        // 指定总页数  Math java中的内置对象    ceil 向上取整   floor 向下取整  round 四舍五入
        int totalPage = (int) Math.ceil((totalCount / (double) size));   // 10 / 3.0 = 3.33
        pageInfo.setTotalPage(totalPage);

        // 判断当前页是否合理
        if (currentPage < 1) {
            pageInfo.setCurrentPage(1);
        } else if (currentPage > totalPage) {
            pageInfo.setCurrentPage(totalPage);
        } else {
            pageInfo.setCurrentPage(currentPage);
        }

        // 指定当前页的数据    实质就是指定sql语句中的两个参数
        int start = (pageInfo.getCurrentPage() - 1) * pageInfo.getSize();
        List<Product> list = productRepository.findAllByPage(start, pageInfo.getSize(), productName);

        System.out.println(list);

        pageInfo.setList(list);

        return pageInfo;


    }

    public Product findProductById(Long id) {
        return productRepository.findProductById(id);

    }

    public int update(Long product_id, String product_name, String kind, BigDecimal price, String introduction) {
        return productRepository.updateProduct(product_id,product_name,kind,price,introduction);

    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public void addProduct(String product_name, String kind, BigDecimal price, String introduction) {

        productRepository.addProduct(product_name,kind,price,introduction);
    }
}
