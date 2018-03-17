package com.brandappraisal.brandAppraisal.service;

import com.brandappraisal.brandAppraisal.model.User;
import com.brandappraisal.brandAppraisal.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DefaultUserService implements UserService{

	private UserRepository userRepository;

	@Override
	public User getUserById(long id) {
		return userRepository.getById(id);
	}

}
