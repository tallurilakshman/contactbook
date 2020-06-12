package com.lwl.contactbook.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.lwl.contactbook.dao.ContactBookDao;
import com.lwl.contactbook.domain.Address;
import com.lwl.contactbook.domain.Contact;
import com.lwl.contactbook.dto.AddressDTO;
import com.lwl.contactbook.dto.ContactDTO;
import com.lwl.contactbook.dto.ContactWithAddressDTO;

import lombok.extern.java.Log;

@Service

public class ContactBookServiceImpl implements ContactBookService {

	private Logger log = LoggerFactory.getLogger(ContactBookServiceImpl.class);

	@Autowired
	private ContactBookDao contactDao;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<ContactWithAddressDTO> getAllContacts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContactWithAddressDTO> search(String str) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContactDTO addContact(ContactDTO contactDto) {
		Assert.notNull(contactDto, "Contact object can't be null");
		Assert.notNull(contactDto.getName(), "Contact name can't be null or empty");
		Assert.notNull(contactDto.getMobile(), "Contact mobile can't be null or empty");
		Contact contact = modelMapper.map(contactDto, Contact.class);
		contact = contactDao.addContact(contact);
		if (contact != null) {
			log.info("Contact is added with id:{}", contact.getCid());
			contactDto = modelMapper.map(contact, ContactDTO.class);
		} else {
			log.error("When user trying to add contact, It Couldn't be add");
		}
		return contactDto;
	}

	@Override
	public boolean deleteContact(int cid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ContactDTO updateContact(ContactDTO contact) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContactDTO getContact(int cid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AddressDTO addAddress(AddressDTO addressDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AddressDTO> searchByCity(String str) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteAddress(int aid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public AddressDTO updateAddress(AddressDTO adddressDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AddressDTO getAddress(int aid) {
		// TODO Auto-generated method stub
		return null;
	}

}
