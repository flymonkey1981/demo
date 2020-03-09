package com.example.demo.service;

import com.example.demo.dao.PersonDao;
import com.example.demo.data.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private PersonDao personDao;

    @Autowired
    public void setPersonDao(@Qualifier("mysqlDB") PersonDao personDao){
        this.personDao = personDao;
    }

    public int insertPerson(Person person){
        return personDao.insertPerson(person);
    }

    public List<Person> listPersons(){
        return personDao.listPersons();
    }

    public Optional<Person> getPersonById(Long id){ return personDao.selectPersonById(id);}

    public int deletePersonById(Long id){return personDao.deletePersonById(id);}

    public Person updatePersonById(Long id, Person personPojo){return personDao.updatePersonById(id, personPojo);}
}
