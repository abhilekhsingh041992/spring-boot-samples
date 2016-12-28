package example.spring.hateoas.domain.repository;

import example.spring.hateoas.domain.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sgupta on 12/28/16.
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
