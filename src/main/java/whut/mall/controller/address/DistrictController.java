package whut.mall.controller.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import whut.mall.entity.District;
import whut.mall.service.implement.DistrictServiceImpl;

import java.util.List;

/**
 * @ClassName DistrictController
 * @Description TODO
 * @Author liaowenhua
 * Date 2020/8/23 16:32
 **/
@Controller
@RequestMapping("/district")
public class DistrictController {
    @Autowired
    DistrictServiceImpl districtService;
    /*
    *@author liaowenhua
    *@Description 获得相应地理信息的list
    *@Date 16:51 2020/8/23
    *@Param [perent]
    *@Return
    **/
    @GetMapping("/list/{id}")
public List<District>listByperent(String id)
{
    return districtService.listByPCode(id);
}

}
