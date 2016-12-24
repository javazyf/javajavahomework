package db;

import com.mysql.jdbc.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.*;

import db.GetConnection;

public class UserSerDB {
	static Connection conn = null;
	static PreparedStatement pst = null;
	static ResultSet rs =null;
	static Statement st = null;
	
	GetConnection getconn = new GetConnection();
	
	//��ȡ�û�������Ϣ
	public ArrayList getinfo(long user_id){//��ȡ�û�������Ϣ������˳���û�id���˺ţ����룬�������Ա����գ��绰������
		//Ǯ����Ȩ��
		conn = getconn.getConection();
		ArrayList info = new ArrayList();
		
		try{
			String sql_search = "select * from homework.user where user_id="+user_id;
			st = (Statement) conn.createStatement();
			rs = st.executeQuery(sql_search);
			int i = 0;
			while(rs.next()){
				while(i<=9){
				info.add(rs.getString(i+1));
				i = i + 1;
				}
			}
			conn.close();
		}catch(SQLException e){
			System.out.println("SQLquery fail");
			e.printStackTrace();
		}
		return info;
	}
	public long getuserid(String account){
		conn = getconn.getConection();
		long user_id = 2016001;
		
		try{
			String sql_search = "select user_id from homework.user where user_account="+account;
			st = (Statement) conn.createStatement();
			rs = st.executeQuery(sql_search);
			while(rs.next()){
				user_id = rs.getLong(1);
			}
			conn.close();
		}catch(SQLException e){
			System.out.println("SQLquery fail");
			e.printStackTrace();
		}
		return user_id;
	}
	
	//�����û�id�������ҷ������ӵ�id
	public ArrayList getpostid(long user_id){//�����û�id�������û�������id
		conn = getconn.getConection();
		ArrayList post_id = new ArrayList();
		
		try{
			String sql_search = "select post_id from homework.post where post_writerid="+user_id;
			st = (Statement) conn.createStatement();
			rs = st.executeQuery(sql_search);
			while(rs.next()){
				post_id.add(rs.getString(1));
			}
			conn.close();
		}catch(SQLException e){
			System.out.println("SQLquery fail");
			e.printStackTrace();
		}
		return post_id;
	}
	
	//��ѯ��������ӵ�id
	public ArrayList search_buyid(long user_id){
		conn = getconn.getConection();
		ArrayList buyid = new ArrayList();
		
		try{
			String sql_search = "select post_id from homework.buy where user_id="+user_id;
			st = (Statement) conn.createStatement();
			rs = st.executeQuery(sql_search);
			while(rs.next()){
				buyid.add(rs.getLong(1));
			}
			conn.close();
		}catch(SQLException e){
			System.out.println("SQLquery fail");
			e.printStackTrace();
		}
		return buyid;
	}
	
	//��ע��ط���
	public boolean follow(long user_id1,long user_id2){//��ע��1Ϊ��ע�ˣ�2Ϊ����ע�ˣ�1Ϊpk
		conn = getconn.getConection();
		
		boolean panduan = false;
		try{
			String sql_insert = "insert into homework.follow(user_id1,user_id2) values ('"+user_id1+"','"+user_id2+"')";
			st = (Statement) conn.createStatement();
			int x= st.executeUpdate(sql_insert);
			conn.close();
			panduan = true;
		}catch(SQLException e){
			System.out.println("SQLquery fail");
			e.printStackTrace();
			panduan = false;
		}
		return panduan;
	}
	
	public boolean delfollow(long user_id1,long user_id2){//ȡ�أ�1Ϊ��ע�ˣ�1Ϊpk
		conn = getconn.getConection();
		
		boolean panduan = false;
		try{
			String sql_delect = "delete from homework.follow where(user_id1="+user_id1+"and user_id2="+user_id2+")";
			st = (Statement) conn.createStatement();
			int x = st.executeUpdate(sql_delect);
			conn.close();
			panduan = true;
		}catch(SQLException e){
			System.out.println("SQLquery fail");
			e.printStackTrace();
			panduan = false;
		}
		return panduan;
	}
	
	public long search_fans(long user_id){//����ע���˲�ѯ����ע������
		conn = getconn.getConection();
		long num = 0;
		
		try{
			String sql_search = "select * from homework.follow where user_id2="+user_id;
			st = (Statement) conn.createStatement();
			rs = st.executeQuery(sql_search);
			while(rs.next()){
				num = num + 1;
			}
			conn.close();
		}catch(SQLException e){
			System.out.println("SQLquery fail");
			e.printStackTrace();
		}
		return num;
	}
	
