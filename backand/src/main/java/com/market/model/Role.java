package com.market.model;

import com.market.model.enums.RoleType;
import com.market.model.user.User;
import com.market.util.EntityIdentify;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

	@Enumerated(EnumType.STRING)
	private RoleType role;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
	private List<User> users;

}
