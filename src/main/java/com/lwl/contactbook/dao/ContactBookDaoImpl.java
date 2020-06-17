package com.lwl.contactbook.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lwl.contactbook.domain.Address;
import com.lwl.contactbook.domain.Contact;
import com.lwl.contactbook.dto.ContactWithAddressDTO;

@Repository
public class ContactBookDaoImpl implements ContactBookDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private static final String CONTACT_WITH_ADDRESS = "SELECT c.cid,name,email,mobile, city,state FROM contact c, address a where c.cid=a.cid";
	private static final String SEARCH = "SELECT c.cid,name,email,mobile, city,state FROM address a inner join contact c on c.cid=a.cid and city= ?";
	private static final String ADDCONTACT = "insert into contact(cid,name,email,mobile) values(?,?,?,?)";
	private static final String DELETE_CONTACT = "delete from contact where cid=?";
	private static final String UPDATE_CONTACT = "UPDATE contact SET name = ?, mobile= ?, email=? WHERE cid = ?";
	private static final String GET_CONTACT = "SELECT * FROM contact WHERE cid = ?";
	private static final String ADD_ADDRESS = "INSERT INTO address(aid, city, state,cid) values(?,?,?,?)";
	private static final String SEARCH_BY_CITY = "SELECT * FROM address where city=?";
	private static final String DELETE_ADDRESS = "delete from address where aid=?";
	private static final String UPDATE_ADDRESS = "UPDATE address SET city = ?, state= ?, cid=? WHERE aid = ?";
	private static final String GET_ADDRESS = "SELECT * FROM address WHERE aid = ?";

	@Override
	public List<ContactWithAddressDTO> getAllContacts() {

		List<ContactWithAddressDTO> contactWithAddressDTOs = jdbcTemplate.query(CONTACT_WITH_ADDRESS,
				new BeanPropertyRowMapper<ContactWithAddressDTO>(ContactWithAddressDTO.class));

		return contactWithAddressDTOs;
	}

	@Override
	public List<ContactWithAddressDTO> search(String str) {
		return jdbcTemplate.queryForList(SEARCH, ContactWithAddressDTO.class, str);

	}

	@Override
	public Contact addContact(Contact contact) {
		int rowsChanged = jdbcTemplate.update(ADDCONTACT, contact.getCid(), contact.getName(), contact.getMobile(),
				contact.getEmail());
		System.out.println(rowsChanged);
		if (rowsChanged != 0) {
			System.out.println("Done Man!!");
			return contact;
		}
		return null;
	}

	@Override
	public boolean deleteContact(int cid) {

		int rowsChanged = jdbcTemplate.update(DELETE_CONTACT, cid);
		if (rowsChanged != 0) {
			return true;
		}
		return false;
	}

	@Override
	public Contact updateContact(Contact contact) {
		int rowsChanged = jdbcTemplate.update(UPDATE_CONTACT, contact.getName(), contact.getMobile(),
				contact.getEmail(), contact.getCid());
		if (rowsChanged != 0) {
			return contact;
		}
		return null;
	}

	@Override
	public Contact getContact(int cid) {
		return jdbcTemplate.queryForObject(GET_CONTACT, new Object[] { cid },
				new BeanPropertyRowMapper<Contact>(Contact.class));
	}

	@Override
	public Address addAddress(Address address) {
		int rowsChanged = jdbcTemplate.update(ADD_ADDRESS, address.getAid(), address.getCity(), address.getState(),
				address.getCid());
		if (rowsChanged != 0) {
			return address;
		}
		return null;
	}

	@Override
	public List<Address> searchByCity(String str) {

		return jdbcTemplate.queryForList(SEARCH_BY_CITY, Address.class, str);
	}

	@Override
	public boolean deleteAddress(int aid) {
		int rowsChanged = jdbcTemplate.update(DELETE_ADDRESS, aid);
		if (rowsChanged != 0) {
			return true;
		}
		return false;
	}

	@Override
	public Address updateAddress(Address address) {

		int rowsChanged = jdbcTemplate.update(UPDATE_ADDRESS, address.getCity(), address.getState(), address.getCid(),
				address.getAid());
		if (rowsChanged != 0) {
			return address;
		}
		return null;
	}

	@Override
	public Address getAddress(int aid) {
		return jdbcTemplate.queryForObject(GET_ADDRESS, new Object[] { aid },
				new BeanPropertyRowMapper<Address>(Address.class));
	}

}
