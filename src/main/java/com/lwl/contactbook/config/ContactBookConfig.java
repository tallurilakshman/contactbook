package com.lwl.contactbook.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContactBookConfig {
	
		@Bean
		public ModelMapper modelMapper() {
			return new ModelMapper();
		}

	
}
