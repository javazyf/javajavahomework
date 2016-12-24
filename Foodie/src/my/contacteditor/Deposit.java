/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.contacteditor;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import db.UserSerDB;
public class Deposit extends javax.swing.JFrame {
	Long deposit_id;
	int deposit_num;
    long user_id;
    public Deposit(long user_id) {
      
        this.user_id=user_id;
  
        jLabel3 = new javax.swing.JLabel();
        nicheng = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JLabel();
        jine = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        queding = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        jLabel3.setText("");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("金币充值");

        nicheng.setText("");
      
        jTextField1.setText("");
        jine.setText("充值金额");

 

        queding.setText("确定");
       
        queding.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jLabel5.setText("");
        jLabel5.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel5AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jLabel5)
                        .addGap(89, 89, 89))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(nicheng)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jine)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(queding)
                            .addComponent(jTextField2))))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nicheng)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jine)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(queding)
                .addGap(38, 38, 38)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setResizable(false);
		setLocationRelativeTo(null);
    }

    private void jLabel5AncestorAdded(javax.swing.event.AncestorEvent evt) {
         setDefaultCloseOperation(Deposit.DISPOSE_ON_CLOSE); 
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    	 String b = jTextField2.getText();//获得充值金额
         deposit_num=Integer.valueOf(b).intValue();   
    	UserSerDB userser = new UserSerDB();
     	userser.recharge(user_id,deposit_num);
     	JOptionPane.showMessageDialog(null, "充值成功！");
     	setVisible(false);
     	}   //输入用户ID，用户金额，调用recharge(),充值成功
    
    private javax.swing.JButton queding;
    private javax.swing.JLabel nicheng;
    private javax.swing.JLabel jine;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jTextField1;
    private javax.swing.JTextField jTextField2;
}
