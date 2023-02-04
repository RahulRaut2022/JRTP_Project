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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "This is Contact API")
public class ContactController {

	@Autowired
	private ContactService contactService;

	@ApiOperation(value = "This operation is used to store new contact")
	@PostMapping("/contact")
	public String createContact(@RequestBody Contact contact) {
		String saveContact = contactService.saveContact(contact);
		return "contact saved";
	}

	@ApiOperation(value = "This operation is used to get all contact")
	@GetMapping("/contacts")
	public List<Contact> getContactDetails() {
		List<Contact> allContact = contactService.getAllContact();
		return allContact;
	}

	@ApiOperation(value = "This operation is used to get contact byId")
	@GetMapping("/contact/{contactId}")
	public Contact getContactById(@PathVariable Integer contactId) {
		Contact contact = contactService.getContactById(contactId);
		return contact;
	}

	@ApiOperation(value = "This operation is used to update contact")
	@PutMapping("/contact")
	public String updateContact(@RequestBody Contact contact) {
		return contactService.updateContact(contact);
	}

	@ApiOperation(value = "This operation is used to delete contact")
	@DeleteMapping("/contact/{contactId}")
	public String deleteContact(@PathVariable Integer contactId) {
		 contactService.deleteContactById(contactId);
		 return "Contact Deleted";
	}

}
