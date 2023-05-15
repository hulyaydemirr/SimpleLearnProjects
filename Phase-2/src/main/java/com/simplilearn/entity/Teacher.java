package com.simplilearn.entity;

import lombok.Data;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Data
@Entity
public class Teacher {

	@Id
	@GeneratedValue
	private int teacher_id;

	private String first_name;

	private String last_name;

	@OneToMany(cascade=CascadeType.ALL, mappedBy="teacher")
	private List<Subject> subjects;
}
