package com.simplilearn.entity;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Student {

	@Id
	@GeneratedValue
	private int student_id;

	private String fname;

	private String lname;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="class_id")
	private Classes classes;
}
