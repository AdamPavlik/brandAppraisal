package com.market.service;

import com.market.model.Role;
import com.market.model.enums.RoleType;
import com.market.repository.RoleRepository;
import com.market.service.interfaces.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Service
@AllArgsConstructor
public class DefaultRoleService implements RoleService {

	private RoleRepository roleRepository;

	@PostConstruct
	private void initializeRoles(){
		Arrays.stream(RoleType.values()).forEach(role -> {
			if(getRoleByRoleType(role) == null){
				Role persistRole = new Role();
				persistRole.setRole(role);
				roleRepository.save(persistRole);
			}
		});
	}

	@Override
	public Role getRoleByRoleType(RoleType roleType) {
		return roleRepository.getByRole(roleType);
	}
}
