package example.spring.hateoas.service;

import example.spring.hateoas.domain.entity.Person;
import example.spring.hateoas.domain.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sgupta on 12/28/16.
 */
@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional
    private Person create(Person person) {
        person.setId(null);
        return personRepository.save(person);
    }

    public Person createPerson(Person person) {
        return create(person);
    }

    public Person getPerson(long id) {
        return personRepository.getOne(id);
    }
}
