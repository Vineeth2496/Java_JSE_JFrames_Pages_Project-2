package com.vnc_billing;

import java.awt.Font;

public class vnc_execution {

	public static void main(String[] args) {
		
		VNC_Users l=new VNC_Users();
			l.setTitle("Institute");
		l.setFont(new Font("TimesRoman",Font.ITALIC, 20));
		l.setSize(1366,786);
		l.setDefaultCloseOperation(vnc_admin.EXIT_ON_CLOSE);
		l.setVisible(true);
	
	/*	vnc_admin_register l=new vnc_admin_register();
	 	l.setTitle("Institute");
		l.setFont(new Font("TimesRoman",Font.ITALIC, 20));
		l.setSize(1366,786);
		l.setDefaultCloseOperation(vnc_admin_register.EXIT_ON_CLOSE);
		l.setVisible(true);
	*/	
		
	
	/*	vnc_admin_forgetpassword l=new vnc_admin_forgetpassword(); 
	 	l.setTitle("Institute");
		l.setFont(new Font("TimesRoman",Font.ITALIC, 20));
		l.setSize(1366,786);
		l.setDefaultCloseOperation(vnc_admin.EXIT_ON_CLOSE);
		l.setVisible(true);
		*/
	}

}
