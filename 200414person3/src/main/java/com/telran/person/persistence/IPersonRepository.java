package com.telran.person.persistence;

import com.telran.person.model.Person;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface IPersonRepository extends CrudRepository<Person, Integer> {

    public List<Person> findAll();

    public List<Person> findByName(String name); // this method looks for all persons according to the name

    public List<Person> findByBirthdayIsBetween (LocalDate startDate, LocalDate endDate); // interpretation of SQL request to Spring

//    @Query("select p from Person p where p.birthday >= ?1 and p.birthday <= ?2") //JPA - language for Query, working with DB
//    public List<Person> findByBirthdayIsBetweenCustom (LocalDate after, LocalDate before);

    @Query("select p from Person p where p.birthday >=:after and p.birthday <=:before") //JPA - language for Query, working with DB
    public List<Person> findByBirthdayIsBetweenCustom (
            @Param("after") LocalDate after,
            @Param("before") LocalDate before);

    // homework
    @Modifying
    @Query ("delete from Person p where p.lastName like ?1%")
    public void removeWithLastNameStarting(String pattern);




}
