package whut.mall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import whut.mall.entity.Admin;

/**
 * mall
 * 2020/8/23 17:20
 *
 * @author 李俊秋
 **/

public interface AdminRepository extends JpaRepository<Admin, Long> {

    @Query("select a from Admin a where a.adminname=?1 and a.password=?2")
    Admin findByAdminnameAndPassword(String username, String password);




}
