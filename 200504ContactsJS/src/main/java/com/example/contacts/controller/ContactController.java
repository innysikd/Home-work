package com.example.contacts.controller;

import com.example.contacts.dto.Contact;
import com.example.contacts.service.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class ContactController {

    private ContactService contactService; // we need it to work with contactsOld

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/contact")
    @ResponseBody
    public List<Contact> contactForm(){
        return contactService.getAll();
    }

    @PostMapping("/contact")
    @ResponseBody
    public void addContact(@RequestBody Contact contact){
        contactService.add(contact);
    }

    @PutMapping("/contact")
    @ResponseBody
    public void editContact(@RequestBody Contact contact){
        contactService.edit(contact);
    }

    @DeleteMapping("/contact/{id}")
    @ResponseBody
    public void removeContact(@PathVariable int id){
        contactService.remove(id);
    }

    @GetMapping("/") // returns a page with all contacts
    public String home(){
        return "forward:/contacts";
    }

    @GetMapping("/contacts")
    public String getContacts(){
        return "contacts";
    }





}
