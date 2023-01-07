package com.jinujawad.com;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Hospital extends JFrame {
	static String hastahaneadi;
	private JList list;
	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hospital frame = new Hospital();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	public void loadList() {
		Connection connection = null;
		Statement statemnt = null;
		ResultSet rs = null;
		
		DatabaseEnter obj_ConnectDB = new DatabaseEnter();
		
		connection = obj_ConnectDB.get_connection();
		
		try {
			String query = "select * from hospital";
			statemnt = connection.createStatement();
			rs = statemnt.executeQuery(query);
			
			
			System.out.println("Value inserted succefully!");
			
			DefaultListModel DLM = new DefaultListModel();
		
			
			while(rs.next()) {
				DLM.addElement(rs.getString("hospitalname"));
				
			}
			
			list.setModel(DLM);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public Hospital() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hospital Names");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(142, 10, 191, 42);
		contentPane.add(lblNewLabel);
		
		list = new JList();
		list.setBackground(Color.PINK);
		list.setFont(new Font("Tahoma", Font.BOLD, 16));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"BayindirHastehanesi", "TOBBHastehanesi", "MedicanaHastehanesi"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(116, 62, 191, 99);
		contentPane.add(list);
		
		JButton btnNewButton = new JButton("Pick Hospital");
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hastahaneadi = (String) list.getSelectedValue();
				Connection connection = null;
				Statement statemnt = null;
				ResultSet rs = null;

				DatabaseEnter obj_ConnectDB = new DatabaseEnter();
				connection = obj_ConnectDB.get_connection();
				try {
					String query = "select count(hospitalname) as giris from hospital where hospitalname = '"+hastahaneadi+"'";
					statemnt = connection.createStatement();
					rs = statemnt.executeQuery(query);
					
					while(rs.next()){
						if(rs.getInt("giris")==1) {
							Doctor d = new Doctor();
							d.setVisible(true);
							d.setSize(900,300);
							d.setTitle("Doctor PAGE");
							d.setResizable(false);
						}
						
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(null,"Hastane Secildi");

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(134, 193, 145, 21);
		contentPane.add(btnNewButton);
		loadList();
	}

}
