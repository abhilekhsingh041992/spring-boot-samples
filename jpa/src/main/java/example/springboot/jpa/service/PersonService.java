package example.springboot.jpa.service;

import example.springboot.jpa.domain.Sim;
import example.springboot.jpa.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by abhilekhsingh on 12/17/16.
 */
@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Sim> getAllSims() {
        return personRepository.getSims();
    }
}
