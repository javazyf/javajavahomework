
package search;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import db.SearchSerDB;
import db.UserSerDB;

public class MyInterest extends JFrame {
	
    private javax.swing.JPanel jPanel12;
    private javax.swing.JScrollPane xialakuang;
    private javax.swing.JTextField wodeguanzhu;
    private javax.swing.JButton fanhui;
    private JButton Logout;
    private JButton New_user;

    private JPanel user[]=new JPanel[100];
    private javax.swing.JPanel userBody = new JPanel();
    private javax.swing.JScrollPane userList = new JScrollPane();
    private javax.swing.JButton Search;
    private javax.swing.JLabel nickname1;
    private JLabel jLable[]=new JLabel[100];
    private javax.swing.JPanel Upper = new JPanel();
    private javax.swing.JLabel Username;
    private JButton jButton[][]=new JButton[100][3];
    private JScrollPane jScrollPane[]=new JScrollPane[100];
    private JTextField jTextField[]=new JTextField[100];
    private UserSerDB uSerdb;
    private int num;
    private Long b;
    private javax.swing.JButton private_user;
    private javax.swing.JButton save_user;
    
    long userid;
    
    public MyInterest(long user_id) {
    	
        xialakuang = new javax.swing.JScrollPane();
        jPanel12 = new javax.swing.JPanel();
        fanhui = new javax.swing.JButton();
        wodeguanzhu = new javax.swing.JTextField();
        
        this.userid=user_id;
        
        jPanel12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 526, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 454, Short.MAX_VALUE)
        );

        xialakuang.setViewportView(jPanel12);
        fanhui.setText("返回");
        wodeguanzhu.setText("我的关注");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(wodeguanzhu, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(fanhui)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(wodeguanzhu, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wodeguanzhu, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fanhui, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(xialakuang, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))                                                       
        );
        System.out.println(userBody);
        userBody.setMaximumSize(new java.awt.Dimension(1000, 32767));
        userBody.setMinimumSize(new java.awt.Dimension(1000, 10));
        userBody.setLayout(new java.awt.GridLayout(10, 1));
        uSerdb=new UserSerDB();
        
        ArrayList a = uSerdb.search_follow_id(user_id);
		int number=a.size();
        
        for(int i=0;i<number;i++){
        	if(i==number && number!=0) break;
        	num = i;
        b= Long.valueOf(a.get(i).toString());
        user[i]=new JPanel();
        user[i].setMaximumSize(new java.awt.Dimension(1000, 32767));
        user[i].setMinimumSize(new java.awt.Dimension(1000, 0));
        
        jTextField[i]=new JTextField();
        jTextField[i].setColumns(20);
        //String user_nickname=uSerdb.getnickname(b);
      //  ArrayList  u = uSerdb.getinfo(b);
		//jTextField[b].setText(u.get(b));
		jLable[i]=new JLabel();
        jScrollPane[i]=new JScrollPane();
        jScrollPane[i].setViewportView(jTextField[i]); 
        jButton[i][0]=new JButton();
        jButton[i][1]=new JButton();
        jLable[i].setText("ID");
        jButton[i][0].setText("详细资料");
        jButton[i][1].setText("取消关注"); 
        
        jButton[i][0].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	ArrayList listu = new ArrayList();
            	listu = uSerdb.getinfo(Long.valueOf(a.get(num).toString()));//关注人信息。。。
                 
            }
        });
        jButton[i][1].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	uSerdb.delfollow(user_id, Long.valueOf(a.get(num).toString()));//删除
                 
            }
        });
        

        
        javax.swing.GroupLayout user1Layout = new javax.swing.GroupLayout(user[num]);
        user[num].setLayout(user1Layout);
        user1Layout.setHorizontalGroup(
            user1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(user1Layout.createSequentialGroup()
                .addContainerGap(127, Short.MAX_VALUE)
                .addComponent(jScrollPane[num], javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLable[num])
                .addGap(18, 18, 18)
                .addComponent(jButton[num][0])
                .addGap(18, 18, 18)
                .addComponent(jButton[num][1])
                .addGap(39, 39, 39))
        );
        user1Layout.setVerticalGroup(
            user1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(user1Layout.createSequentialGroup()
                .addGroup(user1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(user1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(user1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton[num][1])
                            .addComponent(jButton[num][0])
                            .addComponent(jLable[num])))
                    .addGroup(user1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane[num], javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

 
        userBody.add(user[num]);//原本是i ,后来被改成b

       

        }
    
        userList.setViewportView(userBody);
        javax.swing.GroupLayout layout1 = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout1);
        layout1.setHorizontalGroup(
            layout1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout1.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addGroup(layout1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Upper, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userList, javax.swing.GroupLayout.DEFAULT_SIZE, 1066, Short.MAX_VALUE))
                .addGap(166, 166, 166))
        );
        layout1.setVerticalGroup(
            layout1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout1.createSequentialGroup()
                .addComponent(Upper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userList, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();

    }
}
    
