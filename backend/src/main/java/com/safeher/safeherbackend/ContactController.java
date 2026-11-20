package com.safeher.safeherbackend;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/contacts")
@CrossOrigin(origins = "*")
public class ContactController {

    private final ContactRepository contactRepository;

    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @PostMapping
    public Contact addContact(@RequestBody Contact contact) {
        return contactRepository.save(contact);
    }

    @GetMapping
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public String deleteContact(@PathVariable Long id) {
        contactRepository.deleteById(id);
        return "Contact deleted successfully!";
    }
}