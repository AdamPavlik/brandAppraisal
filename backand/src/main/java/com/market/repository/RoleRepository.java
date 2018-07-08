package com.market.repository;

import com.market.model.Role;
import com.market.model.enums.RoleType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

	Role getByRole(RoleType roleType);

}
