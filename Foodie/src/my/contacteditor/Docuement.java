
package my.contacteditor;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import View.PostView;
import db.PostSerDB;
import db.TradeSerDB;
import db.UserSerDB;

public class Docuement extends javax.swing.JFrame {
    
	  long user_id;
	    
	    public Docuement(long user_id) {
	        Upper = new javax.swing.JPanel();
	        jiaoyijilu = new javax.swing.JLabel();
	        New_Post = new javax.swing.JLabel();
	        private_post = new javax.swing.JLabel();
	        save_post = new javax.swing.JLabel();
	        Search = new javax.swing.JLabel();
	        Username = new javax.swing.JLabel();
	        Logout = new javax.swing.JButton();
	        PostList = new javax.swing.JScrollPane();
	        PostBody = new javax.swing.JPanel();
	        this.user_id=user_id;


	       
	        setResizable(false);

	        jiaoyijilu.setFont(new java.awt.Font("微软雅黑", 0, 48)); 
	        jiaoyijilu.setText("交易记录");

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
	                .addComponent(jiaoyijilu, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
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
	                        .addComponent(jiaoyijilu, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
	        );

	        PostList.setHorizontalScrollBar(null);

	        PostBody.setMaximumSize(new java.awt.Dimension(1000, 32767));
	        PostBody.setMinimumSize(new java.awt.Dimension(1000, 10));
	        PostBody.setLayout(new java.awt.GridLayout(10, 1));
	        UserSerDB userserdb= new UserSerDB();
	        TradeSerDB tradeserdb = new TradeSerDB();
	        ArrayList r_date = new ArrayList(); 
	        ArrayList r_chargenum = new ArrayList();
	        r_date = tradeserdb.search_recharge_date(user_id); //搜索充值记录，返回ArrayList，为充值时间
	        r_chargenum = tradeserdb.search_recharge_chargenum(user_id); //搜索充值记录，返回ArrayList，为充值金额
	        String[] rd = new String[r_date.size()];
	        String[] rc = new String[r_chargenum.size()];
	        int number1=r_date.size();    //获得购买记录数据数
			ArrayList b_date = new ArrayList();
			ArrayList b_postprice = new ArrayList();
	        b_date = tradeserdb.search_buy_post_date(user_id); //搜索购买记录，返回ArrayList，为购买时间
	        b_postprice = tradeserdb.search_buy_post_price(user_id);//搜索购买记录，返回ArrayList购买金额
	        String[] bd = new String[b_date.size()];
	        String[] bp = new String[b_postprice.size()];
	        int number2=b_date.size();  //获得购买记录数据数
			int trade_num= number1+number2;  //得到总记录数
	        for(int i=0;i<trade_num;i++){
	        	if(i<number1){
	        		rd[i] = r_date.get(i).toString();
	        		rc[i] = r_chargenum.get(i).toString();
	        post[i]=new JPanel();
	        post[i].setMaximumSize(new java.awt.Dimension(1000, 32767));
	        post[i].setMinimumSize(new java.awt.Dimension(1000, 0));
	        
	        jTextField[i]=new JTextField();
	        jTextField[i].setColumns(20);
	        PostSerDB postSerDB=new PostSerDB();       
			jTextField[i].setText("充值时间："+rd[i]+"       充值金额："+ rc[i]);}  //显示充值记录“充值时间：   充值金额：  ”
	        	else{
	        		bd[i-number1] = b_date.get(i-number1).toString();
	        		bp[i-number1] = b_postprice.get(i-number1).toString();
	    	        post[i]=new JPanel();
	    	        post[i].setMaximumSize(new java.awt.Dimension(1000, 32767));
	    	        post[i].setMinimumSize(new java.awt.Dimension(1000, 0));
	    	        
	    	        jTextField[i]=new JTextField();
	    	        jTextField[i].setColumns(20);
	    	        PostSerDB postSerDB=new PostSerDB();       
	    			jTextField[i].setText("购买时间："+bd[i-number1]+"       购买金额："+ bp[i-number1]);} //显示购买记录“购买时间：   购买金额：
			
			jLable[i]=new JLabel();
	        jScrollPane[i]=new JScrollPane();
	        jScrollPane[i].setViewportView(jTextField[i]);
	        jLable[i].setText("");
	        javax.swing.GroupLayout Post1Layout = new javax.swing.GroupLayout(post[i]);
	        post[i].setLayout(Post1Layout);
	        Post1Layout.setHorizontalGroup(
	            Post1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(Post1Layout.createSequentialGroup()
	                .addContainerGap(127, Short.MAX_VALUE)
	                .addComponent(jScrollPane[i], javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(34, 34, 34)
	                .addComponent(jLable[i])
	                .addGap(18, 18, 18)
	                .addComponent(jLable[i])
	                .addGap(18, 18, 18)
	                .addComponent(jLable[i])
	                .addGap(39, 39, 39))
	        );
	        Post1Layout.setVerticalGroup(
	            Post1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(Post1Layout.createSequentialGroup()
	                .addGroup(Post1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(Post1Layout.createSequentialGroup()
	                        .addGap(43, 43, 43)
	                        .addGroup(Post1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                            .addComponent(jLable[i])
	                            .addComponent(jLable[i])
	                            .addComponent(jLable[i])))
	                    .addGroup(Post1Layout.createSequentialGroup()
	                        .addContainerGap()
	                        .addComponent(jScrollPane[i], javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );

	  

	        PostBody.add(post[i]);

	        


	        
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
	    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {
	        Docuement.this.setVisible(false);
	        new MyGold(user_id).setVisible(true);  
	     }

	 
	    private JButton Logout;
	    private JLabel New_Post;

	    private JPanel post[]=new JPanel[100];
	    private javax.swing.JPanel PostBody;
	    private javax.swing.JScrollPane PostList;
	    private JLabel Search;
	    private javax.swing.JLabel jiaoyijilu;
	    private JLabel jLable[]=new JLabel[100];
	    private javax.swing.JPanel Upper;
	    private javax.swing.JLabel Username;
	    private JScrollPane jScrollPane[]=new JScrollPane[100];
	    private JTextField jTextField[]=new JTextField[100];
	    
	    int b;
	    
	    private JLabel private_post;
	    private JLabel save_post;
	    
		PostSerDB posterSerDB=new PostSerDB();
	    
	}
