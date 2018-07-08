package com.market.model.user;


import com.market.model.Order;
import com.market.model.Role;
import com.market.util.EntityIdentify;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.actuate.audit.listener.AuditListener;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "USERS")
@Getter
@Setter
@AllArgsConstructor
@EntityListeners(AuditListener.class)
@NoArgsConstructor
public class User  extends EntityIdentify{

	private String firstName;

	private String secondName;

	private String phoneNumber;

	@Column(unique = true)
	private String email;

	private String password;

	private Boolean enabled;

	@CreatedDate
	private LocalDateTime createdDate;

	@ManyToOne(fetch = FetchType.EAGER)
	private Role role;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private List<Order> orders;
}
