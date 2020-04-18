package com.telran.person.persistence;

import com.telran.person.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface IPersonRepository extends CrudRepository<Person, Integer> {

    public List<Person> findAll();

    public List<Person> findByName(String name); // this method looks for all persons according to the name

    public List<Person> findByBirthdayIsBetween (LocalDate startDate, LocalDate endDate); // interpretation of SQL request to Spring




}
