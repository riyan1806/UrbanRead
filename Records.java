import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Records {
	private JTable table;
	private JTable table_1;
	public Records(){
		JFrame f=new JFrame("Records");
		f.setResizable(false);
		f.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Priyanshu\\Icon\\book_shelf_60px.png"));
		f.getContentPane().setBackground(new Color(255, 250, 240));
		f.setBounds(100, 100, 899, 760);
		f.setLocationRelativeTo(null);
		f.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0)), "Issue Book Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(new Color(255, 248, 220));
		panel.setBounds(10, 101, 863, 271);
		f.getContentPane().add(panel);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBorder(null);
		scrollPane_2.setBackground(SystemColor.info);
		scrollPane_2.setBounds(22, 22, 819, 226);
		panel.add(scrollPane_2);
		
		JTable table = new JTable();
		table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		table.setBackground(new Color(255, 248, 220));
		table.setForeground(Color.DARK_GRAY);
		table.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		scrollPane_2.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0)), "Return Book Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(new Color(255, 248, 220));
		panel_1.setBounds(10, 383, 863, 293);
		f.getContentPane().add(panel_1);
		
		JScrollPane scrollPane_2_1 = new JScrollPane();
		scrollPane_2_1.setBounds(21, 26, 818, 242);
		panel_1.add(scrollPane_2_1);
		
		
		JTable table1 = new JTable();
		table1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		table1.setBackground(new Color(255, 248, 220));
		table1.setForeground(Color.DARK_GRAY);
		table1.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		scrollPane_2_1.setViewportView(table1);
		
		
		JLabel lblNewLabel = new JLabel("Issue and Return Book Records\r\n");
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 36));
		lblNewLabel.setBounds(116, 26, 658, 48);
		f.getContentPane().add(lblNewLabel);
		
		JButton b1_2_2 = new JButton("Back");
        b1_2_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		f.setVisible(false);
        		new Home_page();
        	}
        });
        b1_2_2.setForeground(new Color(0, 0, 0));
        b1_2_2.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 12));
        b1_2_2.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0)));
        b1_2_2.setBackground(new Color(255, 228, 181));
        b1_2_2.setBounds(787, 687, 86, 23);
        f.getContentPane().add(b1_2_2);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("E:\\Priyanshu\\Icon\\book_shelf_100px.png"));
        lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(10, 11, 86, 79);
        f.getContentPane().add(lblNewLabel_1);
        
        JLabel lblNewLabel_1_1 = new JLabel("");
        lblNewLabel_1_1.setIcon(new ImageIcon("E:\\Priyanshu\\Icon\\process_100px.png"));
        lblNewLabel_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1.setBounds(787, 11, 86, 79);
        f.getContentPane().add(lblNewLabel_1_1);
		
		f.setVisible(true);
		
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_system","root","Priyanshu123");
			String sql = "select * from issueBook order by book_id";
			
		    PreparedStatement st=con.prepareStatement(sql);		
            ResultSet rs = st.executeQuery();

           table.setModel(DbUtils.resultSetToTableModel(rs)); 
           
       
           
            rs.close();            
            st.close();
            con.close();
	} catch (Exception e) {
	
	}
		
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_system","root","Priyanshu123");
			String sql = "select * from returnBook order by book_id";
			
		    PreparedStatement st=con.prepareStatement(sql);		
            ResultSet rs = st.executeQuery();

           table1.setModel(DbUtils.resultSetToTableModel(rs)); 
           
           
                                 
            rs.close();            
            st.close();
            con.close();
	} catch (Exception e) {
	
	}
		
}
	
	
	public static void main(String[] args) {
		new Records();
	}
}
