package com.market.service;

import com.market.dto.user.UserDto;
import com.market.model.enums.RoleType;
import com.market.model.user.User;
import com.market.repository.RoleRepository;
import com.market.repository.UserRepository;
import com.market.service.interfaces.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DefaultUserService implements UserService {

	private UserRepository userRepository;
	private RoleRepository roleRepository;


	@Override
	public User getUserById(long id) {
		return userRepository.getById(id);
	}

	public User saveUser(UserDto userDto, RoleType roleType){
		User user = userDto.toUser(true, roleRepository.getByRole(roleType), null);
		userRepository.save(user);
		return user;
	}

}
