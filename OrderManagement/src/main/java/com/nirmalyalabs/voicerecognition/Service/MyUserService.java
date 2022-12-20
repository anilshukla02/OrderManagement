package com.nirmalyalabs.voicerecognition.Service;

import java.util.List;

import com.nirmalyalabs.voicerecognition.Entity.Myuser;

public interface MyUserService {

	public Myuser saveUser(Myuser user);

	public List<Myuser> getAllUsers();

	public Myuser GetUserByID(String id);

	public void DeleteUserByID(String id);


}
