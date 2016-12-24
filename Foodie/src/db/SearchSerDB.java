package db;

import com.mysql.jdbc.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.*;
import db.GetConnection;

public class SearchSerDB {
	static Connection conn = null;
	static PreparedStatement pst = null;
	static ResultSet rs =null;
	static Statement st = null;
	
	GetConnection getconn = new GetConnection();
	
	public ArrayList search_tag(int tag){//展示用id调用外部显示
		conn = getconn.getConection();
		ArrayList post_id = new ArrayList();
		
		try{
			String sql_search = "select post_id from homework.post where post_tag1="+tag;
			st = (Statement) conn.createStatement();
			rs = st.executeQuery(sql_search);
			while(rs.next()){
				post_id.add(rs.getLong(1));
			}
			conn.close();
		}catch(SQLException e){
			System.out.println("SQLquery fail");
			e.printStackTrace();
		}
		return post_id;
	}
	
	//按照标题搜素
	public ArrayList search_title(String title,int tag){
		conn = getconn.getConection();
		ArrayList post_id = new ArrayList();
		
		try{
			String sql_search = "select post_id from homework.post where post_title like '"+title+"' and post_tag1="+tag+" order by post_date desc";
			st = (Statement)conn.createStatement();
			rs = st.executeQuery(sql_search);
			while(rs.next()){
				post_id.add(rs.getLong(1));
			}
			conn.close();
		}catch(SQLException e){
			System.out.println("SQLquery fail");
			e.printStackTrace();
		}
		return post_id;
	}

	//按照用户昵称搜索
	public ArrayList search_name(String name){
		conn = getconn.getConection();
		ArrayList user_id = new ArrayList();
		
		try{
			String sql_search = "select user_id from homework.user where user_name="+name;
			st = (Statement)conn.createStatement();
			rs = st.executeQuery(sql_search);
			while(rs.next()){
				user_id.add(rs.getLong(1));
			}
			conn.close();
		}catch(SQLException e){
			System.out.println("SQLquery fail");
			e.printStackTrace();
		}
		return user_id;
	}
	
	//区分菜谱和帖子  菜谱1，post0
	public ArrayList search_post(int price){
		conn = getconn.getConection();
		ArrayList post_id2 = new ArrayList();
		
		try{
			String sql_search;
			if(price>0){
				sql_search = "select post_id from homework.post where post_price>0 order by post_date desc";
			}else{
				sql_search = "select post_id from homework.post where post_price=0 order by post_date desc";
			}
			st = (Statement)conn.createStatement();
			rs = st.executeQuery(sql_search);
			while(rs.next()){
				post_id2.add(rs.getLong(1));
			}
			conn.close();
		}catch(SQLException e){
			System.out.println("SQLquery fail");
			e.printStackTrace();
		}
		return post_id2;
	}
}
