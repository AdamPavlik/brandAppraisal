package com.market.repository;

import com.market.model.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User getById(Long id);

	User getByEmail(String email);
}
