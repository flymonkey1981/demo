package com.example.demo.dao;

import com.example.demo.data.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository("mysqlDB")
public class PersonDaoImpl implements PersonDao{
    private PersonRepository personRepository;

    @Autowired
    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public int insertPerson(Person person) {
        personRepository.save(person);
        return 1;
    }

    @Override
    public List<Person> listPersons() {
       return StreamSupport.stream(personRepository.findAll().spliterator(),false).collect(Collectors.toList());
      // Iterator<Person> iterator = personRepository.findAll();
    }

    @Override
    public int deletePersonById(Long id) {
        personRepository.deleteById(id);
        return 1;
    }

    @Override
    public Person updatePersonById(Long id, Person person) {
        return selectPersonById(id).map(
                p -> {
                    p.setName(person.getName());
                    return personRepository.save(p);
                }).orElseGet(() -> {
            person.setId(id);
            return personRepository.save(person);
        });

    }

    @Override
    public Optional<Person> selectPersonById(Long id) {
        return personRepository.findById(id);

    }
}
