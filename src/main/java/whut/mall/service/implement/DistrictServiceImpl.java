package whut.mall.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whut.mall.entity.District;
import whut.mall.repositiry.DistRepository;
import whut.mall.service.DistrictService;

import java.util.List;

/**
 * @ClassName DistrictServiceImpl
 * @Description TODO
 * @Author liaowenhua
 * Date 2020/8/23 16:39
 **/
@Service
public class DistrictServiceImpl implements DistrictService {
@Autowired
    DistRepository distRepository;
    @Override
    public List<District> listByPCode(String parent) {
        return distRepository.findAllByParent(parent);

    }
}
