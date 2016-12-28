package example.spring.hateoas.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.hateoas.Identifiable;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created by sgupta on 12/28/16.
 */
@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 2, max = 200)
    @Column(nullable = false)
    private String name;

    @Size(max = 200)
    @Column
    private String address;
}
