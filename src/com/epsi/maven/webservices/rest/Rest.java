package com.epsi.maven.webservices.rest;

import java.io.IOException;

import javax.validation.Valid;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.epsi.maven.webservices.dao.ApiGoogle;
import com.epsi.maven.webservices.dao.BookData;
import com.epsi.maven.webservices.json.SearchJson;

@RestController
@RequestMapping("/book")
public class Rest {
	@Autowired
	private BookData dataBook;
	@Autowired
	private ApiGoogle googleUrl;
	// Create the Post Webservices
	@RequestMapping(path = "/search", method = RequestMethod.POST, headers = "Content-Type : application/json" , produces = "application/json;charset=utf-8")
	public ResponseEntity<Object> searchBook(@RequestBody @Valid final SearchJson jsonRequest) throws IOException, JSONException {
		// If no json return bad request (400)
		
		if (dataBook.requestBookData(googleUrl.getGoogleResponse(jsonRequest.getTerm(), jsonRequest.getIsbn())) == null ){
			return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body(null);

		}else {
			
				return ResponseEntity.ok( dataBook.requestBookData( googleUrl.getGoogleResponse( jsonRequest.getTerm(), jsonRequest.getIsbn() ) ) );
			
		}

		
	}
	
	
}
