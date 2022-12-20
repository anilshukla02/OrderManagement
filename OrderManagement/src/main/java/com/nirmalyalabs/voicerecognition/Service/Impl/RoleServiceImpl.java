package com.nirmalyalabs.voicerecognition.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nirmalyalabs.voicerecognition.Entity.Role;
import com.nirmalyalabs.voicerecognition.Repository.RoleRepository;
import com.nirmalyalabs.voicerecognition.Service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	
	@Autowired
	RoleRepository rolerepository;
	
	@Override
	public Role saveRole(Role role) {
		return rolerepository.save(role);
	}

	@Override
	public List<Role> getAllRoles() {
		
		return rolerepository.findAll();
	}

	@Override
	public Role getRoleByName(String role) {
		
		return rolerepository.findByRolename(role);
	}

}
