package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {
	public Connection getConection(){
		String url="jdbc:mysql://localhost:3306/homework?useUnicode=true&characterEncoding=utf-8&useSSL=false&user=root&password=123456";
		
		Connection c = null;
		
		try{
			Class.forName("org.gjt.mm.mysql.Driver");
			c = DriverManager.getConnection(url);
			System.out.println("Connect Successfully");
		}
		catch(ClassNotFoundException cnfex){
			System.out.println("Fail to load JDBC driver");
			cnfex.printStackTrace();
			System.exit(1);
		}catch(SQLException sqle){
			System.out.println("Unable to connect");
			sqle.printStackTrace();
			System.exit(1);
		}
		return c;
	}
}
