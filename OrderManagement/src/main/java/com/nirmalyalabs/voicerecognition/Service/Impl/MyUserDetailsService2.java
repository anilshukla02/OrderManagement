package com.nirmalyalabs.voicerecognition.Service.Impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nirmalyalabs.voicerecognition.Entity.Myuser;
import com.nirmalyalabs.voicerecognition.Entity.Role;
import com.nirmalyalabs.voicerecognition.Service.MyUserService;

@Service
public class MyUserDetailsService2 implements UserDetailsService {

	@Autowired
	MyUserService myuserservice;

	@Transactional
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Myuser curruser = myuserservice.GetUserByID(username);
		if(curruser == null)
			throw new UsernameNotFoundException("User Not in our DB. Please try again");
			
		List<GrantedAuthority> authorities = getUserAuthority(curruser.getRoles());
		return buildUserForAuthentication(curruser, authorities);
	}

	private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
		Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
		for (Role role : userRoles) {
			roles.add(new SimpleGrantedAuthority(role.getRolename()));
		}
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
		return grantedAuthorities;
	}

	private UserDetails buildUserForAuthentication(Myuser user, List<GrantedAuthority> authorities) {
		return new org.springframework.security.core.userdetails.User(user.getUserid()  , user.getPassword(),
				user.getActive(), true, true, true, authorities);
	}
}
