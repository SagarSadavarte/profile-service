package com.amdocs.media.profileservice.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Util {
	
	public static <T> T jsonToJava(String json,Class<T> object) throws JsonMappingException, JsonProcessingException {
			return new ObjectMapper().readValue(json, object);
	}
	

}
