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
    private javax.swing.JToggleButton cancel;//鍙栨秷鎸夐挳
    private javax.swing.JButton next;//涓嬩竴姝ユ寜閽�
    private javax.swing.JLabel price;
    private javax.swing.JTextField price_input;//浠锋牸杈撳叆
    private javax.swing.JLabel tag;
    private javax.swing.JComboBox<String> tag1;//涓嬫媺妗嗛�夋嫨tag1
    private javax.swing.JComboBox<String> tag2;//涓嬫媺妗嗛�夋嫨tag2
    private javax.swing.JComboBox<String> tag3;//涓嬫媺妗嗛�夋嫨tag3
    private javax.swing.JLabel title;
    private javax.swing.JTextField title_input;//鏍囬杈撳叆
    private javax.swing.JLabel visibility;
    private javax.swing.JComboBox<String> visible;//涓嬫媺妗嗛�夋嫨鍙鎬�
    long post_wrid;

    
    public String[] tag_input() throws IOException{
    	//鑾峰彇tag锛岃繑鍥濻tring[]鏁扮粍
    Map<String,String> maptag=new HashMap<String,String>();//寤虹珛mapping
    FileReader fr = new FileReader("tag.csv");//璇诲彇tag鐨刢sv鏂囦欢
    BufferedReader br = new BufferedReader(fr);
    String  lineStr;
    while((lineStr = br.readLine()) != null) {//浣縯ag鍜屽搴旀暟鍒嗗紑
    	 String arr[]= lineStr.split(",");
    	 maptag.put(arr[0],arr[1]);
    }
	br.close();
	String taginputvalue[] = new String[20]; 
	for(int i=0;i<20;i++){
		//String[] 鏁扮粍鍌ㄥ瓨tag
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
        
        this.post_wrid=user_id;

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        cancel.setText("鍙栨秷");
        cancel.addActionListener(new java.awt.event.ActionListener() {
        	//璁剧疆鍙栨秷鐩戝惉浜嬩欢
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	cancelActionPerformed(evt);
            }
        });

        next.setText("涓嬩竴姝�");
        next.addActionListener(new java.awt.event.ActionListener() {
        	//璁剧疆涓嬩竴姝ョ洃鍚簨浠�
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	nextActionPerformed(evt);
            }
        });

        title.setText("鏍囬锛�1--20瀛楋級");

        visible.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "鍏紑", "浠呭ソ鍙嬪彲瑙�", "浠呰嚜宸卞彲瑙�" }));
        visible.addActionListener(new java.awt.event.ActionListener() {
        	//璁剧疆鍙鎬х洃鍚簨浠�
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	visibleActionPerformed(evt);
            }
        });

        visibility.setText("鍏紑鑼冨洿锛�");

        price.setText("閲戦锛堝彧鑳借緭鍏ユ暣鏁帮級锛�");

        price_input.setText("0");//浠锋牸榛樿鍊间负0
        
        String[] tag_input1 = tag_input();//璋冪敤tag鑾峰彇鏂规硶
        tag1.setModel(new javax.swing.DefaultComboBoxModel<>(tag_input1));
        tag1.addActionListener(new java.awt.event.ActionListener() {
        	//璁剧疆tag1鐩戝惉浜嬩欢
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
        	//璁剧疆tag2鐩戝惉浜嬩欢
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
        	//璁剧疆tag3鐩戝惉浜嬩欢
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					tag3ActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        tag.setText("鏍囩锛�");

        //椤甸潰甯冨眬
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
        
        this.setLocation(350,150);  //璁剧疆鍒濆浣嶇疆  
        pack();//鑷姩璋冩暣椤甸潰澶у皬 
        setResizable(false);
		setLocationRelativeTo(null);
    }

	public void visibleActionPerformed(java.awt.event.ActionEvent e) {                                         
        // 鍙鎬х洃鍚�
    	if(e.getSource()=="鍏紑"){
    		//榛樿涓哄叕寮�锛屾槧灏勭殑榛樿鍊间负0
    		visibile1=0;
    	}
    	else if(e.getSource()=="浠呭ソ鍙嬪彲瑙�"){
    		//浠呭ソ鍙嬪彲瑙侊紝鏄犲皠鍊间负1
    		visibile1=1;
    	}
    	else if(e.getSource()=="浠呰嚜宸卞彲瑙�"){
    		//浠呰嚜宸卞彲瑙侊紝鏄犲皠鍊间负2
    		visibile1=2;
    	}
    }
      
    public void tag1ActionPerformed(java.awt.event.ActionEvent e) throws IOException {                                     
        //tag1鐩戝惉
    	int i;
    	String[] tag_input2 = tag_input();
    	for(i=0;i<20;i++){
    		if(e.getSource()==tag_input2[i]){
    			post_tag1=i+1;
    		}
    	}
    }  
    
    public void tag2ActionPerformed(java.awt.event.ActionEvent e) throws IOException {                                     
        //tag2鐩戝惉
    	int i;
    	String[] tag_input2 = tag_input();
    	for(i=0;i<20;i++){
    		if(e.getSource()==tag_input2[i]){
    			post_tag2=i+1;
    		}
    	}
    } 
    
    public void tag3ActionPerformed(java.awt.event.ActionEvent e) throws IOException {                                     
        //tag3鐩戝惉
    	int i;
    	String[] tag_input2 = tag_input();
    	for(i=0;i<20;i++){
    		if(e.getSource()==tag_input2[i]){
    			post_tag3=i+1;
    		}
    	}
    } 
    
    public void cancelActionPerformed(java.awt.event.ActionEvent evt) {
        //鍙栨秷鐩戝惉
    	PostSerDB p_head=new PostSerDB();
    	long post_nowid=p_head.post();
//    	p_head.delpost(post_nowid);//璋冪敤褰撳墠甯栧瓙ID锛屽垹闄ゆ暟鎹簱涓殑甯栧瓙
    	setVisible(false);
    }
    
    private void nextActionPerformed(java.awt.event.ActionEvent evt) {                                     
        //涓嬩竴姝ョ洃鍚�
    	PostSerDB p_head=new PostSerDB();
    	long post_nowid=p_head.post();//绯荤粺鑷姩鍒嗛厤褰撳墠甯栧瓙ID
    	
    	String post_title=title_input.getText();//鑾峰彇鏍囬
    	
    	int post_price = 0;
    	String post_pr=price_input.getText();//鑾峰彇浠锋牸
    	int post_pr1=Integer.parseInt(post_pr);
    	
    	if(post_title.equals("")){
    		//鏍囬涓嶈兘涓虹┖
    		JOptionPane.showMessageDialog(null, "璇疯緭鍏ユ爣棰橈紒"); 
    	}
    	else if(post_title.length()>20){
    		//鏍囬涓嶈兘瓒呰繃20瀛�
    		JOptionPane.showMessageDialog(null, "鏍囬涓嶈兘瓒呰繃20瀛楋紒");
    	}
    	else{
        	if(post_pr1>=0){
        		post_price=post_pr1;
        		p_head.post_head(post_nowid,post_wrid,post_title,post_tag1,post_tag2,post_tag3,visibile1,post_price);
        		//璋冪敤post_head()锛屽悜鏁版嵁搴撲紶杈撴暟鎹�
        		setVisible(false);//褰撳墠椤甸潰闅愯棌
        		Post_page1 p_p1 = new Post_page1(post_nowid,post_wrid);//璋冪敤Post_page1锛岃繘鍏ヤ笅涓�姝�
        		p_p1.setVisible(true);//鍙戝笘姝ｅ紡绗竴姝ュ彲瑙�
        	}
        	else{
        		//浠锋牸涓嶈兘灏忎簬0
        		JOptionPane.showMessageDialog(null, "璇疯緭鍏ユ纭殑閲戦锛�");
        	}
    	}
    }                                    
    
}




