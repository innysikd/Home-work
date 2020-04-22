package com.telran.person.validation.annototaion;

import com.telran.person.dto.PersonDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PersonFullNameValidator implements ConstraintValidator<FullName, PersonDto> {

   int maxLenght;

   public void initialize(FullName constraint) {
      maxLenght = constraint.value();
   }

   public boolean isValid(PersonDto obj, ConstraintValidatorContext context) {
      return obj.firstName.length() + obj.lastName.length() < maxLenght;
   }
}
