package whut.mall;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import whut.mall.entity.Cart;
import whut.mall.entity.Product;
import whut.mall.entity.User;
import whut.mall.service.CartService;

import java.awt.print.PageFormat;
import java.awt.print.Pageable;
import java.awt.print.Printable;
import java.util.List;

/**
 * @ClassName CartTest
 * @Description TODO
 * @Author liaowenhua
 * Date 2020/8/24 15:32
 **/
@SpringBootTest
public class CartTest {
    @Autowired
    CartService cartService;
    @Test
    void cartTest()
    {
        User user=new User();
        user.setId((long) 1);
        Product product=new Product();
        product.setProduct_id((long) 1);
        cartService.addCart(user,product,10);
    }
    @Test
    void listCartTest()
    {
        User user=new User();
        user.setId((long) 1);
        Pageable pageable=new Pageable() {
            @Override
            public int getNumberOfPages() {
                return 0;
            }

            @Override
            public PageFormat getPageFormat(int pageIndex) throws IndexOutOfBoundsException {
                return null;
            }

            @Override
            public Printable getPrintable(int pageIndex) throws IndexOutOfBoundsException {
                return null;
            }
        };
        Page<Cart> page=cartService.listCart((org.springframework.data.domain.Pageable) pageable,user);
        System.out.println(page);
    }

    @Test
    void testaddcount()
    {
        System.out.println("================"+cartService.addCount((long) 1));
    }
    @Test
    void testdelete()
    {
        cartService.deleteCart((long) 2);
    }
}
