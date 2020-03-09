package com.example.demo.dao;


import com.example.demo.data.Person;

import java.util.List;
import java.util.Optional;


public interface PersonDao {
    int insertPerson(Person person);

    List<Person> listPersons();

    int deletePersonById(Long id);

    Person updatePersonById(Long id, Person personPojo);

    Optional<Person> selectPersonById(Long id);
}
