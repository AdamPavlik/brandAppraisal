package com.market.controller;

import com.market.dto.user.UserDto;
import com.market.model.enums.RoleType;
import com.market.model.user.User;
import com.market.service.interfaces.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@Controller
@AllArgsConstructor
@RestController
public class UserController {

	private UserService userService;

	@GetMapping("/")
	public ResponseEntity<UserDto> getUser() {
		return ResponseEntity.ok(new UserDto(userService.getUserById(1)));
	}

	@GetMapping("/public")
	public ResponseEntity<UserDto> getPublicUser() {
		return ResponseEntity.ok(new UserDto(userService.getUserById(1)));
	}

	@PostMapping("/public/registration")
	public ResponseEntity<Long> registration(@RequestBody UserDto userDto){
		User user =  userService.saveUser(userDto, RoleType.CLIENT_ROLE);
		return ResponseEntity.ok(user.getId());
	}




}
