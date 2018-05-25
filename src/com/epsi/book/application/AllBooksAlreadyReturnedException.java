package com.epsi.book.application;

public class AllBooksAlreadyReturnedException extends Exception {

	public AllBooksAlreadyReturnedException() {
		System.out.println("Tous les livres avec l'identifiant donné sont déjà retourné");
	}
}
