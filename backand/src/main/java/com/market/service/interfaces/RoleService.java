package com.market.service.interfaces;

import com.market.model.Role;
import com.market.model.enums.RoleType;

public interface RoleService {

	Role getRoleByRoleType(RoleType roleType);

}
