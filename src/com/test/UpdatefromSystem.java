package com.test;




	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	public class UpdatefromSystem {

	    public static void main(String[] args) {
	        Connection connection=null;
	        try
	        {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_first_db", "root", "root");
	            if(connection!=null)
	            {
	                System.out.println("Conneted!!");
	            }
	            else
	            {
	                System.out.println("Problem in database connection!!");
	            }
	            
	            PreparedStatement preparedStatement=connection.prepareStatement("update customer set cname=?, caddress=?,email=?,phone=? where cid=?");
	            preparedStatement.setString(1, "Kiran");
	            preparedStatement.setString(2, "Delhi");
	            preparedStatement.setString(3, "kiran@abc.com");
	            preparedStatement.setLong(4, 377938793);
	            preparedStatement.setInt(5, 5353);
	            
	            
	            if(preparedStatement.executeUpdate()>0)
	            {
	                System.out.println("Record updated!!");
	                
	                preparedStatement=connection.prepareStatement("select * from customer where cid=?");
	                preparedStatement.setInt(1, 5353);
	                ResultSet resultSet=preparedStatement.executeQuery();
	                
	                while(resultSet.next())
	                {
	                    System.out.println(resultSet.getInt(1)+ " "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4)+" "+resultSet.getLong(5));

	                }
	                
	            }
	            else
	            {
	                System.out.println("Problem in update operation!!");
	            }
	        } 
	        
	        catch (ClassNotFoundException e) {
	            
	            e.printStackTrace();
	        }
	        catch (SQLException e) {
	            
	            e.printStackTrace();
	        }

	    }

	}


