package com.example.contacts.service;

import com.example.contacts.dto.Contact;
import com.example.contacts.repository.IContactRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // the state of Service can't change. we cannot add any variables to this class
public class ContactService {

    IContactRepo contactRepo;

    public ContactService(IContactRepo contactRepo) {
        this.contactRepo = contactRepo;
    }

    public void add(Contact contact){
        contactRepo.add(contact);
    }

    public Contact get (int id){
        return contactRepo.get(id);
    }

    public List<Contact> getAll(){
        return contactRepo.getAll();
    }

    public void edit(Contact contact) {
        contactRepo.edit(contact);
    }

    public void remove(int id) {
        contactRepo.remove(id);
    }
}
