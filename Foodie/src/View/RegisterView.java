package View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import java.util.Date;

import db.*;

public class RegisterView extends javax.swing.JFrame {
    private javax.swing.JButton register;
    private javax.swing.JButton back;
    
    private javax.swing.JComboBox<String> sex1;
    private javax.swing.JComboBox<String> year1;
    private javax.swing.JComboBox<String> month1;
    private javax.swing.JComboBox<String> day1;
    
    private javax.swing.JLabel title;
    private javax.swing.JLabel month;
    private javax.swing.JLabel day;
    private javax.swing.JLabel account;
    private javax.swing.JLabel password;
    private javax.swing.JLabel name;
    private javax.swing.JLabel sex;
    private javax.swing.JLabel birthday;
    private javax.swing.JLabel phonenum;
    private javax.swing.JLabel email;
    private javax.swing.JLabel year;
    
    private BackGroundJPanel jPanel1;
    
    private javax.swing.JTextField account1;
    private javax.swing.JPasswordField password1;
    private javax.swing.JTextField phonenum1;
    private javax.swing.JTextField name1;
    private javax.swing.JTextField email1;

    public RegisterView(){

        jPanel1 = new BackGroundJPanel();
        title = new javax.swing.JLabel();
        account = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        sex = new javax.swing.JLabel();
        birthday = new javax.swing.JLabel();
        phonenum = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        register = new javax.swing.JButton();
        back = new javax.swing.JButton();
        
        sex1 = new javax.swing.JComboBox<>();
        
        year1 = new javax.swing.JComboBox<>();
        year = new javax.swing.JLabel();
        month1 = new javax.swing.JComboBox<>();
        month = new javax.swing.JLabel();
        day1 = new javax.swing.JComboBox<>();
        day = new javax.swing.JLabel();
        
        account1 = new javax.swing.JTextField();
        password1 = new javax.swing.JPasswordField();
        phonenum1 = new javax.swing.JTextField();
        name1 = new javax.swing.JTextField();
        email1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        title.setFont(new java.awt.Font("宋体", 0, 24));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("注册");
        title.setToolTipText("");

        account.setText("用户名：");
        account.setToolTipText("");
        
        password.setText("密码(纯数字）：");
        password.setToolTipText("");

        name.setText("昵称：");
        name.setToolTipText("");

        sex.setText("性别：");
        sex.setToolTipText("");
 
        birthday.setText("生日：");
        birthday.setToolTipText("");

        phonenum.setText("电话：");
        phonenum.setToolTipText("");

        email.setText("邮箱：");
        email.setToolTipText("");
        
        account1.setToolTipText("");
        password1.setToolTipText("");
        phonenum1.setToolTipText("");
        name1.setToolTipText("");
        email1.setToolTipText("");

        register.setText("注册");
        register.setToolTipText("");
        
        register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
    			String Account = String.valueOf(account1.getText());
    			String Name = String.valueOf(name1.getText());
    			String Phonenum = String.valueOf(phonenum1.getText());
    			String Email = String.valueOf(email1.getText());
    			String Password = String.valueOf(password1.getPassword());
    			
    			boolean Sex;
    			if ((sex1.getSelectedItem()).equals("男"))
    				Sex = true;
    			else
    				Sex = false;
    			
    			String Birthday = (String)year1.getSelectedItem() + (String)month1.getSelectedItem() + (String)day1.getSelectedItem();
   
            	if (!Account.isEmpty() && !Name.isEmpty() && !Phonenum.isEmpty() 
            			&& !Email.isEmpty() && !Password.isEmpty() && Email.matches("(.*)@(.*)")){
            		if(Password.matches("[0-9]+")){
            			long Npassword = Long.parseLong(Password);
            			new RegisterSerDB().insert(Account, Npassword, Name, Sex, Birthday ,Phonenum, Email);
            			JOptionPane.showMessageDialog(null, "注册成功！", "提示信息",JOptionPane.WARNING_MESSAGE);
            			new Login().setVisible(true);
            			RegisterView.this.setVisible(false);
            		}
            		else
            			JOptionPane.showMessageDialog(null, "密码格式错误！", "提示信息",JOptionPane.WARNING_MESSAGE);
            		}
            	else
            		JOptionPane.showMessageDialog(null, "有项目为空或错误！", "提示信息",JOptionPane.WARNING_MESSAGE);
            }
        });

        back.setText("返回");
        back.setToolTipText("");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	new Login().setVisible(true);
    			RegisterView.this.setVisible(false);
            }
        });



        sex1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "男", "女" }));

        year1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050" }));

        year.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        year.setText("年");

        month1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        month.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        month.setText("月");
        month.setToolTipText("");

        day1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        day.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        day.setText("日");
        day.setToolTipText("");


        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(register)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(back))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(account)
                                    .addComponent(password)
                                    .addComponent(name)
                                    .addComponent(sex)
                                    .addComponent(birthday)
                                    .addComponent(phonenum)
                                    .addComponent(email))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(name1)
                                    .addComponent(account1)
                                    .addComponent(password1)
                                    .addComponent(sex1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(year1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(month1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(month, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                                    .addComponent(phonenum1)
                                    .addComponent(email1))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(day1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(day)))
                .addContainerGap(122, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(account)
                    .addComponent(account1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password)
                    .addComponent(password1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name)
                    .addComponent(name1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sex)
                    .addComponent(sex1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(birthday)
                    .addComponent(year1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(year)
                    .addComponent(month1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(month)
                    .addComponent(day1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(day))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phonenum)
                    .addComponent(phonenum1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email)
                    .addComponent(email1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(register)
                    .addComponent(back))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setTitle("注册");
		setResizable(false);
		setLocationRelativeTo(null);
    }

}
