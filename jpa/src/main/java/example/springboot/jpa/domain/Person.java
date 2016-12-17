package example.springboot.jpa.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by abhilekhsingh on 12/17/16.
 */
@Entity
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.PERSIST, mappedBy = "person")
    @PrimaryKeyJoinColumn
    private PersonData data;

}
