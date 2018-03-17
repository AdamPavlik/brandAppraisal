package com.brandappraisal.brandAppraisal.model;


import com.brandappraisal.brandAppraisal.util.EntityIdentify;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "USERS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User  extends EntityIdentify{

	@Column
	private String firstName;

	@ManyToOne(fetch = FetchType.LAZY)
	private Role role;
}
