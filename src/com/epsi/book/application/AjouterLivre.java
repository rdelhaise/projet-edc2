package com.epsi.book.application ;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class AjouterLivre extends JFrame {

	private JPanel contentPane;
	private JTextField tfTitre;
	private JComboBox comboBoxAuteur;
	private static Auteur a1,a2,a3,a4,a5;
	private JTextField tfAnnee;
	private JTextField tfGenre;
	private JTextField tfId;
	private JTextField tfIsbn;

	
	/**
	 * Create the frame.
	 */
	public AjouterLivre() {
		
		 a1= new Auteur("BACHABI","Bassam");
		 a2= new Auteur("Sinda","Singor");
		 a3= new Auteur("Marc","Arthu");
		 a4= new Auteur("Stéphane","Anthoine");
		 a5= new Auteur("Kaaris","Dozo");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomDuLivre = new JLabel("Titre :");
		lblNomDuLivre.setBounds(93, 88, 77, 16);
		contentPane.add(lblNomDuLivre);
		
		JLabel lblAuteur = new JLabel("Auteur :");
		lblAuteur.setBounds(93, 143, 77, 21);
		contentPane.add(lblAuteur);
		
		JLabel lblAnneDePublication = new JLabel("Année :");
		lblAnneDePublication.setBounds(93, 199, 77, 16);
		contentPane.add(lblAnneDePublication);
		
		JLabel lblGenre = new JLabel("Genre :");
		lblGenre.setBounds(93, 252, 77, 21);
		contentPane.add(lblGenre);
		
		tfTitre = new JTextField();
		tfTitre.setBounds(371, 83, 130, 26);
		contentPane.add(tfTitre);
		tfTitre.setColumns(10);
		
		Object[] auteur = new Object[]{a1, a2, a3, a4, a5};
		comboBoxAuteur = new JComboBox<Object>(auteur);
		comboBoxAuteur.setBounds(371, 141, 130, 27);
		contentPane.add(comboBoxAuteur);
		
		tfAnnee = new JTextField();
		tfAnnee.setBounds(371, 194, 130, 26);
		contentPane.add(tfAnnee);
		tfAnnee.setColumns(10);
		
		tfGenre = new JTextField();
		tfGenre.setBounds(371, 249, 130, 26);
		contentPane.add(tfGenre);
		tfGenre.setColumns(10);
		
		JLabel lblId = new JLabel("ID : ");
		lblId.setBounds(93, 34, 61, 16);
		contentPane.add(lblId);
		
		tfId = new JTextField();
		tfId.setBounds(371, 29, 130, 26);
		contentPane.add(tfId);
		tfId.setColumns(10);
		
		JButton btnAjouter = new JButton("AJOUTER");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if(tfTitre.getText().length() !=0 && tfAnnee.getText().length()!=0 && tfGenre.getText().length()!=0 && tfIsbn.getText().length()!=0) {
					
					String id = tfId.getText();
					String titre= tfTitre.getText();
					int annee= Integer.parseInt(tfAnnee.getText());
					String genre= tfGenre.getText();
					String isbn= tfIsbn.getText();
					Auteur auteur= (Auteur) comboBoxAuteur.getSelectedItem();
					
					Book bk = new Book(id, isbn, titre,genre, auteur, annee );
					
					Bibliotheque biblio= Bibliotheque.getInstance();
					biblio.addBookWithBook(bk);

					JOptionPane.showMessageDialog(null, "Nouveau livre ajouté avec succès");
					
					for(Book b:biblio.getBooks()) {
						System.out.println(b.toString());
					}
					
					Accueil fen= new Accueil();
					fen.setVisible(true);
					setVisible(false);
							
				}else
				{
					JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs");
				}
			}
		});
		btnAjouter.setBackground(new Color(255, 255, 255));
		btnAjouter.setForeground(new Color(0, 0, 0));
		btnAjouter.setBounds(323, 344, 117, 29);
		contentPane.add(btnAjouter);
		
		JButton btnAnnuler = new JButton("ANNULER");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Accueil fen= new Accueil();
				fen.setVisible(true);
				setVisible(false);
			}
		});
		btnAnnuler.setBackground(new Color(255, 255, 255));
		btnAnnuler.setBounds(137, 344, 117, 29);
		contentPane.add(btnAnnuler);
		
		JLabel lblNewLabel = new JLabel("AJOUTER UN LIVRE");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(6, 6, 532, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ISBN");
		lblNewLabel_1.setBounds(93, 297, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		tfIsbn = new JTextField();
		tfIsbn.setBounds(371, 292, 130, 26);
		contentPane.add(tfIsbn);
		tfIsbn.setColumns(10);
		
		
	}
}
