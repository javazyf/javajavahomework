/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;

import java.io.IOException;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import View.*;
import db.PostSerDB;
import db.SearchSerDB;

/**
 *
 * @author lenovo
 */
public class Result_Post extends javax.swing.JFrame {
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton56;
    private javax.swing.JButton jButton57;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane8;
    
    private JButton Logout;
    private JButton New_Post;

    private JPanel post[]=new JPanel[100];
    private javax.swing.JPanel PostBody;
    private javax.swing.JScrollPane PostList;
    private javax.swing.JButton Search;
    private javax.swing.JLabel Title1;
    private JLabel jLable[]=new JLabel[100];
    private javax.swing.JPanel Upper;
    private javax.swing.JLabel Username;
    private JButton jButton[][]=new JButton[100][3];
    private JScrollPane jScrollPane[]=new JScrollPane[100];
    private JTextField jTextField[]=new JTextField[100];
    

    
    private javax.swing.JButton private_post;
    private javax.swing.JButton save_post;

    public Result_Post(ArrayList p) {
        initComponents(p);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents(ArrayList p) {

        jScrollPane8 = new javax.swing.JScrollPane();
        jPanel12 = new javax.swing.JPanel();
        jButton57 = new javax.swing.JButton();
        jButton56 = new javax.swing.JButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        
        Upper = new javax.swing.JPanel();
        Title1 = new javax.swing.JLabel();
        New_Post = new javax.swing.JButton();
        private_post = new javax.swing.JButton();
        save_post = new javax.swing.JButton();
        Search = new javax.swing.JButton();
        Username = new javax.swing.JLabel();
        Logout = new javax.swing.JButton();
        PostList = new javax.swing.JScrollPane();
        PostBody = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));


        jScrollPane8.setViewportView(jPanel12);

        jButton57.setText("搜索结果");

        jButton56.setText("排序方式");

        jRadioButton2.setText("时间");
        jRadioButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jRadioButton2.setDoubleBuffered(true);
        jRadioButton2.setVerifyInputWhenFocusTarget(false);

        jRadioButton3.setText("购买量");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jRadioButton1.setText("收藏量");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jButton1.setText("返回");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
					backtoSea_Poster(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton56)
                    .addComponent(jButton57))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton1))
                    .addComponent(jButton1))
                .addContainerGap(237, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane8)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton57)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton56)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        //查找的方法可能要看Sea_Poster
        SearchSerDB searchSerDB=new SearchSerDB();
        ArrayList a = new ArrayList();
        a = Sea_Post.getP(); 
        a = searchSerDB.search_post(0); //搜索公共菜谱，返回long[]，为帖子id数组
		int number=a.size();
        
        for(int i=0;i<number;i++){
        int b;
        b= Integer.valueOf(a.get(i).toString());
        post[b]=new JPanel();
        post[b].setMaximumSize(new java.awt.Dimension(1000, 32767));
        post[b].setMinimumSize(new java.awt.Dimension(1000, 0));
        
        jTextField[b]=new JTextField();
        jTextField[b].setColumns(20);
        PostSerDB postSerDB=new PostSerDB();
        String post_title=postSerDB.gettitle(b);
        
		jTextField[b].setText(post_title);
		jLable[b]=new JLabel();
        jScrollPane[b]=new JScrollPane();
        jScrollPane[b].setViewportView(jTextField[b]);
        jButton[b][0]=new JButton();
        jButton[b][1]=new JButton();
        jButton[b][2]=new JButton();
        jLable[b].setText("author");
        jButton[b][0].setText("查看");

        jButton[b][1].setText("收藏");
        jButton[b][1].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
                 
            }
        });

        jButton[b][2].setText("点赞");
        
        javax.swing.GroupLayout Post1Layout = new javax.swing.GroupLayout(post[b]);
        post[b].setLayout(Post1Layout);
        Post1Layout.setHorizontalGroup(
            Post1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Post1Layout.createSequentialGroup()
                .addContainerGap(127, Short.MAX_VALUE)
                .addComponent(jScrollPane[b], javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLable[b])
                .addGap(18, 18, 18)
                .addComponent(jButton[b][0])
                .addGap(18, 18, 18)
                .addComponent(jButton[b][1])
                .addGap(39, 39, 39))
        );
        Post1Layout.setVerticalGroup(
            Post1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Post1Layout.createSequentialGroup()
                .addGroup(Post1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Post1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(Post1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton[b][1])
                            .addComponent(jButton[b][0])
                            .addComponent(jLable[b])))
                    .addGroup(Post1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane[b], javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

  /*      javax.swing.GroupLayout postLayout = new javax.swing.GroupLayout(post[i]);
        post[i].setLayout(postLayout);
        postLayout.setHorizontalGroup(
            postLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(postLayout.createSequentialGroup()
                .addContainerGap(127, Short.MAX_VALUE)
                .addComponent(jScrollPane[i], javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLable[i])
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton[i][0])
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton[i][1])
                .addGap(37, 37, 37))
        );
        postLayout.setVerticalGroup(
            postLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(postLayout.createSequentialGroup()
                .addGroup(postLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(postLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(postLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLable[i])
                            .addGap(18, 18, 18)
                            .addComponent(jButton[i][0])
                            .addGap(18, 18, 18)
                            .addComponent(jButton[i][1])
                            .addGap(39, 39, 39))))
                    .addGroup(postLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane[i], javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        */

        PostBody.add(post[b]);//原本是i ,后来被改成b

        


        
        }
        
        PostList.setViewportView(PostBody);

        javax.swing.GroupLayout layout1 = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout1);
        layout1.setHorizontalGroup(
            layout1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout1.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addGroup(layout1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Upper, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PostList, javax.swing.GroupLayout.DEFAULT_SIZE, 1066, Short.MAX_VALUE))
                .addGap(166, 166, 166))
        );
        layout1.setVerticalGroup(
            layout1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout1.createSequentialGroup()
                .addComponent(Upper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PostList, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        
    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchActionPerformed

  /*  private void private_postActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_private_postActionPerformed
       MainPage1.this.setVisible(false);
       new MainPage2().setVisible(true);
    }//GEN-LAST:event_private_postActionPerformed

    private void save_postActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_postActionPerformed
       MainPage1.this.setVisible(false);
       new MainPage3().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_save_postActionPerformed
*/
    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton24ActionPerformed

 
    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             
                       

    private void backtoSea_Poster(java.awt.event.MouseEvent evt) throws IOException {                                  
            this.dispose();//点击按钮时Result_Poster销毁,new一个Sea_Poster
            new Sea_Post().setVisible(true);        // TODO add your handling code here:
    }                                 

 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Result_Post.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Result_Post.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Result_Post.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Result_Post.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }
                  
}
