import javax.swing.JFrame;
import java.sql.*; 

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.DropMode;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.border.EtchedBorder;
import javax.swing.event.AncestorListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


import javax.swing.event.AncestorEvent;
import javax.swing.JCheckBox;
import javax.swing.UIManager;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JProgressBar;

public class Login_Frame {
	private JTextField username;
	private JPasswordField password;
	
	Login_Frame(){
		JFrame f= new JFrame ("Login Frame");
		f.setTitle("Login ");
		f.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Priyanshu\\Icon\\book_shelf_60px.png"));
		f.setResizable(false);
		f.setForeground(new Color(255, 255, 255));
		f.setBackground(new Color(255, 255, 255));
		f.getContentPane().setBackground(new Color(255, 250, 240));
	    f.setBounds(100, 100 , 625 , 641);
		
		f.setLocationRelativeTo(null);
		f.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(255, 250, 240));
		panel.setBounds(0, 0, 609, 227);
		f.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Welcome To UrbanRead :\r\n");
		lblNewLabel_3.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 40));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(22, 36, 545, 109);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("A Library Management System\r\n");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 31));
		lblNewLabel_3_1.setBounds(22, 116, 545, 109);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\image.png"));
		lblNewLabel.setBounds(10, 0, 589, 225);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, SystemColor.textText, SystemColor.textText));
		panel_1.setForeground(new Color(255, 255, 255));
		panel_1.setBackground(new Color(250, 235, 215));
		panel_1.setBounds(10, 238, 590, 349);
		f.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_11 = new JLabel("Username : ");
		lblNewLabel_11.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 26));
		lblNewLabel_11.setForeground(new Color(0, 0, 0));
		lblNewLabel_11.setBackground(new Color(255, 255, 255));
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setBounds(83, 30, 170, 40);
		panel_1.add(lblNewLabel_11);
		
		JLabel lblNewLabel_2 = new JLabel("Password : ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 26));
		lblNewLabel_2.setBounds(83, 103, 158, 35);
		panel_1.add(lblNewLabel_2);
		
		username = new JTextField();
		username.setBorder(new EtchedBorder(EtchedBorder.LOWERED, SystemColor.textText, SystemColor.textText));
		username.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		username.setBounds(272, 33, 199, 40);
		panel_1.add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setBorder(new EtchedBorder(EtchedBorder.LOWERED, SystemColor.textText, SystemColor.textText));
		password.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		password.setBounds(272, 103, 199, 40);
		panel_1.add(password);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0)));
		btnNewButton.setAlignmentY(Component.TOP_ALIGNMENT);
		btnNewButton.setBackground(new Color(255, 228, 181));
		btnNewButton.setForeground(new Color(0, 0, 0));
			btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				try {
								//Class.forName("com.mysql.jdbc.Driver");
								
								Class.forName("com.mysql.cj.jdbc.Driver");
								
								Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_system","root","Priyanshu123");
								Statement stmt=con.createStatement();
								String sql="Select* from account where username='"+username.getText()+"' and password='"+password.getText().toString()+"'";
								ResultSet rs=stmt.executeQuery(sql);
								if(rs.next())
								{
									f.setVisible(false);
								    new Home_page();	
								}			   	
							   else
									JOptionPane.showMessageDialog(null, "Incorrect Username and Password");
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}						
						}

		});
		btnNewButton.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 23));
		btnNewButton.setBounds(95, 200, 183, 40);
		panel_1.add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBorder(null);
		separator.setBackground(SystemColor.controlShadow);
		separator.setForeground(SystemColor.controlText);
		separator.setBounds(-51, 259, 894, 17);
		panel_1.add(separator);
		
		JButton btnNewButton_1 = new JButton("Sign Up");
		btnNewButton_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0)));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(new Color(255, 228, 181));
		btnNewButton_1.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 23));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				new Sign_up();
			}
		});
		btnNewButton_1.setBounds(301, 200, 170, 40);
		panel_1.add(btnNewButton_1);
		
		JLabel lblNewLabel_5 = new JLabel("Forgot Password :");
		lblNewLabel_5.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(83, 281, 183, 54);
		panel_1.add(lblNewLabel_5);
		
		JButton btnNewButton_2 = new JButton("Click Here");
		btnNewButton_2.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0)));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				new Forgot_password();
			}
		});
		btnNewButton_2.setBackground(new Color(255, 228, 181));
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 24));
		btnNewButton_2.setBounds(276, 287, 195, 38);
		panel_1.add(btnNewButton_2);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Show Password");
		chckbxNewCheckBox.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 11));
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox.isSelected()) 
				{
			password.setEchoChar((char)0);
				}else
				{
					password.setEchoChar('*');	
				}
				
			}
		});
		chckbxNewCheckBox.setBackground(new Color(250, 235, 215));
		chckbxNewCheckBox.setBounds(272, 164, 130, 17);
		panel_1.add(chckbxNewCheckBox);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\Priyanshu\\Icon\\forgot_password_32px.png"));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 287, 75, 35);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setIcon(new ImageIcon("E:\\Priyanshu\\Icon\\change_user_32px.png"));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setBounds(10, 27, 75, 46);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("");
		lblNewLabel_1_2_1.setIcon(new ImageIcon("E:\\Priyanshu\\Icon\\key_2_32px.png"));
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setBounds(29, 103, 44, 35);
		panel_1.add(lblNewLabel_1_2_1);
		f.setVisible(true);
	}	
	public static void main(String[] args) {
		new Login_Frame();
	}
}