package com.lwl.contactbook.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lwl.contactbook.domain.Address;
import com.lwl.contactbook.domain.Contact;
import com.lwl.contactbook.dto.ContactWithAddressDTO;

@Repository
public class ContactBookDaoImpl implements ContactBookDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

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
		// TODO Auto-generated method stub
		return null;
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
	public Address addAddress(Address address) {
		// TODO Auto-generated method stub
		return null;
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
