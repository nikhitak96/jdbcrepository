package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertOperation {

	public static void main(String[] args) {
		
Connection connection=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_first_db", "root", "root");
			
			if(connection!=null)
			{
				System.out.println("Connected!");
			}
			else
			{
				System.out.println("Problem in database connection!");
			}
			
			PreparedStatement preparedStatement=connection.prepareStatement("insert into customer values(?,?,?,?,?)"); //?-placeholder
			preparedStatement.setInt(1, 5555);
			preparedStatement.setString(2, "Levish");
			preparedStatement.setString(3, "Hydrabad");
			preparedStatement.setString(4, "lavish@abc");
			preparedStatement.setLong(5, 9878675698L);
			
			if(preparedStatement.executeUpdate()>0)
			{
				System.out.println("Record Inserted!");
			}
			else
			{
				System.out.println("Problem in isert operation!");
			}
		
		
		}	

			catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}

	}

}
