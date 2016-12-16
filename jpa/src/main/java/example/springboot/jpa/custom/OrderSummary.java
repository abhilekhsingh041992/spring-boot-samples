package example.springboot.jpa.custom;

import example.springboot.jpa.domain.CustomOrder;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by abhilekhsingh on 12/16/16.
 */
@Data
@AllArgsConstructor
public class OrderSummary {
    private CustomOrder order;
    private Long orderedItems;
    private Long canceledItems;
}
