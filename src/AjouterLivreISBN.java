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

public class AjouterLivreISBN extends JFrame {

	private JPanel contentPane;
	private JTextField tfIsbn;



	public AjouterLivreISBN() {
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		JLabel lblNewLabel = new JLabel("AJOUTER LIVRE AVEC L'ISBN");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(6, 6, 532, 16);
		contentPane.add(lblNewLabel);
		
		
		
		JLabel lblIsbn = new JLabel("ISBN :");
		lblIsbn.setBounds(89, 68, 61, 16);
		contentPane.add(lblIsbn);
		
		tfIsbn = new JTextField();
		tfIsbn.setBounds(339, 63, 130, 26);
		contentPane.add(tfIsbn);
		tfIsbn.setColumns(10);
		
		JButton btnAjouter = new JButton("AJOUTER");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( tfIsbn.getText().length()!=0) {
					
					
					String isbn= tfIsbn.getText();
					Bibliotheque biblio= Bibliotheque.getInstance();
					biblio.addBook(isbn);
					
					JOptionPane.showMessageDialog(null, "Nouveau livre ajouté avec succès");
					
					Accueil fen= new Accueil();
					fen.setVisible(true);
					setVisible(false);
							
				}else
				{
					JOptionPane.showMessageDialog(null, "Veuillez renseigner l'isbn");
				}
				
			}
		});
		btnAjouter.setBackground(new Color(255, 255, 255));
		btnAjouter.setForeground(new Color(0, 0, 0));
		btnAjouter.setBounds(290, 164, 117, 29);
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
		btnAnnuler.setBounds(128, 164, 117, 29);
		contentPane.add(btnAnnuler);
		
		
	}
}
