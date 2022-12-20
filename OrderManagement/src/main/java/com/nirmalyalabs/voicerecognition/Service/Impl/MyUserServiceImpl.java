package com.nirmalyalabs.voicerecognition.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nirmalyalabs.voicerecognition.Entity.Myuser;
import com.nirmalyalabs.voicerecognition.Repository.MyusersReposirory;
import com.nirmalyalabs.voicerecognition.Service.MyUserService;

@Service
public class MyUserServiceImpl implements MyUserService {

	@Autowired
	MyusersReposirory myusersReposirory;
	
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public Myuser saveUser(Myuser user) {	
		bCryptPasswordEncoder = new BCryptPasswordEncoder();
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return myusersReposirory.save(user);
	}

	@Override
	public List<Myuser> getAllUsers() {
		// List<Myuser> allusers = myusersReposirory.findAll();
		// populate user records with roles
		// code here
		return myusersReposirory.findAll();
	}

	@Override
	public Myuser GetUserByID(String userid) {
		Myuser myuser = myusersReposirory.findById(userid).get();
		return myuser;
	}


	@Override
	public void DeleteUserByID(String userid) {
		myusersReposirory.deleteById(userid);
		return;

	}

}
