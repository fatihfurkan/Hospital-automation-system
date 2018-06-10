import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Color;

public class Manager extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	Connection con = null;
	private JTable table;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manager frame = new Manager();
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
	public Manager() {
		con = Homepage.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1255, 752);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblManager = new JLabel("MANAGER");
		lblManager.setFont(new Font("OCR A Extended", Font.BOLD | Font.ITALIC, 38));
		lblManager.setHorizontalAlignment(SwingConstants.CENTER);
		lblManager.setBounds(366, 0, 437, 52);
		contentPane.add(lblManager);

		JLabel lblEmployeeRegstraton = new JLabel("EMPLOYEE REGISTRATION");
		lblEmployeeRegstraton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblEmployeeRegstraton.setBounds(50, 69, 290, 14);
		contentPane.add(lblEmployeeRegstraton);

		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblName.setBounds(26, 139, 83, 14);
		contentPane.add(lblName);

		JLabel lblIdentfcatonNumber = new JLabel("IDENTIFICATION NO");
		lblIdentfcatonNumber.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblIdentfcatonNumber.setBounds(26, 164, 226, 14);
		contentPane.add(lblIdentfcatonNumber);

		JLabel lblEmal = new JLabel("E-MAIL");
		lblEmal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblEmal.setBounds(26, 189, 117, 14);
		contentPane.add(lblEmal);

		JLabel lblContactno = new JLabel("CONTACT_NO");
		lblContactno.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblContactno.setBounds(26, 214, 153, 14);
		contentPane.add(lblContactno);

		JLabel lblSalary = new JLabel("SALARY");
		lblSalary.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSalary.setBounds(26, 239, 117, 14);
		contentPane.add(lblSalary);

		JLabel lblAge = new JLabel("AGE");
		lblAge.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblAge.setBounds(26, 264, 53, 14);
		contentPane.add(lblAge);

		JLabel lblGender = new JLabel("GENDER");
		lblGender.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblGender.setBounds(26, 289, 117, 14);
		contentPane.add(lblGender);

		JLabel lblDateOfJon = new JLabel("DATE OF JOIN");
		lblDateOfJon.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblDateOfJon.setBounds(26, 340, 193, 14);
		contentPane.add(lblDateOfJon);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(189, 133, 167, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c= e.getKeyChar();
				if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))){
					e.consume();
				}
			}
		});
		textField_1.setColumns(10);
		textField_1.setBounds(189, 162, 167, 20);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(189, 187, 167, 20);
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c= e.getKeyChar();
				if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))){
					e.consume();
				}
			}
		});
		textField_3.setColumns(10);
		textField_3.setBounds(189, 212, 167, 20);
		contentPane.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c= e.getKeyChar();
				if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))){
					e.consume();
				}
			}
		});
		textField_4.setColumns(10);
		textField_4.setBounds(189, 238, 167, 20);
		contentPane.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c= e.getKeyChar();
				if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))){
					e.consume();
				}
			}
		});
		textField_5.setColumns(10);
		textField_5.setBounds(189, 263, 167, 20);
		contentPane.add(textField_5);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 245, 245));
		panel.setBounds(366, 97, 347, 112);
		contentPane.add(panel);
		panel.setVisible(false);
		panel.setLayout(null);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "Cardiologists", "Endocrinologists",
				"Gastroenterologists", "Oncologists", "Neurologists", "Haematologists", "Dermatologists",
				"Pathologists", "Orthopaedists", "Urologists" }));
		comboBox_2.setSelectedItem(null);
		comboBox_2.setBounds(164, 11, 173, 25);
		panel.add(comboBox_2);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 245, 245));
		panel_1.setBounds(365, 214, 347, 82);
		contentPane.add(panel_1);
		panel_1.setVisible(false);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(245, 245, 245));
		panel_2.setBounds(366, 307, 347, 47);
		contentPane.add(panel_2);
		panel_2.setVisible(false);
		panel_2.setLayout(null);

		JDateChooser dateChooser_2 = new JDateChooser();
		dateChooser_2.setDateFormatString("dd/MM/yyyy");
		dateChooser_2.setBounds(163, 11, 162, 20);
		panel_1.add(dateChooser_2);

		JDateChooser dateChooser_3 = new JDateChooser();
		dateChooser_3.setDateFormatString("dd/MM/yyyy");
		dateChooser_3.setBounds(163, 42, 162, 20);
		panel_1.add(dateChooser_3);

		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setDateFormatString("dd/MM/yyyy");
		dateChooser_1.setBounds(164, 69, 173, 20);
		panel.add(dateChooser_1);

		JLabel lblPoston = new JLabel("POSITION");
		lblPoston.setBounds(24, 12, 113, 14);
		panel_2.add(lblPoston);
		lblPoston.setFont(new Font("Times New Roman", Font.PLAIN, 20));

		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] { "Cleaner", "Cook", "Technician", "Security" }));
		comboBox_3.setBounds(159, 8, 163, 24);
		comboBox_3.setSelectedItem(null);
		panel_2.add(comboBox_3);

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Male", "Female" }));
		comboBox.setBounds(189, 288, 167, 20);
		comboBox.setSelectedItem(null);
		contentPane.add(comboBox);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd/MM/yyyy");
		dateChooser.setBounds(189, 340, 167, 20);
		contentPane.add(dateChooser);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 15));

		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (comboBox_1.getSelectedIndex() == 0) {
					panel.setVisible(true);
					panel_1.setVisible(false);
					panel_2.setVisible(false);
				}

				if (comboBox_1.getSelectedIndex() == 1) {
					panel_1.setVisible(true);
					panel_2.setVisible(false);
					panel.setVisible(false);
				}

				if (comboBox_1.getSelectedIndex() == 2) {
					panel_1.setVisible(false);
					panel_2.setVisible(false);
					panel.setVisible(false);
				}

				if (comboBox_1.getSelectedIndex() == 3) {
					panel_2.setVisible(true);
					panel_1.setVisible(false);
					panel.setVisible(false);
				}
			}
		});
		comboBox_1.setModel(
				new DefaultComboBoxModel(new String[] { "DOCTOR", "NURSE", "RECEPTIONIST", "OTHER EMPLOYEE" }));
		comboBox_1.setBounds(189, 315, 167, 20);
		comboBox_1.setSelectedItem(null);
		contentPane.add(comboBox_1);

		JButton btnSave = new JButton("SAVE");
		btnSave.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean status = email_validation(textField_2.getText());
				boolean status1 = identification_no_validation(textField_1.getText());
				boolean status2 = age_validation(textField_5.getText());

				if (status == true && status1 == true && status2 == true) {

					try {
						String query = "insert into employee (name,emp_id,id_number,email,contact_no,salary,gender,age,date_join)"
								+ " values(?,SEQ_EMP1.NEXTVAL,?,?,?,?,?,?,?)";
						PreparedStatement pst = con.prepareStatement(query);

						pst.setString(1, textField.getText());
						pst.setString(2, textField_1.getText());
						pst.setString(3, textField_2.getText());
						pst.setString(4, textField_3.getText());
						pst.setString(5, textField_4.getText());
						pst.setString(6, (String) comboBox.getSelectedItem());
						pst.setString(7, textField_5.getText());
						pst.setString(8, ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText());

						ResultSet rs = pst.executeQuery();

						if (comboBox_1.getSelectedIndex() == 0) {

							String query1 = "insert into doctor (emp_id,name,specialization,room_number,rest_day)"
									+ " values(SEQ_EMP1.CURRVAL,?,?,?,?)";
							PreparedStatement pst1 = con.prepareStatement(query1);

							pst1.setString(1, textField.getText());
							pst1.setString(2, (String) comboBox_2.getSelectedItem());
							pst1.setString(3, textField_6.getText());
							pst1.setString(4, ((JTextField) dateChooser_1.getDateEditor().getUiComponent()).getText());
							ResultSet rs1 = pst1.executeQuery();

							pst1.close();
							rs1.close();
						}

						if (comboBox_1.getSelectedIndex() == 1) {

							String query1 = "insert into nurse (emp_id,name,seizure_day,rest_day)"
									+ " values(SEQ_EMP1.CURRVAL,?,?,?)";
							PreparedStatement pst1 = con.prepareStatement(query1);

							pst1.setString(1, textField.getText());
							pst1.setString(2, ((JTextField) dateChooser_2.getDateEditor().getUiComponent()).getText());
							pst1.setString(3, ((JTextField) dateChooser_3.getDateEditor().getUiComponent()).getText());
							ResultSet rs1 = pst1.executeQuery();

							pst1.close();
							rs1.close();
						}

						if (comboBox_1.getSelectedIndex() == 2) {

							String query1 = "insert into receptionist (emp_id,name)" + " values(SEQ_EMP1.CURRVAL,?)";
							PreparedStatement pst1 = con.prepareStatement(query1);

							pst1.setString(1, textField.getText());

							ResultSet rs1 = pst1.executeQuery();

							pst1.close();
							rs1.close();
						}

						if (comboBox_1.getSelectedIndex() == 3) {

							String query1 = "insert into other_employee (emp_id,name,job)"
									+ " values(SEQ_EMP1.CURRVAL,?,?)";
							PreparedStatement pst1 = con.prepareStatement(query1);

							pst1.setString(1, textField.getText());
							pst1.setString(2, (String) comboBox_3.getSelectedItem());

							ResultSet rs1 = pst1.executeQuery();

							pst1.close();
							rs1.close();
						}

						JOptionPane.showMessageDialog(null, "Data Saved");
						refresh();

						pst.close();
						rs.close();

					} catch (Exception e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Data don't Saved\n Fill in the blank.");
					}
				} else if (status == false) {
					JOptionPane.showMessageDialog(null, "Email is invalid\n For example: example@gmail.com");
				} else if (status1 == false) {
					JOptionPane.showMessageDialog(null,
							"Identification number is invalid.\n           Must be 11 digits");
				}
				 else if (status2 == false) {
						JOptionPane.showMessageDialog(null,"Age is invalid\n Please enter between 0-150");
					}
			}
		});
		btnSave.setBounds(823, 115, 199, 28);
		contentPane.add(btnSave);

		JLabel lblJob = new JLabel("JOB");
		lblJob.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblJob.setBounds(26, 314, 117, 14);
		contentPane.add(lblJob);

		JButton btnShow = new JButton("SHOW");
		btnShow.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "select * from employee";
					PreparedStatement pst = con.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnShow.setBounds(823, 158, 199, 28);
		contentPane.add(btnShow);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 455, 1179, 188);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		scrollPane.setViewportView(table);
		refresh();

		JButton btnDelete = new JButton("DELETE");
		btnDelete.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					String query5 = "delete from diagnose where emp_id=" + textField_7.getText();
					PreparedStatement pst5 = con.prepareStatement(query5);
					ResultSet rs5 = pst5.executeQuery();

					String query1 = "delete from doctor where emp_id=" + textField_7.getText();
					PreparedStatement pst1 = con.prepareStatement(query1);
					ResultSet rs1 = pst1.executeQuery();

					String query2 = "delete from nurse where emp_id=" + textField_7.getText();
					PreparedStatement pst2 = con.prepareStatement(query2);
					ResultSet rs2 = pst2.executeQuery();

					String query3 = "delete from receptionist where emp_id=" + textField_7.getText();
					PreparedStatement pst3 = con.prepareStatement(query3);
					ResultSet rs3 = pst3.executeQuery();

					String query4 = "delete from other_employee where emp_id=" + textField_7.getText();
					PreparedStatement pst4 = con.prepareStatement(query4);
					ResultSet rs4 = pst4.executeQuery();

					String query = "delete from employee where emp_id=" + textField_7.getText();
					PreparedStatement pst = con.prepareStatement(query);
					ResultSet rs = pst.executeQuery();

					JOptionPane.showMessageDialog(null, "Data Deleted");
					refresh();

					pst.close();
					rs.close();

				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Data don't Deleted\n Fill in the blank.");
				}
			}
		});
		btnDelete.setBounds(823, 208, 199, 28);
		contentPane.add(btnDelete);

		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean status = email_validation(textField_2.getText());
				boolean status1 = identification_no_validation(textField_1.getText());
				
				boolean status2 = age_validation(textField_5.getText());
				

				if (status == true && status1 == true && status2 == true) {

					try {
						String query = "update employee set name='" + textField.getText() + "', id_number="
								+ textField_1.getText() + ", email='" + textField_2.getText() + "', contact_no="
								+ textField_3.getText() + ", salary=" + textField_4.getText() + ", gender='"
								+ comboBox.getSelectedItem() + "', age=" + textField_5.getText() + ", date_join='"
								+ ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText()
								+ "' where emp_id=" + textField_7.getText();
						PreparedStatement pst = con.prepareStatement(query);

						ResultSet rs = pst.executeQuery();

						if (comboBox_1.getSelectedIndex() == 0) {

							String query1 = "update doctor set name='" + textField.getText() + "', specialization='"
									+ comboBox_2.getSelectedItem() + "', room_number=" + textField_6.getText()
									+ ", rest_day='"
									+ ((JTextField) dateChooser_1.getDateEditor().getUiComponent()).getText()
									+ "' where emp_id=" + textField_7.getText();
							PreparedStatement pst1 = con.prepareStatement(query1);

							ResultSet rs1 = pst1.executeQuery();

							pst1.close();
							rs1.close();
						}

						if (comboBox_1.getSelectedIndex() == 1) {

							String query1 = "update nurse set name='" + textField.getText() + "', seizure_day='"
									+ ((JTextField) dateChooser_2.getDateEditor().getUiComponent()).getText()
									+ "', rest_day='"
									+ ((JTextField) dateChooser_3.getDateEditor().getUiComponent()).getText()
									+ "' where emp_id=" + textField_7.getText();
							PreparedStatement pst1 = con.prepareStatement(query1);

							ResultSet rs1 = pst1.executeQuery();

							pst1.close();
							rs1.close();
						}

						if (comboBox_1.getSelectedIndex() == 2) {

							String query1 = "update receptionist set name='" + textField.getText() + "' where emp_id="
									+ textField_7.getText();
							PreparedStatement pst1 = con.prepareStatement(query1);

							ResultSet rs1 = pst1.executeQuery();

							pst1.close();
							rs1.close();

						}

						if (comboBox_1.getSelectedIndex() == 3) {
							String query1 = "update other_employee set name='" + textField.getText() + "', job='"
									+ comboBox_3.getSelectedItem() + "' where emp_id=" + textField_7.getText();
							PreparedStatement pst1 = con.prepareStatement(query1);

							ResultSet rs1 = pst1.executeQuery();

							pst1.close();
							rs1.close();

						}

						JOptionPane.showMessageDialog(null, "Data Updated");
						refresh();

						pst.close();
						rs.close();

					} catch (Exception e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Data don't Updated\n Fill in the blank.");
					}
				} else if (status == false) {
					JOptionPane.showMessageDialog(null, "Email is invalid\n For example: example@gmail.com");
				} else if (status1 == false) {
					JOptionPane.showMessageDialog(null,
							"Identification number is invalid.\n           Must be 11 digits");
				}
				 else if (status2 == false) {
						JOptionPane.showMessageDialog(null,"Age is invalid\n Please enter between 0-150");
					}
			}
		});
		btnUpdate.setBounds(823, 259, 199, 28);
		contentPane.add(btnUpdate);

		JLabel lblRoomNo = new JLabel("ROOM NO");
		lblRoomNo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblRoomNo.setBounds(10, 44, 113, 14);
		panel.add(lblRoomNo);

		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_6.setColumns(10);
		textField_6.setBounds(164, 42, 173, 20);
		panel.add(textField_6);

		JLabel lblSpecalzaton = new JLabel("SPECIALIZATION");
		lblSpecalzaton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblSpecalzaton.setBounds(10, 21, 231, 14);
		panel.add(lblSpecalzaton);

		JLabel lblRestDay = new JLabel("REST DAY");
		lblRestDay.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblRestDay.setBounds(10, 69, 113, 14);
		panel.add(lblRestDay);

		JLabel label = new JLabel("REST DAY");
		label.setBounds(20, 36, 113, 14);
		panel_1.add(label);
		label.setFont(new Font("Times New Roman", Font.PLAIN, 20));

		JLabel lblSeuzreDay = new JLabel("SEUZIRE DAY");
		lblSeuzreDay.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSeuzreDay.setBounds(20, 11, 151, 14);
		panel_1.add(lblSeuzreDay);

		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_7.setEditable(false);
		textField_7.setBounds(189, 106, 167, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);

		JLabel lblEmpId = new JLabel("EMP ID");
		lblEmpId.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblEmpId.setBounds(26, 114, 117, 14);
		contentPane.add(lblEmpId);

		JLabel lblSearch = new JLabel("SEARCH");
		lblSearch.setFont(new Font("Times New Roman", Font.ITALIC, 22));
		lblSearch.setBounds(936, 29, 138, 26);
		contentPane.add(lblSearch);

		textField_8 = new JTextField();
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_8.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {

				try {
					String query = "select * from employee where name like '" + textField_8.getText()
							+ "%' or emp_id like '" + textField_8.getText() + "%' ";
					PreparedStatement pst = con.prepareStatement(query);

					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));

					pst.close();
					rs.close();

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		textField_8.setBounds(1038, 34, 167, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);

		JButton btnClear = new JButton("CLEAR");
		btnClear.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				textField_5.setText(null);
				textField_6.setText(null);
				textField_7.setText(null);
				comboBox.setSelectedItem(null);
				comboBox_1.setSelectedItem(null);
				comboBox_2.setSelectedItem(null);
				comboBox_3.setSelectedItem(null);
				dateChooser.setDate(null);
				dateChooser_1.setDate(null);
				dateChooser_2.setDate(null);
				dateChooser_3.setDate(null);
			}
		});
		btnClear.setBounds(823, 306, 199, 29);
		contentPane.add(btnClear);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Homepage h = new Homepage();
				h.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(0, 0, 107, 28);
		contentPane.add(btnBack);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(getClass().getResource("/img/pattern-background-3430.jpeg")));
		label_1.setBounds(0, 2, 1306, 747);
		contentPane.add(label_1);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {

					int i = table.getSelectedRow();
					TableModel model = table.getModel();

					textField.setText(model.getValueAt(i, 0).toString());
					textField_1.setText(model.getValueAt(i, 2).toString());
					textField_2.setText(model.getValueAt(i, 3).toString());
					textField_3.setText(model.getValueAt(i, 4).toString());
					textField_4.setText(model.getValueAt(i, 5).toString());
					comboBox.setSelectedItem(model.getValueAt(i, 6).toString());
					textField_5.setText(model.getValueAt(i, 7).toString());
					textField_7.setText(model.getValueAt(i, 1).toString());

					Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) model.getValueAt(i, 8).toString());
					dateChooser.setDate(date);

					String query = "select * from doctor";
					PreparedStatement pst = con.prepareStatement(query);
					ResultSet rs = pst.executeQuery();

					while (rs.next()) {

						if (rs.getString(1).equals(textField_7.getText())) {

							comboBox_1.setSelectedIndex(0);
							comboBox_2.setSelectedItem(rs.getString(3));
							textField_6.setText(rs.getString(4));
							dateChooser_1.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString(5)));
						}

					}

					String query1 = "select * from nurse";
					PreparedStatement pst1 = con.prepareStatement(query1);
					ResultSet rs1 = pst1.executeQuery();

					while (rs1.next()) {

						if (rs1.getString(1).equals(textField_7.getText())) {

							comboBox_1.setSelectedIndex(1);
							dateChooser_2.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(rs1.getString(3)));
							dateChooser_3.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(rs1.getString(4)));
						}

					}

					String query2 = "select * from receptionist";
					PreparedStatement pst2 = con.prepareStatement(query2);
					ResultSet rs2 = pst2.executeQuery();

					while (rs2.next()) {

						if (rs2.getString(2).equals(textField_7.getText())) {

							comboBox_1.setSelectedIndex(2);
						}

					}

					String query3 = "select * from other_employee";
					PreparedStatement pst3 = con.prepareStatement(query3);
					ResultSet rs3 = pst3.executeQuery();

					while (rs3.next()) {

						if (rs3.getString(1).equals(textField_7.getText())) {

							comboBox_1.setSelectedIndex(3);
							comboBox_3.setSelectedItem(rs3.getString(3));
						}

					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	public void refresh() {
		try {
			String query = "select * from employee";
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public static boolean email_validation(String email) {

		boolean status = false;
		String email_pattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

		Pattern pattern = Pattern.compile(email_pattern);
		Matcher m = pattern.matcher(email);

		if (m.matches()) {
			status = true;

		} else {
			status = false;
		}
		return status;
	}

	public static boolean identification_no_validation(String identification_no) {

		boolean status = false;
		Pattern pattern = Pattern.compile("\\d{11}");
		Matcher m = pattern.matcher(identification_no);

		if (m.matches()) {
			status = true;

		} else {
			status = false;
		}
		return status;

	}
	
	public static boolean age_validation(String age) {

		boolean status = false;
	

		if (Integer.parseInt(age) <= 150  && Integer.parseInt(age) >= 0) {
			status = true;

		} else {
			status = false;
		}
		return status;

	}
}
