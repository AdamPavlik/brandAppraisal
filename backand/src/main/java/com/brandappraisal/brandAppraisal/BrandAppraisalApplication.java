package com.brandappraisal.brandAppraisal;

import com.brandappraisal.brandAppraisal.model.user.CustomUserDetails;
import com.brandappraisal.brandAppraisal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class BrandAppraisalApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrandAppraisalApplication.class, args);
	}

	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository repo) throws Exception {
		builder.userDetailsService(s ->  new CustomUserDetails(repo.getByEmail(s)));
	}
}
