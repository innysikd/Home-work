package com.telran.person.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class PhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Setter
    private String phoneNumber;

    @ManyToOne // relations phone <-> person as many to one
    @OnDelete(action = OnDeleteAction.CASCADE) // means that ALL the numbers of the person will be also removed, when the person is removed
    Person person;

//    public PhoneNumber() {
//    }

    public PhoneNumber(String phoneNumber, Person person) {
        this.phoneNumber = phoneNumber;
        this.person = person;
    }

//    public int getId() {
//        return id;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public Person getPerson() {
//        return person;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
}
