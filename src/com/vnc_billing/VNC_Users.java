package com.vnc_billing;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class VNC_Users extends JFrame implements ActionListener{
	
	public  String yk_un="vnc001";
	public  String ram_un="vnc002";
	public  String sun_un="vnc003";
	public  String prm_un="vnc004";
	private JLabel jl11;
	private JButton  jb1, jb2, jb3,jb4;
	private ImageIcon i1, i2;
	private Font f1, f2, f3, f4;
	
	
	public VNC_Users()
	{
		i1=new ImageIcon("C:\\Users\\vinee\\OneDrive\\Pictures\\Saved Pictures\\Register.jpg");
		f1=new Font("Bookman Old Style",100, 18);
		f2=new Font("Calibri (Body)",150, 16);
			
		jb1=new JButton("YKS");
		jb1.setFont(f2);
		jb1.setBackground(Color.blue);
		jb1.setForeground(Color.white);
		
		jb2=new JButton("RAMESH");
		jb2.setFont(f2);
		jb2.setBackground(Color.blue);
		jb2.setForeground(Color.white);		
	
		jb3=new JButton("SUNITHA");
		jb3.setFont(f2);
		jb3.setBackground(Color.blue);
		jb3.setForeground(Color.white);
		
		jb4=new JButton("PRANITHA");
		jb4.setFont(f2);
		jb4.setBackground(Color.blue);
		jb4.setForeground(Color.white);
	
	jl11 = new JLabel(i1);
		
		//	calling container with empty space
		setLayout(null);
		
		//	After calling, then  arrange components into frame particular position
		//	jl.setBounds(600, 35, 180, 9
		
		
		
		jb1.setBounds(600, 200, 120, 30);
		jb2.setBounds(600, 300, 120, 30);
		jb3.setBounds(600, 400, 120, 30);
		jb4.setBounds(600, 500, 120, 30);

		jl11.setBounds(0, 0, 1366, 786);
		
		
		//	the above value add in conatiner
		
		add(jb1);
		add(jb2);
		add(jb3);
		add(jb4);
		add(jl11);
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);

		
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource().equals(jb1))
		{
			VNC_Users_Loginpage l=new VNC_Users_Loginpage();
			l.setTitle("VNC_Users_Loginpage");
		l.setFont(new Font("TimesRoman",Font.ITALIC, 20));
		l.setSize(1366,786);
		l.setDefaultCloseOperation(vnc_admin.EXIT_ON_CLOSE);
		l.setVisible(true);
	
			
		}
		if(e.getSource().equals(jb2))
		{
		}
		if(e.getSource().equals(jb3))
		{
		}
		if(e.getSource().equals(jb4))
		{
		}

}
}