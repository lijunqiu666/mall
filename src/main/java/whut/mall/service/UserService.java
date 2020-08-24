package whut.mall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whut.mall.entity.User;
import whut.mall.repository.UserRepository;

/**
 * mall
 * 2020/8/23 10:15
 * 用户服务层
 *
 * @author 李俊秋
 **/
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User checkUser(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, password);
        return user;

    }

    public Integer register(String username,String password,String email,String phone){
        Integer i=userRepository.insertUser(username,password,email,phone);
        return i;
    }

}
