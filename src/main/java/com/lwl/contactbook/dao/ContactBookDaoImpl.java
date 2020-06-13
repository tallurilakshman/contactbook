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

	@Override
	public List<ContactWithAddressDTO> getAllContacts() {
		String contactwithaddress = "SELECT c.cid,name,email,mobile, city,state FROM contact c, address a where c.cid=a.cid";

		List<ContactWithAddressDTO> contactWithAddressDTOs = jdbcTemplate.query(contactwithaddress,
				new BeanPropertyRowMapper<ContactWithAddressDTO>(ContactWithAddressDTO.class));

		return contactWithAddressDTOs;
	}

	@Override
	public List<ContactWithAddressDTO> search(String str) {
		String sql = "SELECT c.cid,name,email,mobile, city,state FROM address a inner join contact c on c.cid=a.cid and city= ?";
		return jdbcTemplate.queryForList(sql, ContactWithAddressDTO.class, str);

	}

	@Override
	public Contact addContact(Contact contact) {
		int rowsChanged = jdbcTemplate.update("insert into contact(cid,name,email,mobile) values(?,?,?,?)",
				contact.getCid(), contact.getName(), contact.getMobile(), contact.getEmail());
		System.out.println(rowsChanged);
		if (rowsChanged != 0) {
			System.out.println("Done Man!!");
			return contact;
		}
		return null;
	}

	@Override
	public boolean deleteContact(int cid) {

		int rowsChanged = jdbcTemplate.update("delete from contact where cid=?", cid);
		if (rowsChanged != 0) {
			return true;
		}
		return false;
	}

	@Override
	public Contact updateContact(Contact contact) {
		String sql = "UPDATE contact SET name = ?, mobile= ?, email=? WHERE cid = ?";
		int rowsChanged = jdbcTemplate.update(sql, contact.getName(), contact.getMobile(), contact.getEmail(),
				contact.getCid());
		if (rowsChanged != 0) {
			return contact;
		}
		return null;
	}

	@Override
	public Contact getContact(int cid) {
		String sql = "SELECT * FROM contact WHERE cid = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { cid }, new BeanPropertyRowMapper<Contact>(Contact.class));
	}

	@Override
	public Address addAddress(Address address) {
		int rowsChanged = jdbcTemplate.update("INSERT INTO address(aid, city, state,cid) values(?,?,?,?)",
				address.getAid(), address.getCity(), address.getState(),address.getCid());
		if (rowsChanged != 0) {
			return address;
		}
		return null;
	}

	@Override
	public List<Address> searchByCity(String str) {

		String sql = "SELECT * FROM address where city=?";
		return jdbcTemplate.queryForList(sql, Address.class, str);
	}

	@Override
	public boolean deleteAddress(int aid) {
		int rowsChanged = jdbcTemplate.update("delete from address where aid=?", aid);
		if (rowsChanged != 0) {
			return true;
		}
		return false;
	}

	@Override
	public Address updateAddress(Address address) {
		String sql = "UPDATE address SET city = ?, state= ?, cid=? WHERE aid = ?";

		int rowsChanged = jdbcTemplate.update(sql, address.getCity(), address.getState(), address.getCid(),
				address.getAid());
		if (rowsChanged != 0) {
			return address;
		}
		return null;
	}

	@Override
	public Address getAddress(int aid) {
		String sql = "SELECT * FROM address WHERE aid = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { aid }, new BeanPropertyRowMapper<Address>(Address.class));
	}

}
