import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 624, 429);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblUsername.setBounds(270, 174, 115, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblPassword.setBounds(270, 221, 115, 14);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setFont(new Font("Cooper Black", Font.ITALIC, 18));
		textField.setBounds(392, 171, 186, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(392, 218, 186, 25);
		contentPane.add(passwordField);
		
		JButton btnLogn = new JButton("LOGIN");
		btnLogn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textField.getText().equals("1") && passwordField.getText().equals("1")){

					dispose();
					Manager mn = new Manager();
					mn.setVisible(true);
					
                   
				}
				
				else if(textField.getText().equals("2") && passwordField.getText().equals("2")){
					dispose();
					Doctor dctr = new Doctor();
					dctr.setVisible(true);	
				}
				
				else if(textField.getText().equals("3") && passwordField.getText().equals("3")){
					dispose();
					Receptionist rec = new Receptionist();
					rec.setVisible(true);	
					
				}
			
				else{
					JOptionPane.showMessageDialog(null, "Username or password is not correct");
				}
			}
		});
		btnLogn.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnLogn.setBounds(427, 270, 151, 42);
		contentPane.add(btnLogn);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Homepage h = new Homepage();
				h.setVisible(true);
				dispose();
			}
		});
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnCancel.setBounds(266, 270, 151, 42);
		contentPane.add(btnCancel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(getClass().getResource("/img/mixed-summer-fruits_1147-53.jpg")));
		label.setBounds(0, 0, 608, 390);
		contentPane.add(label);
	}
}
