package com.market.dto.user;

import com.market.model.Order;
import com.market.model.Role;
import com.market.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	private Long id;

	private String firstName;

	private String secondName;

	private String phoneNumber;

	private String email;

	private String password;

	public UserDto(User user){
		this.id = user.getId();
		this.firstName  = user.getFirstName();
		this.secondName = user.getSecondName();
		this.phoneNumber = user.getPhoneNumber();
		this.email = user.getPhoneNumber();
		this.password = user.getPassword();
	}

	public User toUser(Boolean enabled, Role role, List<Order> orders){
		User user = new User();
		if(id != null)
		user.setId(id);
		user.setFirstName(firstName.toLowerCase());
		user.setSecondName(secondName.toLowerCase());
		user.setPhoneNumber(phoneNumber);
		user.setEmail(email);
		user.setPassword(password.toLowerCase());
		user.setEnabled(enabled);
		user.setRole(role);
		user.setOrders(orders);
		return user;
	}
}
