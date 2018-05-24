import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RetournerLivre extends JFrame {

	private JPanel contentPane;
	private JTextField tfId;
	private JTextField tfUser;


	
	
	public RetournerLivre() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("RETOURNER LIVRE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(44, 6, 438, 20);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblNewLabel.setForeground(Color.BLUE);
		contentPane.add(lblNewLabel);
		
		JLabel lblId = new JLabel("ID :");
		lblId.setBounds(102, 53, 61, 16);
		contentPane.add(lblId);
		
		tfId = new JTextField();
		tfId.setBounds(320, 48, 130, 26);
		contentPane.add(tfId);
		tfId.setColumns(10);
		
		JLabel lblUserName = new JLabel("User Name :");
		lblUserName.setBounds(102, 126, 103, 16);
		contentPane.add(lblUserName);
		
		tfUser = new JTextField();
		tfUser.setBounds(320, 121, 130, 26);
		contentPane.add(tfUser);
		tfUser.setColumns(10);
		
		JButton btnRetirer = new JButton("Retourner");
		btnRetirer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfId.getText().length() != 0 && tfUser.getText().length() !=0) {
					
					String id = tfId.getText();
					String user= tfUser.getText();
					Bibliotheque biblio= Bibliotheque.getInstance();
					
						try {
							biblio.returnBook(id, user);
						} catch (BookNotFoundException | AllBooksAlreadyReturnedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "Le livre a été retourné avec succès");
					
					
					Accueil fen= new Accueil();
					fen.setVisible(true);
					setVisible(false);
					
				}else {
					JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs");
				}
					
			}
		});
		btnRetirer.setBounds(116, 221, 117, 29);
		contentPane.add(btnRetirer);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Accueil fen= new Accueil();
				fen.setVisible(true);
				setVisible(false);
			}
		});
		btnAnnuler.setBounds(297, 221, 117, 29);
		contentPane.add(btnAnnuler);
	}

}
