package whut.mall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whut.mall.entity.Admin;
import whut.mall.entity.User;
import whut.mall.repository.AdminRepository;

/**
 * mall
 * 2020/8/23 17:19
 *
 * @author 李俊秋
 **/
@Service
public class AdminService {
    @Autowired
    AdminRepository adminRepository;
    public Admin checkUser(String username, String password) {
        Admin admin = adminRepository.findByAdminnameAndPassword(username, password);
        return admin;

    }
}
