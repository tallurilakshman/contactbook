package com.lwl.contactbook.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
	private int aid;
	private String city;
	private String state;
	private int cid;

}
