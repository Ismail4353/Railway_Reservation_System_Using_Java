package SmallApps;

/*this is jdbc (java data base connectivity)
 if you want to connect this database in java ,you should follow this few steps 
 1.download MySql database or any database,after downloaded MySql det username as 'root' and password as 'root'
 2.download jar file of MySql connector (search it in chrome) 
 3.create database name called 'booking' 
 4.In that database create table name called 'trains'
 5.create eight columns ,you can see the column name in Database()method line 
 6. At last copy/paste this code */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataConnect {

	public void Database(int id,String Names,int Age,String Gender,String Tname,String destination,String Seat,String status) {
		
		try {
			//load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//establish the connection
			Connection C=DriverManager.getConnection("jdbc:mysql://localhost:3306/booking","root","root");//in this line we have the url path addition of my database name,username,password
			
			//create statement
			PreparedStatement ps=C.prepareStatement("insert into trains values (?,?,?,?,?,?,?,?)");
			
			ps.setInt(1, id);
			ps.setString(2, Names);
			ps.setInt(3, Age);
			ps.setString(4, Gender);
			ps.setString(6, Tname);
			ps.setString(5, destination);
			ps.setString(7, Seat);
			ps.setString(8, status);
			
			
			//execute query
			ps.executeUpdate();
		} 
		
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
