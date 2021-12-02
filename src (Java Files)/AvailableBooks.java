import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Component;

public class AvailableBooks extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AvailableBooks frame = new AvailableBooks();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AvailableBooks() {
		setTitle("Available Books");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Priyanshu\\Icon\\book_shelf_60px.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 737, 613);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0)), "Available Books", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(new Color(255, 248, 220));
		panel.setBounds(10, 88, 699, 444);
		contentPane.add(panel);
		
		t1 = new JTextField();
		t1.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 11));
		t1.setColumns(10);
		t1.setBounds(128, 33, 436, 20);
		panel.add(t1);
		
		JButton b1_2 = new JButton("Search");
		b1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					//Class.forName("com.mysql.jdbc.Driver");
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_system","root","Priyanshu123");
					String sql =  "select * from book_backup where concat(name, book_id) like ? order by book_id   ";
					
				    PreparedStatement st=con.prepareStatement(sql);
				    st.setString(1, "%" + t1.getText() + "%");
		            ResultSet rs = st.executeQuery();
		            table.setModel(DbUtils.resultSetToTableModel(rs));
	                rs.close();
	                st.close();

	            }catch(Exception e1){
	                
	            }
			}
		});
		b1_2.setForeground(new Color(240, 248, 255));
		b1_2.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 12));
		b1_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 218, 185), new Color(255, 222, 173)));
		b1_2.setBackground(Color.BLACK);
		b1_2.setBounds(581, 33, 97, 20);
		panel.add(b1_2);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBorder(null);
		scrollPane_2.setBackground(SystemColor.info);
		scrollPane_2.setBounds(21, 79, 657, 343);
		panel.add(scrollPane_2);
		
		table = new JTable();
		table.setAlignmentX(Component.RIGHT_ALIGNMENT);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				 int row = table.getSelectedRow();
					t1.setText(table.getModel().getValueAt(row, 1).toString());
			}
		});
		table.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		table.setBackground(SystemColor.info);
		table.setBounds(0, 0, 1, 1);
		scrollPane_2.setViewportView(table);
		
		JLabel lblAvailable = new JLabel("Available Books in Library");
		lblAvailable.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvailable.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 39));
		lblAvailable.setBounds(92, 26, 534, 39);
		contentPane.add(lblAvailable);
		
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_system","root","Priyanshu123");
			String sql = "select* from book_backup order by book_id ";
			
		    PreparedStatement st=con.prepareStatement(sql);			 
	        ResultSet rs = st.executeQuery();

	        table.setModel(DbUtils.resultSetToTableModel(rs));
	        
	        JLabel lblNewLabel_2_1_1_2_1_1_1 = new JLabel("Book Name :");
	        lblNewLabel_2_1_1_2_1_1_1.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 14));
	        lblNewLabel_2_1_1_2_1_1_1.setBounds(21, 29, 97, 26);
	        panel.add(lblNewLabel_2_1_1_2_1_1_1);
	        
		JButton b1_1 = new JButton("Back");
		b1_1.setBounds(623, 543, 86, 23);
		contentPane.add(b1_1);
		b1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Home_page();
			}
		});
		b1_1.setForeground(new Color(0, 0, 0));
		b1_1.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 12));
		b1_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0)));
		b1_1.setBackground(new Color(255, 228, 181));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("E:\\Priyanshu\\Icon\\ok_60px.png"));
		lblNewLabel.setBounds(636, 11, 73, 66);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\Priyanshu\\Icon\\bookmark_60px.png"));
		lblNewLabel_1.setBounds(23, 11, 73, 66);
		contentPane.add(lblNewLabel_1);
	                
	        rs.close();
	        st.close();
	        con.close();
	} catch (Exception e) {

	}
	}
	
	

}
