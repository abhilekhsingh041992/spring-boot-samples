package example.springboot.jpa.domain;

import example.springboot.jpa.custom.ItemStatus;

import javax.persistence.*;

/**
 * Created by abhilekhsingh on 12/16/16.
 */
@Entity
public class OrderItem {

    @Id
    private Long id;

    @Basic
    private String name;

    @Basic
    @Column(name = "item_status", columnDefinition = "TINYINT")
    private ItemStatus itemStatus;

    @ManyToOne(cascade = CascadeType.ALL)
    private CustomOrder customOrder;

}
