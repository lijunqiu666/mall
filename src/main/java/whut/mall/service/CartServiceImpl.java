package whut.mall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import whut.mall.entity.Cart;
import whut.mall.entity.Product;
import whut.mall.entity.User;
import whut.mall.repository.CartRepository;

import javax.persistence.criteria.*;
import java.util.Date;

/**
 * @ClassName CartServiceImpl
 * @Description TODO
 * @Author liaowenhua
 * Date 2020/8/22 21:59
 **/
@Service
public class CartServiceImpl implements CartService{
    @Autowired
    CartRepository cartRepository;

    public int addCart(User user, Product product, int quantity) {
        //是否需要先查询User而构建完整的user呢？
        //将cart对象设置完整
        //插入即可
    Cart cart=new Cart();
    cart.setUser(user);
    cart.setProduct(product);
    cart.setQuantity(quantity);
    cart.setUpdate_time(new Date());
        Cart cart1= cartRepository.save(cart);
        if(cart1!=null)
            return 1;
        return 0;
    }

    @Override
    public Page<Cart> listCart(Pageable pageable, User user) {

        return cartRepository.findAll(new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Join join = root.join("user");
                return criteriaBuilder.equal(join.get("id"), user.getId());

            }
        },pageable);
    }

    @Override
    public int addCount(Long id) {
       Cart cart= cartRepository.getOne(id);
        cart.setQuantity(cart.getQuantity()+1);
        cartRepository.save(cart);
        return 1;
    }

    @Override
    public int deleteCount(Long id) {
        Cart cart= cartRepository.getOne(id);
        cart.setQuantity(cart.getQuantity()-1);
        cartRepository.save(cart);
        return 1;
    }
}
