package com.example.contacts.repository;

import com.example.contacts.dto.Contact;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class MemoryContactRepo implements IContactRepo{

    Map<Integer, Contact> source = new HashMap<>(); // will store contactsOld. key - id, value - contact
    AtomicInteger currentId = new AtomicInteger();  // each time a new contact is created, our Repository will give it a new id

    @Override
    public void add(Contact contact) {
        source.put(currentId.incrementAndGet(), contact);
        contact.setId(currentId.get());
    }

    @Override
    public Contact get(int id) {
        return source.get(id);
    }

    @Override
    public void edit(Contact contact) {
        source.replace(contact.getId(), contact);
    }

    @Override
    public Contact remove(int id) {
        return source.remove(id);
    }

    @Override
    public boolean remove(Contact contact) {
        source.remove(contact.id, contact);
        return true;
    }

    @Override
    public List<Contact> getAll() {
        return source.values()
                .stream()
                .sorted(Comparator.comparingInt(Contact::getId))
                .collect(Collectors.toList());
    }
}
