package com.brandappraisal.brandAppraisal.controller;

import com.brandappraisal.brandAppraisal.dto.user.UserDto;
import com.brandappraisal.brandAppraisal.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@CrossOrigin
@Controller
@AllArgsConstructor
@RestController
public class UserController {

	private UserService userService;

	@GetMapping("/user")
	public ResponseEntity<UserDto> getUser() {
		return ResponseEntity.ok(new UserDto(userService.getUserById(1)));
	}


	@GetMapping("/user/me")
	public Principal user(Principal principal) {
		return principal;
	}


}
