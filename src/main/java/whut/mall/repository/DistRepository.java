package whut.mall.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import whut.mall.entity.District;

import java.util.List;

/**
 * @ClassName DistRepository
 * @Description TODO
 * @Author liaowenhua
 * Date 2020/8/23 16:57
 **/
public interface DistRepository extends JpaRepository<District, Integer> {
    List<District> findAllByParent(String parent);
}
