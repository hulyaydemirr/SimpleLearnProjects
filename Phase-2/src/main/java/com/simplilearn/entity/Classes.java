package com.simplilearn.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import javax.persistence.CascadeType;

import java.util.List;

@Data
@Entity
public class Classes {

	@Id
	@GeneratedValue
	private int class_id;

	private String class_name;

	@OneToMany(cascade= CascadeType.ALL, mappedBy="classes")
	private List<Student> students;

	@OneToMany(cascade= CascadeType.ALL, mappedBy="classes")
	private List<Subject> subjects;

}
