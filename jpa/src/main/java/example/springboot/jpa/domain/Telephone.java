package example.springboot.jpa.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by abhilekhsingh on 12/17/16.
 */
@Entity
public class Telephone implements Serializable {
    @Id
    private String number;
    @Id
    @ManyToOne()
    @JoinColumn(name = "person_id")
    private Person person;
    @Id
    @ManyToOne(cascade = {})
    @JoinColumn(name = "sim_id")
    private Sim sim;
}
