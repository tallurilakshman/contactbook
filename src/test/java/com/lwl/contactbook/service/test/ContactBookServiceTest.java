package com.lwl.contactbook.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ScriptException;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import com.lwl.contactbook.dto.AddressDTO;
import com.lwl.contactbook.dto.ContactDTO;
import com.lwl.contactbook.dto.ContactWithAddressDTO;
import com.lwl.contactbook.service.ContactBookServiceImpl;

@SpringBootTest
public class ContactBookServiceTest {

	@Autowired
	private ContactBookServiceImpl contactBookService;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String script = "data.sql";
	private static final String delete = "delete.sql";

	@BeforeEach
	public void before() {
		try {
			Connection con = jdbcTemplate.getDataSource().getConnection();
			ScriptUtils.executeSqlScript(con, new ClassPathResource(script));
			con.close();
		} catch (ScriptException | SQLException e) {
			e.printStackTrace();
		}
	}

	@AfterEach
	public void after() {
		try {
			Connection con = jdbcTemplate.getDataSource().getConnection();

			ScriptUtils.executeSqlScript(con, new ClassPathResource(delete));

			con.close();
		} catch (ScriptException | SQLException e) {
			e.printStackTrace();
		}
	}


	@Test
	public void getAllContacts() {
		List<ContactWithAddressDTO> actual = contactBookService.getAllContacts();
		assertEquals("Pradeep", actual.get(0).getName());
		System.out.println("Done getAllContacts");
	}
//		public List<ContactWithAddressDTO> search(String str);

	@Test
	public void addContact() {
		ContactDTO expected = new ContactDTO(6, "pradeep", "pradeep@gmail.com", "353747646446");
		ContactDTO actual = contactBookService.addContact(expected);
		assertEquals(expected.getName(), actual.getName());
		System.out.println("Done addContact");
	}

	@Test
	public void deleteContact() {
		boolean actual = contactBookService.deleteContact(1);
		assertEquals(true, actual);
		System.out.println("Done deleteContact");
	}

	@Test
	public void updateContact() {
		ContactDTO expected = new ContactDTO(6, "pradeep", "pradeep@gmail.com", "353747646446");
		ContactDTO actual = contactBookService.updateContact(expected);
		assertEquals(expected.getName(), actual.getName());
		System.out.println("Done addContact");

	}

	@Test
	public void getContact() {
		ContactDTO actual = contactBookService.getContact(1);
		assertEquals("Pradeep", actual.getName());
		System.out.println("Done addContact");

	}

	public void addAddress() {
		AddressDTO expected = new AddressDTO(6, "Kansas", "KS", 2);
		AddressDTO actual = contactBookService.addAddress(expected,1);
		assertEquals(expected, actual);
		System.out.println("Done addAddress");
	}
//		public List<AddressDTO> searchByCity(String str);

//	public void deleteAddress() {
//		boolean actual = contactBookService.deleteAddress(1);
//		assertEquals(true, actual);
//		System.out.println("Done deleteAddress");
//	}

	public void updateAddress() {
		AddressDTO expected = new AddressDTO(6, "Kansas", "KS", 2);
		AddressDTO actual = contactBookService.updateAddress(expected);
		assertEquals(expected, actual);
		System.out.println("Done updateAddress");
	}

	public void getAddress() {
		ContactDTO actual = contactBookService.getContact(1);
		assertEquals("Pradeep", actual.getName());
		System.out.println("Done getAddress");
	}

}