	public ArrayList search_fan_id(long user_id){//����ע���˲�ѯ����ע����
		conn = getconn.getConection();
		ArrayList fans = new ArrayList();
		
		try{
			String sql_search = "select user_id1 from homework.follow where user_id2="+user_id;
			st = (Statement) conn.createStatement();
			rs = st.executeQuery(sql_search);
			while(rs.next()){
				fans.add(rs.getLong(1));
			}
			conn.close();
		}catch(SQLException e){
			System.out.println("SQLquery fail");
			e.printStackTrace();
		}
		return fans;
	}
	
	public long search_follow(long user_id){//��ע�Ų�ѯ��ע����
		conn = getconn.getConection();
		long num = 0;
		
		try{
			String sql_search = "select * from homework.follow where user_id1="+user_id;
			st = (Statement) conn.createStatement();
			rs = st.executeQuery(sql_search);
			while(rs.next()){
				num = num + 1;
			}conn.close();
		}catch(SQLException e){
			System.out.println("SQLquery fail");
			e.printStackTrace();
		}
		return num;
	}
	
	public ArrayList search_follow_id(long user_id){//��ע���˲�ѯ����ע����
		conn = getconn.getConection();
		ArrayList follow = new ArrayList();
		
		try{
			String sql_search = "select user_id2 from homework.follow where user_id1="+user_id;
			st = (Statement) conn.createStatement();
			rs = st.executeQuery(sql_search);
			while(rs.next()){
				follow.add(rs.getLong(1));
			}
			conn.close();
		}catch(SQLException e){
			System.out.println("SQLquery fail");
			e.printStackTrace();
		}
		return follow;
	}
	
	//�鿴�û��ղص�����
	public ArrayList search_collection_id(long user_id){//�ղ�����id
		conn = getconn.getConection();
		ArrayList collect = new ArrayList();

		try{
			String sql_search = "select post_id from homework.collection where user_id="+user_id;
			st = (Statement) conn.createStatement();
			rs = st.executeQuery(sql_search);
			while(rs.next()){
				collect.add(rs.getLong(1));
			}
			conn.close();
		}catch(SQLException e){
			System.out.println("SQLquery fail");
			e.printStackTrace();
		}
		return collect;
	}
	
	//ǩ��   ��1���
	public boolean qiandao(long user_id){//ǩ��
		conn = getconn.getConection();
		boolean panduan = false;
		int charge = 0;
		
		try{
			String sql_query = "select user_purse from homework.user where user_id="+user_id;
			st = (Statement) conn.createStatement();
			rs = st.executeQuery(sql_query);
			while(rs.next()){
				charge = rs.getInt(1) + 1;
			}
			String sql_update = "update user set user_purse="+charge+" where user_id="+user_id;
			st = (Statement) conn.createStatement();
			int rst = st.executeUpdate(sql_update);
			conn.close();
			panduan = true;
		}catch(SQLException e){
			System.out.println("SQLquery fail");
			e.printStackTrace();
			panduan = false;
		}
		return panduan;
	}
	
	//��ֵ���
	public boolean recharge(long user_id,int chargenum){//�����û��ͳ�ֵ���
		conn = getconn.getConection();
		int charge = 0;
		boolean panduan = false;
		
		try{
			//��ֵ���û�Ǯ�����ĸı�
			String sql_query = "select user_purse from homework.user where user_id="+user_id;
			st = (Statement) conn.createStatement();
			rs = st.executeQuery(sql_query);
			while(rs.next()){
				charge = rs.getInt(1)+chargenum;
			}
			String sql_update = "update homework.user set user_purse="+charge+" where user_id="+user_id;
			st = (Statement) conn.createStatement();
			int rst = st.executeUpdate(sql_update);
			//�½��û���ֵ���׼�¼���
			Calendar date = Calendar.getInstance();
			SimpleDateFormat da = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String sql_insert = "insert into homework.recharge(user_id,chargenum,date) values ('"+user_id+"','"+chargenum+"','"+da.format(date.getTime())+"')";
			st = (Statement) conn.createStatement();
			int rst2 = st.executeUpdate(sql_insert);
			conn.close();
			panduan = true;  
		}catch(SQLException e){
			System.out.println("SQLquery fail");
			e.printStackTrace();
			panduan = false;
		}
		return panduan;
	}
	
	public boolean changeroot(long user_id,int rootchangeto){//�����û��͸ı���Ȩ��
		conn = getconn.getConection();
		
		boolean panduan = false;
		try{
			String sql_update = "update homework.user set user_root="+rootchangeto+" where user_id="+user_id;
			st = (Statement) conn.createStatement();
			int rst = st.executeUpdate(sql_update);
			conn.close();
			panduan = true;
		}catch(SQLException e){
			System.out.println("SQLquery fail");
			e.printStackTrace();
			panduan = false;
		}
		return panduan;
	}
	

}
