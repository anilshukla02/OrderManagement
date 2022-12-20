package com.nirmalyalabs.voicerecognition.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nirmalyalabs.voicerecognition.Entity.language;

public interface LanguagesRepository extends JpaRepository<language, String> {

}
