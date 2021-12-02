import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Forgot_password {
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;
	 
	Forgot_password (){
		JFrame f=new JFrame("Forgot password");
		f.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Priyanshu\\Icon\\book_shelf_60px.png"));
		f.setResizable(false);
		f.getContentPane().setBackground(new Color(255, 250, 240));
		f.getContentPane().setForeground(new Color(255, 255, 255));
		f.setBounds(100, 100 , 648 , 498);
		f.setLocationRelativeTo(null);
		f.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setFont(new Font("Tahoma", Font.ITALIC, 11));
		panel.setBackground(new Color(250, 235, 215));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0)), "Forgot Password", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 606, 437);
		panel.setForeground(new Color(0, 0, 0));
		f.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username : ");
		lblNewLabel.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		lblNewLabel.setBounds(24, 40, 268, 44);
		panel.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name : ");
		lblName.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		lblName.setBounds(24, 95, 268, 44);
		panel.add(lblName);
		
		JLabel lblYour = new JLabel("Your Security Question :");
		lblYour.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		lblYour.setBounds(24, 150, 268, 44);
		panel.add(lblYour);
		
		JLabel lblAnswer = new JLabel("Answer : ");
		lblAnswer.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		lblAnswer.setBounds(24, 205, 268, 44);
		panel.add(lblAnswer);
		
		JLabel lblPassword = new JLabel("Password : ");
		lblPassword.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		lblPassword.setBounds(24, 260, 268, 44);
		panel.add(lblPassword);
		
		t1 = new JTextField();
		t1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t1.setBounds(292, 48, 130, 28);
		panel.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t2.setBorder(null);
		t2.setBackground(UIManager.getColor("CheckBox.light"));
		t2.setEditable(false);
		t2.setColumns(10);
		t2.setBounds(292, 104, 130, 28);
		panel.add(t2);
		
		t3 = new JTextField();
		t3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t3.setBorder(null);
		t3.setBackground(UIManager.getColor("CheckBox.light"));
		t3.setEditable(false);
		t3.setColumns(10);
		t3.setBounds(292, 159, 216, 28);
		panel.add(t3);
		
		t4 = new JTextField();
		t4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t4.setColumns(10);
		t4.setBounds(292, 213, 130, 28);
		panel.add(t4);
		
		t5 = new JTextField();
		t5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t5.setBorder(null);
		t5.setBackground(UIManager.getColor("CheckBox.light"));
		t5.setEditable(false);
		t5.setColumns(10);
		t5.setBounds(292, 269, 130, 28);
		panel.add(t5);
		
		JButton button1 = new JButton("Search");
		button1.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0)));
		button1.setForeground(new Color(0, 0, 0));
		button1.setBackground(new Color(255, 228, 181));
		button1.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 17));
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
		        try{
		        	//Class.forName("com.mysql.jdbc.Driver");
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_system","root","Priyanshu123");				
		            if(e.getSource() == button1 ){
		                String sql = "select * from account where username=?";
				PreparedStatement st = con.prepareStatement(sql);

				st.setString(1, t1.getText());
				ResultSet rs = st.executeQuery();
				if (rs.next()) {
		                    t2.setText(rs.getString("name"));
		                    t3.setText(rs.getString("sec_q"));
				}
		            }
		         } catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();}
				}
		});
		button1.setBounds(465, 47, 118, 32);
		panel.add(button1);
		
		JButton button2 = new JButton("Get Password");
		button2.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0)));
		button2.setForeground(new Color(0, 0, 0));
		button2.setBackground(new Color(255, 228, 181));
		button2.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 13));
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
		        try{
		        	//Class.forName("com.mysql.jdbc.Driver");
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_system","root","Priyanshu123");				
		       
	          if(e.getSource() == button2 ){
	                String sql = "select * from account where username=? and sec_ans=?";
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, t1.getText());
			st.setString(2, t4.getText());			
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
	                    	t5.setText(rs.getString("password"));
			}
	            }
	          
	        } catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();}
		}
			
		});
		button2.setBounds(465, 213, 118, 32);
		panel.add(button2);		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0)));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				new Login_Frame();
			}
		});
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setBackground(new Color(255, 228, 181));
		btnNewButton_2.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 17));
		btnNewButton_2.setBounds(465, 373, 118, 37);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\Priyanshu\\Icon\\lock_male_user_100px.png"));
		lblNewLabel_1.setBounds(22, 319, 100, 96);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon("E:\\Priyanshu\\Icon\\lock_female_user_100px.png"));
		lblNewLabel_1_1.setBounds(120, 319, 100, 96);
		panel.add(lblNewLabel_1_1);
		f.setVisible(true);
	}
		
	            
	public static void main(String[] args) {
		new Forgot_password ();
	}
	
}

