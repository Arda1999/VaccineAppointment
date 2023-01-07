package com.jinujawad.com;

import java.awt.BorderLayout;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;

public class Vaccine extends JFrame {
	//private JList list;
	private JPanel contentPane;
	private JList list;
	private JTable table;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vaccine frame = new Vaccine();
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
			String query = "select * from vaccine";
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
	public Vaccine() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 752, 470);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Vaccine Type");
		lblNewLabel.setBounds(292, 27, 395, 23);
		lblNewLabel.setForeground(Color.PINK);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		contentPane.add(lblNewLabel);
		list = new JList();
		list.setBounds(600, 71, 125, 215);
		list.setFont(new Font("Tahoma", Font.BOLD, 10));
		list.setBackground(Color.PINK);
		list.setForeground(Color.BLACK);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"BharatBiotech", "VectorInstitue", "Novavax", "Sinopharm", "Johnson&Johnson", "CanSino", "Moderna", "Gameleya", "Oxford-AstraZeneca", "Pfizer-Biontech", "Sinopharm-Wuhan", "Sinovac"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setToolTipText("");
		contentPane.add(list);
		
		JButton btnNewButton = new JButton("Pick Vaccine");
		btnNewButton.setBounds(520, 336, 208, 65);
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String vaccineN = (String) list.getSelectedValue();
				Connection connection = null;
				Statement statemnt = null;
				DatabaseEnter obj_ConnectDB = new DatabaseEnter();
				connection = obj_ConnectDB.get_connection();
				try {
					String query = "update patient set vaccinename = '"+vaccineN+"' where username = '"+LoginDesign.kullaniciadi+"'";
					statemnt = connection.createStatement();
					statemnt.executeUpdate(query);
					System.out.println("Value inserted succefully!");
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				Hospital h = new Hospital();
				h.setVisible(true);
				h.setSize(450,300);
				h.setTitle("Hospital Page");
				h.setResizable(false);
			}
		});
		contentPane.add(btnNewButton);
		
		
		//==========
		
		JButton btnNewButton_1 = new JButton(" Country");
		btnNewButton_1.setBackground(Color.ORANGE);
		btnNewButton_1.setBounds(10, 146, 216, 65);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VaccineCountry vc = new VaccineCountry();
				vc.setVisible(true);
				vc.setSize(500,300);
				vc.setTitle("Vaccine Country Page");
				vc.setResizable(false);
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Technology");
		btnNewButton_2.setBackground(Color.ORANGE);
		btnNewButton_2.setBounds(10, 71, 216, 65);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VaccineTechnology vt = new VaccineTechnology();
				vt.setVisible(true);
				vt.setSize(500,300);
				vt.setTitle("Vaccine Technology Page");
				vt.setResizable(false);
				
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(btnNewButton_2);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 10));
		table.setBackground(Color.PINK);
		table.setBounds(236, 71, 354, 215);
		contentPane.add(table);
		
		JButton btnNewButton_3 = new JButton("Show List");
		btnNewButton_3.setBackground(Color.ORANGE);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection connection = null;
				Statement statemnt = null;
				ResultSet rs = null;
				
				DatabaseEnter obj_ConnectDB = new DatabaseEnter();
				
				connection = obj_ConnectDB.get_connection();
				try {
					String query = "select * from vaccine";
					statemnt = connection.createStatement();
					rs = statemnt.executeQuery(query);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBounds(10, 221, 216, 65);
		contentPane.add(btnNewButton_3);
		
		
		
		loadList();
	}
}
