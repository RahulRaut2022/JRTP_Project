package com.project1.phonebook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project1.phonebook.entity.Contact;
import com.project1.phonebook.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	ContactRepository contactRepo;

	@Override
	public String saveContact(Contact contact) {
		contact.setActiveSw("Y");
		Contact savedContact = contactRepo.save(contact);
		if (contact.getContactId() != null) {
			return "contact saved";
		} else {
			return "contact saved to failed";
		}
	}

	@Override
	public List<Contact> getAllContact() {
		return contactRepo.findByActiveSw("Y");
	}

	@Override
	public Contact getContactById(Integer contactId) {

		Optional<Contact> findById = contactRepo.findById(contactId);
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public String updateContact(Contact contact) {
		if (contactRepo.existsById(contact.getContactId())) {
			contactRepo.save(contact);
			return "Update success";
		} else {
			return "No record found";
		}
	}

	@Override
	public String deleteContactById(Integer contactId) {

		/*
		 * if (contactRepo.existsById(contactId)) { contactRepo.deleteById(contactId);
		 * return "record deleted"; } else { return "record not found"; }
		 */

		Optional<Contact> findById = contactRepo.findById(contactId);
		if (findById.isPresent()) {
			Contact contact = findById.get();
			contact.setActiveSw("N");
			contactRepo.save(contact);
			return "record deleted";
		} else {
			return "record not deleted";
		}
	}

}
