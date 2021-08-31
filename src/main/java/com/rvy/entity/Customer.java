package com.rvy.entity;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@RedisHash("customer_rvy")
public class Customer implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer customerId;
	private Integer uin;
	private String name;
	private String email;
	private Long mobile;
	private LocalDate birthdate;
	private String doorNumber;
	private String street;
	private String city;
	private String state;
	private String country;
	private Long zipCode;
	private Integer regionId;
}
