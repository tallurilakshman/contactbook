package com.lwl.contactbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lwl.contactbook.dto.AddressDTO;
import com.lwl.contactbook.dto.ContactDTO;
import com.lwl.contactbook.dto.ContactWithAddressDTO;
import com.lwl.contactbook.service.ContactBookServiceImpl;

@RestController
@RequestMapping("v1/cbook/")
public class Maincontroller {

	@Autowired
	ContactBookServiceImpl contactBookServiceImpl;

	@GetMapping("all")
	public List<ContactWithAddressDTO> getAll() {
		return contactBookServiceImpl.getAllContacts();
	}

	@GetMapping("getaddress")
	public AddressDTO getAddress(int aid) {
		return contactBookServiceImpl.getAddress(aid);
	}

	@GetMapping("getcontact")
	public ContactDTO getContact(int cid) {
		return contactBookServiceImpl.getContact(cid);
	}

	@PutMapping("newaddress")
	public AddressDTO addAddress(AddressDTO addressDTO) {
		return contactBookServiceImpl.addAddress(addressDTO);
	}

	@PutMapping("newcontact")
	public ContactDTO addContact(ContactDTO contactDTO) {
		return contactBookServiceImpl.addContact(contactDTO);
	}

	@PutMapping("updateaddress")
	public AddressDTO updateAddress(AddressDTO addressDTO) {
		return contactBookServiceImpl.updateAddress(addressDTO);
	}

	@PutMapping("updatecontact")
	public ContactDTO updateContact(ContactDTO contactDTO) {
		return contactBookServiceImpl.updateContact(contactDTO);
	}

}
