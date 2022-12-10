package com.project1.phonebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project1.phonebook.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
