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

public class CommentSerDB {
	private long comment_id;
	private long comment_postid;//2016000001
	private long comment_writerid;
	private String comment_txt;//1,2,3,4,
	private Calendar comment_date;
	
	static Connection conn = null;
	static PreparedStatement pst = null;
	static ResultSet rs =null;
	static Statement st = null;
	
	GetConnection getconn = new GetConnection();
	
	//添加评论
	public boolean comment(long comment_postid,long comment_writerid,String comment_txt){//评论必须全部填写
		conn = getconn.getConection();
		
		boolean panduan = false;
		try{
			String sql_query = "select comment_id from homework.comment";
			st = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs = st.executeQuery(sql_query);
			long id = 1;
			while(rs.next()){
				id = rs.getLong(1);
				System.out.println("you post_id is "+id);
			}
			id = id +1;
			//评论时间
			comment_date = Calendar.getInstance();
			SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String sql_insert = "insert into homework.comment(comment_id,comment_postid,comment_writerid,"
					+ "comment_txt,comment_date) values ('"+id+"','"+comment_postid+"','"+comment_writerid+
					"','"+comment_txt+"','"+date.format(comment_date.getTime())+"')";
			st = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			st.executeUpdate(sql_insert);
			conn.close();
			panduan = true;
		}catch(SQLException e){
			System.out.println("SQLquery fail");
			e.printStackTrace();
			panduan = false;
		}
		return panduan;
	}
	//删除评论
	public boolean delcomment(long comment_id){//删除评论
		conn = getconn.getConection();
		int count = 0;
		
		boolean panduan = false;
		try{
			String sql_del = "delete from homework.comment where comment_id="+comment_id;
			st = (Statement)conn.createStatement();
			st.executeUpdate(sql_del);
			String sql_search = "select * from homework.comment";
			rs = st.executeQuery(sql_search);
			while(rs.next()){
				count = count + 1;
				String sql_update = "update homework.comment set comment_id="+count;
				int y = st.executeUpdate(sql_update);
			}
			conn.close();
			panduan = true;
		}catch(SQLException e){
			System.out.println("SQLquery fail");
			e.printStackTrace();
			panduan = false;
		}
		return panduan;
	}
	//统计某个用户评论的数量
	public long search_comment(long user_id){//评论数量
		conn = getconn.getConection();
		long num = 0;
		
		try{
			String sql_search = "select from homework.comment where user_id="+user_id;
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
	//统计某个用户发出评论的id
	public ArrayList search_writer(long comment_writerid){//我的评论的评论ID，数组调用
		conn = getconn.getConection();
		ArrayList id = new ArrayList();
		
		try{
			String sql_search = "select comment_id from homework.comment where comment_writerid="+comment_writerid;
			st = (Statement) conn.createStatement();
			rs = st.executeQuery(sql_search);
			while(rs.next()){
				id.add(rs.getLong(1));
			}
			conn.close();
		}catch(SQLException e){
			System.out.println("SQLquery fail");
			e.printStackTrace();
		}
		return id;
	}
	//统计某个帖子中含有评论的ID
	public ArrayList search_post(long comment_postid){//帖子被评论的评论ID，数组调用
		conn = getconn.getConection();
		ArrayList id = new ArrayList();
		
		try{
			String sql_search = "select comment_id from homework.comment where comment_postid="+comment_postid;
			st = (Statement) conn.createStatement();
			rs = st.executeQuery(sql_search);
			while(rs.next()){
				id.add(rs.getLong(1));
			}
			conn.close();
		}catch(SQLException e){
			System.out.println("SQLquery fail");
			e.printStackTrace();
		}
		return id;
	}
	//获取评论
	public String getcontent(long comment_id){//外部获取评论内容
		conn = getconn.getConection();
		String txt = null;
		
		try{
			String sql_search = "select comment_txt from homework.comment where comment_id="+comment_id;
			st = (Statement) conn.createStatement();
			rs = st.executeQuery(sql_search);
			while(rs.next()){
				txt = rs.getString(1);
			}
			conn.close();
		}catch(SQLException e){
			System.out.println("SQLquery fail");
			e.printStackTrace();
		}
		return txt;
	}
	public long getwriterid(long comment_id){//通过comment_id获取评论者id
		conn = getconn.getConection();
		long writerid = 0;
		
		try{
			String sql_search = "select comment_writerid from homework.comment where comment_id="+comment_id;
			st = (Statement) conn.createStatement();
			rs = st.executeQuery(sql_search);
			while(rs.next()){
				writerid = rs.getLong(1);
			}
			conn.close();
		}catch(SQLException e){
			System.out.println("SQLquery fail");
			e.printStackTrace();
		}
		return writerid;
	}
}
