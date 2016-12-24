package View;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import db.*;

public class PostView extends javax.swing.JFrame {

    private javax.swing.JTextField amount;
    private javax.swing.JButton back;
    private javax.swing.JButton collection; 
    private javax.swing.JButton confirm;
    private javax.swing.JButton delete;
    private javax.swing.JButton dianzan;
    private javax.swing.JButton interest;
    private javax.swing.JButton issue;
    
    private javax.swing.JLabel collectionnum;
    private javax.swing.JLabel[] comment;
    
    /*private javax.swing.JLabel comment[1];
    private javax.swing.JLabel comment[2];
    private javax.swing.JLabel comment[3];*/
    
    private javax.swing.JLabel dianzannum;
    private javax.swing.JLabel[] image;
    
    /*private javax.swing.JLabel image[1];
    private javax.swing.JLabel image[2];
    private javax.swing.JLabel image[3];*/
    
    private javax.swing.JLabel[] name;
    
    /*private javax.swing.JLabel name[1];
    private javax.swing.JLabel name[2];
    private javax.swing.JLabel name[3];*/
    
    private javax.swing.JLabel reward;
    private javax.swing.JLabel title;
    private javax.swing.JLabel tag1;
    private javax.swing.JLabel tag2;
    private javax.swing.JLabel tag3;
  
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    
    long user_id;
    long post_id;
    long writer_id;
   
    
    public PostView(long user_id, long post_id) {
    	
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        
        image = new javax.swing.JLabel[4];
        name = new javax.swing.JLabel[4];
        comment = new javax.swing.JLabel[4];
        
        interest = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        dianzan = new javax.swing.JButton();
        collection = new javax.swing.JButton();
        dianzannum = new javax.swing.JLabel();
        collectionnum = new javax.swing.JLabel();
        reward = new javax.swing.JLabel();
        amount = new javax.swing.JTextField();
        confirm = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        
        
        /*image[1] = new javax.swing.JLabel();
        name[1] = new javax.swing.JLabel();
        comment[1] = new javax.swing.JLabel();
        image[2] = new javax.swing.JLabel();
        name[2] = new javax.swing.JLabel();
        comment[2] = new javax.swing.JLabel();
        image[3] = new javax.swing.JLabel();
        name[3] = new javax.swing.JLabel();
        comment[3] = new javax.swing.JLabel();*/
        
        jTextField1 = new javax.swing.JTextField();
        issue = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        tag1 = new javax.swing.JLabel();
        tag2 = new javax.swing.JLabel();
        tag3 = new javax.swing.JLabel();
        
        this.user_id = user_id;
        this.post_id = post_id;
        writer_id = new PostSerDB().getwriterid(post_id);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("帖子");
        setPreferredSize(new java.awt.Dimension(750, 650));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(700, 800));
        jScrollPane1.setRequestFocusEnabled(false);

        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText(new PostSerDB().gettitle(post_id));
        
        //image[0].setIcon(new ImageIcon("头像2.jpg"));
        //image[0].setText("头像2");
        //image[0].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        System.out.println(new UserSerDB().getinfo(writer_id).get(1).toString());
        System.out.println(name[0]);
        name[0] = new JLabel();
        name[0].setText(new UserSerDB().getinfo(writer_id).get(1).toString());
        name[0].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        comment[0].setText("评论");
        comment[0].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
       
        image[1].setText("头像1");
        image[1].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        name[1].setText("昵称1");
        name[1].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        comment[1].setText("评论1");
        comment[1].setToolTipText("");

        image[2].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        image[2].setText("头像2");

        name[2].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name[2].setText("昵称2");
        name[2].setToolTipText("");

        comment[2].setText("评论2");
        comment[2].setToolTipText("");

        image[3].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        image[3].setText("头像3");

        name[3].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name[3].setText("昵称3");

        comment[3].setText("评论3");
        comment[3].setToolTipText("");
        
        refreshcom(post_id);

        dianzannum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dianzannum.setText(new PostSerDB().post_zannum(post_id) + "次点赞");
        dianzannum.setToolTipText("");

        collectionnum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        collectionnum.setText(new PostSerDB().search_collections(post_id) + "次收藏");
        collectionnum.setToolTipText("");

