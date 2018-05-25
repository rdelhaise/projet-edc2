package com.epsi.book.application;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RechercheLivre extends JFrame {

	private JPanel contentPane;
	private JTextPane txtLivre;
	private JTextField tfId;


	/**
	 * Launch the application.
	 */



	public RechercheLivre() throws ClassNotFoundException {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("RECHERCHER LIVRE");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 6, 438, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID :");
		lblNewLabel_1.setBounds(63, 44, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		tfId = new JTextField();
		tfId.setBounds(205, 39, 208, 26);
		contentPane.add(tfId);
		tfId.setColumns(10);
		
		txtLivre = new JTextPane();
		txtLivre.setBounds(37, 179, 376, 93);
		contentPane.add(txtLivre);
		
		
		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if(tfId.getText().length() !=0 ) {
					
							String id = tfId.getText();	
							Bibliotheque biblio= Bibliotheque.getInstance();
							Book b =biblio.getBook(id);
							if(b != null) {
								txtLivre.setText(b.toString());
							}else
								JOptionPane.showMessageDialog(null, "Le livre que vous recherchez n'existe pas dans la bibliothèque");
							
					}else {
						
							JOptionPane.showMessageDialog(null, "Veuillez renseigner l'id du livre");
						
					}
			}
		});
		btnRechercher.setBounds(78, 138, 117, 29);
		contentPane.add(btnRechercher);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Accueil fen= new Accueil();
				fen.setVisible(true);
				setVisible(false);
			}
		});
		btnAnnuler.setBounds(244, 138, 117, 29);
		contentPane.add(btnAnnuler);
		
	}
}
