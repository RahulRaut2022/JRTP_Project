package com.project1.phonebook.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "Phonebook_tbl")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CONTACT_ID", length = 10)
	private Integer contactId;
	@Column(name = "CONTACT_NAME",length = 50)
	private String contactName;
	@Column(name = "CONTACT_EMAIL",length = 50)
	private String contactEmail;
	@Column(name = "CONTACT_NUMBER",length = 10)
	private Long phoneNumber;
}
