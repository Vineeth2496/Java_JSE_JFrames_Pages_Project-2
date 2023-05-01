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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class vnc_admin_register extends JFrame implements ActionListener
{
		private JLabel  jl1, jl2, jl3, jl4, jl5;
		private JButton jb1, jb2, jb3;
		private JTextField jt1, jt2;
		private JPasswordField jp1;
		private ImageIcon i1;
		private Font f1, f2, f3;
		
	public vnc_admin_register()
	{
		i1=new ImageIcon("C:\\Users\\vinee\\OneDrive\\Pictures\\Saved Pictures\\admin.jpg");
		f1=new Font("Bookman Old Style",100, 18);
		f2=new Font("Calibri (Body)",150, 16);
		f3=new Font("Bookman Old Style",100, 18);
		
		jl1=new JLabel("Institute:");
		jl1.setFont(f1);
		jl1.setForeground(Color.BLACK);
		jt1=new JTextField("");
		
		
		jl2=new JLabel("Username:");
		jl2.setFont(f1);
		jl2.setForeground(Color.BLACK);
		jt2=new JTextField("");
		
		jl3=new JLabel("Password:	");
		jl3.setFont(f1);
		jl3.setForeground(Color.BLACK);
		jp1=new JPasswordField("");
		
		jb1=new JButton("Sing up");
		jb1.setFont(f2);
		jb1.setBackground(Color.blue);
		jb1.setForeground(Color.white);
		
		jb2=new JButton("Clear");
		jb2.setFont(f2);
		jb2.setBackground(Color.blue);
		jb2.setForeground(Color.white);
		
		jl4=new JLabel("Have an account?");
		jl4.setFont(f3);
		jl4.setForeground(Color.black);
		
		jb3=new JButton("Log in");
		jb3.setFont(f2);
		jb3.setBackground(Color.blue);
		jb3.setForeground(Color.white);
		
		jl5=new JLabel(i1);
		
		// Calling Container with empty spaces
		
		setLayout(null);
		
		jl1.setBounds(490, 225, 120, 40);
		jt1.setBounds(620, 230, 230, 30);
	
		jl2.setBounds(490, 260, 120, 40);
		jt2.setBounds(620, 265, 230, 30);
		
		jl3.setBounds(490, 295, 120, 40);
		jp1.setBounds(620, 300, 230, 30);
	
		jb1.setBounds(670, 350, 100, 30);
		jb2.setBounds(570, 350, 80, 30);
		
		jl4.setBounds(520, 400, 200, 30);
		jb3.setBounds(700, 404, 80, 25);
			
		jl5.setBounds(0, 0, 1366, 786);
		
		add(jl1);
		add(jt1);
		
		add(jl2);
		add(jt2);
		
		add(jl3);
		add(jp1);
		
		add(jb1);
		add(jb2);
		
		add(jl4);
		add(jb3);
		
		add(jl5);
		
		jb1.addActionListener(this);
		jb3.addActionListener(this);
		jb2.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource().equals(jb1))
		{
			try 
			{
				String institute=jt1.getText();
				String username=jt2.getText();
				String password=jp1.getText();
				
				
				FileInputStream fi=new FileInputStream("C:\\Users\\vinee\\OneDrive\\Desktop\\Java\\Practice\\Collections Frame Works\\com.vnc_billing\\jdbc.properties");
				Properties p=new Properties();
				p.load(fi);
				Class.forName(p.getProperty("jdbc.driver")).newInstance();
				Connection con=DriverManager.getConnection(p.getProperty("jdbc.url"), p.getProperty("jdbc.username"), p.getProperty("jdbc.password"));
				
				PreparedStatement pst=con.prepareStatement("insert into institute_admin values(?, ?, ?)");
				pst.setString(1, institute);
				pst.setString(2, username);
				pst.setString(3, password);
		
				int i=pst.executeUpdate();
				
				System.out.println("Update: "+i);
				
				JOptionPane.showMessageDialog(this, "Institute Admin Account is Created"+"\n"+"Username: "+username+"\n"+"Password "+password);
			
			}
			catch (Exception e1) {
				// TODO: handle exception
				e1.printStackTrace();
			}
		}

		if(e.getSource().equals(jb3))
		{
			vnc_admin l1=new vnc_admin();
			l1.setTitle("Institute Admin");
			l1.setSize(1366, 786);
			l1.setVisible(true);
		}
		if(e.getSource().equals(jb2))
		{
			this.jt1.setText("");
			this.jt2.setText("");
			this.jp1.setText("");
		}
		
		
	}
	
}
