package com.jinujawad.com;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;

public class DatabaseEnter extends JFrame {

	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatabaseEnter frame = new DatabaseEnter();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public DatabaseEnter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton btnNewButton = new JButton("CONNECT");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Connection connection = null;

				try {
					
					Class.forName("org.postgresql.Driver");
					connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/BIL344HOMEWORK-2","postgres","1234");
					if(connection != null) {
						LoginDesign l = new LoginDesign();
						l.setVisible(true);
						l.setSize(500,300);
						l.setTitle("Log-In Page");
						l.setResizable(false);	
					}
					else {
						JOptionPane.showMessageDialog(null,"Connection FAILD");			
						}
					
					
				}catch(Exception e) {
					System.out.println(e);
				}
			}
		});
		btnNewButton.setBounds(241, 200, 161, 39);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Welcome To My Database Server");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setBackground(Color.GRAY);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel.setBounds(44, 83, 392, 61);
		contentPane.add(lblNewLabel);
	}
	public Connection get_connection() {
Connection connection = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/BIL344HOMEWORK-2","postgres","1234");

			if(connection != null) {
				System.out.println("Connection OK");
			}
			else {
				System.out.println("Connection Failed");
			}
			
		}
		catch(Exception e){
			System.out.println(e);
		}
		return connection;
		
		
	}
}
