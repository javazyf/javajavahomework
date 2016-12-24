package View;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import db.*;
import my.contacteditor.MyCollection;
import my.contacteditor.PersonalHpmepage;
import post_upload.*;
import search.Sea_Post;
import View.*;

public class MainPage1 extends javax.swing.JFrame {

    private long user_id;
    
    public MainPage1(long user_id) {
        Upper = new BackGroundJPanel();
        Title1 = new javax.swing.JLabel();
        New_Post = new javax.swing.JButton();
        private_post = new javax.swing.JButton();
        save_post = new javax.swing.JButton();
        Search = new javax.swing.JButton();
        Username = new javax.swing.JButton();
        Logout = new javax.swing.JButton();
        PostList = new javax.swing.JScrollPane();
        PostBody = new BackGroundJPanel();
        this.user_id=user_id;


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        Title1.setFont(new java.awt.Font("微软雅黑", 0, 48)); // NOI18N
        Title1.setText("食控们的菜市场");

        New_Post.setText("分享新菜谱");
        New_Post.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	try {
					New_PostActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        private_post.setText("私房菜");
        private_post.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                private_postActionPerformed(evt);
            }
        });

        save_post.setText("订阅菜");
        save_post.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_postActionPerformed(evt);
            }
        });

        Search.setText("搜索");
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					SearchActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        Username.setText("傅馨_个人主页");
        Username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	UsernameActionPerformed(evt);
            }
        });
        Logout.setText("退出登录");
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	LogoutActionPerformed(evt);
            }

			private void LogoutActionPerformed(ActionEvent evt) {
				System.exit(0);
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
        SearchSerDB searchSerDB=new SearchSerDB();
        ArrayList a = new ArrayList(); 
        a = searchSerDB.search_post(0); //搜索公共菜谱，返回long[]，为帖子id数组
		int number=a.size();
        for(int i=0;i<number;i++){
        
        int b[] = new int[100]; 
        b[i]= Integer.valueOf(a.get(i).toString());
        post[b[i]]=new BackGroundJPanel();
        post[b[i]].setMaximumSize(new java.awt.Dimension(1000, 32767));
        post[b[i]].setMinimumSize(new java.awt.Dimension(1000, 0));
        
        jTextField[b[i]]=new JTextField();
        jTextField[b[i]].setColumns(20);
        PostSerDB postSerDB=new PostSerDB();
        String post_title=postSerDB.gettitle(b[i]);
        
		jTextField[b[i]].setText(post_title);
		jLable[b[i]]=new JLabel();
        jScrollPane[b[i]]=new JScrollPane();
        jScrollPane[b[i]].setViewportView(jTextField[b[i]]);
        jButton[b[i]][0]=new JButton();
        jButton[b[i]][1]=new JButton();
        jButton[b[i]][2]=new JButton();
      
        long wirter_id=postSerDB.getwriterid(b[i]);
        UserSerDB userSerDB= new UserSerDB();
        ArrayList writer_name= new ArrayList();
        writer_name = userSerDB.getinfo(wirter_id);
       
        jLable[b[i]].setText(writer_name.get(3).toString());
        jButton[b[i]][0].setText("查看");
        jButton[b[i]][0].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });
        boolean judge = new UserSerDB().search_collection_id(user_id).contains(a.get(i));
        if (judge)
        	jButton[b[i]][1].setText("已收藏");
        else
        	jButton[b[i]][1].setText("收藏");
        final int s=b[i];
        jButton[b[i]][1].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt,s);
            }
        });

        jButton[b[i]][2].setText("点赞");
        
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
    }// </editor-fold>//GEN-END:initComponents

    
    public void New_PostActionPerformed(java.awt.event.ActionEvent evt) throws IOException {//GEN-FIRST:event_SearchActionPerformed
        // TODO add your handling code here:
    	Post_other p_o=new Post_other(user_id);
    	p_o.setVisible(true);
    }//GEN-LAST:event_SearchActionPerformed

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) throws IOException {//GEN-FIRST:event_SearchActionPerformed
        // TODO add your handling code here:
    	Sea_Post s_p = new Sea_Post();
    	s_p.setVisible(true);
    }//GEN-LAST:event_SearchActionPerformed

    private void private_postActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_private_postActionPerformed
       MainPage1.this.setVisible(false);
       new MainPage2(user_id).setVisible(true);
    }//GEN-LAST:event_private_postActionPerformed

    private void save_postActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_postActionPerformed
       MainPage1.this.setVisible(false);
       new MainPage3(user_id).setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_save_postActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt,int i) {//GEN-FIRST:event_jButton24ActionPerformed
    	long c=0;    
    
    	String str = jButton[i][1].getText();
        if (str.equals("收藏")){
        	jButton[i][1].setText("已收藏");
        	c=i;
        	posterSerDB.collection(user_id,c); 
        }
        else{
        	jButton[i][1].setText("收藏");
        	c=i;
        	posterSerDB.delcollection(user_id,c); 
        }
    } 
    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
    	PostView postView=new PostView(user_id,b);
        postView.setVisible(true);
    } 
    
    private void UsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_private_postActionPerformed
        MainPage1.this.setVisible(false);
        PersonalHpmepage ph = new PersonalHpmepage(user_id);
        ph.setVisible(true);  //杈撳叆鐢ㄦ埛ID锛屾墦寮�MyCollection
     }
    
    private JButton Logout;
    private JButton New_Post;

    private BackGroundJPanel post[]=new BackGroundJPanel[100];
    private BackGroundJPanel PostBody;
    private javax.swing.JScrollPane PostList;
    private javax.swing.JButton Search;
    private javax.swing.JLabel Title1;
    private JLabel jLable[]=new JLabel[100];
    private BackGroundJPanel Upper;
    private javax.swing.JButton Username;
    private JButton jButton[][]=new JButton[100][3];
    private JScrollPane jScrollPane[]=new JScrollPane[100];
    private JTextField jTextField[]=new JTextField[100];
    
    int b;
    
    private javax.swing.JButton private_post;
    private javax.swing.JButton save_post;
    
	PostSerDB posterSerDB=new PostSerDB();
    // End of variables declaration//GEN-END:variables
}
