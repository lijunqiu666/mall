package whut.mall.controller.shoping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shoping")
public class Shoping {
@GetMapping("/one")
    int shoping(Long id)
    {
    return 1;
    }

}
