import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class Addstudent {
	private JTextField t1;
	private JTextField t2;
	private JComboBox cb1;
	public Addstudent(){
		JFrame f=new JFrame("Add Student");
		f.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Priyanshu\\Icon\\book_shelf_60px.png"));
		f.setResizable(false);
		f.getContentPane().setBackground(new Color(255, 250, 240));
		f.setBounds(100, 100, 500, 511);
		f.setLocationRelativeTo(null);
		f.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0)), "Add Student", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(new Color(250, 235, 215));
		panel.setBounds(20, 11, 439, 416);
		f.getContentPane().add(panel);
		
		JLabel lblFirstName = new JLabel(" First name : ");
		lblFirstName.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		lblFirstName.setBounds(22, 54, 180, 37);
		panel.add(lblFirstName);
		
		JLabel lblSurname = new JLabel("Surname : ");
		lblSurname.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		lblSurname.setBounds(30, 102, 212, 43);
		panel.add(lblSurname);
		
		JLabel lblBranch = new JLabel("Branch : ");
		lblBranch.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		lblBranch.setBounds(30, 156, 124, 43);
		panel.add(lblBranch);
		
		JLabel lblNewLabel_2_1 = new JLabel("Year : ");
		lblNewLabel_2_1.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(30, 210, 212, 43);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Semester : ");
		lblNewLabel_2_1_1.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		lblNewLabel_2_1_1.setBounds(30, 268, 212, 43);
		panel.add(lblNewLabel_2_1_1);
		
		t1 = new JTextField();
		t1.setColumns(10);
		t1.setBounds(252, 66, 151, 20);
		panel.add(t1);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(252, 117, 151, 20);
		panel.add(t2);
		
		cb1 = new JComboBox();
		cb1.setModel(new DefaultComboBoxModel(new String[] { "CMPN", "IT", "EXTC", "ETRX", "BIOMED"}));
		cb1.setBounds(252, 170, 151, 22);
		panel.add(cb1);		
		
		JComboBox cb2 = new JComboBox();
		cb2.setBounds(252, 224, 151, 22);
		cb2.setModel(new DefaultComboBoxModel(new String[] { "First", "Second", "Third", "Fourth" }));
		panel.add(cb2);
		
		JComboBox cb3 = new JComboBox();
		cb3.setModel(new DefaultComboBoxModel(new String[] {"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th"}));
		cb3.setBounds(252, 282, 151, 22);
		panel.add(cb3);
		
		JButton b1 = new JButton("ADD");
		b1.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0)));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//Class.forName("com.mysql.jdbc.Driver");
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_system","root","Priyanshu123");
					String sql="insert into student (name , surname , branch , year , semester ) values  (?,?,?,?,?)";
					
				    PreparedStatement st=con.prepareStatement(sql);					
			

					if(e.getSource() == b1) {
						st.setString(1, t1.getText());
		                st.setString(2, t2.getText());
				st.setString(3,(String) cb1.getSelectedItem());
				st.setString(4, (String) cb2.getSelectedItem());
				st.setString(5, (String) cb3.getSelectedItem());

		               

				int i = st.executeUpdate();
				if (i > 0){
		                    JOptionPane.showMessageDialog(null, "Student Added Successfully");
		                    f.setVisible(false);
		                   new Home_page();
		                }
				else
                    JOptionPane.showMessageDialog(null, "Error");
		                t1.setText("");
		                t2.setText("");
				
		            }
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
			}
		});
		b1.setForeground(new Color(0, 0, 0));
		b1.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 23));
		b1.setBackground(new Color(255, 228, 181));
		b1.setBounds(252, 349, 151, 43);
		panel.add(b1);		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("E:\\Priyanshu\\Icon\\id_male_student_100px.png"));
		lblNewLabel.setBounds(25, 322, 107, 80);
		panel.add(lblNewLabel);
	
		
		JButton b2 = new JButton("Go Back");
		b2.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 11));
		b2.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0)));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 f.setVisible(false);
					new Home_page() ;
			}
		});
		b2.setForeground(new Color(0, 0, 0));
		b2.setBackground(new Color(255, 228, 181));
		b2.setBounds(370, 438, 89, 23);
		f.getContentPane().add(b2);
		f.setVisible(true);
}
		
	public static void main(String[] args) {
		new Addstudent();
	}
}
