package com.lwl.contactbook.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lwl.contactbook.domain.Contact;

public interface ContactRepo extends JpaRepository<Contact,Integer> {

}
