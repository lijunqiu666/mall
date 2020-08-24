package whut.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import whut.mall.entity.Stock;
import whut.mall.service.StockService;

@Controller
@RequestMapping("/后台功能")
public class StockController {
    @Autowired
    StockService stockService;

    @GetMapping("/前端分类页面请求路径")
    public String StockController() {
        return "前端页面";
    }

    @GetMapping("/路径")
    public String stocks(@PageableDefault(size = 5,sort = {"id"},direction = Sort.Direction.DESC) Pageable pageable,
                         Model model){
        //pageable 前端封装分页对象 内部存放相关分页数据
        //查询所有分类对象
       Page<Stock> page = stockService.listStock(pageable);
       model.addAttribute("Page",page);
       return "前端分类页面";
    }

    @GetMapping("/前端增加分类请求路径")
    public String Stocks_Input(Model model){
        model.addAttribute("Stock",new Stock());
        return "前端增加分类页面";

    }

    @PostMapping("请求路径")
    public String Stock_Post(Stock stock, RedirectAttributes attributes)
    {
      Stock t = stockService.save(stock);
      if(t==null){
          attributes.addFlashAttribute("message", "新增失败");
      }
        attributes.addFlashAttribute("message", "新增成功");
      return "重定位分类页面";
    }

    @GetMapping("删除by id")
    public  String Stock_delete(@PathVariable long id,RedirectAttributes attributes)
    {
        stockService.delete(id);
        attributes.addFlashAttribute("message","删除成功");
        return "重定位分类页面";
    }

    @GetMapping("请求路径")
    public String Stock_update(long id, Stock stock, BindingResult bindingResult,RedirectAttributes attributes){
        Stock t1=stockService.getStockByName(stock.getName());
        if(t1!=null){
            bindingResult.rejectValue("name","nameErr","该名称存在");
        }
        if(bindingResult.hasErrors()){
            return "重定位增加页面";
        }
        Stock t2 = stockService.updateStock(id,stock);
        if (t2 == null) {
            attributes.addFlashAttribute("message", "更新失败");
        } else {
            attributes.addFlashAttribute("message", "更新成功");
        }
        return "重定位分类页面";
    }
}
