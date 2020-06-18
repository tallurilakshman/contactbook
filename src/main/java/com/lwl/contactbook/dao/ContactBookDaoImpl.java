package com.lwl.contactbook.dao;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lwl.contactbook.domain.Address;
import com.lwl.contactbook.domain.Contact;
import com.lwl.contactbook.dto.ContactWithAddressDTO;
import com.lwl.contactbook.repo.AddressRepo;
import com.lwl.contactbook.repo.ContactRepo;

@Repository
public class ContactBookDaoImpl implements ContactBookDao {

	@Autowired
	private ContactRepo contactRepo;

	@Autowired
	private AddressRepo addressRepo;

	private Logger log = LoggerFactory.getLogger(ContactBookDaoImpl.class);

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
	public Contact addContact(Contact contact) {
		contact = contactRepo.save(contact);
		log.info("Contact is added with id :{}", contact.getCid());
		return contact;
	}

	@Override
	public boolean deleteContact(int cid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Contact updateContact(Contact contact) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contact getContact(int cid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address addAddress(Address address, int cid) {
		Optional<Contact> obj = contactRepo.findById(cid);
    	Contact contact = Optional.ofNullable(obj).flatMap(e -> e).orElseThrow(() -> new IllegalArgumentException("Contact id is not found"));
		address = addressRepo.save(address);
		log.info("Contact address is added with id :{}",address.getAid());
		contact.setAddress(address);
		contactRepo.save(contact);
		return address;
	}

	@Override
	public List<Address> searchByCity(String str) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteAddress(int aid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Address updateAddress(Address adddress) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address getAddress(int aid) {
		// TODO Auto-generated method stub
		return null;
	}

}
