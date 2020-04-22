package com.telran.person.service;

import com.telran.person.dto.PersonDto;
import com.telran.person.dto.PhoneNumberDto;
import com.telran.person.mapper.PersonMapper;
import com.telran.person.mapper.PhoneNumberMapper;
import com.telran.person.model.Person;
import com.telran.person.model.PhoneNumber;
import com.telran.person.persistence.IPersonRepository;
import com.telran.person.persistence.IPhoneNumberRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    public static final String PERSON_NOT_FOUND = "This person doesn't exist";
    final IPersonRepository personRepository;
    final IPhoneNumberRepository phoneNumberRepository;
    final PersonMapper personMapper;
    final PhoneNumberMapper phoneNumberMapper;

    public PersonService(IPersonRepository personRepository,
                         IPhoneNumberRepository phoneNumberRepository,
                         PersonMapper personMapper,
                         PhoneNumberMapper phoneNumberMapper) {
        this.personRepository = personRepository;
        this.phoneNumberRepository = phoneNumberRepository;
        this.personMapper = personMapper;
        this.phoneNumberMapper = phoneNumberMapper;
    }

    public void addPerson(PersonDto personDto){ // creates Person from PersonDto

        Person person = new Person(personDto.firstName, personDto.lastName, personDto.birthday);
        personRepository.save(person);

        personDto.numbers.stream()
                .map(numberIn -> new PhoneNumber(numberIn.number, person))
                .forEach(phoneNumberRepository::save);
    }

    public void edit(PersonDto personDto){ // Optional - we don't know if something is returned, in this case it throws exception
        Person person = personRepository.findById(personDto.id).orElseThrow(() -> new EntityNotFoundException(PERSON_NOT_FOUND));
        person.setName(personDto.firstName);
        person.setLastName(personDto.lastName);

        personRepository.save(person);
    }

    public PersonDto getById(int id){
        Person person = personRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(PERSON_NOT_FOUND));
        PersonDto personDto = personMapper.mapPersonToPersonDto(person);
        personDto.numbers = person.getNumbers().stream()
                .map(phoneNumberMapper::mapNumberToNumberDto)
                .collect(Collectors.toList());

        return personDto;
    }

    public void removeById(int id){
        personRepository.deleteById(id);
    }

    public List<PersonDto> getAll(){
        List<Person> persons = personRepository.findAll();

        return persons.stream()
                .map(personMapper::mapPersonToPersonDto)
                .collect(Collectors.toList());
    }

    public List<PersonDto> getAllByName(String name) {
        List<Person> persons = personRepository.findByName(name);

        return persons.stream()
                .map(personMapper::mapPersonToPersonDto)
                .collect(Collectors.toList());
    }

    public List<PersonDto> getAllConstrainedByAge(int min, int max) {
        LocalDate earliestBirthday = LocalDate.now().minusYears(max);
        LocalDate latestBirthday = LocalDate.now().minusYears(min);
        List<Person> persons = personRepository.findByBirthdayIsBetween(earliestBirthday, latestBirthday);

        return persons.stream()
                .map(personMapper::mapPersonToPersonDto)
                .collect(Collectors.toList());
    }

    public List<PersonDto> getAllConstrainedByBirthday(LocalDate startDate, LocalDate endDate) {
        List<Person> persons = personRepository.findByBirthdayIsBetween(startDate, endDate);

        return persons.stream()
                .map(personMapper::mapPersonToPersonDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public void removeWithLastNameStarting(String pattern) {
        personRepository.removeWithLastNameStarting(pattern);
    }

    public List<PhoneNumberDto> getNumbersByPersonId(int id){
        Person person = personRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(PERSON_NOT_FOUND));

        return person.getNumbers().stream()
                .map(phoneNumberMapper::mapNumberToNumberDto)
                .collect(Collectors.toList());
    }



}
