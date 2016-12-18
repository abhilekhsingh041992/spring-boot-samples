package example.springboot.jpa.controllers;

import example.springboot.jpa.custom.OrderSummary;
import example.springboot.jpa.domain.Person;
import example.springboot.jpa.domain.Sim;
import example.springboot.jpa.service.OrderService;
import example.springboot.jpa.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by abhilekhsingh on 12/17/16.
 */
@RestController
public class SimController {

    private final PersonService personService;

    @Autowired
    public SimController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping("/sims")
    public List<Sim> greeting() {
        return personService.getAllSims();
    }

}
