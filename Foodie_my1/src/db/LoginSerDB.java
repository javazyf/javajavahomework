package db;

import java.sql.*;
import com.mysql.jdbc.Statement;
import db.GetConnection;

public class LoginSerDB {
	static Connection conn = null;
	static PreparedStatement pst = null;
	static ResultSet rs =null;
	
	public boolean check(String account,long password){
		GetConnection getconn = new GetConnection();
		conn = getconn.getConection();
		boolean panduan = false;
		
		try{
			String sql = "select user_password from homework.user where user_account="+account;
			Statement statement = (Statement)conn.createStatement();
			rs = statement.executeQuery(sql);
			long rs_password = 0;
			while(rs.next()){
				rs_password = rs.getLong(1);
			}
			if((rs_password != 0)&(rs_password==password)){
				System.out.println("your account is right");
				panduan = true;
			}else{
				System.out.println("your account is error");
				panduan = false;
			}
			conn.close();
		}catch(SQLException e){
			System.out.println("SQLquery fail");
			e.printStackTrace();
			panduan = false;
		}
		return panduan;
	}
	
}
