package example.springboot.jpa.specification;

import example.springboot.jpa.domain.Person;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhilekhsingh on 12/17/16.
 */
public class PersonSpecification implements Specification<Person> {

    @Override
    public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        List<Predicate> predicates = new ArrayList<>();
        query.groupBy(root.get("id"));
        //there I want to order by Sim.name i dont know how
        query.orderBy(builder.asc(root.join("telephonesNumber").get("sim").get("name")));

        query.orderBy(builder.asc(root.get("phone")));//this works
        return  builder.and((predicates.toArray(new Predicate[predicates.size()])));
    }

}
