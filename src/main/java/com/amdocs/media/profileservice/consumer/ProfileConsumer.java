package com.amdocs.media.profileservice.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.amdocs.media.profileservice.entity.Profile;
import com.amdocs.media.profileservice.service.ProfileService;
import com.amdocs.media.profileservice.util.Util;

@Component
public class ProfileConsumer {
	
	protected static final Logger LOGGER = LoggerFactory.getLogger(ProfileConsumer.class);
	
	@Autowired
	ProfileService profileService;
	
	
	@KafkaListener(topics = "${kafka.topic.name}")
	public void consumeProfile(ConsumerRecord<String, String> record) {
		LOGGER.info("consuming the profile");
		LOGGER.info(record.value());

		Profile profile = null;
		try {
			profile = Util.jsonToJava(record.value(), Profile.class);

			if (profile.getEventType() != null) {
				if (profile.getEventType().equalsIgnoreCase("Save")
						|| profile.getEventType().equalsIgnoreCase("Update"))
					profileService.save(profile);
				else if (profile.getEventType().equalsIgnoreCase("Delete"))
					profileService.delete(profile);
			}
		} catch (Exception e) {
			LOGGER.error("Exception while consuming and processing profile", e);
		}
	}

}