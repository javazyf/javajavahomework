package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {
	public Connection getConection(){
		String url="jdbc:mysql://localhost:3306/homework?useUnicode=true&characterEncoding=utf-8&useSSL=false&user=root&password=1234";
		
		Connection c = null;
		
		try{
			Class.forName("org.gjt.mm.mysql.Driver");
			c = DriverManager.getConnection(url);
		}
		catch(ClassNotFoundException cnfex){
			System.out.println("Fail to load JDBC driver");
			cnfex.printStackTrace();
			System.exit(1);
		}catch(SQLException sqle){
			sqle.printStackTrace();
			System.exit(1);
		}
		return c;
	}
}
