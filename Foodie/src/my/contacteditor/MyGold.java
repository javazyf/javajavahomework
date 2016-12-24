
package my.contacteditor;

import View.MainPage1;
public class MyGold extends javax.swing.JFrame {
   long user_id;
    
    public MyGold(long user_id) {
        initComponents();
        this.user_id=user_id;
    }

    
    @SuppressWarnings("unchecked")
   
    private void initComponents() {

        jinbichongzhi = new javax.swing.JButton();
        jiaoyijilu = new javax.swing.JButton();
        chongzhibangzhu = new javax.swing.JButton();
        jLabel1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("我的金币");

        jinbichongzhi.setText("金币充值");
        jinbichongzhi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jiaoyijilu.setText("交易记录");
        jiaoyijilu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	jiaoyijiluActionPerformed(evt);
            }
        });

        chongzhibangzhu.setText("充值帮助");
        chongzhibangzhu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jLabel1.setText("返回");
        jLabel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	jLabel1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chongzhibangzhu, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jiaoyijilu, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jinbichongzhi, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(jLabel1)))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jinbichongzhi, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jiaoyijilu, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(chongzhibangzhu, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
        setResizable(false);
		setLocationRelativeTo(null);
    }

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {
           new Deposit(user_id).setVisible(true);       
    }   //打开充值界面

    private void jiaoyijiluActionPerformed(java.awt.event.ActionEvent evt) {
        MyGold.this.setVisible(false);
        new Docuement(user_id).setVisible(true);  
     }

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {
      new HelpMessage().setVisible(true);       //打开充值帮助界面 
    }

    private void jLabel1ActionPerformed(java.awt.event.ActionEvent evt) {
        MyGold.this.setVisible(false);
        new PersonalHpmepage(user_id).setVisible(true);  
     }

    
    private javax.swing.JButton jinbichongzhi;
    private javax.swing.JButton jiaoyijilu;
    private javax.swing.JButton chongzhibangzhu;
    private javax.swing.JButton jLabel1;
    
}
