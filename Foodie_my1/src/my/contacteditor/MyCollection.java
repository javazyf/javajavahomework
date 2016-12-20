
package my.contacteditor;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import View.MainPage1;
import View.PostView;
import db.PostSerDB;
import db.SearchSerDB;
import db.UserSerDB;
public class MyCollection extends javax.swing.JFrame {

	  long user_id;
	    
	    public MyCollection(long user_id) {
	        Upper = new javax.swing.JPanel();
	        Title1 = new javax.swing.JLabel();
	        New_Post = new javax.swing.JLabel();
	        private_post = new javax.swing.JLabel();
	        save_post = new javax.swing.JLabel();
	        Search = new javax.swing.JLabel();
	        Username = new javax.swing.JLabel();
	        Logout = new javax.swing.JButton();
	        PostList = new javax.swing.JScrollPane();
	        PostBody = new javax.swing.JPanel();
	        this.user_id=user_id;


	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	        setResizable(false);

	        Title1.setFont(new java.awt.Font("微软雅黑", 0, 48)); 
	        Title1.setText("我的收藏");

	        New_Post.setText("");
	        private_post.setText("");
	        save_post.setText("");
	        Search.setText("");
	        Username.setText("");
	        Logout.setText("返回");
	        Logout.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	LogoutActionPerformed(evt);
	            }
	        });
	   
	        javax.swing.GroupLayout UpperLayout = new javax.swing.GroupLayout(Upper);
	        Upper.setLayout(UpperLayout);
	        UpperLayout.setHorizontalGroup(
	            UpperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(UpperLayout.createSequentialGroup()
	                .addComponent(Title1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(UpperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(UpperLayout.createSequentialGroup()
	                        .addGap(0, 0, Short.MAX_VALUE)
	                        .addComponent(New_Post))
	                    .addGroup(UpperLayout.createSequentialGroup()
	                        .addComponent(private_post)
	                        .addGap(35, 35, 35)
	                        .addComponent(save_post)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                        .addComponent(Username)))
	                .addGap(36, 36, 36)
	                .addGroup(UpperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UpperLayout.createSequentialGroup()
	                        .addComponent(Logout)
	                        .addGap(10, 10, 10))
	                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UpperLayout.createSequentialGroup()
	                        .addComponent(Search)
	                        .addContainerGap())))
	        );
	        UpperLayout.setVerticalGroup(
	            UpperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(UpperLayout.createSequentialGroup()
	                .addGap(11, 11, 11)
	                .addGroup(UpperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
	                    .addComponent(Username)
	                    .addComponent(Logout)
	                    .addComponent(save_post)
	                    .addComponent(private_post))
	                .addGroup(UpperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(UpperLayout.createSequentialGroup()
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
	                        .addGroup(UpperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                            .addComponent(Search)
	                            .addComponent(New_Post))
	                        .addGap(34, 34, 34))
	                    .addGroup(UpperLayout.createSequentialGroup()
	                        .addGap(1, 1, 1)
	                        .addComponent(Title1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
	        );

	        PostList.setHorizontalScrollBar(null);

	        PostBody.setMaximumSize(new java.awt.Dimension(1000, 32767));
	        PostBody.setMinimumSize(new java.awt.Dimension(1000, 10));
	        PostBody.setLayout(new java.awt.GridLayout(10, 1));
	        UserSerDB userserdb= new UserSerDB();
	        ArrayList a = new ArrayList(); 
	        a = userserdb.search_collection_id(user_id); //搜索我的收藏的帖子表，输入user_id，返回为帖子id数组
			int number=a.size();    //得到数组大小
	        
	        for(int i=0;i<number;i++){      
	        
	        int b[] = new int[100]; 
	        b[i]= Integer.valueOf(a.get(i).toString());
	        
	        post[b[i]]=new JPanel();
	        post[b[i]].setMaximumSize(new java.awt.Dimension(1000, 32767));
	        post[b[i]].setMinimumSize(new java.awt.Dimension(1000, 0));
	        
	        jTextField[b[i]]=new JTextField();
	        jTextField[b[i]].setColumns(20);
	        PostSerDB postSerDB=new PostSerDB();        
	        String post_title=postSerDB.gettitle(b[i]);    //调用gettitle方法，输入帖子ID，返回帖子标题
	        
			jTextField[b[i]].setText(post_title);
			jLable[b[i]]=new JLabel();
	        jScrollPane[b[i]]=new JScrollPane();
	        jScrollPane[b[i]].setViewportView(jTextField[b[i]]);
	        jButton[b[i]][0]=new JButton();
	        jButton[b[i]][1]=new JButton();
	      
	        jLable[b[i]].setText("");
	        jButton[b[i]][0].setText("查看");
	        final int s=b[i];
	        jButton[b[i]][0].addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton25ActionPerformed(evt,s);
	            }
	        });
	        jButton[b[i]][1].setText("删除");
	        
	        jButton[b[i]][1].addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton24ActionPerformed(evt,s);
	            }
	        });
	        
	        javax.swing.GroupLayout Post1Layout = new javax.swing.GroupLayout(post[b[i]]);
	        post[b[i]].setLayout(Post1Layout);
	        Post1Layout.setHorizontalGroup(
	            Post1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(Post1Layout.createSequentialGroup()
	                .addContainerGap(127, Short.MAX_VALUE)
	                .addComponent(jScrollPane[b[i]], javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(34, 34, 34)
	                .addComponent(jLable[b[i]])
	                .addGap(18, 18, 18)
	                .addComponent(jButton[b[i]][0])
	                .addGap(18, 18, 18)
	                .addComponent(jButton[b[i]][1])
	                .addGap(39, 39, 39))
	        );
	        Post1Layout.setVerticalGroup(
	            Post1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(Post1Layout.createSequentialGroup()
	                .addGroup(Post1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(Post1Layout.createSequentialGroup()
	                        .addGap(43, 43, 43)
	                        .addGroup(Post1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                            .addComponent(jButton[b[i]][1])
	                            .addComponent(jButton[b[i]][0])
	                            .addComponent(jLable[b[i]])))
	                    .addGroup(Post1Layout.createSequentialGroup()
	                        .addContainerGap()
	                        .addComponent(jScrollPane[b[i]], javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );

	        PostBody.add(post[b[i]]);
 
	        }
	        
	        PostList.setViewportView(PostBody);

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                .addContainerGap(74, Short.MAX_VALUE)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                    .addComponent(Upper, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(PostList, javax.swing.GroupLayout.DEFAULT_SIZE, 1066, Short.MAX_VALUE))
	                .addGap(166, 166, 166))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addComponent(Upper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(PostList, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(61, Short.MAX_VALUE))
	        );

	        pack();
	        setResizable(false);
			setLocationRelativeTo(null);
	    }

	    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {
	    }

	    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {
	        MyCollection.this.setVisible(false);
	        new PersonalHpmepage(user_id).setVisible(true);  
	     }
	    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt,int i) {
	    	long c=0;  
	    	PostSerDB postser= new PostSerDB();
	    	c=i;
	        postser.delcollection(user_id,c); //调用delcollection方法，输入use_id,帖子ID，删除用户收藏的该帖子
	        JOptionPane.showMessageDialog(null, "取消收藏成功！");
	    } 
	    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt,int i) {
	    	long c=0;  
	    	PostSerDB postser= new PostSerDB();
	    	c=i;
	    	PostView postView=new PostView(user_id,c);   //输入use_id和帖子ID，打开帖子界面，查看该帖子
	        postView.setVisible(true);
	    } 
	   
	    private JButton Logout;
	    private JLabel New_Post;

	    private JPanel post[]=new JPanel[100];
	    private javax.swing.JPanel PostBody;
	    private javax.swing.JScrollPane PostList;
	    private JLabel Search;
	    
	    private javax.swing.JLabel Title1;
	    private JLabel jLable[]=new JLabel[100];
	    private javax.swing.JPanel Upper;
	    private javax.swing.JLabel Username;
	    private JButton jButton[][]=new JButton[100][2];
	    private JScrollPane jScrollPane[]=new JScrollPane[100];
	    private JTextField jTextField[]=new JTextField[100];
	    
	    int b;
	    
	    private JLabel private_post;
	    private JLabel save_post;
	    
		PostSerDB posterSerDB=new PostSerDB();


//		public static void main(String args[]){
//			long user = 20160003;
//			int post = 2;
//			MyCollection mc = new MyCollection(user);
//			mc.setVisible(true);
//			PostSerDB postserdb= new PostSerDB();
//	    	postserdb.delcollection(user,post);
//	    	JOptionPane.showMessageDialog(null, "取消成功！");
//	    	MyCollection mc1 = new MyCollection(user);
//			mc1.setVisible(true);
//		}
}
