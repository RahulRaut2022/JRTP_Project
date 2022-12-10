package com.project1.phonebook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project1.phonebook.entity.Contact;
import com.project1.phonebook.exception.ResourceNotFoundException;
import com.project1.phonebook.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	ContactRepository contactRepo;
	
	@Override
	public String saveContact(Contact contact) {
		contactRepo.save(contact);
		return "Contact save successfully";
	}

	@Override
	public List<Contact> getAllContact() {
		return contactRepo.findAll();
	}

	@Override
	public Contact getContactById(Integer contactId) {
		return contactRepo.findById(contactId).orElseThrow(()-> ResourceNotFoundException("Contact", "id", contactId));
	}

	@Override
	public String updateContact(Contact contact) {
		contact.setContactName(contact.getContactName());
		contact.setContactEmail(contact.getContactEmail());
		contact.setPhoneNumber(contact.getPhoneNumber());
		contactRepo.save(contact);
		return "contact update successfully";
	}

	@Override
	public String deleteContactById(Integer contactId) {
		 contactRepo.findById(contactId).orElseThrow();
		return "contact delete successsully" ;
	}

}
