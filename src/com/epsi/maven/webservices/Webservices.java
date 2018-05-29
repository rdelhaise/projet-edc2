package com.epsi.maven.webservices;

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
public class WebServices {
	@ApiOperation(value = "Find book woth ISBN")
	@ApiResponses(value ={
			@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 400, message = "Bad request"),
			@ApiResponse(code = 502, message = "Bad gateway")
	})
    @RequestMapping(path = "/findByAuthor/{author}", method = RequestMethod.GET)
    String findByAuthor(@PathVariable String author) throws IOException {    
		
		GetData data = new GetData(); 
		
		
        return data.getData("author", author);
    }
}
