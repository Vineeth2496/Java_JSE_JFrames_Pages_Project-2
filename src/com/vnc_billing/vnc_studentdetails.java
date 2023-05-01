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

public class vnc_studentdetails extends JFrame implements ActionListener
{
	private JLabel  jl1, jl2, jl3, jl4, jl7, jl8, jl10, jl11;
	private JButton  jb1,jb3;
	private JTextField jt1, jt2, jt3, jt4;

	private ImageIcon i1;
	private Font f1, f2;
	private JRadioButton jr1, jr2, jr3;
	
	String Gender;
	
	public vnc_studentdetails()
	{
		i1=new ImageIcon("C:\\Users\\vinee\\OneDrive\\Pictures\\Saved Pictures\\Admissions.jpg");
		f1=new Font("Bookman Old Style",100, 18);
		f2=new Font("Calibri (Body)",150, 16);
		
		jl1=new JLabel("First Name:");
		jl1.setFont(f1);
		jl1.setForeground(Color.BLACK);
		jt1=new JTextField("First Name");
		
		jl2=new JLabel("Last Name:	");
		jl2.setFont(f1);
		jl2.setForeground(Color.BLACK);
		jt2= new JTextField("Last Name");
		
		jl3=new JLabel("Phone No:	");
		jl3.setFont(f1);
		jl3.setForeground(Color.BLACK);
		
		jt3=new JTextField("Phone number");
		
		jl4=new JLabel("Email:	");
		jl4.setFont(f1);
		jl4.setForeground(Color.BLACK);
		jt4=new JTextField("Email Id");
		
		jl7=new JLabel("Gender");
		jl7.setFont(f1);
		jl7.setForeground(Color.BLACK);		
		jr1=new JRadioButton("Male");
		jr2=new JRadioButton("Female");
		jr3=new JRadioButton("Others");
		
		
		jb1=new JButton("SUBMIT STD DATA");
		jb1.setFont(f2);
		jb1.setBackground(Color.blue);
		jb1.setForeground(Color.white);
		
		jb3=new JButton("Clear");
		jb3.setFont(f2);
		jb3.setBackground(Color.blue);
		jb3.setForeground(Color.white);		
	
		
		jl11=new JLabel(i1);
		
		//	calling container with empty space
		setLayout(null);
		
		//	After calling, then  arrange components into frame particular position
		//	jl.setBounds(600, 35, 180, 9
		
		jl1.setBounds(490, 125, 120, 40);
		jt1.setBounds(620, 130, 230, 30);
	
		jl2.setBounds(490, 160, 120, 40);
		jt2.setBounds(620, 165, 230, 30);
		
		jl3.setBounds(490, 195, 120, 40);
		jt3.setBounds(685, 200, 165, 30);
		
		jl4.setBounds(490, 230, 120, 40);
		jt4.setBounds(620, 235, 230, 30);

		
		jl7.setBounds(490, 335, 120, 40);
		jr1.setBounds(620, 340, 80, 40);
		jr2.setBounds(700, 340, 80, 40);
		jr3.setBounds(780, 340, 90, 40);
		

		
		
		
		jb1.setBounds(670, 475, 100, 30);
		jb3.setBounds(570, 475, 80, 30);
	


			
		jl11.setBounds(0, 0, 1366, 786);
		
		
		//	the above value add in conatiner
		
		//	add(jl);
		add(jl1);
		add(jt1);
		
		add(jl2);
		add(jt2);
		
		add(jl3);
		add(jt3);
		
		add(jl4);
		add(jt4);
		
		add(jl7);
		add(jr1);
		add(jr2);
		add(jr3);
		add(jb1);
		add(jb3);

		add(jl11);
		
		jb1.addActionListener(this);
		jr1.addActionListener(this);
		jr2.addActionListener(this);
		jr3.addActionListener(this);
		jb3.addActionListener(this);

		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource().equals(jr1))
		{
			Gender="Male";
			jr2.setSelected(false);
			jr3.setSelected(false);
		}
		if(e.getSource().equals(jr2))
		{
			Gender="Female";
			jr1.setSelected(false);
			jr3.setSelected(false);
		}
		if(e.getSource().equals(jr3))
		{
			Gender="Others";
			jr2.setSelected(false);
			jr1.setSelected(false);
		}
		if(e.getSource().equals(jb1))
		{
			try
			{
				//	storing data in bytes format
				
			String FirstName=jt1.getText();
			String LastName= jt2.getText();
			String PhoneNo=jt3.getText();
			String Email=jt4.getText();
			
			FileInputStream fi=new FileInputStream("C:\\Users\\vinee\\OneDrive\\Desktop\\Java\\Practice\\Collections Frame Works\\com.vnc_billing\\jdbc.properties");
			Properties p=new Properties();
			p.load(fi);
			Class.forName(p.getProperty("jdbc.driver")).newInstance();
			Connection con= DriverManager.getConnection(p.getProperty("jdbc.url"), p.getProperty("jdbc.username"), p.getProperty("jdbc.password"));
			System.out.println(con);
			PreparedStatement ps=con.prepareStatement("insert into institute_student values(?,?,?,?,?)");
			ps.setString(1, FirstName);
			ps.setString(2, LastName);
			ps.setString(3, PhoneNo);
			ps.setString(4, Email);
			ps.setString(5, Gender);
		
			int i=ps.executeUpdate();
			
			System.out.println("Update: "+i);
			
			JOptionPane.showMessageDialog(this, "Institute Team Account is Created"+"\n");
	
			}
			catch (Exception e1) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "Institute Team Account is NOT Created");
				e1.printStackTrace();
			}
		}
		if(e.getSource().equals(jb3))
		{
			this.jt1.setText("");
			this.jt2.setText("");
			this.jt3.setText("");
			this.jt4.setText("");
		}
	}


}
