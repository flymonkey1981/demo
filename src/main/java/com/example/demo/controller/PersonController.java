package com.example.demo.controller;

import com.example.demo.data.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="api/v1/person", produces = { MediaType.APPLICATION_JSON_VALUE })
public class PersonController {

    private PersonService personService;

    @Autowired
    public void setPersonService(PersonService personService){
        this.personService = personService;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('admin')")
    public void insertPerson(@RequestBody Person person){
        personService.insertPerson(person);

    }
    @GetMapping
    public List<Person> listPerson(){
        return personService.listPersons();

    }

    @GetMapping(path="{id}")
    @PreAuthorize("hasAuthority('admin')")
    public Person getPersonById(@PathVariable("id") Long id){
        return personService.getPersonById(id).orElse(null);
    }

    @DeleteMapping(path="{id}")
    public void deletePersonById(@PathVariable("id") Long id){
        personService.deletePersonById(id);
    }
    @PutMapping(path="{id}")
    public void updatePersonById(@PathVariable("id") Long id, @RequestBody Person person){
        personService.updatePersonById(id, person);
    }
}
