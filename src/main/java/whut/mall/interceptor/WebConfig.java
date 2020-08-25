package whut.mall.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * mall
 * 2020/8/23 10:10
 *
 * @author 李俊秋
 **/
@Configuration
public class WebConfig extends WebMvcConfigurationSupport{
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginInterceptor())
//                .addPathPatterns("/user/**")
//                .excludePathPatterns("/user")
//                .excludePathPatterns("/user/login");
//    }
public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
    // 注册Spring data jpa pageable的参数分解器
    argumentResolvers.add(new PageableHandlerMethodArgumentResolver());
}
}
