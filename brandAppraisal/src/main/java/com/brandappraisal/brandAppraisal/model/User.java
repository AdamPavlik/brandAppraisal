package com.brandappraisal.brandAppraisal.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "user")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue
	private long id;

	@Column
	private String name;



}
