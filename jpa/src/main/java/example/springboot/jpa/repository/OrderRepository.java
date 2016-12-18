package example.springboot.jpa.repository;

import example.springboot.jpa.custom.ItemStatus;
import example.springboot.jpa.custom.OrderSummary;
import example.springboot.jpa.domain.CustomOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by abhilekhsingh on 12/16/16.
 */
@Repository
public interface OrderRepository extends JpaRepository<CustomOrder, Long> {

    @Query("select new example.springboot.jpa.custom.OrderSummary(o, " +
            "sum(case when oi.itemStatus = 1 then 1 else 0 end) as orderedItems, " +
            "sum(case when oi.itemStatus = 1 then 1 else 0 end) as canceledItems)  " +
            "from OrderItem oi right join oi.customOrder o group by o")
    List<OrderSummary> findAllOrdersSummary();

}
