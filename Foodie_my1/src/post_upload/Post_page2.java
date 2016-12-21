package post_upload;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import db.*;

import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import db.*;

public class Post_page2 extends javax.swing.JFrame {
	
	private int progress1=2;
	
	private static final long serialVersionUID = 1L;
    private javax.swing.JToggleButton cancel1;
    private javax.swing.JLabel img1;
    private javax.swing.JButton img_upload1;
    private javax.swing.JButton issue1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton next1;
    private javax.swing.JLabel p1;
    private javax.swing.JButton previous1;
    private javax.swing.JLabel txt1;
    private javax.swing.JTextArea txt_input1;
    
    private String image =null;
    long post_nowid;
    long post_wrid;
    
    public Post_page2(long post_id,long user_id) {

        jPanel1 = new javax.swing.JPanel();
        p1 = new javax.swing.JLabel();
        txt1 = new javax.swing.JLabel();
        img1 = new javax.swing.JLabel();
        img_upload1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_input1 = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        cancel1 = new javax.swing.JToggleButton();
        previous1 = new javax.swing.JButton();
        next1 = new javax.swing.JButton();
        issue1 = new javax.swing.JButton();
        
        this.post_nowid = post_id;
        this.post_wrid=user_id;
        this.setLocation(450,150);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        p1.setText("绗�"+progress1+"姝�");

        txt1.setText("璇疯緭鍏ユ枃瀛楋細");

        img1.setText("璇蜂笂浼犲浘鐗�");

        img_upload1.setText("涓婁紶");
        img_upload1.addActionListener(new java.awt.event.ActionListener() {
        	//上传
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	img_upload1ActionPerformed(evt);
            }
        });

        txt_input1.setColumns(20);
        txt_input1.setRows(5);
        jScrollPane1.setViewportView(txt_input1);
      
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(img1)
                        .addGap(35, 35, 35)
                        .addComponent(img_upload1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt1)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(p1)
                .addGap(181, 181, 181))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(p1)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(86, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(img1)
                            .addComponent(img_upload1))
                        .addGap(41, 41, 41))))
        );

        cancel1.setText("鍙栨秷");
        cancel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel1ActionPerformed(evt);
            }
        });

        previous1.setText("涓婁竴姝�");
        previous1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	try {
					previous1ActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        next1.setText("涓嬩竴姝�");
        next1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                next1ActionPerformed(evt);
            }
        });

        issue1.setText("鍙戝竷");
        issue1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issue1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(cancel1)
                .addGap(34, 34, 34)
                .addComponent(previous1)
                .addGap(39, 39, 39)
                .addComponent(next1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(issue1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancel1)
                    .addComponent(previous1)
                    .addComponent(next1)
                    .addComponent(issue1))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }
    
    private void img_upload1ActionPerformed(java.awt.event.ActionEvent evt) {
        //鍙栨秷鐩戝惉
    	Object[] obj2 = { "green","orange","red","yellow"};
    	image=(String) JOptionPane.showInputDialog(null,"请选择想上传的图片\n","图片",
    			JOptionPane.PLAIN_MESSAGE,new ImageIcon("green.jpg"),obj2,"green");
    }
    
    private void cancel1ActionPerformed(java.awt.event.ActionEvent evt) {
        //鍙栨秷

    	PostSerDB pid = new PostSerDB();
    	pid.delpost(post_nowid);
    	setVisible(false);
    }
    
    private void previous1ActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
		//杩斿洖涓婁竴姝�
    	setVisible(false);
    	Post_page1 p_p1=new Post_page1(post_nowid,post_wrid);
    	p_p1.setVisible(true);
    }
    
    private void next1ActionPerformed(java.awt.event.ActionEvent evt) {
    	//
    	PostSerDB pid = new PostSerDB(); 	
    	String txt=txt_input1.getText();
    	
    	pid.post_progress(post_nowid,progress1,txt,image);
    	
    	setVisible(false);
    	Post_page3 p_p1=new Post_page3(post_nowid,post_wrid);
    	p_p1.setVisible(true);
    }
    
    private void issue1ActionPerformed(java.awt.event.ActionEvent evt) {
        //
    	PostSerDB pid = new PostSerDB();
    	String txt=txt_input1.getText();
    	
    	pid.post_progress(post_nowid,progress1,txt,image);
    	setVisible(false);
    }
    
}