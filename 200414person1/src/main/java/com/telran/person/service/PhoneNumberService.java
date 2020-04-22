package com.telran.person.service;

import com.telran.person.dto.PhoneNumberDto;
import com.telran.person.mapper.PhoneNumberMapper;
import com.telran.person.model.Person;
import com.telran.person.model.PhoneNumber;
import com.telran.person.persistence.IPersonRepository;
import com.telran.person.persistence.IPhoneNumberRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhoneNumberService {

    private static final String NUMBER_NOT_FOUND = "This phone number doesn't exist";
    final IPhoneNumberRepository phoneNumberRepository;
    final IPersonRepository personRepository;
    final PhoneNumberMapper phoneNumberMapper;

    public PhoneNumberService(IPhoneNumberRepository phoneNumberRepository, IPersonRepository personRepository, PhoneNumberMapper phoneNumberMapper) {
        this.phoneNumberRepository = phoneNumberRepository;
        this.personRepository = personRepository;
        this.phoneNumberMapper = phoneNumberMapper;
    }

    public void addNumber(PhoneNumberDto numberDto) {
        Person person = personRepository.findById(numberDto.personId).orElseThrow(() -> new EntityNotFoundException(PersonService.PERSON_NOT_FOUND));
        PhoneNumber phoneNumber = new PhoneNumber(numberDto.number, person);
        phoneNumberRepository.save(phoneNumber);
    }

    public void edit(PhoneNumberDto numberDto) {
        PhoneNumber number = phoneNumberRepository.findById(numberDto.id).orElseThrow(() -> new EntityNotFoundException(NUMBER_NOT_FOUND));
        number.setPhoneNumber(numberDto.getNumber());
        phoneNumberRepository.save(number);
    }

    public PhoneNumberDto getById(int id) {
        PhoneNumber number = phoneNumberRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(NUMBER_NOT_FOUND));
        PhoneNumberDto phoneNumberDto = new PhoneNumberDto(id, number.getPhoneNumber(), number.getPerson().getId());
        return phoneNumberDto;
    }

    public void removeById(int id) {
        phoneNumberRepository.deleteById(id);
    }

    public List<PhoneNumberDto> getAllNumbers() {
        List<PhoneNumber> numbers = phoneNumberRepository.findAll();

        return numbers.stream()
                .map(phoneNumberMapper::mapNumberToNumberDto)
                .collect(Collectors.toList());
    }


}
