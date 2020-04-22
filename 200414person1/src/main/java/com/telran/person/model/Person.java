package com.telran.person.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity // this annotation means that spring app needs to connect this Entity with a table in DB
@NoArgsConstructor // generates no args constructor for this class
@Getter // generates getters for all fields of the class
public class Person {
    // this class is connected directly to the DB

    @Id // this field is an identifier of Entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // with this annotation id will be generated by DB
    //this id will be stored as id field inside the DB table
    @Setter
    private int id;

    @Setter
    private String name;

    @Setter
    private String lastName;

    @Setter
    private LocalDate birthday;

    @OneToMany(mappedBy = "person") // person is related to numbers as oneToMany
    private List<PhoneNumber> numbers = new ArrayList<>(); // each number is related to variable person

//    public Person() {
//    }

    public Person (String name, String lastName, LocalDate birthday){
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
    }

//    public int getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public LocalDate getBirthday() {
//        return birthday;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }

    public List<PhoneNumber> getNumbers(){
        return Collections.unmodifiableList(numbers);
    }


}
