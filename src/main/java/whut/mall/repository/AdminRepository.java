package whut.mall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import whut.mall.entity.Admin;
import whut.mall.entity.Product;

import java.util.List;

/**
 * mall
 * 2020/8/23 17:20
 *
 * @author 李俊秋
 **/

public interface AdminRepository extends JpaRepository<Admin, Long> {

    @Query(nativeQuery = true, value = "select * from admin where adminname=?1 and password=?2")
    Admin findByAdminnameAndPassword(String username, String password);


}
