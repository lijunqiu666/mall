package whut.mall.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import whut.mall.entity.Stock;

import java.util.List;

public interface StockService {
    //新增方法
    Stock save(Stock t1);
    //带分页的数据查询
    Page<Stock> listStock(Pageable pageable);
    //删除
    void delete(long id);
    // 根据名称查找类别
    Stock getStockByName(String name);
    //更新操作
    Stock updateStock(long id,Stock stock);
    // 全查
    List<Stock> listStock();

    Stock getStockByID(long id);



}
