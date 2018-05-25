package com.epsi.book.application;

import java.io.Serializable;
import java.util.ArrayList;

public class Book implements Serializable {

	private String id;
	private String isbn;
	private String titre;
	private String genre;
	private ArrayList<Auteur> Listauteur;
	private int annee;
	private boolean isBorrowed;
	
	
	//Constructeur d'un livre
	public Book(String id, String isbn,String genre, String titre, Auteur auteur, int annee) {
		super();
		this.id = id;
		this.isbn=isbn;
		this.titre = titre;
		this.Listauteur = new ArrayList<Auteur>();
		this.Listauteur.add(auteur);
		this.annee = annee;
		this.isBorrowed = false;
	}


public Book() {
		// TODO Auto-generated constructor stub
	}


	//Cette fonction permet de vérifier si un livre est disponible
	public boolean isBorrowed() {
		return isBorrowed;
	}


//Cette fonction permet de mettre à jour la disponibilité d'un livre
	public void setBorrowed(boolean isBorrowed) {
		this.isBorrowed = isBorrowed;
	}


//Retourne l'Isbn d'un livre
	public String getIsbn() {
		return isbn;
	}
	
	



	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}



	public void setId(String id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}



	public void setTitre(String titre) {
		this.titre = titre;
	}


//Retourne la liste des auteurs
	public ArrayList<Auteur> getListAuteur() {
		return this.Listauteur;
	}
	
	//Retourne un auteur du livre
	public Auteur getAuteur(String nom, String prenom) {
		Auteur auteur= new Auteur();
		for (Auteur au:Listauteur) {
			if(au.getNom().equals(nom) && au.getPrenom().equals(prenom)) {
				auteur=au;
				break;
			}
		}
		return auteur;
	}


//Ajouter un auteur
	public void setAuteur(Auteur auteur) {
		this.Listauteur.add(auteur);
	}



	public int getAnnee() {
		return annee;
	}



	public void setAnnee(int annee) {
		this.annee = annee;
	}



	public String getId() {
		return id;
	}
	
	/**
	 * isEqualTo
	 * Cette fonction permet de verifier si 2 livres sont identiques
	 * @param b
	 * @return
	 */
	public boolean isEqualTo(Book b)
	{
		return this.id.equalsIgnoreCase(b.id) && this.isbn.equalsIgnoreCase(b.isbn) && this.titre.equalsIgnoreCase(b.titre) && this.annee == b.annee;
	}


	@Override
	public String toString() {
		return "Book [id=" + id + ", isbn=" + isbn + ", titre=" + titre + ", genre=" + genre + ", Listauteur="
				+ Listauteur + ", annee=" + annee + ", isBorrowed=" + isBorrowed + "]";
	}
	
	
}
