package example.springboot.jpa.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by abhilekhsingh on 12/16/16.
 */
@Entity
public class CustomOrder {

    @Id
    private Long id;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="customOrder")
    private List<OrderItem> orderItems;
}