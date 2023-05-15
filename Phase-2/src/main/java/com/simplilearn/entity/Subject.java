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
public class Subject {

	@Id
	@GeneratedValue
	private int subject_id;

	private String subject_name;

	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="teacher_id")
	private Teacher teacher;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="class_id")
	private Classes classes;
}
