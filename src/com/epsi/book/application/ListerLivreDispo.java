package com.epsi.book.application;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListerLivreDispo extends JFrame {

	private JPanel contentPane;


	public ListerLivreDispo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LISTE DES LIVRE DISPONIBLES");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(94, 6, 438, 20);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblNewLabel.setForeground(Color.BLUE);
		contentPane.add(lblNewLabel);
		
		Bibliotheque biblio= Bibliotheque.getInstance();
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(73, 55, 493, 283);
		contentPane.add(textPane);
		textPane.setText(biblio.getBooks().toString()); 
		
		
		JButton btnAccueil = new JButton("ACCUEIL");
		btnAccueil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Accueil fen= new Accueil();
				fen.setVisible(true);
				setVisible(false);
			}
		});
		btnAccueil.setBounds(267, 352, 117, 29);
		contentPane.add(btnAccueil);
		
	}
}
