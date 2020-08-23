package whut.mall.service;

import whut.mall.entity.District;

import java.util.List;

/**
 * @ClassName DistrictService
 * @Description TODO
 * @Author liaowenhua
 * Date 2020/8/23 16:37
 **/
public interface DistrictService {
    List<District> listByPCode(String parent);
}
