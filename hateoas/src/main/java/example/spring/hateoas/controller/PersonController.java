package example.spring.hateoas.controller;

import example.spring.hateoas.domain.entity.Person;
import example.spring.hateoas.resource.model.Resource;
import example.spring.hateoas.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

/**
 * Created by sgupta on 12/28/16.
 */
@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public @ResponseBody Resource<Person> createPerson(HttpServletRequest httpServletRequest, @RequestBody Person person) {
        person = personService.createPerson(person);
        Resource<Person> resource = new Resource<>(person);
        resource.add(linkTo(PersonController.class).slash(httpServletRequest.getServletPath()).slash(person
                .getId()).withSelfRel());
        return resource;
    }

    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
    public @ResponseBody Resource<Person> getPerson(@PathVariable Long id) {
        Person person = personService.getPerson(id);
        Resource<Person> resource = new Resource<>(person);
        resource.add(linkTo(methodOn(PersonController.class).getPerson(id)).withSelfRel());
        return resource;
    }
}
