package com.vnc_billing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Vector;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class vnc_admin extends JFrame implements ActionListener
{
	private JLabel jl1, jl2, jl3, jl4;
	private JTextField jt1;
	private JPasswordField jp1;
	private JButton jb1, jb2, jb3, jb4;
	private ImageIcon i1, i2, i3;
	private Font f1, f2;
	public vnc_admin()
	{
		i1=new ImageIcon("C:\\Users\\vinee\\OneDrive\\Pictures\\Saved Pictures\\Admin-1.jpg");
		f1=new Font("Calibri (Body)",140, 18);
		f2=new Font("Calibri (Body)",180, 16);
		
		jl1=new JLabel("Username");
		jl2=new JLabel("Password"); 
		jt1=new JTextField();
		jp1=new JPasswordField();
		jb1=new JButton("Login");
		jb1.setFont(f1);
		jb1.setBackground(Color.blue);
		jb1.setForeground(Color.WHITE);
		
		jb2=new	JButton("Forgot password?");
		jb2.setFont(f2);
		jb2.setBackground(Color.BLUE);
		jb2.setForeground(Color.white);
		
		jb3=new JButton("Sing up");
		jb3.setFont(f1);
		jb3.setBackground(Color.blue);
		jb3.setForeground(Color.WHITE);;
		jb4=new JButton("Clear");
		jb4.setFont(f1);
		jb4.setBackground(Color.blue);
		jb4.setForeground(Color.WHITE);
		
		jl3=new JLabel(i1);
		
		//	calling container with empty space
		
		setLayout(null);
		
		jl1.setBounds(890, 265, 120, 40);
		jl2.setBounds(890, 305, 120, 40);
		jt1.setBounds(1000, 275, 200, 25);
		jp1.setBounds(1000, 315, 200, 25);
		
		jb2.setBounds(1015, 360, 180, 25);
		
		jb1.setBounds(1050, 415, 80, 25);
		jb4.setBounds(950, 415, 80, 25);
		
		jb3.setBounds(985, 470, 100, 25);
		jl3.setBounds(0, 0, 1366, 786);
		
		add(jl1);
		add(jl2);
		add(jt1);
		add(jp1);
		add(jb1);
		add(jb4);
		add(jb2);
		add(jb3);
		add(jl3);
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource().equals(jb3))
		{
			//	Create Account Action
			vnc_admin_register l=new vnc_admin_register();
		 	l.setTitle("Admin Register");
			l.setFont(new Font("TimesRoman",Font.ITALIC, 20));
			l.setSize(1366,786);
			l.setDefaultCloseOperation(vnc_admin_register.EXIT_ON_CLOSE);
			l.setVisible(true);
		}
		if(e.getSource().equals(jb2))
		{
			// Forgot Password Action

			vnc_admin_forgetpassword l=new vnc_admin_forgetpassword(); 
		 	l.setTitle("Institute");
			l.setFont(new Font("TimesRoman",Font.ITALIC, 20));
			l.setSize(1366,786);
			l.setDefaultCloseOperation(vnc_admin.EXIT_ON_CLOSE);
			l.setVisible(true);
		
		}
		
		if(e.getSource().equals(jb1))
		{
			// Login Action
			try
			{
				String U_id=jt1.getText();
				String U_pass =jp1.getText();

				FileInputStream fi=new FileInputStream("C:\\Users\\vinee\\OneDrive\\Desktop\\Java\\Practice\\Collections Frame Works\\com.vnc_billing\\jdbc.properties");
				Properties p=new Properties();
				p.load(fi);
				Class.forName(p.getProperty("jdbc.driver"));
				RowSetFactory rf=RowSetProvider.newFactory();
				JdbcRowSet jr=rf.createJdbcRowSet();
				jr.setUrl(p.getProperty("jdbc.url"));
				jr.setUsername(p.getProperty("jdbc.username"));
				jr.setPassword(p.getProperty("jdbc.password"));
				jr.setCommand("select username, password from institute_admin");
				jr.execute();
				
				Connection con=DriverManager.getConnection(p.getProperty("jdbc.url"), p.getProperty("jdbc.username"), p.getProperty("jdbc.password"));
				
				Vector v=new Vector();
				
				for(;jr.next();)
				{
					v.add(jr.getString("username"));
					v.add(jr.getString("password"));
				}
				if(v.contains(U_id) && v.contains(U_pass))
				{
					VNC_Users_Loginpage v1=new VNC_Users_Loginpage();
					v1.setTitle("Institute");
					v1.setFont(new Font("TimesRoman",Font.ITALIC, 20));
					v1.setSize(1366,786);
					v1.setDefaultCloseOperation(VNC_Users_Loginpage.EXIT_ON_CLOSE);
					v1.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(this, "Invalid Username or Password");
				}
			}
			catch (Exception e1) {
				// TODO: handle exception
				e1.printStackTrace();
			}
			
		}

		if(e.getSource().equals(jb4))
		{
			//	Clear Action
			this.jt1.setText("");
			this.jp1.setText("");
		}
	}
	
}
