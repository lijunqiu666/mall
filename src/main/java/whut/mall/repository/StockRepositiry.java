package whut.mall.repositiry;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import whut.mall.entity.Stock;

import java.util.List;


public interface StockRepositiry extends JpaRepository<Stock,Long> {
    Stock findByName(String name);

    @Query("select t from Stock t")
    List<Stock> findTop(Pageable p);
}
