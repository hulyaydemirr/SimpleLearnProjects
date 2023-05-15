package com.simplilearn.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	// auto_increment
	private int id;

	private String email;
	private String password;
}
