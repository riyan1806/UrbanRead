import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class Addbooks {
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	public Addbooks(){
		JFrame f=new JFrame("Add Book");
		f.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Priyanshu\\Icon\\book_shelf_60px.png"));
		f.setResizable(false);
		f.getContentPane().setBackground(new Color(255, 250, 240));
		f.setBounds(100, 100, 500, 520);
		f.setLocationRelativeTo(null);
		f.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0)), "Add Book", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(new Color(250, 235, 215));
		panel.setBounds(20, 16, 439, 417);
		f.getContentPane().add(panel);
		
		JLabel lblBookName = new JLabel("Book name : ");
		lblBookName.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		lblBookName.setBounds(30, 54, 180, 37);
		panel.add(lblBookName);
		
		JLabel lblPublisher = new JLabel("Publisher/Author  :");
		lblPublisher.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		lblPublisher.setBounds(30, 102, 212, 43);
		panel.add(lblPublisher);
		
		JLabel lblEdition = new JLabel("Edition :\r\n");
		lblEdition.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		lblEdition.setBounds(30, 156, 124, 43);
		panel.add(lblEdition);
		
		JLabel lblNewLabel_2_1 = new JLabel("Price : ");
		lblNewLabel_2_1.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(30, 210, 212, 43);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Pages : ");
		lblNewLabel_2_1_1.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		lblNewLabel_2_1_1.setBounds(30, 264, 212, 43);
		panel.add(lblNewLabel_2_1_1);
		
		t1 = new JTextField();
		t1.setColumns(10);
		t1.setBounds(252, 66, 151, 20);
		panel.add(t1);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(252, 117, 151, 20);
		panel.add(t2);
		
		JComboBox cb = new JComboBox();
		cb.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6 ", "7", "8 ", "9"}));
		cb.setBounds(252, 170, 151, 22);
		panel.add(cb);
		
		JButton b1 = new JButton("ADD");
		b1.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0)));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//Class.forName("com.mysql.jdbc.Driver");
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_system","root","Priyanshu123");
					String sql="insert into book (name , publisher_or_author , edition , price , pages ) values  (?,?,?,?,?)";
					String sql1= "insert into book_backup (book_id , name , publisher_or_author ,edition , price , pages )\r\n"
							+ "							select* from book where name = ? " ;
				    PreparedStatement st=con.prepareStatement(sql);					

					PreparedStatement st1=con.prepareStatement(sql1);
					
					

					if(e.getSource() == b1) {
						st.setString(1, t1.getText());
		                st.setString(2, t2.getText());
				st.setString(3,(String) cb.getSelectedItem());
				st.setString(4, t3.getText());
				st.setString(5, t4.getText());
				
				st1.setString(1, t1.getText());
				
				

		               

				int i = st.executeUpdate();
				st1.executeUpdate(); 
				
				if (i > 0){
		                    JOptionPane.showMessageDialog(null, "Book Added Successfully");
		                    f.setVisible(false);
		                   new Home_page();
		                }
				else
                    JOptionPane.showMessageDialog(null, "error");
		                t1.setText("");
		                t2.setText("");
		                t3.setText("");
		                t4.setText("");
		                
		              
		            }
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
					
					
		
			}
		});
		b1.setForeground(new Color(0, 0, 0));
		b1.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 23));
		b1.setBackground(new Color(255, 222, 173));
		b1.setBounds(252, 339, 151, 43);
		panel.add(b1);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(252, 225, 151, 20);
		panel.add(t3);
		
		t4 = new JTextField();
		t4.setColumns(10);
		t4.setBounds(252, 279, 151, 20);
		panel.add(t4);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setIcon(new ImageIcon("E:\\Priyanshu\\Icon\\literature_100px.png"));
		lblNewLabel.setBounds(22, 327, 107, 80);
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
		b2.setBackground(new Color(255, 222, 173));
		b2.setBounds(368, 444, 89, 23);
		f.getContentPane().add(b2);
		f.setVisible(true);
}
	
	
	public static void main(String[] args) {
		new Addbooks();
	}
}
