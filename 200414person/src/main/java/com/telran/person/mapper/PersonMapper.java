package com.telran.person.mapper;

import com.telran.person.dto.PersonDto;
import com.telran.person.model.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {

    public PersonDto mapPersonToPersonDto(Person person){
        return new PersonDto(person.getId(), person.getName(), person.getLastName(), person.getBirthday());
    }
}
