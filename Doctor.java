package com.jinujawad.com;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Doctor extends JFrame {
	private JList list;
	private JPanel contentPane;
	


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Doctor frame = new Doctor();
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
			String query = "select * from doctor where hospitalname = '"+Hospital.hastahaneadi +"'";
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
	public Doctor() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 938, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Choosen Doctors and Doctors Information");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(240, 10, 428, 30);
		contentPane.add(lblNewLabel);
		
		list = new JList();
		list.setFont(new Font("Tahoma", Font.PLAIN, 15));
		list.setBackground(Color.PINK);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(10, 70, 167, 145);
		contentPane.add(list);
		
		JLabel lblNewLabel_1 = new JLabel("All Doctors");
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setBackground(Color.ORANGE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1.setBounds(206, 50, 69, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("All Info");
		lblNewLabel_2.setForeground(Color.ORANGE);
		lblNewLabel_2.setBackground(Color.ORANGE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_2.setBounds(334, 50, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JList list_1 = new JList();
		list_1.setBackground(Color.LIGHT_GRAY);
		list_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		list_1.setModel(new AbstractListModel() {
			String[] values = new String[] {"Ahmet", "Mehmet", "Arda", "Yagiz", "Kayra"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list_1.setBounds(183, 67, 101, 145);
		contentPane.add(list_1);
		
		JLabel lblNewLabel_3 = new JLabel("Choosen Doctors");
		lblNewLabel_3.setForeground(Color.ORANGE);
		lblNewLabel_3.setBackground(Color.ORANGE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_3.setBounds(60, 50, 88, 13);
		contentPane.add(lblNewLabel_3);
		
		JTextArea txtrUsernameHosptalnamePassword = new JTextArea();
		txtrUsernameHosptalnamePassword.setBackground(Color.LIGHT_GRAY);
		txtrUsernameHosptalnamePassword.setText("USERNAME      HOSPITALNAME  PASSWORD  NAME    SURNAME\tDEPARTMENT\r\nSatanaAhmet\tBayindirHasth.\t   1234      \t Ahmet    Satana\tKulak Burun Bogaz\r\nKalayciMehmet TOBBHasth.\t   4531    \t  Mehmet   Kalayci\tPretisyen\t\t\t\t\t\r\nPekerArda\tMedicanaHasth.   6234    \t   Arda     Peker  \tPretisyen\t\t\t\r\nHititYagiz\tBayindirHasth.\t   1254     \t   Yagiz    Hitit\t\tKulak Burun Bogaz\r\nTemelliKayra\tTOBBHasth.\t   8234      \t  Kayra   Temelli\tPretisyen\t\t\t\t\t");
		txtrUsernameHosptalnamePassword.setBounds(316, 70, 598, 138);
		contentPane.add(txtrUsernameHosptalnamePassword);
		
		JButton btnNewButton = new JButton("Tarih Secmek Icin Tiklayiniz");
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Tarih t = new Tarih();
				t.setVisible(true);
				t.setSize(450,300);
				t.setTitle("Date PAGE");
				t.setResizable(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.setBounds(694, 218, 220, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Choose Doctor");
		btnNewButton_1.setBackground(Color.ORANGE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//*******************************
				String doctoradi = (String) list.getSelectedValue();
				Connection connection = null;
				Statement statemnt = null;
				ResultSet rs = null;

				DatabaseEnter obj_ConnectDB = new DatabaseEnter();
				connection = obj_ConnectDB.get_connection();
				try {
					String query = "update patient set doctorname = '"+doctoradi+"'  where username ='"+LoginDesign.kullaniciadi+"' ";
					statemnt = connection.createStatement();
					statemnt.executeUpdate(query);
					
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,"Doktor Secildi");
			}
		});
		btnNewButton_1.setBounds(10, 225, 167, 21);
		contentPane.add(btnNewButton_1);
		loadList();
	}
}
