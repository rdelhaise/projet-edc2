package com.epsi.maven.webservices.json;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown=true)

public class Items {
	@ApiModelProperty(required = true)
	
	
	private Book book;

	@JsonValue
	public Book getBook() {
		return book;
	}

	public void setVolumeInfo(Book book) {
		this.book = book;
	}
}
