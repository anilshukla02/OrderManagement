package com.nirmalyalabs.voicerecognition.Service.Impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nirmalyalabs.voicerecognition.Entity.Myuser;
import com.nirmalyalabs.voicerecognition.Entity.MyuserDetails;
import com.nirmalyalabs.voicerecognition.Service.MyUserService;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	MyUserService myuserservice;

	@Transactional
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Myuser curruser = myuserservice.GetUserByID(username);
		if(curruser == null)
			throw new UsernameNotFoundException("User Not in our DB. Please try again");
			
		return new MyuserDetails(curruser);
	}

}
