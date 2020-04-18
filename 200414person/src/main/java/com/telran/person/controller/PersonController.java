package com.telran.person.controller;

import com.telran.person.dto.PersonDto;
import com.telran.person.service.PersonService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.util.List;

@RestController // means that all methods will return JSON or String
@Validated // to connect the validation @Min to the whole Class
public class PersonController {

    PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/person")
    public void create(@RequestBody @Valid PersonDto personDto){
        // this method takes a body which comes in Json format and parses it to the DTO object of personDto.
        // DTO is used for transferring data
        personService.addPerson(personDto);
    }

    @PutMapping("/person") // if comes "put" then comes method edit
    public void edit(@RequestBody @Valid PersonDto personDto){
        personService.edit(personDto);
    }

    @GetMapping("/person/{id}")
    public PersonDto getById (@PathVariable @Min(1) int id){
        return personService.getById(id);
    }

    @DeleteMapping("/person/{id}")
    public void removePersonById(@PathVariable int id){
        personService.removeById(id);
    }

    // query address in this case: /person?name=Petja (when there is @RequestParam
    // in case of query with no name (name is null): /person - will be done as "required = false"
    @GetMapping("/person")
    public List<PersonDto> getAllPersons(){ //(@RequestParam(required = false) String name) {
//        if (name != null && !name.equals(""))
//            return personService.getAllByName(name);
        return personService.getAll();
    }

    // the same with PathVariable
    @GetMapping("/person/name/{name}")
    public List<PersonDto> getAllByName(@PathVariable String name) {
        return personService.getAllByName(name);
    }

//    @GetMapping("/person/age") // in this case not an entity is returned, but an error status
//    public ResponseEntity<List<PersonDto>> getAllFilteredByAge(@RequestParam(required = false, defaultValue = "0") int min,
//                                                              @RequestParam(required = false, defaultValue = "" + Integer.MAX_VALUE) int max){
//        return new ResponseEntity(HttpStatus.BAD_REQUEST);
//    }
    
    @GetMapping("/person/age")
    public List<PersonDto> getAllFilteredByAge(@RequestParam (required = false) @DateTimeFormat(pattern = "yyyy.MM.dd") LocalDate startDate,
                                               @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy.MM.dd") LocalDate endDate){
        return personService.getAllConstrainedByAge(startDate, endDate);
    }





}
