package com.jinujawad.com;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;
import com.toedter.components.JLocaleChooser;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class Tarih extends JFrame {
	private JTextField textField;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tarih frame = new Tarih();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tarih() {
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDateChooser dateChooser = new JDateChooser();
		
		dateChooser.setBounds(147, 120, 152, 45);
		contentPane.add(dateChooser);
		
		JLabel lblNewLabel = new JLabel("Choose Appointment Date");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(93, 40, 319, 27);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("! Secim Yapmadan Once Lutfen Buraya Tiklayiniz !");
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,"Asi Sectikten Bir Ay Sonra Ikinci Doz Uygulanmaktadir.");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.setBounds(60, 77, 319, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Pick Appointmentdate");
		btnNewButton_1.setBackground(Color.ORANGE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//***********
				String secilengun = ((JTextField)((JDateChooser) dateChooser).getDateEditor().getUiComponent()).getText();
				System.out.println(secilengun);
			
				//-----
				Connection connection = null;
				Statement statemnt = null;
				ResultSet rs = null;
				DatabaseEnter obj_ConnectDB = new DatabaseEnter();
				connection = obj_ConnectDB.get_connection();
				try {
					String query = "select count(*) as enter from patient where appointmentdate = '"+secilengun+"'";
					statemnt = connection.createStatement();
					rs = statemnt.executeQuery(query);
					while(rs.next()){
						if(rs.getInt("enter")<10) {
							JOptionPane.showMessageDialog(null,"Uygun Gun Secildi");
							String query1 = "update patient set appointmentdate = '"+secilengun+"'where username = '"+LoginDesign.kullaniciadi+"'";
							statemnt = connection.createStatement();
							statemnt.executeUpdate(query1);
						
							JOptionPane.showMessageDialog(null,"Tabloya Ekleme Islemi Basariyla Gerceklesti");
						
							
						}
						else if(rs.getInt("enter")<10)
						{
							String query2 = "select * from patient where appointmentdate IN (select p1.appointmentdate from patient p1 where p1.appointmentdate ='"+secilengun+"'";
							statemnt = connection.createStatement();
							statemnt.executeUpdate(query2);
							JOptionPane.showMessageDialog(null,"Gun Secimi Tamamlanamadi");

						}
						else if(rs.getInt("enter")>=10)
						{
							JOptionPane.showMessageDialog(null,"Gun Secimi Tamamlanamadi");

						}
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			
			}
		});
		btnNewButton_1.setBounds(147, 188, 152, 21);
		contentPane.add(btnNewButton_1);
		
	
	
		
	}
}
