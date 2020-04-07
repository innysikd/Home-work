package com.example.contacts.controller;

import com.example.contacts.dto.Contact;
import com.example.contacts.repository.MemoryContactRepo;
import com.example.contacts.service.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class ContactController {

    private ContactService contactService; // we need it to work with contacts

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("contact") // this action returns a form for creating a new contact
    public String contactForm(Model model){
        model.addAttribute("contact", new Contact());
        return "contact-form";
    }

    @PostMapping("contact") // can send a filled form and save it, and returns a page with list of all contacts
    public ModelAndView addContact(@ModelAttribute Contact contact){
        if(contact.getId() == 0)
            contactService.add(contact);
        else
            contactService.edit(contact);
        contactService.add(contact);
        return new ModelAndView ("redirect:/");
        // or - return "redirect:/";
    }

    @GetMapping("/") // returns a page with all contacts
    public ModelAndView home(){
        return new ModelAndView("redirect:/contacts");
        // browser sends a request to server to home page ->
        // server sends a status 302 (redirect) and a new address for redirection ->
        // browser sends to server a new request to contacts page

        // or - return "forward:/contacts"; in this case all this work is performed inside java
        // and browser returns the same page for "/" and for "/contacts"
    }

    @GetMapping("contact/{id}") // returns a contact according to the id
    public String getContact(@PathVariable int id, Model model){
        Contact contact = contactService.get(id);
        model.addAttribute("contact", contact);
        return "contact";
    }

    @GetMapping("contacts")// returns contacts list
    public String getContacts(Model model){
        List<Contact> contacts = contactService.getAll();
        model.addAttribute("contacts", contacts);
        return "contacts";
    }

    @GetMapping ("contact/remove/{id}") // remove contact
    public String removeContact(@PathVariable int id){
        contactService.remove(id);
        return "redirect:/";
    }

    @GetMapping("/contact/edit/{id}") // edit contact
    public String editContact(@PathVariable int id, Model model){
        Contact contact = contactService.get(id);
        model.addAttribute("contact", contact);
        return "contact-form";
    }

}

// 1. стилизовать страницу contact и страницу формы контакта (на примере стр /contacts с помощью проекта Димы)
// 2. добавить на стр контакта ссылку на главную страницу
// 3. сделать возможность кликнуть на контакт в списке контактов, чтоб перейти на стр контакта