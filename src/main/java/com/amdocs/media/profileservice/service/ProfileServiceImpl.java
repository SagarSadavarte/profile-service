package com.amdocs.media.profileservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.media.profileservice.dao.ProfileRepository;
import com.amdocs.media.profileservice.entity.Profile;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	ProfileRepository profileRepository;
	
	@Override
	public Profile save(Profile profile) {

		if(profile!=null)
			profile = profileRepository.save(profile);
		return profile;
	}

	@Override
	public void delete(Profile profile) {
		if(profile !=null)
			profileRepository.delete(profile);
	}

}
