import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class latereturn extends JFrame {

	private JPanel contentPane;
	private JButton b1;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTable table;
	private JTable table_1;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					latereturn frame = new latereturn();
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
	public latereturn() {
		setTitle("Late Return And Fine");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Priyanshu\\Icon\\book_shelf_60px.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setBounds(100, 100, 808, 589);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
            
            JLabel lblNewLabel = new JLabel("Late Return and Fine Records");
            lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
            lblNewLabel.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 40));
            lblNewLabel.setBounds(90, 23, 605, 41);
            contentPane.add(lblNewLabel);
            
            JLayeredPane layeredPane_1 = new JLayeredPane();
            layeredPane_1.setBackground(new Color(0, 255, 204));
            layeredPane_1.setBounds(10, 79, 768, 413);
            contentPane.add(layeredPane_1);
            layeredPane_1.setLayout(new CardLayout(0, 0));
            
            JPanel panel = new JPanel();
            panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0)), "Late Return And Fine", TitledBorder.LEADING, TitledBorder.TOP, null, null));
            panel.setBackground(new Color(255, 248, 220));
            layeredPane_1.add(panel, "name_6187186165300");
            panel.setLayout(null);
            
            t1 = new JTextField();
            t1.setBounds(127, 32, 512, 21);
            t1.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 11));
            t1.setColumns(10);
            panel.add(t1);
            
            
            
            JButton b2 = new JButton("Search");
            b2.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		
            		try {
    					//Class.forName("com.mysql.jdbc.Driver");
    					
    					Class.forName("com.mysql.cj.jdbc.Driver");
    					
    					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_system","root","Priyanshu123");
    					String sql =  "select book_id, student_id , bname , sname , dateOfIssue , dateOfReturn , dateReturned \r\n"
    							+ "from returnbook \r\n"
    							+ "where dateReturned - dateOfReturn > 0 and dateReturned - dateOfReturn <= 7 and concat(bname, book_id) like ? ";
    							
    					
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
            b2.setForeground(new Color(0, 0, 0));
            b2.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 12));
            b2.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0)));
            b2.setBackground(new Color(255, 182, 193));
            b2.setBounds(649, 32, 97, 21);
            panel.add(b2);
            
            JScrollPane scrollPane_2 = new JScrollPane();
            scrollPane_2.setBorder(null);
            scrollPane_2.setBackground(SystemColor.info);
            scrollPane_2.setBounds(20, 69, 726, 321);
            panel.add(scrollPane_2);
            
            table = new JTable();
            table.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
            table.addMouseListener(new MouseAdapter() {
            	@Override
            	public void mouseClicked(MouseEvent e) {
            		 int row = table.getSelectedRow();
 					t1.setText(table.getModel().getValueAt(row, 2).toString());
            	}
            });
            
            table.setBackground(new Color(255, 182, 193));
            table.setBounds(0, 0, 1, 1);           
            scrollPane_2.setViewportView(table);
            
            JPanel panel_1 = new JPanel();
            panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0)), "Late Return And Fine", TitledBorder.LEADING, TitledBorder.TOP, null, null));
            panel_1.setBackground(new Color(255, 248, 220));
            layeredPane_1.add(panel_1, "name_6193458134100");
            panel_1.setLayout(null);
            
            JScrollPane scrollPane_2_1 = new JScrollPane();
            scrollPane_2_1.setBorder(null);
            scrollPane_2_1.setBackground(SystemColor.info);
            scrollPane_2_1.setBounds(20, 69, 726, 321); //20, 69, 726, 321
            panel_1.add(scrollPane_2_1);
            
            table_1 = new JTable();
            table_1.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
            table_1.addMouseListener(new MouseAdapter() {
            	@Override
            	public void mouseClicked(MouseEvent e) {
            		 int row = table_1.getSelectedRow();
 					t2.setText(table_1.getModel().getValueAt(row, 2).toString());
            	}
            });
            table_1.setBackground(new Color(255, 182, 193));
            table_1.setBounds(0, 0, 1, 1);           
            scrollPane_2_1.setViewportView(table_1);
            
            t2 = new JTextField();
            t2.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 11));
            t2.setColumns(10);
            t2.setBounds(127, 32, 512, 21);
            panel_1.add(t2);
            
            JButton b3 = new JButton("Search");
            b3.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		
            		try {
    					//Class.forName("com.mysql.jdbc.Driver");
    					
    					Class.forName("com.mysql.cj.jdbc.Driver");
    					
    					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_system","root","Priyanshu123");
    					String sql =  "select book_id, student_id , bname , sname , dateOfIssue , dateOfReturn , dateReturned \r\n"
    							+ "from returnbook \r\n"
    							+ "where dateReturned - dateOfReturn > 7 and dateReturned - dateOfReturn <=28 and concat(bname, book_id) like ? ";
    							
    					
    				    PreparedStatement st=con.prepareStatement(sql);
    				    st.setString(1, "%" + t2.getText() + "%");
    		            ResultSet rs = st.executeQuery();
    		            table_1.setModel(DbUtils.resultSetToTableModel(rs));
    	                rs.close();
    	                st.close();

    	            }catch(Exception e1){
    	                
    	            }
            	}
            });
            b3.setForeground(new Color(0, 0, 0));
            b3.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 12));
            b3.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0)));
            b3.setBackground(new Color(255, 182, 193));
            b3.setBounds(649, 32, 97, 21);
            panel_1.add(b3);
            
            JPanel panel_2 = new JPanel();
            panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0)), "Late Return And Fine", TitledBorder.LEADING, TitledBorder.TOP, null, null));
            panel_2.setBackground(new Color(255, 248, 220));
            layeredPane_1.add(panel_2, "name_6199161580700");
            panel_2.setLayout(null);
            
            JScrollPane scrollPane_2_1_1 = new JScrollPane();
            scrollPane_2_1_1.setBorder(null);
            scrollPane_2_1_1.setBackground(SystemColor.info);
            scrollPane_2_1_1.setBounds(20, 69, 726, 321);
            panel_2.add(scrollPane_2_1_1);
            
            table_2 = new JTable();
            table_2.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
            table_2.addMouseListener(new MouseAdapter() {
            	@Override
            	public void mouseClicked(MouseEvent e) {
            		 int row = table_2.getSelectedRow();
 					t3.setText(table_2.getModel().getValueAt(row, 2).toString());
            	}
            });
            table_2.setBackground(new Color(255, 182, 193));
            table_2.setBounds(0, 0, 1, 1);
            scrollPane_2_1_1.setViewportView(table_2);
            
            
            t3 = new JTextField();
            t3.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 11));
            t3.setColumns(10);
            t3.setBounds(127, 32, 512, 21);
            panel_2.add(t3);
            
            JButton b4 = new JButton("Search");
            b4.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		

            		try {
    					//Class.forName("com.mysql.jdbc.Driver");
    					
    					Class.forName("com.mysql.cj.jdbc.Driver");
    					
    					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_system","root","Priyanshu123");
    					String sql =  "select book_id, student_id , bname , sname , dateOfIssue , dateOfReturn , dateReturned \r\n"
    							+ "from returnbook \r\n"
    							+ "where dateReturned - dateOfReturn > 28 and concat(bname, book_id) like ? ";
    							
    					
    				    PreparedStatement st=con.prepareStatement(sql);
    				    st.setString(1, "%" + t3.getText() + "%");
    		            ResultSet rs = st.executeQuery();
    		            table_2.setModel(DbUtils.resultSetToTableModel(rs));
    	                rs.close();
    	                st.close();

    	            }catch(Exception e1){
    	                
    	            }
            	}
            });
            b4.setForeground(new Color(0, 0, 0));
            b4.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 12));
            b4.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0)));
            b4.setBackground(new Color(255, 182, 193));
            b4.setBounds(649, 32, 97, 21);
            panel_2.add(b4);
            
            JButton op2 = new JButton("Within 1 Month");
            op2.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		
            		layeredPane_1.removeAll();
    				layeredPane_1.add(panel_1);
    				layeredPane_1.repaint();
    				layeredPane_1.revalidate();
            	}
            });
            op2.setBounds(365, 515, 123, 20);
            contentPane.add(op2);
            op2.setForeground(Color.BLACK);
            op2.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 15));
            op2.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0)));
            op2.setBackground(new Color(255, 228, 181));
            
            JLabel lblNewLabel_2_1_1_2_1 = new JLabel("Date Returned : ");
            lblNewLabel_2_1_1_2_1.setBounds(20, 510, 172, 26);
            contentPane.add(lblNewLabel_2_1_1_2_1);
            lblNewLabel_2_1_1_2_1.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
            
            b1 = new JButton("Back");
            b1.setBounds(692, 515, 86, 23);
            contentPane.add(b1);
            b1.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		setVisible(false);
            		new Home_page();
            		
            	}
            });
            b1.setForeground(new Color(0, 0, 0));
            b1.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 12));
            b1.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0)));
            b1.setBackground(new Color(255, 228, 181));
            
            JButton op3 = new JButton("After 1 month");
            op3.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		
            		layeredPane_1.removeAll();
    				layeredPane_1.add(panel_2);
    				layeredPane_1.repaint();
    				layeredPane_1.revalidate();
            	}
            });
            op3.setBounds(508, 515, 123, 20);
            contentPane.add(op3);
            op3.setForeground(Color.BLACK);
            op3.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 15));
            op3.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0)));
            op3.setBackground(new Color(255, 228, 181));
            
            JButton op1 = new JButton("Within 1 Week");
            op1.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		
            		layeredPane_1.removeAll();
    				layeredPane_1.add(panel);
    				layeredPane_1.repaint();
    				layeredPane_1.revalidate();
            	}
            });
            op1.setBounds(220, 515, 123, 20);
            contentPane.add(op1);
            op1.setForeground(Color.BLACK);
            op1.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 15));
            op1.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0)));
            op1.setBackground(new Color(255, 228, 181));
            
            try {
    			//Class.forName("com.mysql.jdbc.Driver");
    			
    			Class.forName("com.mysql.cj.jdbc.Driver");
    			
    			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_system","root","Priyanshu123");
    			String sql = "select book_id, student_id , bname , sname , dateOfIssue , dateOfReturn , dateReturned , Late_Duration , Fine_Amount\r\n"
    					+ "from returnbook , fine\r\n"
    					+ "where  timestampdiff(day ,dateOfReturn , dateReturned) < 7 and timestampdiff(day ,dateOfReturn , dateReturned) > 0 and Sr_no = 1 ";
    			
    		    PreparedStatement st=con.prepareStatement(sql);			 
                ResultSet rs = st.executeQuery();
                table.setModel(DbUtils.resultSetToTableModel(rs)); 
                
                JLabel lblNewLabel_2_1_1_2_1_1 = new JLabel("Book Name :");
                lblNewLabel_2_1_1_2_1_1.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 14));
                lblNewLabel_2_1_1_2_1_1.setBounds(20, 28, 97, 26);
                panel.add(lblNewLabel_2_1_1_2_1_1);
                
            
                    
            rs.close();
            st.close();
            con.close();
	} catch (Exception e) {
	
	}
            
            try {
    			//Class.forName("com.mysql.jdbc.Driver");
    			
    			Class.forName("com.mysql.cj.jdbc.Driver");
    			
    			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_system","root","Priyanshu123");
    			String sql = "select book_id, student_id , bname , sname , dateOfIssue , dateOfReturn , dateReturned , Late_Duration , Fine_Amount\r\n"
    					+ "from returnbook , fine\r\n"
    					+ "where timestampdiff(day ,dateOfReturn , dateReturned) < 30  and timestampdiff(day ,dateOfReturn , dateReturned) > 7 and Sr_no = 2 ";
    			
    		    PreparedStatement st=con.prepareStatement(sql);			 
                ResultSet rs = st.executeQuery();
                table_1.setModel(DbUtils.resultSetToTableModel(rs)); 
                
                JLabel lblNewLabel_2_1_1_2_1_1 = new JLabel("Book Name :");
                lblNewLabel_2_1_1_2_1_1.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 14));
                lblNewLabel_2_1_1_2_1_1.setBounds(20, 28, 97, 26);
                panel_1.add(lblNewLabel_2_1_1_2_1_1);
                
            
                    
            rs.close();
            st.close();
            con.close();
	} catch (Exception e) {
	
	}
            
            try {
    			//Class.forName("com.mysql.jdbc.Driver");
    			
    			Class.forName("com.mysql.cj.jdbc.Driver");
    			
    			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_system","root","Priyanshu123");
    			String sql = "select book_id, student_id , bname , sname , dateOfIssue , dateOfReturn , dateReturned , Late_Duration , Fine_Amount\r\n"
    					+ "from returnbook , fine\r\n"
    					+ "where timestampdiff(day ,dateOfReturn , dateReturned) > 30 and  Sr_no = 3 ";
    			
    		    PreparedStatement st=con.prepareStatement(sql);			 
                ResultSet rs = st.executeQuery();
                table_2.setModel(DbUtils.resultSetToTableModel(rs)); 
                
                JLabel lblNewLabel_2_1_1_2_1_1 = new JLabel("Book Name :");
                lblNewLabel_2_1_1_2_1_1.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 14));
                lblNewLabel_2_1_1_2_1_1.setBounds(20, 28, 97, 26);
                panel_2.add(lblNewLabel_2_1_1_2_1_1);
                
                JLabel lblNewLabel_1 = new JLabel("");
                lblNewLabel_1.setIcon(new ImageIcon("E:\\Priyanshu\\Icon\\cancel_60px.png"));
                lblNewLabel_1.setBounds(705, 11, 73, 66);
                contentPane.add(lblNewLabel_1);
                
                JLabel lblNewLabel_2 = new JLabel("");
                lblNewLabel_2.setIcon(new ImageIcon("E:\\Priyanshu\\Icon\\last_6_hours_60px.png"));
                lblNewLabel_2.setBounds(19, 11, 73, 66);
                contentPane.add(lblNewLabel_2);
                
            
                    
            rs.close();
            st.close();
            con.close();
	} catch (Exception e) {
	
	}
	}
}
