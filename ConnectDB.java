package com.jinujawad.com;
import javax.swing.*;


import java.sql.DriverManager;
import java.sql.Connection;
public class ConnectDB {
	public static void main(String[] args) {
		
			Connection connection = null;

			try {
				
				Class.forName("org.postgresql.Driver");
				connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/BIL344HOMEWORK-2","postgres","1234");
				if(connection != null) {
					JOptionPane.showMessageDialog(null,"Connection OK");
				}
				else {
					JOptionPane.showMessageDialog(null,"Connection FAILD");			
					}
				
				
			}catch(Exception e) {
				System.out.println(e);
			}
		}

	
}
		

