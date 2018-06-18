package com.epsi.maven.webservices.DAO;

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


public class AppelApiGoogle {
	
    public String getByAuthor(String author) throws IOException {
    	
        author = URLEncoder.encode(author, "UTF-8");
        InputStream input = new URL("https://www.googleapis.com/books/v1/volumes?q=inauthor:"+author).openStream();
        Scanner s = new Scanner(input).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
	

    public String getByIsbn(String isbn) throws IOException {
    	
        isbn = URLEncoder.encode(isbn, "UTF-8");
        InputStream input = new URL("https://www.googleapis.com/books/v1/volumes?q=inisbn:"+isbn).openStream();
        Scanner s = new Scanner(input).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
        
    }
	

    public String getByTitle(String title) throws IOException {
    	
        title = URLEncoder.encode(title, "UTF-8");
        InputStream input = new URL("https://www.googleapis.com/books/v1/volumes?q=intitle:"+title).openStream();
        Scanner s = new Scanner(input).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
        
    }
}
