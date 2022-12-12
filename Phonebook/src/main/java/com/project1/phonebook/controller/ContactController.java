package com.project1.phonebook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project1.phonebook.entity.Contact;
import com.project1.phonebook.service.ContactService;

@RestController
@RequestMapping("/phonebook")
public class ContactController {

	@Autowired
	private ContactService contactService;

	@PostMapping("/contactSave")
	public String createContact(@RequestBody Contact contact) {
		String saveContact = contactService.saveContact(contact);
		return "contact saved";
	}

	@GetMapping("/getAllContact")
	public List<Contact> getContactDetails() {
		List<Contact> allContact = contactService.getAllContact();
		return allContact;
	}

	@GetMapping("/getContactById/{contactId}")
	public Contact getContactById(@PathVariable Integer contactId) {
		Contact contact = contactService.getContactById(contactId);
		return contact;
	}

	@PutMapping("/updateContact")
	public String updateContact(@RequestBody Contact contact) {
		return contactService.updateContact(contact);
	}

	@DeleteMapping("/deleteContact/{contactId}")
	public String deleteContact(@PathVariable Integer contactId) {
		return contactService.deleteContactById(contactId);
	}

}
