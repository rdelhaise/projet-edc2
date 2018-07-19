package com.epsi.maven.webservices.rest;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/supervision")
public class PingQuery {
	@GetMapping(path = "/ping")
	public String ping(final HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
		return "ping";
	}
}
