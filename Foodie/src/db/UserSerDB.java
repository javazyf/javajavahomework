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
	
	//获取用户所有信息
	public ArrayList getinfo(long user_id){//获取用户所有信息，储存顺序，用户id，账号，密码，姓名，性别，生日，电话，邮箱
		//钱包，权限
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
	
	//根据用户id，返回我发的帖子的id
	public ArrayList getpostid(long user_id){//输入用户id，返回用户发帖的id
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
	
	//查询购买的帖子的id
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
	
	//关注相关方法
	public boolean follow(long user_id1,long user_id2){//关注，1为关注人，2为被关注人，1为pk
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
	
	public boolean delfollow(long user_id1,long user_id2){//取关，1为关注人，1为pk
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
	
	public long search_fans(long user_id){//被关注的人查询被关注的数量
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
	
	public ArrayList search_fan_id(long user_id){//被关注的人查询被关注的人
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
	
	public long search_follow(long user_id){//关注着查询关注数量
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
	
	public ArrayList search_follow_id(long user_id){//关注的人查询被关注的人
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
	
	//查看用户收藏的帖子
	public ArrayList search_collection_id(long user_id){//收藏帖子id
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
	
	//签到   加1金币
	public boolean qiandao(long user_id){//签到
		conn = getconn.getConection();
		boolean panduan = false;
		boolean qiandao = false;
		int charge = 0;
		
		try{
			String sql_query = "select user_purse from homework.user where user_id="+user_id;
			st = (Statement) conn.createStatement();
			rs = st.executeQuery(sql_query);
			while(rs.next()){
				charge = rs.getInt(1) + 1;
			}
			String sql_update = "update homewor.user set user_purse="+charge+" where user_id="+user_id;
			st = (Statement) conn.createStatement();
			int rst = st.executeUpdate(sql_update);
			qiandao = true;
			String sql_qiandao = "update homework.user set user_qiandao="+qiandao;
			int x = st.executeUpdate(sql_qiandao);
			conn.close();
			panduan = true;
		}catch(SQLException e){
			System.out.println("SQLquery fail");
			e.printStackTrace();
			panduan = false;
		}
		return panduan;
	}
	public boolean qiandaorefresh(long user_id){	//qiandao refresh
		conn = getconn.getConection();
		boolean panduan = false;
		boolean qiandao = false;
		int charge = 0;
		
		try{
			String sql_update = "update homework.user set user_qiandao="+qiandao;
			st = (Statement) conn.createStatement();
			int x = st.executeUpdate(sql_update);
			conn.close();
			panduan = true;
		}catch(SQLException e){
			System.out.println("SQLquery fail");
			e.printStackTrace();
			panduan = false;
		}
		return panduan;
	}
	
	//充值相关
	public boolean recharge(long user_id,int chargenum){//输入用户和充值金额
		conn = getconn.getConection();
		int charge = 0;
		boolean panduan = false;
		
		try{
			//充值后用户钱包金额的改变
			String sql_query = "select user_purse from homework.user where user_id="+user_id;
			st = (Statement) conn.createStatement();
			rs = st.executeQuery(sql_query);
			while(rs.next()){
				charge = rs.getInt(1)+chargenum;
			}
			String sql_update = "update homework.user set user_purse="+charge+" where user_id="+user_id;
			st = (Statement) conn.createStatement();
			int rst = st.executeUpdate(sql_update);
			//新建用户充值交易记录表格
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
	
	public boolean changeroot(long user_id,int rootchangeto){//输入用户和改编后的权限
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
