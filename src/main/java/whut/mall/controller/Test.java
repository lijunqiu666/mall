package whut.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * mall
 * 2020/8/20 16:58
 * 测试类
 *
 * @author 李俊秋
 **/
@RestController
@RequestMapping("/user")

public class Test {
    @GetMapping("/test")
    public String test(){
        return "hello";
    }

    @GetMapping("/shoping")
    public String test1()
    {
        return "nothing";
    }
}
