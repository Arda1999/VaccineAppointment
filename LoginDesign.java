package com.jinujawad.com;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class LoginDesign extends JFrame {
	static String kullaniciadi;
	static String sifre;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginDesign frame = new LoginDesign();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public LoginDesign() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 496, 328);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setForeground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Kullanici Adi");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setBackground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(187, 44, 134, 13);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(169, 69, 140, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Sifre");
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel_1.setBounds(221, 98, 62, 13);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(169, 121, 140, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Log In");
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				kullaniciadi = textField.getText();
				sifre = textField_1.getText();
				
				Connection connection = null;
				Statement statemnt = null;
				ResultSet rs = null;
				ResultSet newrs = null;
				DatabaseEnter obj_ConnectDB = new DatabaseEnter();
				
				connection = obj_ConnectDB.get_connection();
				try {
					String query = "select count(name) as giris from patient where username = '"+kullaniciadi+"' and password = '"+sifre+"'";
					statemnt = connection.createStatement();
					rs = statemnt.executeQuery(query);
					
					while(rs.next()){
						if(rs.getInt("giris")==1) {
							Vaccine v = new Vaccine();
							v.setVisible(true);
							v.setSize(800,500);
							v.setTitle("VACCINE PAGE");
							v.setResizable(false);
						}
						else {
							//JOptionPane.showMessageDialog(null,"Kullaniciadi ve Sifre Hatali");
						}
					
						
					}
					String query1 = "select count(name) as giris1 from doctor where username = '"+kullaniciadi+"' and password = '"+sifre+"'";
					statemnt = connection.createStatement();
					newrs = statemnt.executeQuery(query1);
					while(newrs.next()){
						if(newrs.getInt("giris1")==1) {
							AsiRandevu ar = new AsiRandevu();
							ar.setVisible(true);
							ar.setSize(900,500);
							ar.setTitle("Doctor Change Patient Report PAGE");
							ar.setResizable(false);
						}
						else {
							//JOptionPane.showMessageDialog(null,"Kullaniciadi ve Sifre Hatali");
						}
					}
			
					
					
					
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.setBackground(Color.ORANGE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(169, 221, 140, 21);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Register r = new Register();
				r.setVisible(true);
				r.setSize(500,300);
				r.setTitle("Patient Register Page");
				r.setResizable(false);
			}
		});
		btnNewButton.setBounds(169, 165, 140, 46);
		contentPane.add(btnNewButton);
		
		
		
	}
}
