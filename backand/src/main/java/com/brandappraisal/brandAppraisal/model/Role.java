package com.brandappraisal.brandAppraisal.model;

import com.brandappraisal.brandAppraisal.util.EntityIdentify;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "ROLE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role extends EntityIdentify {

	private String role;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
	private List<User> users;

}
