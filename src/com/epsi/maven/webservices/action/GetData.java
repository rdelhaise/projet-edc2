package com.epsi.maven.webservices.action;

import java.io.IOException;

import com.epsi.maven.webservices.DAO.AppelApiGoogle;

public class GetData {
		public String getData(String researchType, String data) throws IOException {
			String response = "" ; 
			AppelApiGoogle appelApi = new AppelApiGoogle();
			if(researchType == "author"){
				
				response = appelApi.getByAuthor(data);
				
			}else if(researchType == "isbn") {
				
				response = appelApi.getByIsbn(data);
				
			}else {
				
				response = appelApi.getByTitle(data);

			}
			return response;
		}
}
