package whut.mall.controller.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import whut.mall.entity.Address;
import whut.mall.entity.User;
import whut.mall.service.implement.AddressServiceImpl;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ClassName AddressControler
 * @Description 地址控制器
 * @Author liaowenhua
 * Date 2020/8/23 14:44
 **/
@Controller
@RequestMapping("/address")
public class AddressControler {

    @Autowired
    AddressServiceImpl addressService;

List<Address> listaddress(HttpSession session)
{
    List<Address> list = addressService.getListByUser((User) session.getAttribute("user"));
    return list;
}

//可以把创建和更新地址放在一起吗，创建的时候Address的id为0或者为负都可以,应该把地址信息改一下，再设置一下address的id字段就好了
    /*
    *@author liaowenhua
    *@Description 创建或者更新地址信息
    *@Date 21:44 2020/8/23
    *@Param [address, session]
    *@Return int
    **/
@PostMapping("/createOrupdate")
public int handleCreate(Address address, HttpSession session) {
    User user= (User) session.getAttribute("user");

    address.setUser(user);
    int i=addressService.createOrUpdate(address);
    return i;
}
    @GetMapping("/default/{id}")
    public int setDefault(HttpSession session, @PathVariable("id") Long id) {//得到Address的id
       int i= addressService.setDefault((User) session.getAttribute("user"), id);
        return i;
    }

    @GetMapping("/delete/{id}")
    public int deleteById( @PathVariable("id") Long id) {
       int i= addressService.delete(id);
        return i;
    }


}
