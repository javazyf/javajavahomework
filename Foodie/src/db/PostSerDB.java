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

public class PostSerDB {
	static Connection conn = null;
	static PreparedStatement pst = null;
	static ResultSet rs =null;
	static Statement st = null;
	
	GetConnection getconn = new GetConnection();
	
	//发帖相关的所有方法
	//插入发帖最原始，分配id
	public long post(){//给用户分配ID,返回id
		conn = getconn.getConection();
		long post_id = 1;
		long writerid = 0;
		String title = "123123";
		int tag = 1;
		int visible = 0;
		int price = 0;
		
		try{
			String sql_query = "select post_id from homework.post";
			st = (Statement) conn.createStatement();
			rs = st.executeQuery(sql_query);
			while(rs.next()){
			post_id = post_id +1;
			}
			String sql_insert = "insert into homework.post(post_id,post_writerid,post_title,post_tag1,post_visible,post_price) values ('"+post_id+"','"+writerid+"','"+title+"','"+tag+"','"+visible+"','"+price+"')";
			st.executeUpdate(sql_insert);
			conn.close();
		}catch(SQLException e){
			System.out.println("SQLquery fail");
			e.printStackTrace();
		}
		return post_id;
	}
	
	//插入发帖的一些相关信息，tag title  time等
	public boolean post_head(long post_id,long post_writerid,String post_title,int post_tag1,int post_tag2,int post_tag3,int post_price,int post_visible){//开始插入标题，tag，visible，price   检查返回值是不是为真   记录发帖时间
		conn = getconn.getConection();
		Calendar post_date;
		int x = 0;
		boolean panduan = false;
		
		try{
			post_date = Calendar.getInstance();
			SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String sql_update = "update homework.post set post_writerid=? and post_title=? and post_tag1=? and post_tag2=? and post_tag3=? "
			+ "and post_visible=? and post_price=? and post_date=? where post_id=?";
			pst =(PreparedStatement) conn.prepareStatement(sql_update);
			pst.setLong(1, post_writerid);
			pst.setString(2, post_title);
			pst.setInt(3,post_tag1);
			pst.setFloat(4, post_tag2);
			pst.setInt(5, post_tag3);
			pst.setInt(6, post_visible);
			pst.setInt(7, post_price);
			pst.setString(8,date.format(post_date.getTime()));
			pst.setLong(9, post_id);
			x = pst.executeUpdate();	
			conn.close();
			panduan = true;
		}catch(SQLException e){
			System.out.println("SQLquery fail");
			e.printStackTrace();
			panduan = false;
		}
		return panduan;
	}
	//具体插入每一步骤对应的数据
	public boolean post_progress(long post_id,int progress,String txt,String impage){//post_id,步骤，content，impage   检查返回值是不是为真
		conn = getconn.getConection();
		int x = 0;
		boolean panduan = false;
		
		try{
			String sql_update = "update homework.post set post_txt?=?, post_impage?=? where post_id=?";
			pst = (PreparedStatement) conn.prepareStatement(sql_update);
			pst.setInt(1, progress);
			pst.setString(2, txt);
			pst.setInt(3, progress);
			pst.setString(4, impage);
			pst.setLong(5, post_id);
			x = pst.executeUpdate();
			conn.close();
			panduan = true;
		}catch(SQLException e){
			System.out.println("SQLquery fail");
			e.printStackTrace();
			panduan = false;
		}
		return panduan;
	}
	
