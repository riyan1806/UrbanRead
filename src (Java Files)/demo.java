import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import net.proteanit.sql.DbUtils;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Window.Type;



public class demo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					demo frame = new demo();
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
	public demo() {
		setResizable(false);
		setTitle("Data");
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Priyanshu\\Icon\\book_shelf_60px.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 804, 575);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);

		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBackground(new Color(0, 255, 204));
		layeredPane_1.setBounds(10, 95, 768,399);
		contentPane.add(layeredPane_1);
		layeredPane_1.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 248, 220));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0)), "Book Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		layeredPane_1.add(panel, "name_35342237481900");
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 11));
		textField.setBounds(128, 33, 405, 20);
		textField.setColumns(10);
		panel.add(textField);
		
		JButton b1_2 = new JButton("Search");
		b1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					//Class.forName("com.mysql.jdbc.Driver");
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_system","root","Priyanshu123");
					String sql =  "select * from book where concat(name, book_id) like ?";
					
				    PreparedStatement st=con.prepareStatement(sql);
				    st.setString(1, "%" + textField.getText() + "%");
		            ResultSet rs = st.executeQuery();
		            table.setModel(DbUtils.resultSetToTableModel(rs));
	                rs.close();
	                st.close();

	            }catch(Exception e1){
	                
	            }
				
			}
		});
		b1_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 218, 185), new Color(255, 222, 173)));
		b1_2.setBackground(new Color(0, 0, 0));
		b1_2.setForeground(new Color(240, 248, 255));
		b1_2.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 12));
		b1_2.setBounds(543, 33, 97, 20);
		panel.add(b1_2);
		
		JButton b2_2 = new JButton("Delete");
		b2_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 218, 185), new Color(255, 222, 173)));
		b2_2.setBackground(new Color(0, 0, 0));
		b2_2.setForeground(new Color(240, 248, 255));
		b2_2.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 12));
		b2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					//Class.forName("com.mysql.jdbc.Driver");
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_system","root","Priyanshu123");
					String sql = "delete from book where name = '" + textField.getText() + "'";
					String sql1 = "delete from book_backup where name = '" + textField.getText() + "'";
					
				    PreparedStatement st=con.prepareStatement(sql);
				    PreparedStatement st1=con.prepareStatement(sql1);
				    
					int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (response == JOptionPane.NO_OPTION) {

					} else if (response == JOptionPane.YES_OPTION) {
						  st1.executeUpdate();
			                    int i = st.executeUpdate();
			                    if (i > 0){
				                    JOptionPane.showMessageDialog(null, "Deleted Successfully");
			                    }
					} else if (response == JOptionPane.CLOSED_OPTION) {
			                
			                }
					st.close();
					
			            
			            con.close();
	            }catch(Exception e1){
	                
	            }
				
			}
		});
		b2_2.setBounds(650, 32, 97, 23);
		panel.add(b2_2);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBorder(null);
		scrollPane_2.setBackground(SystemColor.info);
		scrollPane_2.setBounds(21, 79, 726, 299); //21, 79, 726, 299
		panel.add(scrollPane_2);
		
		table = new JTable();
		table.setBorder(null);
		table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 int row = table.getSelectedRow();
				
					textField.setText(table.getModel().getValueAt(row, 1).toString());
			}
		});
		table.setBackground(SystemColor.info);
		table.setForeground(Color.DARK_GRAY);
		table.setFont(new Font("Trebuchet MS", Font.BOLD, 13));		
		scrollPane_2.setViewportView(table);
		
		
	
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 248, 220));
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0)), "Student Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		layeredPane_1.add(panel_1, "name_35864541327400");
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 11));
		textField_1.setColumns(10);
		textField_1.setBounds(142, 33, 391, 20);
		panel_1.add(textField_1);
		
		JButton b1_2_1 = new JButton("Search");
		b1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					//Class.forName("com.mysql.jdbc.Driver");
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_system","root","Priyanshu123");
					String sql = "select * from student where concat(name, student_id) like ? order by student_id ";
					
				    PreparedStatement st=con.prepareStatement(sql);
				    st.setString(1, "%" + textField_1.getText() + "%");
		            ResultSet rs = st.executeQuery();
		            table1.setModel(DbUtils.resultSetToTableModel(rs));
	                rs.close();
	                st.close();

	            }catch(Exception e1){
	                
	            }
			}
		});
		b1_2_1.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 12));
		b1_2_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 218, 185), new Color(255, 218, 185)));
		b1_2_1.setBackground(new Color(0, 0, 0));
		b1_2_1.setForeground(new Color(255, 255, 255));
		b1_2_1.setBounds(543, 33, 97, 20);
		panel_1.add(b1_2_1);
		
		JButton b2_2_1 = new JButton("Delete");
		b2_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					//Class.forName("com.mysql.jdbc.Driver");
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_system","root","Priyanshu123");
					String sql = "delete from student where name = '" + textField_1.getText() + "'";
					
				    PreparedStatement st=con.prepareStatement(sql);
				    
				    
					int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (response == JOptionPane.NO_OPTION) {

					} else if (response == JOptionPane.YES_OPTION) {
			                    int i = st.executeUpdate();
			                    if (i > 0){
				                    JOptionPane.showMessageDialog(null, "Deleted Successfully");
			                    }
					} else if (response == JOptionPane.CLOSED_OPTION) {
			                
			                }
					st.close();
					
			            
			            con.close();
	            }catch(Exception e1){
	                
	            }

				
			}
		});
		b2_2_1.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 12));
		b2_2_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 218, 185), new Color(255, 218, 185)));
		b2_2_1.setBackground(new Color(0, 0, 0));
		b2_2_1.setForeground(new Color(255, 255, 255));
		b2_2_1.setBounds(650, 32, 97, 23);
		panel_1.add(b2_2_1);
		
		JScrollPane scrollPane_2_1 = new JScrollPane();
		scrollPane_2_1.setBounds(21, 79, 726, 299);
		panel_1.add(scrollPane_2_1);
		
		table1 = new JTable();
		table1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		table1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 int row = table1.getSelectedRow();
					textField_1.setText(table1.getModel().getValueAt(row, 1).toString());
			}
		});
		table1.setBackground(new Color(255, 248, 220));
		table1.setForeground(Color.DARK_GRAY);
		table1.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		scrollPane_2_1.setViewportView(table1);
		
		JButton btnNewButton_1 = new JButton("Student Details\r\n");
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(new Color(255, 228, 181));
		btnNewButton_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0)));
		btnNewButton_1.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 26));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_1.removeAll();
				layeredPane_1.add(panel_1);
				layeredPane_1.repaint();
				layeredPane_1.revalidate();
			}
		});
		btnNewButton_1.setBounds(416, 24, 258, 43);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Book Details\r\n");
		btnNewButton.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0)));
		btnNewButton.setBackground(new Color(255, 228, 181));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 26));
		btnNewButton.setBounds(114, 24, 258, 43);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_1.removeAll();
				layeredPane_1.add(panel);
				layeredPane_1.repaint();
				layeredPane_1.revalidate();
				
				
			}
		});
		

        JLabel lblNewLabel_2_1_1_2_1_1 = new JLabel("Student Name :");
        lblNewLabel_2_1_1_2_1_1.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 13));
        lblNewLabel_2_1_1_2_1_1.setBounds(21, 29, 123, 26);
        panel_1.add(lblNewLabel_2_1_1_2_1_1);
               
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("E:\\Priyanshu\\Icon\\id_male_student_100px.png"));
        lblNewLabel.setBounds(10, 11, 94, 75);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("E:\\Priyanshu\\Icon\\literature_100px.png"));
        lblNewLabel_1.setBounds(684, 9, 94, 75);
        contentPane.add(lblNewLabel_1);
        
        JButton b1_1 = new JButton("Back");
        b1_1.setBounds(692, 505, 86, 23);
        contentPane.add(b1_1);
        b1_1.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 12));
        b1_1.setForeground(new Color(0, 0, 0));
        b1_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0)));
        b1_1.setBackground(new Color(255, 228, 181));
        b1_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		setVisible(false);
        		new Home_page();
        		
        	}
        });
		
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_system","root","Priyanshu123");
			String sql = "select * from book";
			
		    PreparedStatement st=con.prepareStatement(sql);			 
            ResultSet rs = st.executeQuery();

            table.setModel(DbUtils.resultSetToTableModel(rs));
            
            JLabel lblNewLabel_2_1_1_2_1_1_1 = new JLabel("Book Name :");
            lblNewLabel_2_1_1_2_1_1_1.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 14));
            lblNewLabel_2_1_1_2_1_1_1.setBounds(21, 29, 97, 26);
            panel.add(lblNewLabel_2_1_1_2_1_1_1);
            
           
                    
            rs.close();
            st.close();
            con.close();
	} catch (Exception e) {
	
	}
		
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_system","root","Priyanshu123");
			String sql = "select * from student ";
			
		    PreparedStatement st=con.prepareStatement(sql);		
            ResultSet rs = st.executeQuery();

           table1.setModel(DbUtils.resultSetToTableModel(rs)); 
           
       
           
            rs.close();            
            st.close();
            con.close();
	} catch (Exception e) {
	
	}
  	
		 	
		
	}
}
