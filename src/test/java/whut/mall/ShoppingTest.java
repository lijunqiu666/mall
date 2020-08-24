package whut.mall;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import whut.mall.entity.User;
import whut.mall.service.implement.ShoppingServiceImpl;

/**
 * @ClassName ShoppingTest
 * @Description TODO
 * @Author liaowenhua
 * Date 2020/8/24 18:58
 **/
@SpringBootTest
public class ShoppingTest {
    @Autowired
    ShoppingServiceImpl shoppingService;
    @Test
    void testbuyone()
    {
        User user=new User();
        user.setId((long) 1);
        System.out.println("================================"+shoppingService.buyOne(user, (long) 1,10));
    }
}
