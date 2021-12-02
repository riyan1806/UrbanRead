import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

public class Home_page {
	 
	Home_page (){
		JFrame f=new JFrame("Home Page");
		f.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Priyanshu\\Icon\\book_shelf_60px.png"));
		f.setResizable(false);
		f.getContentPane().setBackground(new Color(255, 250, 240));
		f.setBounds(100, 100 , 738 , 681);
		f.setLocationRelativeTo(null);
		f.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(10, 11, 702, 182);
		f.getContentPane().add(panel_1);
		
		JLabel lblNewLabel_3_2 = new JLabel(" UrbanRead :\r\n\r\n ");
		lblNewLabel_3_2.setForeground(Color.WHITE);
		lblNewLabel_3_2.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 48));
		lblNewLabel_3_2.setBounds(0, 21, 399, 77);
		panel_1.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("A Library Management System\r\n");
		lblNewLabel_3_1_1.setForeground(Color.WHITE);
		lblNewLabel_3_1_1.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 33));
		lblNewLabel_3_1_1.setBounds(20, 81, 554, 90);
		panel_1.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\image.png"));
		lblNewLabel.setBounds(0, 0, 704, 182);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 204, 702, 426);
		f.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 702, 426);
		panel_2.add(panel);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0)), "Features", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(255, 255, 224));
		panel.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.BLACK, Color.BLACK));
		separator.setForeground(Color.BLACK);
		separator.setBounds(0, 183, 702, 2);
		panel.add(separator);
		
		JButton btnNewButton_1 = new JButton("Add Student");
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0)));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				new Addstudent();
			}
		});
		btnNewButton_1.setBackground(new Color(255, 228, 181));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBounds(24, 133, 140, 23);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\Priyanshu\\Icon\\reading_100px.png"));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(29, 11, 123, 119);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton_1_1 = new JButton("Records");
		btnNewButton_1_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_1_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0)));
		btnNewButton_1_1.setBackground(new Color(255, 228, 181));
		btnNewButton_1_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				new Records();
			}
		});
		btnNewButton_1_1.setBounds(366, 322, 140, 23);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Add Book");
		btnNewButton_1_2.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_1_2.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0)));
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				new Addbooks();
			}
		});
		btnNewButton_1_2.setBackground(new Color(255, 228, 181));
		btnNewButton_1_2.setForeground(new Color(0, 0, 0));
		btnNewButton_1_2.setBounds(366, 133, 140, 23);
		panel.add(btnNewButton_1_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setBackground(new Color(250, 235, 215));
		lblNewLabel_1_2.setIcon(new ImageIcon("E:\\Priyanshu\\Icon\\book_100px.png"));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setBounds(372, 11, 123, 116);
		panel.add(lblNewLabel_1_2);
		
		JButton btnNewButton_1_3 = new JButton("Issue Book\r\n");
		btnNewButton_1_3.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_1_3.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0)));
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				new Issuebook();
			}
		});
		btnNewButton_1_3.setBackground(new Color(255, 228, 181));
		btnNewButton_1_3.setForeground(new Color(0, 0, 0));
		btnNewButton_1_3.setBounds(24, 322, 140, 23);
		panel.add(btnNewButton_1_3);
		
		JButton btnNewButton_1_4 = new JButton("Return Book\r\n");
		btnNewButton_1_4.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_1_4.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0)));
		btnNewButton_1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				new Returnbook();
			}
		});
		btnNewButton_1_4.setBackground(new Color(255, 228, 181));
		btnNewButton_1_4.setForeground(new Color(0, 0, 0));
		btnNewButton_1_4.setBounds(195, 322, 140, 23);
		panel.add(btnNewButton_1_4);
		
		JLabel lblNewLabel_1_3 = new JLabel("");
		lblNewLabel_1_3.setBorder(null);
		lblNewLabel_1_3.setBackground(new Color(255, 255, 255));
		lblNewLabel_1_3.setIcon(new ImageIcon("E:\\Priyanshu\\Icon\\book_shelf_80px.png"));
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setBounds(372, 187, 140, 134);
		panel.add(lblNewLabel_1_3);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		btnExit.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0)));
		btnExit.setIcon(null);
		btnExit.setBounds(575, 383, 104, 23);
		panel.add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
			}
		});
		btnExit.setForeground(new Color(0, 0, 0));
		btnExit.setBackground(new Color(255, 228, 181));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon("E:\\Priyanshu\\Icon\\account_80px.png"));
		lblNewLabel_2.setBounds(200, 11, 135, 119);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Login Page");
		btnNewButton.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0)));
		btnNewButton.setBounds(429, 383, 123, 23);
		panel.add(btnNewButton);
		btnNewButton.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				new Login_Frame() ;
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 228, 181));
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.BLACK, Color.BLACK));
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(0, 365, 702, 2);
		panel.add(separator_1);
		
		JButton btnNewButton_1_4_1 = new JButton("Data");
		btnNewButton_1_4_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_1_4_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0)));
		btnNewButton_1_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					try {
						demo frame = new demo();
						frame.setVisible(true);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				
				f.setVisible(false);								
			}
		});
		btnNewButton_1_4_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1_4_1.setBackground(new Color(255, 228, 181));
		btnNewButton_1_4_1.setBounds(195, 133, 140, 23);
		panel.add(btnNewButton_1_4_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setIcon(new ImageIcon("E:\\Priyanshu\\Icon\\save_as_80px.png"));
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setBounds(24, 195, 140, 116);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("E:\\Priyanshu\\Icon\\books_emoji_96px.png"));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(205, 197, 140, 124);
		panel.add(lblNewLabel_3);
		
		JButton btnNewButton_1_2_1 = new JButton("Available Books");
		btnNewButton_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AvailableBooks frame = new AvailableBooks();
				frame.setVisible(true);
				f.setVisible(false);
				
			}
		});
		btnNewButton_1_2_1.setForeground(Color.BLACK);
		btnNewButton_1_2_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_1_2_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0)));
		btnNewButton_1_2_1.setBackground(new Color(255, 228, 181));
		btnNewButton_1_2_1.setBounds(539, 133, 140, 23);
		panel.add(btnNewButton_1_2_1);
		
		JButton btnNewButton_1_2_2 = new JButton("Late Return and Fine\r\n\r\n");
		btnNewButton_1_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				latereturn frame = new latereturn();
				frame.setVisible(true);
				f.setVisible(false);
			}
		});
		btnNewButton_1_2_2.setForeground(Color.BLACK);
		btnNewButton_1_2_2.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_1_2_2.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0)));
		btnNewButton_1_2_2.setBackground(new Color(255, 228, 181));
		btnNewButton_1_2_2.setBounds(539, 322, 140, 23);
		panel.add(btnNewButton_1_2_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("");
		lblNewLabel_1_2_1.setIcon(new ImageIcon("E:\\Priyanshu\\Icon\\book_shelf_96px.png"));
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setBackground(new Color(250, 235, 215));
		lblNewLabel_1_2_1.setBounds(545, 14, 123, 116);
		panel.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("");
		lblNewLabel_1_2_1_1.setIcon(new ImageIcon("E:\\Priyanshu\\Icon\\cash_in_hand_80px.png"));
		lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1.setBackground(new Color(250, 235, 215));
		lblNewLabel_1_2_1_1.setBounds(545, 197, 123, 116);
		panel.add(lblNewLabel_1_2_1_1);
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Home_page ();
	}
}

