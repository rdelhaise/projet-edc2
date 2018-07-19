package com.epsi.maven.webservices.dao;

import java.io.IOException;

import org.json.JSONException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.epsi.maven.webservices.json.AllBookItems;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class BookData {
/** Configuration */

private String url = "https://www.googleapis.com/books/v1/volumes?";

public String requestBookData(String terms) throws IOException, JSONException  {
	String uriString = UriComponentsBuilder.fromUriString(url)
	        .queryParam("q", terms)
			.toUriString();
	
	ObjectMapper objectMapper = new ObjectMapper();
	// Create the JSON Object
	RestTemplate restTemplate = new RestTemplate();
	AllBookItems responseJSON = restTemplate.getForObject(uriString, AllBookItems.class);
	
	return objectMapper.writeValueAsString(responseJSON);
}
}
