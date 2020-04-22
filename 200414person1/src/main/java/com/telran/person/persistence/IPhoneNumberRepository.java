package com.telran.person.persistence;

import com.telran.person.model.PhoneNumber;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IPhoneNumberRepository extends CrudRepository<PhoneNumber, Integer> {

    public List<PhoneNumber> findAll();

}
