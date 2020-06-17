package com.lwl.contactbook.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ContactWithAddressDTO {
	
	private int cid;
	private String name;
	private String email;
	private String mobile;
	private String city;
	private String state;
	
}
