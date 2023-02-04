package com.project1.phonebook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project1.phonebook.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

	//select * from contacts where ACTIVE_SW= :status
	public List<Contact> findByActiveSw(String status);
}
