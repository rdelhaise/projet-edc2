package com.epsi.book.application ;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;

public class Accueil extends JFrame {

	private JPanel contentPane;

	private static Bibliotheque biblio;

	/**
	 * Launch the application.
	 * @throws JSONException 
	 */
	public static void main(String[] args)   {
		try {
			biblio= Bibliotheque.getInstance();
			
		
			
			biblio.addBook("AZT-RTE");
			biblio.addBook("AZT-RTE");
			
			for(Book b:biblio.getBooks()) {
				System.out.println(b.toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Accueil frame = new Accueil();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});}
	


	/**
	 * Create the frame.
	 */
	public Accueil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GESTION DE LA BIBLIOTHEQUE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 6, 542, 20);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblNewLabel.setForeground(Color.BLUE);
		contentPane.add(lblNewLabel);
		
		JButton btnAjouterLivre = new JButton("Ajouter Livre");
		btnAjouterLivre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AjouterLivre fen= new AjouterLivre();
				fen.setVisible(true);
				setVisible(false);
				
			}
		});
		btnAjouterLivre.setBounds(200, 61, 147, 29);
		contentPane.add(btnAjouterLivre);
		
		JButton btnAjouterLivreAvec = new JButton("Ajouter Livre avec ISBN");
		btnAjouterLivreAvec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AjouterLivreISBN fen= new AjouterLivreISBN();
				fen.setVisible(true);
				setVisible(false);
			}
		});
		btnAjouterLivreAvec.setBounds(187, 116, 171, 29);
		contentPane.add(btnAjouterLivreAvec);
		
		JButton btnSupprimerLivre = new JButton("Retirer Livre");
		btnSupprimerLivre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RetirerLivre fen= new RetirerLivre();
				fen.setVisible(true);
				setVisible(false);
			}
		});
		btnSupprimerLivre.setBounds(200, 198, 147, 29);
		contentPane.add(btnSupprimerLivre);
		
		JButton btnRetournerLivres = new JButton("Retourner Livre");
		btnRetournerLivres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RetournerLivre fen= new RetournerLivre();
				fen.setVisible(true);
				setVisible(false);
			}
		});
		btnRetournerLivres.setBounds(200, 239, 153, 29);
		contentPane.add(btnRetournerLivres);
		
		JButton btnRechercherLivre = new JButton("Rechercher Livre");
		btnRechercherLivre.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				RechercheLivre fenetreRechercher = null;
				try {
					fenetreRechercher = new RechercheLivre();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				fenetreRechercher.setVisible(true);
				setVisible(false);
			}
		});
		btnRechercherLivre.setBounds(200, 157, 147, 29);
		contentPane.add(btnRechercherLivre);
		
		JButton btnListerLesLivres = new JButton("Lister les Livres");
		btnListerLesLivres.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e)
			{
				ListerLivreDispo fen= new ListerLivreDispo();
				fen.setVisible(true);
				setVisible(false);
				
			}
		});
		btnListerLesLivres.setBounds(200, 281, 153, 29);
		contentPane.add(btnListerLesLivres);
		
		JButton btnListerLesLivres_1 = new JButton("Lister les Livres empruntés");
		btnListerLesLivres_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListLivreNonDispo fen= new ListLivreNonDispo();
				fen.setVisible(true);
				setVisible(false);
			}
		});
		btnListerLesLivres_1.setBounds(173, 319, 198, 29);
		contentPane.add(btnListerLesLivres_1);
	}
}
