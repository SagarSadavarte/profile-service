package com.amdocs.media.profileservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amdocs.media.profileservice.entity.Profile;
import com.amdocs.media.profileservice.service.ProfileService;

@Controller
@RequestMapping("/profileService")
public class ProfileController {

	protected static final Logger LOGGER = LoggerFactory.getLogger(ProfileController.class);

	@Autowired
	ProfileService profileService;
	
	@PostMapping("/saveProfile")
	public ResponseEntity<Profile> storeProfileData(Profile profile) {
		LOGGER.info("store profile service called");
		profile = profileService.save(profile);
		return new ResponseEntity<>(profile,HttpStatus.OK);
	}
	
}
