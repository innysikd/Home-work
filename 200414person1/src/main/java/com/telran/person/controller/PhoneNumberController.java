package com.telran.person.controller;

import com.telran.person.dto.PhoneNumberDto;
import com.telran.person.service.PhoneNumberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PhoneNumberController {

    PhoneNumberService numberService;

    public PhoneNumberController(PhoneNumberService numberService) {
        this.numberService = numberService;
    }

    @PostMapping("/number")
    public void create(@RequestBody PhoneNumberDto numberDto){
        numberService.addNumber(numberDto);
    }

    @GetMapping("/number/{id}")
    public PhoneNumberDto getById(@PathVariable int id){
        return numberService.getById(id);
    }

    @PutMapping("/number")
    public void edit(@RequestBody PhoneNumberDto numberDto){
        numberService.edit(numberDto);
    }

    @DeleteMapping("/number/{id}")
    public void removeById(@PathVariable int id){
        numberService.removeById(id);
    }

    @GetMapping("/number")
    public List<PhoneNumberDto> getAllNumbers(){
        return numberService.getAllNumbers();
    }


}
