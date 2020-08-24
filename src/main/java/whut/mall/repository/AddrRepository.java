package whut.mall.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import whut.mall.entity.Address;
import whut.mall.entity.User;

import java.util.List;

/**
 * @ClassName AddrRepository
 * @Description TODO
 * @Author liaowenhua
 * Date 2020/8/23 21:35
 **/
public interface AddrRepository extends JpaRepository<Address,Long> {
    List<Address> findAllByUser(User user);



//    @Query("update Address n set n.isDefault = false where User.id = ?1 ") //报错，无效
//    @Transactional
//    @Modifying
//    @Query("update Address n set n.isDefault = false where user_id= ?1 ")
//    int setNotDefault(Long uid);
}
