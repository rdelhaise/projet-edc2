package com.epsi.maven.webservices.rest;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.epsi.maven.webservices.action.GetData;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Api(value="greeting", description="Operations that permit to greet")
@RestController
@RequestMapping("/library/")
public class Rest {
	GetData data = new GetData();
	/*
	 * Appel de l'API par le client lourd
	 * Récupération des livres par Auteur 
	 * 
	 */
	
	@ApiOperation(value = "Find books with Author")
	@ApiResponses(value ={
			@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 400, message = "Bad request"),
			@ApiResponse(code = 502, message = "Bad gateway")
	})
    @RequestMapping(path = "/author/{author}", method = RequestMethod.GET)
	String author(@PathVariable String author) throws IOException {
		
		return data.getData("author", author);
		
    }
	
}
