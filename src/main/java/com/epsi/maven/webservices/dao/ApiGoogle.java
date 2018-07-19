package com.epsi.maven.webservices.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ApiGoogle {
	
	public String getGoogleResponse(String term, String isbn) {
		// Set the type of search on google webservices
		
		final List<String> googleUrl = new ArrayList<>();
		if (term != null) {
			googleUrl.add(term);
		}
		if (isbn != null) {
			googleUrl.add("isbn:" + isbn);
		}
		return String.join("+", googleUrl);
	}

    
}
