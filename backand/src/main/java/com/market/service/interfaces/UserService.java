package com.market.service.interfaces;
import com.market.dto.user.UserDto;
import com.market.model.enums.RoleType;
import com.market.model.user.User;

public interface UserService {
	User getUserById(long id);

	User saveUser(UserDto userDto, RoleType roleType);
}
