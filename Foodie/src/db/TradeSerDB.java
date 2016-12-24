package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import db.*;

public class TradeSerDB {
	static Connection conn = null;
	static PreparedStatement pst = null;
	static ResultSet rs =null;
	static Statement st = null;
	
	GetConnection getconn = new GetConnection();
	
	public ArrayList search_recharge_chargenum(long user_id){//���س�ֵ��ȣ���.get(i) �е�iƥ��ͬ��
		conn = getconn.getConection();
		ArrayList chargenum = new ArrayList();
//		ArrayList date = new ArrayList();
		
		try{
			String sql_search = "select * from homework.recharge where user_id="+user_id;
			st = (Statement) conn.createStatement();
			rs = st.executeQuery(sql_search);
			while(rs.next()){
				chargenum.add(rs.getInt(2));
//				date.add(rs.getString(3));
			}
			conn.close();
		}catch(SQLException e){
			System.out.println("SQLquery fail");
			e.printStackTrace();
		}
		return chargenum;
	}
	
	public ArrayList search_recharge_date(long user_id){//���س�ֵʱ��
		conn = getconn.getConection();
//		ArrayList chargenum = new ArrayList();
		ArrayList date = new ArrayList();
		
		try{
			String sql_search = "select * from homework.recharge where user_id="+user_id;
			st = (Statement) conn.createStatement();
			rs = st.executeQuery(sql_search);
			while(rs.next()){
//				chargenum.add(rs.getInt(2));
				date.add(rs.getString(3));
			}
			conn.close();
		}catch(SQLException e){
			System.out.println("SQLquery fail");
			e.printStackTrace();
		}
		return date;
	}
	
	public ArrayList search_buy_post_id(long user_id){//���ع������ӵ�id
		conn = getconn.getConection();
		ArrayList post_id = new ArrayList();
		
		try{
			String sql_search = "select post_id from homework.buy where user_id="+user_id;
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
	
	public ArrayList search_buy_post_price(long user_id){//���ع���۸�
		conn = getconn.getConection();
		ArrayList post_price = new ArrayList();
		
		try{
			String sql_search = "select post_price from homework.buy where user_id="+user_id;
			st = (Statement) conn.createStatement();
			rs = st.executeQuery(sql_search);
			while(rs.next()){
				post_price.add(rs.getInt(1));
			}
			conn.close();
		}catch(SQLException e){
			System.out.println("SQLquery fail");
			e.printStackTrace();
		}
		return post_price;
	}
	
	public ArrayList search_buy_post_date(long user_id){//���ع���ʱ��
		conn = getconn.getConection();
		ArrayList post_date = new ArrayList();
		
		try{
			String sql_search = "select post_date from homework.buy where user_id="+user_id;
			st = (Statement) conn.createStatement();
			rs = st.executeQuery(sql_search);
			while(rs.next()){
				post_date.add(rs.getString(1));
//				date.add(rs.getString(3));
			}
			conn.close();
		}catch(SQLException e){
			System.out.println("SQLquery fail");
			e.printStackTrace();
		}
		return post_date;
	}
	
}
