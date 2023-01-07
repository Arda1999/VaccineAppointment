package com.jinujawad.com;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class AsiRandevu extends JFrame {
	private JList list;
	private JPanel contentPane;
	static String patientname;
	private JTable table;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AsiRandevu frame = new AsiRandevu();
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
			String query = "select p.* from patient p,doctor d where d.username = '"+LoginDesign.kullaniciadi+"'and d.name = p.doctorname";
			statemnt = connection.createStatement();
			rs = statemnt.executeQuery(query);
			
			
			System.out.println("Value inserted succefully!");
			
			DefaultListModel DLM = new DefaultListModel();
		
			
			while(rs.next()) {
				DLM.addElement(rs.getString("name"));

			}
			
			list.setModel(DLM);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public AsiRandevu() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 915, 536);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		list = new JList();
		list.setFont(new Font("Tahoma", Font.BOLD, 17));
		list.setBackground(Color.PINK);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(331, 141, 198, 217);
		contentPane.add(list);
		
		JLabel lblNewLabel = new JLabel("Patient List");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(370, 30, 248, 31);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Attendent");
		btnNewButton.setBackground(Color.ORANGE);
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(59, 160, 145, 69);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Not Attendent");
		btnNewButton_1.setBackground(Color.ORANGE);
		
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(59, 295, 148, 63);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("The patient came for an appointment");
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1.setBounds(10, 104, 287, 46);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("The patient did not come to the appointment");
		lblNewLabel_2.setForeground(Color.ORANGE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_2.setBounds(10, 257, 294, 13);
		contentPane.add(lblNewLabel_2);
		
		
	
		JButton btnNewButton_2 = new JButton("Choose List Patient");
		btnNewButton_2.setBackground(Color.RED);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBounds(331, 403, 198, 52);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_3 = new JLabel("Choosen Patient TC");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(343, 118, 198, 13);
		contentPane.add(lblNewLabel_3);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 10));
		table.setBackground(Color.PINK);
		table.setBounds(559, 148, 332, 210);
		contentPane.add(table);
		
		JButton btnNewButton_3 = new JButton("Patient Information");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Connection connection = null;
				Statement statemnt = null;
				ResultSet rs = null;
				
				DatabaseEnter obj_ConnectDB = new DatabaseEnter();
				
				connection = obj_ConnectDB.get_connection();
				try {
					String query = "select tc,name,surname,appointmentreport,priority username from patient";
					statemnt = connection.createStatement();
					rs = statemnt.executeQuery(query);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_3.setBackground(Color.ORANGE);
		btnNewButton_3.setBounds(625, 403, 207, 52);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_4 = new JLabel("Information Patients");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(598, 122, 198, 13);
		contentPane.add(lblNewLabel_4);
		
		
		
		
		
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				patientname = (String) list.getSelectedValue();
				JOptionPane.showMessageDialog(null,"Hasta Secildi");

			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection connection = null;
				Statement statemnt = null;
				DatabaseEnter obj_ConnectDB = new DatabaseEnter();
				connection = obj_ConnectDB.get_connection();
				try {
					String query = "update patient set appointmentreport = 'NotAttending' where name = '"+patientname+"'";
					statemnt = connection.createStatement();
					statemnt.executeUpdate(query);
					JOptionPane.showMessageDialog(null,"Hastanin AppointmentReport'u NotAtteding olarak guncellendi");

				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection connection = null;
				Statement statemnt = null;
				DatabaseEnter obj_ConnectDB = new DatabaseEnter();
				connection = obj_ConnectDB.get_connection();
				try {
					String query = "update patient set appointmentreport = 'Attending' where name = '"+patientname+"'";
					statemnt = connection.createStatement();
					statemnt.executeUpdate(query);
					JOptionPane.showMessageDialog(null,"Hastanin AppointmentReport'u Atteding olarak guncellendi");
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		loadList();
	}
}
