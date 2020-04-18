package com.telran.person.service;

import com.telran.person.dto.PersonDto;
import com.telran.person.model.Person;
import com.telran.person.persistence.IPersonRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private static final String PERSON_NOT_FOUND = "This person doesn't exist";
    final IPersonRepository personRepository;

    public PersonService(IPersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void addPerson(PersonDto personDto){ // creates Person from PersonDto
        Person person = new Person(personDto.firstName, personDto.lastName, personDto.birthday);
        personRepository.save(person);
    }

    public void edit(PersonDto personDto){ // Optional - we don't know if something is returned, in this case it throws exception
        Person person = personRepository.findById(personDto.id).orElseThrow(() -> new EntityNotFoundException(PERSON_NOT_FOUND));
        person.setName(personDto.firstName);
        person.setLastName(personDto.lastName);

        personRepository.save(person);
    }

    public PersonDto getById(int id){
        Person person = personRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(PERSON_NOT_FOUND));
        return new PersonDto(id, person.getName(), person.getLastName(), person.getBirthday());
    }

    public void removeById(int id){
        personRepository.deleteById(id);
    }

    public List<PersonDto> getAll(){
        List<Person> persons = personRepository.findAll();

        return persons.stream()
                .map(person -> new PersonDto(person.getId(),
                        person.getName(),
                        person.getLastName(),
                        person.getBirthday()))
                .collect(Collectors.toList());
    }

    public List<PersonDto> getAllByName(String name) {
        List<Person> persons = personRepository.findByName(name);

        return persons.stream()
                .map(person -> new PersonDto(person.getId(),
                        person.getName(),
                        person.getLastName(),
                        person.getBirthday()))
                .collect(Collectors.toList());
    }

    public List<PersonDto> getAllConstrainedByAge(LocalDate startDate, LocalDate endDate) {
        List<Person> persons = personRepository.findByBirthdayIsBetween(startDate, endDate);

        return persons.stream()
                .map(person -> new PersonDto(person.getId(),
                        person.getName(),
                        person.getLastName(),
                        person.getBirthday()))
                .collect(Collectors.toList());
    }

}
