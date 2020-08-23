package whut.mall.service;

import whut.mall.entity.Address;
import whut.mall.entity.User;

import java.util.List;

/**
 * @ClassName AddressService
 * @Description TODO
 * @Author liaowenhua
 * Date 2020/8/23 21:30
 **/
public interface AddressService {
    List<Address> getListByUser(User user);
    int createOrUpdate(Address address);
    int setDefault(User user, Long id);
    int delete(Long id);
}
