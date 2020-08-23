package whut.mall.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whut.mall.entity.Address;
import whut.mall.entity.User;
import whut.mall.repositiry.AddrRepository;
import whut.mall.service.AddressService;

import java.util.List;

/**
 * @ClassName AddressServiceImpl
 * @Description 地址处理
 * @Author liaowenhua
 * Date 2020/8/23 21:31
 **/
@Service
public class AddressServiceImpl implements AddressService {
@Autowired
    AddrRepository addrRepository;
    @Override
    public List<Address> getListByUser(User user) {
        return addrRepository.findAllByUser(user);
    }

    @Override
    public int createOrUpdate(Address address) {

        Address address1= addrRepository.save(address);
        if(address1!=null)
            return 1;
            return 0;
    }

    @Override
    public int setDefault(User user, Long id) {
        //将现在的默认类型设置为非默认类型
//        addrRepository.setNotDefault(user.getId());
        List<Address> list=addrRepository.findAllByUser(user);
        for (Address a:list
             ) {
            a.setDefault(false);
            addrRepository.save(a);
        }
        //设置现在的为默认类型
        Address address = addrRepository.getOne(id);
        if (address == null)
            return 0;
        address.setDefault(true);
        address.setUser(user);//不清楚用不用
        addrRepository.save(address);
        return 1;

    }
    public int delete( Long id) {
         addrRepository.deleteById(id);//返回类型为void？
         return 1;
    }

}
