package com.jsp.jdbc_preparedstatement_crud.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductDeleteController {

	public static void main(String[] args) {
		Connection connection = null;

		try {
			// step-1 load/Register Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// step-2 create connection
			
			String url = "jdbc:mysql://localhost:3306/jdbc-preparedstatement";
			String user = "root";
			String pass = "Root";
			
			connection=DriverManager.getConnection(url, user, pass);
			
			//step-3 create statement 
			String deletQuery = "delete from product where productid=?";
			
			PreparedStatement preparedStatement=connection.prepareStatement(deletQuery);
			
			preparedStatement.setInt(1, 100);
			
			int a=preparedStatement.executeUpdate();
			
			if(a==1) {
				System.out.println("Data is deleted");
			}else {
				System.err.println("given id is not present");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