        reward.setText("请输入打赏金额：");
        jTextField1.setText("");
        amount.setToolTipText("");
        
        int[] a = new PostSerDB().gettag(post_id);
        tag1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tag1.setText(String.valueOf(a[0]));

        tag2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tag2.setText(String.valueOf(a[1]));

        tag3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tag3.setText(String.valueOf(a[2]));

        boolean judge1 = new UserSerDB().search_follow_id(user_id).contains(new Long(writer_id));
        if (judge1)
        	interest.setText("已关注");
        else
        	interest.setText("+ 关注");
        interest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                interestActionPerformed(evt);
            }
        });

        delete.setText("删除");
        delete.setToolTipText("");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        back.setText("返回");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        
        int i;
        for (i = 1; i<=10; i++){
        	String str = new PostSerDB().gettxt(post_id, i);
        	if (!str.isEmpty()){
        		JPanel panel = new JPanel();
        	    JTextArea txt = new JTextArea();
        	    JLabel pic = new JLabel();
        	    panel.setLayout(new GridLayout(2,1,20,0));
        	    txt.setLineWrap(true);
        	    txt.setWrapStyleWord(true);
        	    txt.setText(str);
        	    pic.setIcon(new ImageIcon(new PostSerDB().getimage(post_id, i)));
        	    panel.add(txt);
        	    panel.add(pic);
        	    jPanel3.add(panel);
        	}
        	else
        		break;
        }
        
        dianzan.setText("点赞");
        dianzan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dianzanActionPerformed(evt);
            }
        });

        boolean judge2 = new UserSerDB().search_collection_id(user_id).contains(new Long(post_id));
        if (judge2)
        	collection.setText("已收藏");
        else
        	collection.setText("收藏");
        collection.setToolTipText("");
        collection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                collectionActionPerformed(evt);
            }
        });

        confirm.setText("确定");
        confirm.setToolTipText("");
        confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmActionPerformed(evt);
            }
        });
        
        issue.setText("发表");
        issue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(back)
                    .addComponent(image[0], javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(delete))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(name[0], javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(interest)
                        .addGap(82, 82, 82)
                        .addComponent(tag1)
                        .addGap(68, 68, 68)
                        .addComponent(tag2)
                        .addGap(69, 69, 69)
                        .addComponent(tag3)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(title)
                    .addComponent(back)
                    .addComponent(delete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(image[0], javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name[0])
                    .addComponent(interest)
                    .addComponent(tag1)
                    .addComponent(tag2)
                    .addComponent(tag3))
                .addGap(414, 414, 414))
        );

        

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dianzan, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(dianzannum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(collection, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(collectionnum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(reward)
                .addGap(30, 30, 30)
                .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(confirm)
                .addGap(76, 76, 76))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dianzan)
                            .addComponent(collection))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dianzannum)
                            .addComponent(collectionnum)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(reward)
                            .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(confirm))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        
        jPanel5.setPreferredSize(new java.awt.Dimension(600, 238));
        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(image[3], javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(name[3], javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(comment[3], javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(image[1], javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(comment[0], javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(image[2], javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(name[2], javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comment[2], javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(name[1], javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comment[1], javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(173, 173, 173))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jTextField1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(issue)
                                .addGap(30, 30, 30))))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comment[0], javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(issue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(image[1], javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(name[1])
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comment[1])))
                .addGap(16, 16, 16)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(name[2])
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comment[2]))
                    .addComponent(image[2], javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(image[3], javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(name[3])
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comment[3])))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        
        java.awt.GridLayout jPanel3Layout = new java.awt.GridLayout(10, 1, 20, 0);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3.setMaximumSize(new java.awt.Dimension(1000, 32767));
        jPanel3.setMinimumSize(new java.awt.Dimension(1000, 0));
       
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE))
                .addGap(0, 1047, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        
        
        jScrollPane1.setViewportView(jPanel1);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE)
        );

        pack();
		setResizable(false);
		this.setLocationRelativeTo(null);
    }                       

    private void interestActionPerformed(java.awt.event.ActionEvent evt) {
        String str = interest.getText();
        if (str.equals("+ 关注")){
        	boolean judge = new UserSerDB().follow(user_id, writer_id);
        	if (judge)
        		interest.setText("已关注");
        	else
        		JOptionPane.showMessageDialog(null, "关注失败！", "提示信息",JOptionPane.WARNING_MESSAGE);           
        }
        else{
        	boolean judge = new UserSerDB().delfollow(user_id,writer_id);
        	if (judge)
        		interest.setText("+ 关注");
        	else
        		JOptionPane.showMessageDialog(null, "取消关注失败！", "提示信息",JOptionPane.WARNING_MESSAGE);           
        }
    }                                       

    private void dianzanActionPerformed(java.awt.event.ActionEvent evt) {
        String str = dianzan.getText();
        if (str.equals("点赞")){
        	boolean judge = new PostSerDB().dianzan(post_id);
        	if (judge)
        		dianzan.setText("已点赞");
        	else
        		JOptionPane.showMessageDialog(null, "点赞失败！", "提示信息",JOptionPane.WARNING_MESSAGE); 
        }
    }                                       

    private void collectionActionPerformed(java.awt.event.ActionEvent evt) {
         String str = collection.getText();
         if (str.equals("收藏")){
         	boolean judge = new PostSerDB().collection(user_id, post_id);
         	if (judge)
         		collection.setText("已收藏");
         	else
         		JOptionPane.showMessageDialog(null, "收藏失败！", "提示信息",JOptionPane.WARNING_MESSAGE);           
         }
         else{
         	boolean judge = new PostSerDB().delcollection(user_id, post_id);
         	if (judge)
         		interest.setText("收藏");
         	else
         		JOptionPane.showMessageDialog(null, "取消收藏失败！", "提示信息",JOptionPane.WARNING_MESSAGE);           
         }
                                          
    }                                          

    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {
    	try {
    	  int a = Integer.parseInt(amount.getText());
    	  boolean barget = new PostSerDB().buy(user_id, post_id, a);
    	  if (barget)
    		  JOptionPane.showMessageDialog(null, "打赏成功！", "提示信息",JOptionPane.WARNING_MESSAGE);
    	  else
    		  JOptionPane.showMessageDialog(null, "金币不足！", "提示信息",JOptionPane.WARNING_MESSAGE);
    		  
    	} catch (NumberFormatException e) {
    	    e.printStackTrace();
     		JOptionPane.showMessageDialog(null, "请输入数字！", "提示信息",JOptionPane.WARNING_MESSAGE);
    	}
    }                                       

    private void backActionPerformed(java.awt.event.ActionEvent evt) {                                     
        PostView.this.dispose();
        new MainPage1(user_id).setVisible(true);
    }                                    

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {                                       
        boolean judge = new PostSerDB().delpost(post_id);
        if (judge){
        	new MainPage1(user_id).setVisible(true);
        	PostView.this.dispose();
        }
        	
    }                                      

    private void issueActionPerformed(java.awt.event.ActionEvent evt) {                                      
        String str = String.valueOf(jTextField1.getText());
        if (str.isEmpty()){
        	JOptionPane.showMessageDialog(null, "评论内容为空！", "提示信息",JOptionPane.WARNING_MESSAGE);
        }
        else{
        	boolean judge = new CommentSerDB().comment(post_id, writer_id, str);
            if (judge)
            	refreshcom(post_id);
            else
            	JOptionPane.showMessageDialog(null, "评论失败！", "提示信息",JOptionPane.WARNING_MESSAGE);
            }
    }


    private void refreshcom(long post_id) {
    	int i;
    	ArrayList<Long> com = new CommentSerDB().search_post(post_id);
    	for (i = 1; i <= 3; i++){
    		long com_id = (com.get(i - 1)).longValue();
    		String str = new CommentSerDB().getcontent(com_id);
    		long wri_id = new CommentSerDB().getwriterid(com_id);
    		String com_name = new UserSerDB().getinfo(wri_id).get(1).toString();
    		name[i].setText(com_name);
    		comment[i].setText(str);
    		image[i].setIcon(new ImageIcon("头像1.jpg"));//添加图像
    	}  		
	}

	/*public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PostView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PostView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PostView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PostView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PostView(0, 0).setVisible(true);
            }
        });
    }*/                 
}

