package com.brandappraisal.brandAppraisal.dto.user;

import com.brandappraisal.brandAppraisal.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	private long id;

	private String firstName;

	public UserDto(User user){
		this.id = user.getId();
		this.firstName  = user.getFirstName();
	}
}
