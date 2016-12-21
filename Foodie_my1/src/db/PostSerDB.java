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
	
	//������ص����з���
	//���뷢����ԭʼ������id
	public long post(){//���û�����ID,����id
		conn = getconn.getConection();
		long post_id = 2016001;
		long writerid = 0;
		String title = "123123";
		int tag = 1;
		int visible = 0;
		
		try{
			String sql_query = "select post_id from homework.post";
			st = (Statement) conn.createStatement();
			rs = st.executeQuery(sql_query);
			while(rs.next()){
				post_id = rs.getLong(1);
				System.out.println("you post_id is "+post_id);
			}
			post_id = post_id +1;
			String sql_insert = "insert into homework.post(post_id,post_writerid,post_title,post_tag1,post_visible) values ('"+post_id+"','"+writerid+"','"+title+"','"+tag+"','"+visible+"')";
			st.executeUpdate(sql_insert);
			conn.close();
		}catch(SQLException e){
			System.out.println("SQLquery fail");
			e.printStackTrace();
		}
		return post_id;
	}
	
	//���뷢����һЩ�����Ϣ��tag title  time��
	public boolean post_head(long post_id,long post_writerid,String post_title,int post_tag1,int post_tag2,int post_tag3,int post_price,int post_visible){//��ʼ������⣬tag��visible��price   ��鷵��ֵ�ǲ���Ϊ��   ��¼����ʱ��
		conn = getconn.getConection();
		Calendar post_date;
		int x = 0;
		post_price = 0;
		post_visible = 0;
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
	//�������ÿһ�����Ӧ������
	public boolean post_progress(long post_id,int progress,String txt,String impage){//post_id,���裬content��impage   ��鷵��ֵ�ǲ���Ϊ��
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
	
	//ɾ������
	public boolean delpost(long post_id){//ɾ������
		conn = getconn.getConection();
		boolean panduan = false;
		
		try{
			String sql_delect = "delete from homework.collection where post_id="+post_id;
			st = (Statement) conn.createStatement();
			rs = st.executeQuery(sql_delect);
			conn.close();
			panduan = true;
		}catch(SQLException e){
			System.out.println("SQLquery fail");
			e.printStackTrace();
			panduan = false;
		}
		return panduan;
	}
	
	//����˫������
	public boolean buy(long user_id,long post_id,int price){//Ϊ�򷽣�����id���۸�
		conn = getconn.getConection();
		boolean panduan = false;	
		int service = 1;//1�ǹ���
		
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
	//����ҵ��
	public boolean give(long user_id,long post_id,int price){//Ϊ�򷽣�����id���۸�
		conn = getconn.getConection();
		boolean panduan = false;	
		int service = 0;//1�ǹ���
		
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
	
	//�ղص���ط���    ��ӣ�������ɾ��
	public long search_collections(long user_id){//�ղ�����
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
	
	public boolean collection(long user_id,long post_id){//�ղ����ӣ�����id
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
	
	public boolean delcollection(long user_id,long post_id){//ɾ���ղأ����ĳ���û�ɾ���ղ�
		conn = getconn.getConection();
		boolean panduan = false;
		
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
	
	//�ⲿ��ȡ������Ϣ
	public ArrayList getpost_id(long user_id){//��ȡ���ӵ�tag,����[0]Ϊtag1���Դ�����
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
	public int[] gettag(long post_id){//��ȡ���ӵ�tag,����[0]Ϊtag1���Դ�����
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
	public int getprice(long post_id){//�ⲿ��ȡ���Ӽ۸�
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
	public long getwriterid(long post_id){//�ⲿ��ȥ������д�˵�id������id
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
	public String gettxt(long post_id,int progress){//�ⲿ��ȡ��������, id �ڼ���
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
	
	public String getimage(long post_id,int progress){//�ⲿ��ȡ����ͼƬ, id �ڼ���
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
	
	public String gettitle(long post_id){//�ⲿ��ȡ���ӱ���
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

	//������صķ���
	public boolean dianzan(long post_id){//���ޣ�����id,����Ϊ��ɹ�
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
	
	public int post_zannum(long post_id){//ͳ�Ƶ�����
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
	
}
