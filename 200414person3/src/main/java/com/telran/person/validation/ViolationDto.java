package com.telran.person.validation;

public class ViolationDto {

    // this class creates exceptions when the fields of PersonDto are filled wrong
    // in PersonController we also create a method, which throws these exceptions

    public String fieldName;

    public String message;

    public ViolationDto(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }
}
