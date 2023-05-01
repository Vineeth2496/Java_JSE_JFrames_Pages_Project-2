package com.vnc_billing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class vnc_admin_forgetpassword extends JFrame implements ActionListener
{
	private JLabel  jl1, jl2, jl3,jl4, jl5, jl6;	//jl
	private JButton jb1, jb2, jb3;
	private JTextField jt1, jt2;
	private ImageIcon i1, i2;
	private Font f1, f2;
	 public vnc_admin_forgetpassword() {
		i1=new ImageIcon("C:\\Users\\vinee\\OneDrive\\Pictures\\Saved Pictures\\forgetpass.jpg");
		f1=new Font("Calibri (Body)",140, 18);
				
		jl1=new JLabel("Username");
		jl2=new JLabel("New Password");
		jt1=new JTextField("");
		jt2=new JTextField("");
		
		jb1=new JButton("Reset Password");
		jb1.setFont(f1);
		jb1.setBackground(Color.BLUE);
		jb1.setForeground(Color.WHITE);
		
		jb2=new JButton("Create New Account");
		jb2.setFont(f1);
		jb2.setBackground(Color.BLUE);
		jb2.setForeground(Color.WHITE);
		
		jb3=new JButton("Back to Login");
		jb3.setFont(f1);
		jb3.setBackground(Color.BLUE);
		jb3.setForeground(Color.WHITE);
		
		jl5=new JLabel(i1);
		//	calling container with empty space
		setLayout(null);

		// After calling, then  arrange components into frame particular position
		
		jl1.setBounds(820, 275, 120, 40);
		jl2.setBounds(820, 315, 120, 40);
		jt1.setBounds(950, 285, 200, 25);
		jt2.setBounds(950, 325, 200, 25);
		
		jb1.setBounds(900, 380, 200, 25);
		jb2.setBounds(900, 450, 200, 25);
		jb3.setBounds(900, 520, 200, 25);
	
		
		jl5.setBounds(0, 0, 1366, 786);
		//	the above value add in conatiner
		
		//	add(jl);
		add(jl1);
		add(jl2);
		
		add(jt1);
		add(jt2);
		
		add(jb1);
		add(jb2);
		add(jb3);
		
		add(jl5);
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		}
	 public void actionPerformed(ActionEvent e)
	 {
		if(e.getSource().equals(jb2))
		{
			// create account page
			vnc_admin_register l=new vnc_admin_register();
		 	l.setTitle("Institute");
			l.setFont(new Font("TimesRoman",Font.ITALIC, 20));
			l.setSize(1366,786);
			l.setDefaultCloseOperation(vnc_admin_register.EXIT_ON_CLOSE);
			l.setVisible(true);
		}
		if(e.getSource().equals(jb3))
		{
			// Login Page
			vnc_admin l=new vnc_admin();
		 	l.setTitle("Institute");
			l.setFont(new Font("TimesRoman",Font.ITALIC, 20));
			l.setSize(1366,786);
			l.setDefaultCloseOperation(vnc_admin.EXIT_ON_CLOSE);
			l.setVisible(true);
		}
		if(e.getSource().equals(jb1))
		{
			// Reset password
			try 
			{
				String U_id =jt1.getText();
				String U_Npass =jt2.getText();
				
				FileInputStream fi=new FileInputStream("C:\\Users\\vinee\\OneDrive\\Desktop\\Java\\Practice\\Collections Frame Works\\com.vnc_billing\\jdbc.properties");
				Properties p=new Properties();
				p.load(fi);
				Class.forName(p.getProperty("jdbc.driver")).newInstance();
				Connection con=DriverManager.getConnection(p.getProperty("jdbc.url"), p.getProperty("jdbc.username"), p.getProperty("jdbc.password"));
				
				PreparedStatement pst=con.prepareStatement("update institute_admin set password=? where username=?");
				pst.setString(1, U_Npass);
				pst.setString(2, U_id);
				int i=pst.executeUpdate();
				
				System.out.println("Update: "+i);
				
				JOptionPane.showMessageDialog(this, "Admin Password is Reseted "+"\n"+"Username: "+U_id+"\n"+"Password "+U_Npass);
				
			}
			catch (Exception e1) {
				// TODO: handle exception
				e1.printStackTrace();
			}
		}
	 }
	 
}

