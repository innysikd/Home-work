package com.telran.person.mapper;

import com.telran.person.dto.PhoneNumberDto;
import com.telran.person.model.PhoneNumber;
import org.springframework.stereotype.Component;

@Component
public class PhoneNumberMapper {

    public PhoneNumberDto mapNumberToNumberDto(PhoneNumber number){
        return new PhoneNumberDto(number.getId(), number.getPhoneNumber(), number.getPerson().getId());
    }
}
