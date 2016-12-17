package example.springboot.jpa.repository;

import example.springboot.jpa.domain.CustomOrder;
import example.springboot.jpa.domain.Person;
import example.springboot.jpa.domain.Sim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by abhilekhsingh on 12/17/16.
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("select s from Person p join p.telephonesNumber t join t.sim s order by t.sim.id")
    List<Sim> getSims();
}
