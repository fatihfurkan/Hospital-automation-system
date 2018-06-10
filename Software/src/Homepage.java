import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Homepage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Homepage frame = new Homepage();
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
	public static Connection dbConnector() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SOFTING", "12345s");
			Statement statement = con.createStatement();

			return con;
		} catch (Exception e) {
			e.printStackTrace();

			return null;
		}

	}

	public Homepage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1166, 663);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		dbConnector();

		JButton btnManager = new JButton("MANAGER");
		btnManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login l = new Login();
				l.setVisible(true);
				dispose();
			}
		});
		btnManager.setBounds(341, 251, 134, 44);
		contentPane.add(btnManager);

		JButton btnDoctor = new JButton("DOCTOR");
		btnDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				l.setVisible(true);
				dispose();
			}
		});
		btnDoctor.setBounds(520, 251, 122, 44);
		contentPane.add(btnDoctor);

		JButton btnReceptonst = new JButton("RECEPTIONIST");
		btnReceptonst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				l.setVisible(true);
				dispose();
			}
		});
		btnReceptonst.setBounds(678, 251, 134, 44);
		contentPane.add(btnReceptonst);
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(getClass().getResource("/img/manager.jpg")));
		label.setBounds(373, 89, 102, 151);
		contentPane.add(label);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(getClass().getResource("/img/doctor_PNG16006.png")));
		label_1.setBounds(530, 107, 105, 133);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(getClass().getResource("/img/Receptionist.jpg")));
		label_2.setBounds(696, 107, 102, 133);
		contentPane.add(label_2);

		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(getClass().getResource("/img/calendar-may-2017-uk.png")));
		label_5.setBounds(1047, -16, 110, 133);
		contentPane.add(label_5);

		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(getClass().getResource("/img/Hospital_48px_1.png")));
		label_4.setBounds(346, 22, 58, 65);
		contentPane.add(label_4);

		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(getClass().getResource("/img/dirty-pattern-paint-room-block_1203-5709.jpg")));
		label_8.setBounds(348, 46, 464, 32);
		contentPane.add(label_8);

		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(getClass().getResource("/img/c672e0f8f58f1000b0b10a74f794483c.jpg")));
		label_3.setBounds(500, 152, 158, 157);
		contentPane.add(label_3);

		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon(getClass().getResource("/img/c672e0f8f58f1000b0b10a74f794483c.jpg")));
		label_9.setBounds(500, 0, 158, 157);
		contentPane.add(label_9);

		JLabel label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon(getClass().getResource("/img/c672e0f8f58f1000b0b10a74f794483c.jpg")));
		label_10.setBounds(500, 306, 158, 157);
		contentPane.add(label_10);

		JLabel label_12 = new JLabel("");
		label_12.setIcon(new ImageIcon(getClass().getResource("/img/c672e0f8f58f1000b0b10a74f794483c.gif")));
		label_12.setBounds(0, 0, 500, 491);
		contentPane.add(label_12);

		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(getClass().getResource("/img/c672e0f8f58f1000b0b10a74f794483c.gif")));
		label_6.setBounds(657, 0, 500, 491);
		contentPane.add(label_6);

		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(getClass().getResource("/img/medicamentos.jpg")));
		label_7.setBounds(0, 491, 670, 133);
		contentPane.add(label_7);

		JLabel label_11 = new JLabel("");
		label_11.setIcon(new ImageIcon(getClass().getResource("/img/medicamentos.jpg")));
		label_11.setBounds(487, 491, 670, 133);
		contentPane.add(label_11);

		JLabel label_13 = new JLabel("");
		label_13.setIcon(new ImageIcon(getClass().getResource("/img/c672e0f8f58f1000b0b10a74f794483c.jpg")));
		label_13.setBounds(500, 412, 158, 157);
		contentPane.add(label_13);

	}


}
