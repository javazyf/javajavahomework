

package search;
import db.SearchSerDB;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Sea_User extends javax.swing.JFrame {
	 public javax.swing.JTextField getField1() {
			return field1;
		}

		public void setField1(javax.swing.JTextField field1) {
			this.field1 = field1;
		}
		             
	    private javax.swing.JTextField field1;
	    private javax.swing.JButton quxiao;
	    private javax.swing.JLabel chazhaoyonghu;
	    private javax.swing.JButton queding;
	    private javax.swing.JLabel shurunicheng;
	    private String nickname;

	    public Sea_User() {
        chazhaoyonghu = new JLabel();
        quxiao = new javax.swing.JButton();
        setField1(new javax.swing.JTextField());
        shurunicheng = new javax.swing.JLabel();
        queding = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nickname = field1.getText(); 
        
        chazhaoyonghu.setText("查找用户");

        quxiao.setText("取消");

        shurunicheng.setText("输入昵称");

        queding.setText("确定");
        queding.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	quedingMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(shurunicheng, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(getField1(), javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(chazhaoyonghu)
                                .addGap(98, 98, 98)
                                .addComponent(quxiao))
                            .addComponent(queding))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chazhaoyonghu)
                    .addComponent(quxiao))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(shurunicheng, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(getField1(), javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addComponent(queding)
                .addContainerGap(102, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        
    
   
    private void quedingMouseClicked(java.awt.event.MouseEvent evt) { 
    	
        this.dispose();
        new Result_User(nickname).setVisible(true);
    }
   
              
}
