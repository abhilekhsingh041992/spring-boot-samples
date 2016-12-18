package example.springboot.jpa.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by abhilekhsingh on 12/17/16.
 */
@Entity
public class PersonData implements Serializable {

    @Id
    @OneToOne(targetEntity = Person.class)
    private Long personId;
}
