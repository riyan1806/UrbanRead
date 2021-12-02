import javax.swing.JFrame;



import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;

import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import java.awt.GridBagConstraints;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.ImageIcon;
import java.awt.Toolkit;public class Sign_up {

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	 
	Sign_up (){
		JFrame f=new JFrame("Signup");
		f.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Priyanshu\\Icon\\book_shelf_60px.png"));
		f.setResizable(false);
		f.getContentPane().setBackground(new Color(255, 250, 240));
		f.setBounds(100, 100 , 478 , 518);
		f.setLocationRelativeTo(null);
		f.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(250, 235, 215));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0)), "Create Account", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.infoText));
		panel.setBounds(13, 11, 439, 419);
		f.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" Username : ");
		lblNewLabel.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		lblNewLabel.setBounds(23, 31, 180, 37);
		panel.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name : ");
		lblName.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		lblName.setBounds(33, 77, 212, 43);
		panel.add(lblName);
		
		JLabel lblE = new JLabel("Password : ");
		lblE.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		lblE.setBounds(33, 131, 212, 43);
		panel.add(lblE);
		
		JLabel lblNewLabel_2_1 = new JLabel("Security Question : ");
		lblNewLabel_2_1.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(33, 185, 212, 43);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Answer : ");
		lblNewLabel_2_1_1.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		lblNewLabel_2_1_1.setBounds(33, 239, 212, 43);
		panel.add(lblNewLabel_2_1_1);
		
		textField = new JTextField();
		textField.setBounds(252, 43, 151, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(252, 92, 151, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(255, 146, 151, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(255, 254, 151, 20);
		panel.add(textField_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Your NickName?", "Your Lucky Number?",
				"Your child SuperHero?", "Your childhood Name ?" }));
		comboBox.setBounds(252, 199, 151, 22);
		panel.add(comboBox);
		
		JButton btnNewButton_1 = new JButton("CREATE");
		btnNewButton_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0)));
		btnNewButton_1.setBackground(new Color(255, 228, 181));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 23));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//Class.forName("com.mysql.jdbc.Driver");
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_system","root","Priyanshu123");
					String sql="insert into account(username, name, password, sec_q, sec_ans) values (?,?,?,?,?)";
				    PreparedStatement st=con.prepareStatement(sql);					
			

					if(e.getSource() == btnNewButton_1) {
						st.setString(1, textField.getText());
		                st.setString(2, textField_1.getText());
				st.setString(3, textField_2.getText());
				st.setString(4, (String) comboBox.getSelectedItem());
				st.setString(5, textField_3.getText());

		               

				int i = st.executeUpdate();
				if (i > 0){
		                    JOptionPane.showMessageDialog(null, "successfully Created");
		                }

		                textField.setText("");
		                textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
		            }
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}					
				}
			});
		btnNewButton_1.setBounds(252, 349, 151, 37);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\Priyanshu\\Icon\\add_male_user_100px.png"));
		lblNewLabel_1.setBounds(10, 312, 100, 96);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon("E:\\Priyanshu\\Icon\\add_female_user_100px.png"));
		lblNewLabel_1_1.setBounds(113, 312, 100, 96);
		panel.add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0)));
		btnNewButton.setBounds(351, 441, 101, 27);
		f.getContentPane().add(btnNewButton);
		btnNewButton.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 18));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 228, 181));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 f.setVisible(false);
				new Login_Frame() ;
			}
		});
		f.setVisible(true);
	}
	public static void main(String[] args) {
		new Sign_up ();
	}
}

