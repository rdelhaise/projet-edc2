package com.epsi.maven.webservices.action;

import java.io.IOException;

import com.epsi.maven.webservices.DAO.AppelApiGoogle;

public class GetData {
		public String getData(String researchType, String data) throws IOException {
			final AppelApiGoogle appelApi = new AppelApiGoogle();
			if ("author".equals(researchType)) {

				return appelApi.getByAuthor(data);
			
			} else if (researchType == "isbn") {
			
				return appelApi.getByIsbn(data);
			}

			return appelApi.getByTitle(data);
		}
}
