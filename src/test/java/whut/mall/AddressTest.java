package whut.mall;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import whut.mall.entity.District;
import whut.mall.service.implement.AddressServiceImpl;
import whut.mall.service.implement.DistrictServiceImpl;

import java.util.List;

/**
 * @ClassName AddressTest
 * @Description TODO
 * @Author liaowenhua
 * Date 2020/8/24 17:34
 **/
@SpringBootTest
public class AddressTest {
    @Autowired
    AddressServiceImpl addressService;
    @Autowired
    DistrictServiceImpl districtService;

    @Test
    void testdistrict()//懒加载错误
    {
        List<District> districtList = districtService.listByPCode("86");
        System.out.println(districtList);
    }

}
