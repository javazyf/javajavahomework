/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;

import javax.swing.AbstractButton;
import javax.swing.JTextField;
import db.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Sea_Post extends javax.swing.JFrame {
    
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
   // private javax.swing.JTextField 发布者;
    private javax.swing.JButton quxiao;
    private javax.swing.JLabel sousuocaipu;
    private javax.swing.JComboBox<String> Result_Poster;
    private javax.swing.JComboBox<String> Tag1;
    private javax.swing.JComboBox<String> Tag2;
    private javax.swing.JComboBox<String> Tag3;
   // private javax.swing.JTextField 标题;
    private javax.swing.JButton quding;
   // private javax.swing.JTextField 自定义搜索条件;
    private javax.swing.JTextField xuanzebiaoqian;
   // private javax.swing.JTextField 输入发布者昵称;
   // private javax.swing.JTextField 输入标题;
    private static ArrayList p;
    
    private int post_Tag1,post_Tag2,post_Tag3;
    
    public String[] tag_input() throws IOException{
        Map<String,String> maptag=new HashMap<String,String>();
//    	File csvFile = new File("D:\\tag.csv");
        FileReader fr = new FileReader("d:\\tag.csv");
        BufferedReader br = new BufferedReader(fr);
        String  lineStr;
        while((lineStr = br.readLine()) != null) {
        	 String arr[]= lineStr.split(",");
        	 maptag.put(arr[0],arr[1]);
        }
    	br.close();
//    	String taginputvalue = null;
    	String taginputvalue[] = new String[20]; 
    	for(int i=0;i<20;i++){
    		String taginputkey=String.valueOf(i+1);
    		taginputvalue[i]=maptag.get(taginputkey);
    	}
    	return taginputvalue;
        }
    
    public Sea_Post() throws IOException {
      
        Result_Poster = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
       // 输入发布者昵称 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
       // 输入标题 = new javax.swing.JTextField();
        Tag3 = new javax.swing.JComboBox<>();
        Tag2 = new javax.swing.JComboBox<>();
        Tag1 = new javax.swing.JComboBox<>();
       // 标题 = new javax.swing.JTextField();
       // 发布者 = new javax.swing.JTextField();
        quxiao = new javax.swing.JButton();
        quding = new javax.swing.JButton();
       // 自定义搜索条件 = new javax.swing.JTextField();
        xuanzebiaoqian = new javax.swing.JTextField();
        sousuocaipu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        
        Result_Poster.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Result_Poster.setToolTipText("");
        Result_Poster.setName("Result_Poster"); // NOI18N

        //输入发布者昵称.setToolTipText("");
        //jScrollPane2.setViewportView(输入发布者昵称);

        //输入标题.setToolTipText("");
        //jScrollPane3.setViewportView(输入标题);
        
        String[] tag_input1 = tag_input();
        Tag1.setModel(new javax.swing.DefaultComboBoxModel<>(tag_input1));
        Tag1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					Tag1ActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        Tag3.setModel(new javax.swing.DefaultComboBoxModel<>(tag_input1));
        Tag3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					Tag3ActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        Tag3.setOpaque(false);

        Tag2.setModel(new javax.swing.DefaultComboBoxModel<>(tag_input1));
        Tag2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					Tag2ActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        Tag2.setOpaque(false);

       /* 标题.setText("标  题 ：");

        发布者.setText("发布者 ：");
        发布者.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                发布者ActionPerformed(evt);
            }
        });

        自定义搜索条件.setText("自定义搜索条件");*/

        xuanzebiaoqian.setText("请选择标签");

        sousuocaipu.setText("搜索菜谱");
        quxiao.setText("取消");
        quding.setText("确定");
        quding.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                qudingMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                   // .addComponent(自定义搜索条件)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                //.addComponent(标题, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                //.addComponent(发布者, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(quding, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Result_Poster, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane3)
                                .addComponent(jScrollPane2)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(Tag2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(Tag3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(xuanzebiaoqian)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(sousuocaipu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(quxiao)))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quxiao)
                    .addComponent(sousuocaipu))
                .addGap(8, 8, 8)
                //.addComponent(自定义搜索条件)
                .addGap(18, 18, 18)
                .addComponent(xuanzebiaoqian)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Result_Poster, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Tag1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Tag2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Tag3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                       //.addComponent(标题, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    //.addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    //.addComponent(发布者, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(quding)
                .addGap(49, 49, 49))
                    )
                )
            );
        
//        pack();
    }    
    
    public void Tag1ActionPerformed(java.awt.event.ActionEvent e) throws IOException {                                     
        //
    	int i;
    	String[] tag_input2 = tag_input();
    	for(i=0;i<20;i++){
    		if(e.getSource()==tag_input2[i]){
    			post_Tag1=i+1;
    		}
    	}
    }  
    
    public void Tag2ActionPerformed(java.awt.event.ActionEvent e) throws IOException {                                     
        //
    	int i;
    	String[] tag_input2 = tag_input();
    	for(i=0;i<20;i++){
    		if(e.getSource()==tag_input2[i]){
    			post_Tag2=i+1;
    		}
    	}
    }  
    
    public void Tag3ActionPerformed(java.awt.event.ActionEvent e) throws IOException {                                     
        //
    	int i;
    	String[] tag_input2 = tag_input();
    	for(i=0;i<20;i++){
    		if(e.getSource()==tag_input2[i]){
    			post_Tag3=i+1;
    		}
    	}
    }  
    
    private void qudingMouseClicked(java.awt.event.MouseEvent evt) {                                

    	long pid = 0;
        UserSerDB userserdb = new UserSerDB();
        SearchSerDB searserdb = new SearchSerDB();
        ArrayList r1 = new ArrayList();
        ArrayList r2 = new ArrayList();
        ArrayList r3 = new ArrayList();
        r1 = searserdb.search_tag(post_Tag1);
        r2 = searserdb.search_tag(post_Tag2);
        r3 = searserdb.search_tag(post_Tag3);
        int i;
        int j=0;
        int m=0;
        int n=0;
        for(i=0;i<=r1.size();i++){
        	for(j=0;j<=r2.size();j++){
        		if(r1.get(i).equals(r2.get(j))){
        			r1.add(r2.get(j));
        		}
        	}
        }
        
        for(m=0;m<=r1.size();m++){
        	for(n=0;n<=r3.size();n++){
        		if(r1.get(m).equals(r3.get(n))){
        			r1.add(r2.get(n));
        		}
        	}
        
        p = new ArrayList();
        p = r1; 
        
        
        new Result_Post(p).setVisible(true);
        }
    }                               


	public static ArrayList getP() {
		return p;
	}

	public void setP(ArrayList p) {
		this.p = p;
	}
}