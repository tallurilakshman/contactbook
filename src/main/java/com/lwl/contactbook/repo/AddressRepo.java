package com.lwl.contactbook.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lwl.contactbook.domain.Address;

public interface AddressRepo extends JpaRepository<Address,Integer>{

}
