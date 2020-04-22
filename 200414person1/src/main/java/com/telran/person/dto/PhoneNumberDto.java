package com.telran.person.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
public class PhoneNumberDto {

    public int id;
    @Setter
    public String number;
    public int personId;

    public PhoneNumberDto(int id, String number, int personId) {
        this.id = id;
        this.number = number;
        this.personId = personId;
    }

//    public String getNumber() {
//        return number;
//    }




}
