package com.telran.person.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.telran.person.validation.annototaion.FullName;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@FullName(20)
@NoArgsConstructor
public class PersonDto {

    public PersonDto(int id, String firstName, String lastName, LocalDate birthday) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    @Min(0)
    public int id;

    // validation. we also have to add annotation @Valid in methods create and edit
    @Size(min = 1, max = 10, message = "The name '${validatedValue}' is shorter than {min} or greater than {max}")
    // we customise the default spring massage
    public String firstName;

    @Size(min = 2, max = 20)
    public String lastName;

    @JsonFormat(pattern = "yyyy.MM.dd")// this way Json parser knows how to parse this field
    public LocalDate birthday;

    public List<PhoneNumberDto> numbers;



}
