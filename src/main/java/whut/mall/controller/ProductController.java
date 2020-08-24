package whut.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import whut.mall.entity.Product;
import whut.mall.entity.ProductQuery;
import whut.mall.entity.Stock;
import whut.mall.service.ProductService;
import whut.mall.service.StockService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    StockService stockService;

    // 分页全查
    @GetMapping("/Product")
    public String Product(@PageableDefault(size = 3) Pageable pageable, Model model) {
        // 不仅需要查询当前页的数据  还需要查询全部的类别
        model.addAttribute("types", stockService.listStock());
        model.addAttribute("page", productService.listProduct(pageable));
        return "admin/Product";
    }

    // 跳转到user的index
    @GetMapping("/Product2")
    public String Product2(@PageableDefault(size = 3) Pageable pageable, Model model) {
        model.addAttribute("stocks", stockService.listStock());
        model.addAttribute("page", productService.listProduct(pageable));
        return "user/index";
    }

    // 新增的前置操作
    @GetMapping("/news/input")
    public String toAdd(Model model) {
        // 需要传递空对象  所有类别  所有标签
        model.addAttribute("product", new Product());
        model.addAttribute("Stock", stockService.listStock());
        return "admin/Product-input";
    }

    // 新增操作
    @PostMapping("/Product/add")
    public String addOrUpdate(Product product, HttpSession session, RedirectAttributes attributes) {

        // 得到Stock对象 , 将Stock对象存储到对象中，    因为前台传递的Type对象中只有一个id  所以需要通过id找到整个type对象  再进行存储
        //有问题
//        product.setStock(stockService.getStockByID(product.getStock().getId()));
        System.out.println(product);
        Product n;
        // 判断当前是新增或是更新
        if (product.getProduct_id() == 0) {
            n = productService.save(product);
        } else {
            n = productService.updateProduct(product.getProduct_id(), product);
        }

        if (n == null) {
            attributes.addFlashAttribute("message", "操作失败");
        } else {
            attributes.addFlashAttribute("message", "操作成功");
        }
        return "redirect:/admin/Product ";

    }




//    @PostMapping("/product/search")
//    public String search(@PageableDefault(size = 3, sort = "updateTime", direction = Sort.Direction.DESC) Pageable pageable,
//                         Model model, ProductQuery productQuery) {
//
//
//        // 携带查询条件  查找数据
//        System.out.println(productQuery);
//        model.addAttribute("page", productService.listProduct(pageable, productQuery));
//        return "admin/product :: productList";
//    }
}






