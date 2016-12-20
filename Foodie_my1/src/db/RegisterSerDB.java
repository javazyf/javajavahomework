package db;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.sql.*;
import java.util.Date;

import db.GetConnection;

public class RegisterSerDB {
	private int root = 0;
	private int purse = 0;
	
	static Connection conn = null;
	static PreparedStatement pst = null;
	static ResultSet rs =null;
	static Statement st = null;
	
	GetConnection getconn = new GetConnection();
	
	public boolean insert(String account,long password,String name,boolean sex,String birth,String tel,String mail){
		conn = getconn.getConection();
		
		boolean panduan = false;
		try{
			String sql_check = "select user_account from homework.user";
			st = (Statement) conn.createStatement();
			rs = st.executeQuery(sql_check);
			while(rs.next()){
				if(rs.getString(1).equals(account)){
					System.out.println("your account is wright");
				}else{
					System.out.println("your account is used");
				}
			}
			String sql_id = "select user_id from homework.user";
			rs = st.executeQuery(sql_id);
			int i = 1;
			while(rs.next()){
				i = i + 1;
			}
			long id_temp = 20160000 + i;
			String sql_insert = "insert into homework.user(user_id,user_account,"
					+ "user_password,user_name,user_sex,user_birth,user_tel,user_mail,user_purse,user_root) values ('"+
			id_temp+"','"+account+"','"+password+"','"+
			name+"','"+sex+"','"+birth+"','"+tel+"','"+mail+"','"+purse+"','"+root+"')";
			int count = st.executeUpdate(sql_insert);
			System.out.println("Insert " + count +" records into departments table");
			conn.close();
			panduan = true;
		}catch(SQLException e){
			System.out.println("insert record failed" + e.getMessage());
			e.printStackTrace();
			panduan = false;
		}
		return panduan;
	}
}
