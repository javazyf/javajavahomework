package post_upload;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;
import db.*;
import View.*;


public class Post_other extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	
	private static int visibile1;
    private static int post_tag1,post_tag2,post_tag3;
	
    private BackGroundJPanel jPanel1;
    private javax.swing.JToggleButton cancel;//取消
    private javax.swing.JButton next;//下一步
    private javax.swing.JLabel price;
    private javax.swing.JTextField price_input;//输入价格
    private javax.swing.JLabel tag;
    private javax.swing.JComboBox<String> tag1;//获取tag1
    private javax.swing.JComboBox<String> tag2;//获取tag2
    private javax.swing.JComboBox<String> tag3;//获取tag3
    private javax.swing.JLabel title;
    private javax.swing.JTextField title_input;//输入标题
    private javax.swing.JLabel visibility;
    private javax.swing.JComboBox<String> visible;//选择可见性
    long post_wrid;
    
    public String[] tag_input() throws IOException{
    	//读入tag
    Map<String,String> maptag=new HashMap<String,String>();//设置mapping
    FileReader fr = new FileReader("tag.csv");//CSV文件
    BufferedReader br = new BufferedReader(fr);
    String  lineStr;
    while((lineStr = br.readLine()) != null) {
    	//读取key-value映射
    	 String arr[]= lineStr.split(",");
    	 maptag.put(arr[0],arr[1]);
    }
	br.close();
	String taginputvalue[] = new String[20]; 
	for(int i=0;i<20;i++){
		//String[] 存取tag
		String taginputkey=String.valueOf(i+1);
		taginputvalue[i]=maptag.get(taginputkey);
	}
	return taginputvalue;
    }
 
    public Post_other(long user_id) throws IOException {
    	
    	jPanel1 = new BackGroundJPanel();
        title_input = new javax.swing.JTextField();
        cancel = new javax.swing.JToggleButton();
        next = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        visible = new javax.swing.JComboBox<>();
        visibility = new javax.swing.JLabel();
        price = new javax.swing.JLabel();
        price_input = new javax.swing.JTextField();
        tag1 = new javax.swing.JComboBox<>();
        tag2 = new javax.swing.JComboBox<>();
        tag3 = new javax.swing.JComboBox<>();
        tag = new javax.swing.JLabel();
        
        this.post_wrid=user_id;//接收用户ID

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        cancel.setText("取消");
        cancel.addActionListener(new java.awt.event.ActionListener() {
        	//设置取消监听事件
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	cancelActionPerformed(evt);
            }
        });

        next.setText("下一步");
        next.addActionListener(new java.awt.event.ActionListener() {
        	//设置下一步监听事件
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	nextActionPerformed(evt);
            }
        });

        title.setText("标题（1--20字）");

        visible.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "公开", "仅朋友可见", "仅自己可见" }));
        visible.addActionListener(new java.awt.event.ActionListener() {
        	//设置可见性监听事件
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	visibleActionPerformed(evt);
            }
        });

        visibility.setText("发布范围");

        price.setText("金额（请输入正整数）");

        price_input.setText("0");//默认金额为0
        
        String[] tag_input1 = tag_input();//调用 tag_input()，获取tag列表
        tag1.setModel(new javax.swing.DefaultComboBoxModel<>(tag_input1));
        tag1.addActionListener(new java.awt.event.ActionListener() {
        	//设置tag1监听事件
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					tag1ActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        tag2.setModel(new javax.swing.DefaultComboBoxModel<>(tag_input1));
        tag2.addActionListener(new java.awt.event.ActionListener() {
        	//设置tag2监听事件
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					tag2ActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        tag3.setModel(new javax.swing.DefaultComboBoxModel<>(tag_input1));
        tag3.addActionListener(new java.awt.event.ActionListener() {
        	//设置tag3监听事件
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					tag3ActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        tag.setText("标签");

        //页面布局
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(title)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(tag)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(tag3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tag1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tag2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cancel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(visibility)
                    .addComponent(visible)
                    .addComponent(title_input, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(price)
                    .addComponent(price_input, javax.swing.GroupLayout.PREFERRED_SIZE, 100,javax.swing.GroupLayout.DEFAULT_SIZE)
                    .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(title_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(visibility, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tag, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(visible)
                            .addComponent(tag1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(price_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)   
                    .addComponent(tag2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)              
                    .addComponent(tag3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancel)
                    .addComponent(next))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        
        this.setLocation(350,150);  //设置初始位置
        pack();
        setResizable(false);
		setLocationRelativeTo(null);
    }

	public void visibleActionPerformed(java.awt.event.ActionEvent e) {                                         
        //可见性监听
    	if(e.getSource()=="公开"){
    		//默认值为0
    		visibile1=0;
    	}
    	else if(e.getSource()=="仅朋友可见"){
    		//仅朋友可见为1
    		visibile1=1;
    	}
    	else if(e.getSource()=="仅自己可见"){
    		//仅自己可见为2
    		visibile1=2;
    	}
    }
      
    public void tag1ActionPerformed(java.awt.event.ActionEvent e) throws IOException {                                     
        //tag1监听
    	int i;
    	String[] tag_input2 = tag_input();
    	for(i=0;i<20;i++){
    		if(e.getSource()==tag_input2[i]){
    			post_tag1=i+1;
    		}
    	}
    }  
    
    public void tag2ActionPerformed(java.awt.event.ActionEvent e) throws IOException {                                     
        //tag2监听
    	int i;
    	String[] tag_input2 = tag_input();
    	for(i=0;i<20;i++){
    		if(e.getSource()==tag_input2[i]){
    			post_tag2=i+1;
    		}
    	}
    } 
    
    public void tag3ActionPerformed(java.awt.event.ActionEvent e) throws IOException {                                     
        //tag3监听
    	int i;
    	String[] tag_input2 = tag_input();
    	for(i=0;i<20;i++){
    		if(e.getSource()==tag_input2[i]){
    			post_tag3=i+1;
    		}
    	}
    } 
    
    public void cancelActionPerformed(java.awt.event.ActionEvent evt) {
        //取消监听
    	PostSerDB p_head=new PostSerDB();
    	long post_nowid=p_head.post();
    	setVisible(false);
    }
    
    private void nextActionPerformed(java.awt.event.ActionEvent evt) {                                     
        //下一步监听
    	PostSerDB p_head=new PostSerDB();
    	long post_nowid=p_head.post();//分配当前帖子ID
    	
    	String post_title=title_input.getText();//获取标题
    	int post_price = 0;
    	String post_pr=price_input.getText();//获取价格
    	int post_pr1=Integer.parseInt(post_pr);//价格转为int型
    	System.out.println(post_nowid);
    	System.out.println(post_wrid);
    	if(post_title.equals("")){
    		//标题不能为0
    		JOptionPane.showMessageDialog(null, "标题不能为0！"); 
    	}
    	else if(post_title.length()>20){
    		//标题字数不能超过20字
    		JOptionPane.showMessageDialog(null, "标题字数不能超过20字！");
    	}
    	else{
        	if(post_pr1>=0){
        		post_price=post_pr1;
        		p_head.post_head(post_nowid,post_wrid,post_title,post_tag1,post_tag2,post_tag3,visibile1,post_price);
        		//调用post_head()，传送当前数据到数据库
        		setVisible(false);//当前页面不可见
        		Post_page1 p_p1 = new Post_page1(post_nowid,post_wrid);//调用Post_page1，进入发帖内容第一步
        		p_p1.setVisible(true);//第一步可见
        	}
        	else{
        		//价格小于0或者输入除数字以外的字符
        		JOptionPane.showMessageDialog(null, "请输入正确的金额！");
        	}
    	}
    }                                    
    
}




