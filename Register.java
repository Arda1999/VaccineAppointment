package com.jinujawad.com;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField tctf;
	private JTextField usernametf;
	private JTextField nametf;
	private JTextField surnametf;
	private JTextField passwordtf;
	private JTextField gendertf;
	private JTextField pregnancytf;
	private JTextField datetf;
	private JTextField allergytf;
	private JTextField chronictf;

	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	public Register() {
		//create connection ******************
		Connection connection = null;
		Statement statemnt = null;
		DatabaseEnter obj_ConnectDB = new DatabaseEnter();
		connection = obj_ConnectDB.get_connection();
		//********************************
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setBounds(77, 37, 112, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setBounds(77, 60, 122, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Surname");
		lblNewLabel_2.setForeground(Color.ORANGE);
		lblNewLabel_2.setBounds(77, 83, 112, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setForeground(Color.ORANGE);
		lblNewLabel_3.setBounds(77, 106, 60, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Gender");
		lblNewLabel_4.setForeground(Color.ORANGE);
		lblNewLabel_4.setBounds(77, 129, 60, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("TC No");
		lblNewLabel_5.setForeground(Color.ORANGE);
		lblNewLabel_5.setBounds(77, 14, 45, 13);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Pregnancy Info");
		lblNewLabel_6.setForeground(Color.ORANGE);
		lblNewLabel_6.setBounds(60, 152, 94, 13);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Date Of Birth");
		lblNewLabel_7.setForeground(Color.ORANGE);
		lblNewLabel_7.setBounds(77, 175, 77, 19);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Allergy Info");
		lblNewLabel_8.setForeground(Color.ORANGE);
		lblNewLabel_8.setBounds(77, 204, 122, 13);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("ChronicDiseaseInfo");
		lblNewLabel_9.setForeground(Color.ORANGE);
		lblNewLabel_9.setBounds(58, 230, 112, 13);
		contentPane.add(lblNewLabel_9);
		
		tctf = new JTextField();
		tctf.setBounds(183, 11, 96, 19);
		contentPane.add(tctf);
		tctf.setColumns(10);
		
		usernametf = new JTextField();
		usernametf.setBounds(183, 34, 96, 19);
		contentPane.add(usernametf);
		usernametf.setColumns(10);
		
		nametf = new JTextField();
		nametf.setBounds(183, 57, 96, 19);
		contentPane.add(nametf);
		nametf.setColumns(10);
		
		surnametf = new JTextField();
		surnametf.setBounds(183, 80, 96, 19);
		contentPane.add(surnametf);
		surnametf.setColumns(10);
		
		passwordtf = new JTextField();
		passwordtf.setBounds(183, 103, 96, 19);
		contentPane.add(passwordtf);
		passwordtf.setColumns(10);
		
		gendertf = new JTextField();
		gendertf.setBounds(183, 126, 96, 19);
		contentPane.add(gendertf);
		gendertf.setColumns(10);
		
		pregnancytf = new JTextField();
		pregnancytf.setBounds(183, 149, 96, 19);
		contentPane.add(pregnancytf);
		pregnancytf.setColumns(10);
		
		datetf = new JTextField();
		datetf.setBounds(183, 175, 96, 19);
		contentPane.add(datetf);
		datetf.setColumns(10);
		
		allergytf = new JTextField();
		allergytf.setBounds(183, 201, 96, 19);
		contentPane.add(allergytf);
		allergytf.setColumns(10);
		
		chronictf = new JTextField();
		chronictf.setBounds(183, 227, 96, 19);
		contentPane.add(chronictf);
		chronictf.setColumns(10);
		
		JButton btnNewButton = new JButton("Insert Database");
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection connection = null;
				Statement statemnt = null;
				DatabaseEnter obj_ConnectDB = new DatabaseEnter();
				connection = obj_ConnectDB.get_connection();
				try {
					String query = "insert into Patient(TC,username,name,surname,password,gender,pregnancyinfo,dateofbirth,allergyinfo,chronicdiseaseinfo) values('"+tctf.getText()+"', '"+usernametf.getText()+"','"+nametf.getText()+"','"+surnametf.getText()+"','"+passwordtf.getText()+"','"+gendertf.getText()+"','"+pregnancytf.getText()+"','"+datetf.getText()+"','"+allergytf.getText()+"','"+chronictf.getText()+"')";
					statemnt = connection.createStatement();
					statemnt.executeUpdate(query);
					System.out.println("Value inserted succefully!");
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.setBounds(289, 117, 137, 37);
		contentPane.add(btnNewButton);
	}

}
