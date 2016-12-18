package example.springboot.jpa.domain;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by abhilekhsingh on 12/17/16.
 */
@Entity
public class Sim implements Serializable {
    @Id
    private Long id;
    @Column(unique = true)
    private String name;
}