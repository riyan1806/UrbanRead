import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;


public class Issuebook {
	private JTextField t1;
	private JTextField t2;
	private JTextField t4;
	private JTextField t5;
	private JTextField t0;
	private JTextField t3;
	private JTextField t7;
	private JTextField t8;
	private JTextField t10;
	private JTextField t11;
	private JTextField t6;
	private JTextField t9;
	public Issuebook(){
		JFrame f=new JFrame("Issuebook");
		f.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Priyanshu\\Icon\\book_shelf_60px.png"));
		f.setResizable(false);
		f.getContentPane().setBackground(new Color(255, 250, 240));
		f.setBounds(100, 100 , 974 , 498);
		f.setLocationRelativeTo(null);
		f.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0)), "Book Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(new Color(250, 235, 215));
		panel.setBounds(20, 11, 520, 340);
		f.getContentPane().add(panel);
		
		JLabel lblBookName = new JLabel("Book name : ");
		lblBookName.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		lblBookName.setBounds(21, 97, 141, 26);
		panel.add(lblBookName);
		
		JLabel lblPublisher = new JLabel("Publisher : ");
		lblPublisher.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		lblPublisher.setBounds(21, 145, 124, 35);
		panel.add(lblPublisher);
		
		JLabel lblEdition = new JLabel("Edition :\r\n");
		lblEdition.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		lblEdition.setBounds(22, 187, 111, 43);
		panel.add(lblEdition);
		
		JLabel lblNewLabel_2_1 = new JLabel("Price : ");
		lblNewLabel_2_1.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(22, 233, 111, 43);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Pages : ");
		lblNewLabel_2_1_1.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		lblNewLabel_2_1_1.setBounds(22, 279, 111, 43);
		panel.add(lblNewLabel_2_1_1);
		
		t2 = new JTextField();
		t2.setBackground(new Color(250, 235, 215));
		t2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t2.setBorder(null);
		t2.setColumns(10);
		t2.setBounds(160, 152, 299, 28);
		panel.add(t2);
		
		t4 = new JTextField();
		t4.setBackground(new Color(250, 235, 215));
		t4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t4.setBorder(null);
		t4.setColumns(10);
		t4.setBounds(160, 248, 215, 20);
		panel.add(t4);
		
		t5 = new JTextField();
		t5.setBackground(new Color(250, 235, 215));
		t5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t5.setBorder(null);
		t5.setColumns(10);
		t5.setBounds(160, 294, 215, 20);
		panel.add(t5);
		
		JLabel lblBook = new JLabel("Book ID : ");
		lblBook.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		lblBook.setBounds(22, 40, 111, 42);
		panel.add(lblBook);
		
		t0 = new JTextField();
		t0.setFont(new Font("Tahoma", Font.PLAIN, 16));
		t0.setColumns(10);
		t0.setBounds(160, 53, 46, 20);
		panel.add(t0);
		
		JButton b1 = new JButton("Search\r\n");
		b1.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0)));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try{
			        	//Class.forName("com.mysql.jdbc.Driver");
						
						Class.forName("com.mysql.cj.jdbc.Driver");
						
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_system","root","Priyanshu123");				
			            if(e.getSource() == b1 ){
			                String sql = "select * from book where book_id =?";
					PreparedStatement st = con.prepareStatement(sql);

					st.setString(1, t0.getText());
					ResultSet rs = st.executeQuery();
					if (rs.next()) {
			                    t1.setText(rs.getString("name"));
			                    t2.setText(rs.getString("publisher_or_author"));
			                    t3.setText(rs.getString("edition"));
			                    t4.setText(rs.getString("price"));
			                    t5.setText(rs.getString("pages"));
					}
					else
	                    JOptionPane.showMessageDialog(null, "Invalid Book ID");
			            }
			         } catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();}
					}
				
		
				
			}
		);
		b1.setForeground(new Color(0, 0, 0));
		b1.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 15));
		b1.setBackground(new Color(255, 228, 181));
		b1.setBounds(412, 53, 95, 20);
		panel.add(b1);
		
		t3 = new JTextField();
		t3.setBackground(new Color(250, 235, 215));
		t3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t3.setBorder(null);
		t3.setColumns(10);
		t3.setBounds(160, 202, 215, 20);
		panel.add(t3);
		
		t1 = new JTextField();
		t1.setBounds(160, 99, 347, 26);
		panel.add(t1);
		t1.setBackground(new Color(250, 235, 215));
		t1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		t1.setBorder(null);
		t1.setColumns(10);
		
		
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-dd");
		dateChooser.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		dateChooser.setBounds(392, 374, 148, 23);
		f.getContentPane().add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setDateFormatString("yyyy-MM-dd");
		dateChooser_1.setBounds(798, 374, 148, 23);
		f.getContentPane().add(dateChooser_1);
	
		JButton b3 = new JButton("Issue Book\r\n\r\n");
		b3.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0)));
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					//Class.forName("com.mysql.jdbc.Driver");
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_system","root","Priyanshu123");
					String sql= "insert into issueBook(book_id, student_id, bname, sname , branch, semester , dateOfIssue , dateOfReturn ) values(?, ?, ?, ?, ?, ?, ?, ?)";
					String sql1 = "delete from book_backup where book_id = '" + t0.getText() + "'";
				    PreparedStatement st=con.prepareStatement(sql);	
				    PreparedStatement st1=con.prepareStatement(sql1);	
				    
			

					if(e.getSource() == b3) {
						st.setString(1, t0.getText());
						st.setString(2, t6.getText());
						st.setString(3, t1.getText());
						st.setString(4, t7.getText());
						st.setString(5, t9.getText());
						st.setString(6, t11.getText());
						st.setString(7, ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText());
						st.setString(8, ((JTextField) dateChooser_1.getDateEditor().getUiComponent()).getText());

		               
                int j = st1.executeUpdate();
				int i = st.executeUpdate();
				if (i > 0){
		                    JOptionPane.showMessageDialog(null, "Book Issued Successfully");
		                   
		                }
				else 					
                    JOptionPane.showMessageDialog(null, "error");
		                t0.setText("");
		                t1.setText("");
		                t2.setText("");
		                t3.setText("");
		                t4.setText("");
		                t5.setText(""); 
		                t6.setText("");
		                t7.setText("");
		                t8.setText("");
		                t9.setText("");
		                t10.setText("");
		                t11.setText("");
		                
		            		            }
				}
					
					catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				 
			}
				 
		});
		b3.setForeground(new Color(0, 0, 0));
		b3.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 18));
		b3.setBackground(new Color(255, 228, 181));
		b3.setBounds(647, 422, 166, 23);
		f.getContentPane().add(b3);
		
		JButton btnBack = new JButton("Back\r\n");
		btnBack.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0)));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				new Home_page();
			}
		});
		btnBack.setForeground(new Color(0, 0, 0));
		btnBack.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 18));
		btnBack.setBackground(new Color(255, 228, 181));
		btnBack.setBounds(823, 422, 123, 23);
		f.getContentPane().add(btnBack);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("Date of Issue : ");
		lblNewLabel_2_1_1_2.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		lblNewLabel_2_1_1_2.setBounds(169, 362, 166, 49);
		f.getContentPane().add(lblNewLabel_2_1_1_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0)), "Student Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(new Color(250, 235, 215));
		panel_1.setBounds(557, 11, 389, 340);
		f.getContentPane().add(panel_1);
		
		JLabel lblFirsrName = new JLabel("First Name :\r\n");
		lblFirsrName.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		lblFirsrName.setBounds(29, 93, 151, 26);
		panel_1.add(lblFirsrName);
		
		JLabel lblSurname = new JLabel("Surname : ");
		lblSurname.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		lblSurname.setBounds(29, 141, 124, 35);
		panel_1.add(lblSurname);
		
		JLabel lblBranch = new JLabel("Branch :");
		lblBranch.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		lblBranch.setBounds(29, 187, 124, 43);
		panel_1.add(lblBranch);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Year :");
		lblNewLabel_2_1_2.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		lblNewLabel_2_1_2.setBounds(29, 233, 124, 43);
		panel_1.add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Semester : ");
		lblNewLabel_2_1_1_1.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		lblNewLabel_2_1_1_1.setBounds(29, 279, 124, 43);
		panel_1.add(lblNewLabel_2_1_1_1);
		
		t7 = new JTextField();
		t7.setFont(new Font("Tahoma", Font.PLAIN, 19));
		t7.setBorder(null);
		t7.setEditable(false);
		t7.setBackground(new Color(250, 235, 215));
		t7.setColumns(10);
		t7.setBounds(169, 100, 151, 20);
		panel_1.add(t7);
		
		t8 = new JTextField();
		t8.setFont(new Font("Tahoma", Font.PLAIN, 19));
		t8.setBorder(null);
		t8.setBackground(new Color(250, 235, 215));
		t8.setColumns(10);
		t8.setBounds(169, 148, 151, 28);
		panel_1.add(t8);
		
		t10 = new JTextField();
		t10.setBackground(new Color(250, 235, 215));
		t10.setFont(new Font("Tahoma", Font.PLAIN, 19));
		t10.setBorder(null);
		t10.setColumns(10);
		t10.setBounds(169, 248, 151, 20);
		panel_1.add(t10);
		
		t11 = new JTextField();
		t11.setBackground(new Color(250, 235, 215));
		t11.setFont(new Font("Tahoma", Font.PLAIN, 19));
		t11.setBorder(null);
		t11.setColumns(10);
		t11.setBounds(169, 294, 160, 20);
		panel_1.add(t11);
		
		JLabel lblStudentId = new JLabel("Student ID : ");
		lblStudentId.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		lblStudentId.setBounds(29, 35, 151, 42);
		panel_1.add(lblStudentId);
		
		t6 = new JTextField();
		t6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		t6.setColumns(10);
		t6.setBounds(169, 48, 51, 20);
		panel_1.add(t6);
		
		JButton b2 = new JButton("Search\r\n");
		b2.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0)));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 try{
			        	//Class.forName("com.mysql.jdbc.Driver");
						
						Class.forName("com.mysql.cj.jdbc.Driver");
						
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_system","root","Priyanshu123");				
			            if(e.getSource() == b2 ){
			                String sql = "select * from student where student_id =?";
					PreparedStatement st = con.prepareStatement(sql);

					st.setString(1, t6.getText());
					ResultSet rs = st.executeQuery();
					if (rs.next()) {
			                    t7.setText(rs.getString("name"));
			                    t8.setText(rs.getString("surname"));
			                    t9.setText(rs.getString("branch"));
			                    t10.setText(rs.getString("year"));
			                    t11.setText(rs.getString("semester"));
					}
					else
	                    JOptionPane.showMessageDialog(null, "Invalid Student ID");
			            }
			         } catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();}
					}
		});
		b2.setForeground(new Color(0, 0, 0));
		b2.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 16));
		b2.setBackground(new Color(255, 228, 181));
		b2.setBounds(289, 47, 90, 20);
		panel_1.add(b2);
		
		t9 = new JTextField();
		t9.setBackground(new Color(250, 235, 215));
		t9.setFont(new Font("Tahoma", Font.PLAIN, 19));
		t9.setBorder(null);
		t9.setColumns(10);
		t9.setBounds(169, 202, 160, 20);
		panel_1.add(t9);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("E:\\Priyanshu\\Icon\\book_shelf_100px.png"));
		lblNewLabel.setBounds(30, 350, 85, 80);
		f.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2_1_1_2_1 = new JLabel("Date of Return : ");
		lblNewLabel_2_1_1_2_1.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		lblNewLabel_2_1_1_2_1.setBounds(567, 362, 198, 49);
		f.getContentPane().add(lblNewLabel_2_1_1_2_1);
		
		f.setVisible(true);
		
		
}
	
	
	public static void main(String[] args) {
		new Issuebook();
	}
}
