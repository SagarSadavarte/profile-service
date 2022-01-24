package com.amdocs.media.profileservice.service;

import com.amdocs.media.profileservice.entity.Profile;

public interface ProfileService {

	public Profile save(Profile profile);
	public void delete(Profile profile);
}
