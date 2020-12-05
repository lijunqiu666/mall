package whut.mall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import whut.mall.entity.User;

/**
 * mall
 * 2020/8/23 16:57
 * 用户数据访问层
 *
 * @author 李俊秋
 **/

public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsernameAndPassword(String username,String password);


    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "insert into user(username,password,email,phone) values (?1,?2,?3,?4)")
    Integer insertUser(String username, String password, String email, String phone);
}
