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

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Api(value="greeting", description="Operations that permit to greet")
@RestController
@RequestMapping("/library/")
public class Webservices {
	
	@ApiOperation(value = "Find books with Author")
	@ApiResponses(value ={
			@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 400, message = "Bad request"),
			@ApiResponse(code = 502, message = "Bad gateway")
	})
    @RequestMapping(path = "/findByAuthor/{author}", method = RequestMethod.GET)
    String findByAuthor(@PathVariable String author) throws IOException {
        author = URLEncoder.encode(author, "UTF-8");
        InputStream input = new URL("https://www.googleapis.com/books/v1/volumes?q=inauthor:"+author).openStream();
        Scanner s = new Scanner(input).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
	
	@ApiOperation(value = "Find book with ISBN")
	@ApiResponses(value ={
			@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 400, message = "Bad request"),
			@ApiResponse(code = 502, message = "Bad gateway")
	})
    @RequestMapping(path = "/findByIsbn/{isbn}", method = RequestMethod.GET)
    String findByIsbn(@PathVariable String isbn) throws IOException {
        isbn = URLEncoder.encode(isbn, "UTF-8");
        InputStream input = new URL("https://www.googleapis.com/books/v1/volumes?q=inisbn:"+isbn).openStream();
        Scanner s = new Scanner(input).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
	
	@ApiOperation(value = "Find book with Title")
	@ApiResponses(value ={
			@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 400, message = "Bad request"),
			@ApiResponse(code = 502, message = "Bad gateway")
	})
    @RequestMapping(path = "/findByTitle/{title}", method = RequestMethod.GET)
    String findByTitle(@PathVariable String title) throws IOException {
        title = URLEncoder.encode(title, "UTF-8");
        InputStream input = new URL("https://www.googleapis.com/books/v1/volumes?q=intitle:"+title).openStream();
        Scanner s = new Scanner(input).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}
