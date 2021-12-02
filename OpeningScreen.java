import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;

public class OpeningScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpeningScreen frame = new OpeningScreen();
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
	public OpeningScreen() {
		setTitle("UrbanRead");
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Priyanshu\\Icon\\book_shelf_60px.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 520);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 196));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 245, 220));
		panel.setBounds(10, 263, 483, 207);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3_2_2 = new JLabel("Go To Login ");
		lblNewLabel_3_2_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_3_2_2.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 44));
		lblNewLabel_3_2_2.setBounds(10, 34, 291, 55);
		panel.add(lblNewLabel_3_2_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_3.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBackground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(45, 53, 0, 0);
		panel.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Click Here");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			setVisible(false);
			new Login_Frame();
			}
		});
		btnNewButton.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0)));
		btnNewButton.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 26));
		btnNewButton.setBackground(new Color(255, 228, 196));
		btnNewButton.setBounds(116, 109, 166, 67);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon("E:\\Priyanshu\\Icon\\login_96px.png"));
		lblNewLabel_2_1.setBounds(10, 100, 96, 96);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setIcon(new ImageIcon("E:\\Priyanshu\\Icon\\books_200px.png"));
		lblNewLabel_1_2.setBounds(280, 34, 193, 142);
		panel.add(lblNewLabel_1_2);
		
		
		
		JLabel lblNewLabel_3_2_1 = new JLabel("The Modern Day Library\r\n");
		lblNewLabel_3_2_1.setForeground(Color.WHITE);
		lblNewLabel_3_2_1.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 33));
		lblNewLabel_3_2_1.setBounds(20, 140, 459, 86);
		contentPane.add(lblNewLabel_3_2_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("UrbanRead :\r\n\r\n");
		lblNewLabel_3_2.setForeground(Color.WHITE);
		lblNewLabel_3_2.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 44));
		lblNewLabel_3_2.setBounds(20, 52, 301, 77);
		contentPane.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\Priyanshu\\Icon\\user_male_100px.png"));
		lblNewLabel_1.setBounds(309, 52, 87, 77);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("E:\\Priyanshu\\Icon\\books_100px.png"));
		lblNewLabel_2.setBounds(389, 52, 90, 75);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\image.png"));
		lblNewLabel.setBounds(10, 0, 483, 252);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setBounds(406, 52, 73, 77);
		contentPane.add(lblNewLabel_1_1);
	}
}
