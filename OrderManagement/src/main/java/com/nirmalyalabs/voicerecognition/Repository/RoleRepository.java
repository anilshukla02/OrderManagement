package com.nirmalyalabs.voicerecognition.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nirmalyalabs.voicerecognition.Entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	
	Role findByRolename(String role);

}
