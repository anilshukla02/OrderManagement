package com.nirmalyalabs.voicerecognition.Utilities.General;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.nirmalyalabs.voicerecognition.Entity.MyuserDetails;

@Service
public class GeneralUtilities {

	// Let Logged in user language
	public String getUserLanguage() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		MyuserDetails userDetails = (MyuserDetails) authentication.getPrincipal();
		System.out.println("User is:"+userDetails.getUsername()+"  Language is:"+userDetails.getPreflang());

		return userDetails.getPreflang();
	}
}
