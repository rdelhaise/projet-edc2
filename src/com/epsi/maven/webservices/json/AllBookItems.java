package com.epsi.maven.webservices.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class AllBookItems {
	@ApiModelProperty(required = true)

	@JsonProperty("totalItems")
	private int totalItems;
	@JsonProperty("items")
	private List<Items> items;
	public int getTotalItems() {
		return totalItems;
	}
	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}
	public void setItems(List<Items> items) {
		this.items = items;
	}
	public List<Items> getItems() {
		return items;
	}
	
}