	//删除帖子
	public boolean delpost(long post_id){//删除帖子
		conn = getconn.getConection();
		boolean panduan = false;
		int count = 0;
		
		try{
			String sql_delect = "delete from homework.post where post_id="+post_id;
			st = (Statement) conn.createStatement();
			int x = st.executeUpdate(sql_delect);
			String sql_search = "select * from homework.post";
			rs = st.executeQuery(sql_search);
			while(rs.next()){
				count = count + 1;
				String sql_update = "update homework.post set post_id="+count;
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
	
	//买卖双方建标
	public boolean buy(long user_id,long post_id,int price){//为买方，帖子id，价格
		conn = getconn.getConection();
		boolean panduan = false;	
		int service = 1;//1是购买
		
		try{
				int charge1 = 0;
				String sql_query = "select user_purse from homework.user where user_id="+user_id;
			st = (Statement) conn.createStatement();
			rs = st.executeQuery(sql_query);
			while(rs.next()){
				charge1 = rs.getInt(1)-price;
			}
			String sql_update = "update homework.user set user_purse="+charge1+" where user_id="+user_id;
			st = (Statement) conn.createStatement();
			int rst = st.executeUpdate(sql_update);
			
			Calendar date = Calendar.getInstance();
			SimpleDateFormat da = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String sql_insert = "insert into homework.buy(user_id,post_id,post_price,post_date,service) values ('"+user_id+"','"+post_id+"','"+price+"','"+da.format(date.getTime())+"','"+service+"')";
			st = (Statement) conn.createStatement();
			int rst3 = st.executeUpdate(sql_insert);
			conn.close();
			panduan = true;
		}catch(SQLException e){
			System.out.println("SQLquery fail");
			e.printStackTrace();
			panduan = false;
		}
		return panduan;
	}
	//打赏业务
	public boolean give(long user_id,long post_id,int price){//为买方，帖子id，价格
		conn = getconn.getConection();
		boolean panduan = false;	
		int service = 0;//1是购买
		
		try{
				int charge1 = 0;
				String sql_query = "select user_purse from homework.user where user_id="+user_id;
			st = (Statement) conn.createStatement();
			rs = st.executeQuery(sql_query);
			while(rs.next()){
				charge1 = rs.getInt(1)-price;
			}
			String sql_update = "update homework.user set user_purse="+charge1+" where user_id="+user_id;
			st = (Statement) conn.createStatement();
			int rst = st.executeUpdate(sql_update);
			
			Calendar date = Calendar.getInstance();
			SimpleDateFormat da = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String sql_insert = "insert into homework.buy(user_id,post_id,post_price,date,service) values ('"+user_id+"','"+post_id+"','"+price+"','"+da.format(date.getTime())+"','"+service+"')";
			st = (Statement) conn.createStatement();
			int rst3 = st.executeUpdate(sql_insert);
			conn.close();
			panduan = true;
		}catch(SQLException e){
			System.out.println("SQLquery fail");
			e.printStackTrace();
			panduan = false;
		}
		return panduan;
	}
	
	//收藏的相关方法    添加，数量，删除
	public long search_collections(long user_id){//收藏数量
		conn = getconn.getConection();
		long num = 0;
		
		try{
			String sql_search = "select from homework.collection where user_id="+user_id;
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
	
	public boolean collection(long user_id,long post_id){//收藏帖子，两者id
		conn = getconn.getConection();
		boolean panduan = false;
		
		try{
			String sql_insert = "insert into homework.collection(user_id,post_id) values ('"+user_id+"','"+post_id+"')";
			st = (Statement) conn.createStatement();
			int x = st.executeUpdate(sql_insert);
			conn.close();
			panduan = true;
		}catch(SQLException e){
			System.out.println("SQLquery fail");
			e.printStackTrace();
			panduan =false;
		}
		return panduan;
	}
	
	public boolean delcollection(long user_id,long post_id){//删除收藏，针对某个用户删除收藏
		conn = getconn.getConection();
		boolean panduan = false;
		int count = 0;
		
		try{
			String sql_delect = "delete from homework.collection where(user_id="+user_id+" and post_id="+post_id+")";
			st = (Statement) conn.createStatement();
			int x = st.executeUpdate(sql_delect);
			conn.close();
			panduan = true;
		}catch(SQLException e){
			System.out.println("SQLquery fail");
			e.printStackTrace();
			panduan =false;
		}
		return panduan;
	}
	
	//外部获取所有信息
	public ArrayList getpost_id(long user_id){//获取帖子的tag,数组[0]为tag1，以此类推
		conn = getconn.getConection();
		ArrayList post_id = new ArrayList();
		
		try{
			String sql_search = "select post_id from homework.post where post_writerid="+user_id;
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
	public int[] gettag(long post_id){//获取帖子的tag,数组[0]为tag1，以此类推
		conn = getconn.getConection();
		int post_tag[] = new int[3];
		
		try{
			String sql_search = "select * from homework.post where post_id="+post_id;
			st = (Statement) conn.createStatement();
			rs = st.executeQuery(sql_search);
			while(rs.next()){
				post_tag[0] = rs.getInt(4);
				post_tag[1] = rs.getInt(5);
				post_tag[2] = rs.getInt(6);
			}
			conn.close();
		}catch(SQLException e){
			System.out.println("SQLquery fail");
			e.printStackTrace();
		}
		return post_tag;
	}
	public int getprice(long post_id){//外部获取帖子价格
		conn = getconn.getConection();
		int post_price = 0;
		
		try{
			String sql_search = "select post_price from homework.post where post_id="+post_id;
			st = (Statement) conn.createStatement();
			rs = st.executeQuery(sql_search);
			while(rs.next()){
				post_price = rs.getInt(1);
			}
			conn.close();
		}catch(SQLException e){
			System.out.println("SQLquery fail");
			e.printStackTrace();
		}
		return post_price;
	}
	public long getwriterid(long post_id){//外部回去帖子书写人的id，返回id
		conn = getconn.getConection();
		long writerid = 0;
		
		try{
			String sql_search = "select post_writerid from homework.post where post_id="+post_id;
			st = (Statement)conn.createStatement();
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
	public String gettxt(long post_id,int progress){//外部获取帖子内容, id 第几步
		conn = getconn.getConection();
		String txt = null;
		
		try{
			String sql_search = "select post_txt"+progress+"\\s from homework.post where post_id="+post_id;
			Statement statement = (Statement)conn.createStatement();
			st = (Statement) conn.createStatement();
			rs = st.executeQuery(sql_search);
			while(rs.next()){
				txt = rs.getString(0);
			}
			conn.close();
		}catch(SQLException e){
			System.out.println("SQLquery fail");
			e.printStackTrace();
		}
		return txt;
	}
	
	public String getimage(long post_id,int progress){//外部获取帖子图片, id 第几步
		conn = getconn.getConection();
		String txt = null;
		
		try{
			String sql_search = "select post_image"+progress+"\\s from homework.post where post_id="+post_id;
			Statement statement = (Statement)conn.createStatement();
			st = (Statement) conn.createStatement();
			rs = st.executeQuery(sql_search);
			while(rs.next()){
				txt = rs.getString(0);
			}
			conn.close();
		}catch(SQLException e){
			System.out.println("SQLquery fail");
			e.printStackTrace();
		}
		return txt;
	}
	
	public String gettitle(long post_id){//外部获取帖子标题
		conn = getconn.getConection();
		String post_title = null;
		
		try{
			String sql_search = "select post_title from homework.post where post_id="+post_id;
			st = (Statement) conn.createStatement();
			rs = st.executeQuery(sql_search);
			while(rs.next()){
				post_title = rs.getString(1);
			}
			conn.close();
		}catch(SQLException e){
			System.out.println("SQLquery fail");
			e.printStackTrace();
		}
		return post_title;
	}

	//点赞相关的方法
	public boolean dianzan(long post_id){//点赞，输入id,返回为真成功
		conn = getconn.getConection();
		int zan = 0;
		int x = 0;
		boolean panduan = false;
		try{
			String sql_search = "select post_zan from homework.post where post_id="+post_id;
			st = (Statement)conn.createStatement();
			rs =st.executeQuery(sql_search); 
			while(rs.next()){
				zan = rs.getInt(1);
			}
			int zan2 = zan + 1;
			String sql_update = "update homework.post set post_zan="+zan2+"\\s where post_id="+post_id;
			st = (Statement)conn.createStatement();
			x = st.executeUpdate(sql_update);
			conn.close();
			panduan = true;
		}catch(SQLException e){
			System.out.println("SQLquery fail");
			e.printStackTrace();
			panduan = false;
		}
		return panduan;
	}
	
	public int post_zannum(long post_id){//统计点赞数
		conn = getconn.getConection();
		int zan = 0;
		try{
			String sql_search = "select post_zan from homework.post where post_id="+post_id;
			st = (Statement)conn.createStatement();
			rs =st.executeQuery(sql_search); 
			while(rs.next()){
				zan = zan + 1;
			}
			conn.close();
		}catch(SQLException e){
			System.out.println("SQLquery fail");
			e.printStackTrace();
		}
		return zan;
	}
	
	public static void main(String[] args){
		PostSerDB p = new PostSerDB();
		p.delpost(1);
	}
}
