package com.epsi.book.application;

import java.io.Serializable;

public class Auteur implements Serializable {
	private String nom;
	private String prenom;
	
	
	
	public Auteur() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Auteur(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}


	public String getNom() {
		return this.nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return this.prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	@Override
	public String toString() {
		return "Auteur [nom=" + nom + ", prenom=" + prenom + "]";
	}
	
	
	
	
	
}
