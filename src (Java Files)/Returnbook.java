import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.demo.DateChooserPanel;

import java.awt.BorderLayout;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class Returnbook {
	private JTextField t3;
	private JTextField t1;
	private JTextField t5;
	private JTextField t2;
	private JTextField t4;
	private JTextField t6;
	private JTextField t7;
	private JTextField t8;
	public Returnbook(){
		JFrame f=new JFrame("Returnbook");
		f.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Priyanshu\\Icon\\book_shelf_60px.png"));
		f.setResizable(false);
		f.getContentPane().setBackground(new Color(255, 250, 240));
		f.setBounds(100, 100, 936, 481);
		f.setLocationRelativeTo(null);
		f.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0)), "Return Book", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(new Color(250, 235, 215));
		panel.setBounds(10, 11, 900, 420);
		f.getContentPane().add(panel);
		
		JLabel lblBookName = new JLabel("Book name : ");
		lblBookName.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		lblBookName.setBounds(21, 97, 136, 26);
		panel.add(lblBookName);
		
		JLabel lblSemester = new JLabel("Semester : ");
		lblSemester.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		lblSemester.setBounds(21, 156, 136, 35);
		panel.add(lblSemester);
		
		t3 = new JTextField();
		t3.setBackground(new Color(250, 235, 215));
		t3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		t3.setColumns(10);
		t3.setBorder(null);
		t3.setBounds(160, 100, 367, 26);
		panel.add(t3);
		
		JLabel lblBookId_1 = new JLabel("Book ID : ");
		lblBookId_1.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		lblBookId_1.setBounds(22, 40, 124, 42);
		panel.add(lblBookId_1);
		
		t1 = new JTextField();
		t1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		t1.setColumns(10);
		t1.setBounds(169, 55, 46, 20);
		panel.add(t1);
		
		JButton b1 = new JButton("Search\r\n");
		b1.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0)));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					//Class.forName("com.mysql.jdbc.Driver");
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_system","root","Priyanshu123");
					String sql= "select * from issueBook where book_id = ? and student_id =?";
					
				    PreparedStatement st=con.prepareStatement(sql);	
				    

				    st.setString(1, t1.getText());
					st.setString(2, t2.getText());
					ResultSet rs = st.executeQuery();
					
			                while (rs.next()) {
			                    t3.setText(rs.getString("bname"));
			                    t4.setText(rs.getString("sname"));
			                    t5.setText(rs.getString("semester"));
			                    t6.setText(rs.getString("branch"));
			                    t7.setText(rs.getString("dateOfIssue"));
			                    t8.setText(rs.getString("dateOfReturn"));
			                    
				    
							
					
				}} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		b1.setForeground(new Color(0, 0, 0));
		b1.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 15));
		b1.setBackground(new Color(255, 228, 181));
		b1.setBounds(782, 53, 95, 20);
		panel.add(b1);
		
		t5 = new JTextField();
		t5.setBackground(new Color(250, 235, 215));
		t5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t5.setColumns(10);
		t5.setBorder(null);
		t5.setBounds(160, 163, 132, 20);
		panel.add(t5);
		
		JLabel lblBookId = new JLabel("Student ID : ");
		lblBookId.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		lblBookId.setBounds(537, 40, 161, 42);
		panel.add(lblBookId);
		
		t2 = new JTextField();
		t2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		t2.setColumns(10);
		t2.setBounds(681, 53, 46, 20);
		panel.add(t2);
		
		JLabel lblName = new JLabel("Name :\r\n");
		lblName.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		lblName.setBounds(537, 97, 151, 26);
		panel.add(lblName);
		
		JLabel lblBranch = new JLabel("Branch :");
		lblBranch.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		lblBranch.setBounds(537, 152, 124, 43);
		panel.add(lblBranch);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("Date of Issue : ");
		lblNewLabel_2_1_1_2.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		lblNewLabel_2_1_1_2.setBounds(21, 225, 209, 49);
		panel.add(lblNewLabel_2_1_1_2);
		
		t4 = new JTextField();
		t4.setBackground(new Color(250, 235, 215));
		t4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t4.setColumns(10);
		t4.setBorder(null);
		t4.setBounds(681, 98, 196, 26);
		panel.add(t4);
		
		t6 = new JTextField();
		t6.setBackground(new Color(250, 235, 215));
		t6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t6.setColumns(10);
		t6.setBorder(null);
		t6.setBounds(681, 163, 132, 20);
		panel.add(t6);
		
		t7 = new JTextField();
		t7.setBackground(new Color(250, 235, 215));
		t7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t7.setColumns(10);
		t7.setBorder(null);
		t7.setBounds(200, 237, 209, 26);
		panel.add(t7);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setDateFormatString("yyyy-MM-dd");
		dateChooser_1.setBounds(200, 364, 209, 23);
		panel.add(dateChooser_1);
		
		JButton b2 = new JButton("Return");
		b2.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0)));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					//Class.forName("com.mysql.jdbc.Driver");
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_system","root","Priyanshu123");
					String sql= "insert into returnBook(book_id, student_id, bname, sname , branch, semester , dateOfIssue , dateOfReturn , dateReturned) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
					String sql1= "insert into book_backup (book_id , name , publisher_or_author ,edition , price , pages )\r\n"
							+ "							select* from book where name = ? " ;
				    PreparedStatement st=con.prepareStatement(sql);					
				    PreparedStatement st1=con.prepareStatement(sql1);	

					if(e.getSource() == b2) {
						st.setString(1, t1.getText());
						st.setString(2, t2.getText());
						st.setString(3, t3.getText());
						st.setString(4, t4.getText());
						st.setString(5, t6.getText());
						st.setString(6, t5.getText());
						st.setString(7, t7.getText());
						st.setString(9, ((JTextField) dateChooser_1.getDateEditor().getUiComponent()).getText());
						st.setString(8, t8.getText());
						

		               st1.setString(1,t3.getText());
                int j = st1.executeUpdate();
				int i = st.executeUpdate();
				if (i > 0){
		                    JOptionPane.showMessageDialog(null, "Book Returned Successfully");		                  
		                }
				else
                    JOptionPane.showMessageDialog(null, "error");
		                
		                t1.setText("");
		                t2.setText("");
		                t3.setText("");
		                t4.setText("");
		                t5.setText(""); 
		                t6.setText("");
		                t7.setText("");
		                t8.setText("");
					}					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}		
		});
		b2.setForeground(new Color(0, 0, 0));
		b2.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 15));
		b2.setBackground(new Color(255, 228, 181));
		b2.setBounds(759, 238, 118, 26);
		panel.add(b2);
		
		JLabel lblNewLabel_2_1_1_2_1 = new JLabel("Date Returned : ");
		lblNewLabel_2_1_1_2_1.setBounds(21, 361, 172, 26);
		panel.add(lblNewLabel_2_1_1_2_1);
		lblNewLabel_2_1_1_2_1.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBackground(Color.BLACK);
		separator.setBounds(0, 206, 900, 8);
		panel.add(separator);	
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("E:\\Priyanshu\\Icon\\process_100px.png"));
		lblNewLabel.setBounds(635, 234, 86, 69);
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setDisabledIcon(new ImageIcon("E:\\Priyanshu\\Icon\\process_100px.png"));
		
		JButton b3 = new JButton("Back");
		b3.setBounds(759, 363, 118, 26);
		panel.add(b3);
		b3.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0)));
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				new Home_page();
			}
		});
		b3.setForeground(new Color(0, 0, 0));
		b3.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 15));
		b3.setBackground(new Color(255, 228, 181));
		
		t8 = new JTextField();
		t8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t8.setColumns(10);
		t8.setBorder(null);
		t8.setBackground(new Color(250, 235, 215));
		t8.setBounds(200, 299, 209, 26);
		panel.add(t8);
		
		JLabel lblNewLabel_2_1_1_2_1_1 = new JLabel("Date of Return : ");
		lblNewLabel_2_1_1_2_1_1.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		lblNewLabel_2_1_1_2_1_1.setBounds(21, 298, 172, 26);
		panel.add(lblNewLabel_2_1_1_2_1_1);
		
		f.setVisible(true);
}
	
	
	public static void main(String[] args) {
		new Returnbook();
	}
}
