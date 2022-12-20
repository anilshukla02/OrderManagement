package com.nirmalyalabs.voicerecognition.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nirmalyalabs.voicerecognition.Entity.Myuser;

public interface MyusersReposirory  extends JpaRepository<Myuser, String> {

}
