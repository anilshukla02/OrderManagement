package com.nirmalyalabs.voicerecognition.Service;

import java.util.List;

import com.nirmalyalabs.voicerecognition.Entity.Role;

public interface RoleService {
	
	public Role saveRole(Role role);
	public List<Role> getAllRoles();
	public Role getRoleByName(String role);

}
