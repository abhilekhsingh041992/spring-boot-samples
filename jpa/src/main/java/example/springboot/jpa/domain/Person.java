package example.springboot.jpa.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by abhilekhsingh on 12/17/16.
 */
@Entity
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.PERSIST, mappedBy = "personId")
    @PrimaryKeyJoinColumn
    private PersonData data;

    @OneToMany(orphanRemoval = true, mappedBy = "person", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Telephone> telephonesNumber;

}
