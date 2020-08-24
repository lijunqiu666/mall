package whut.mall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import whut.mall.entity.Stock;
import whut.mall.repositiry.StockRepositiry;
import whut.mall.service.StockService;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {
    @Autowired
    StockRepositiry stockRepositiry;

    @Override
    public Stock save(Stock t1) {

        return stockRepositiry.save(t1);
    }

    @Override
    public Page<Stock> listStock(Pageable pageable) {
        return stockRepositiry.findAll(pageable);
    }

    @Override
    public void delete(long id) {
        stockRepositiry.deleteById(id);

    }

    @Override
    public Stock getStockByName(String name) {
       return stockRepositiry.findByName(name);
    }

    @Override
    public Stock updateStock(long id, Stock stock) {
        Stock t = stockRepositiry.getOne(id);
        if (t == null) {
            System.out.println("没有该分类");
            return null;
        }
        // save方法 如果存在数据则更新 不存在则保存
        return stockRepositiry.save(stock);
    }

    @Override
    public List<Stock> listStock() {
        return stockRepositiry.findAll();
    }

    @Override
    public Stock getStockByID(long id) {
        return stockRepositiry.getOne(id);
    }
}
