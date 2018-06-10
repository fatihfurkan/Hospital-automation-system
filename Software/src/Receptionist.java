import java.awt.BorderLayout;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import net.miginfocom.swing.MigLayout;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDayChooser;


import com.toedter.calendar.JCalendar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Receptionist extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	Connection con = null;
	private JTable table;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Receptionist frame = new Receptionist();
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
	public Receptionist() {
		con = Homepage.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1254, 797);
		getContentPane().setLayout(null);

		JLabel lblReceptonst = new JLabel("RECEPTIONIST");
		lblReceptonst.setFont(new Font("OCR A Extended", Font.BOLD | Font.ITALIC, 31));
		lblReceptonst.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceptonst.setBounds(324, 11, 375, 41);
		getContentPane().add(lblReceptonst);

		JLabel lblPatentRegs = new JLabel("PATIENT REGISTRATION");
		lblPatentRegs.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		lblPatentRegs.setBounds(34, 85, 236, 41);
		getContentPane().add(lblPatentRegs);

		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblName.setBounds(34, 137, 80, 18);
		getContentPane().add(lblName);

		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblAddress.setBounds(34, 166, 114, 18);
		getContentPane().add(lblAddress);

		JLabel lblEmal = new JLabel("E-MAIL");
		lblEmal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblEmal.setBounds(34, 195, 80, 18);
		getContentPane().add(lblEmal);

		JLabel lblContactNo = new JLabel("CONTACT NO");
		lblContactNo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblContactNo.setBounds(34, 224, 138, 18);
		getContentPane().add(lblContactNo);

		JLabel lblSsn = new JLabel("SSN");
		lblSsn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSsn.setBounds(34, 261, 80, 18);
		getContentPane().add(lblSsn);

		JLabel lblIdentfcatonNumber = new JLabel("IDENTIFICATION NO");
		lblIdentfcatonNumber.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblIdentfcatonNumber.setBounds(34, 290, 216, 18);
		getContentPane().add(lblIdentfcatonNumber);

		JLabel lblAge = new JLabel("AGE");
		lblAge.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblAge.setBounds(34, 321, 80, 18);
		getContentPane().add(lblAge);

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Male", "Female" }));
		comboBox.setBounds(196, 352, 162, 18);
		comboBox.setSelectedItem(null);
		getContentPane().add(comboBox);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_1
				.setModel(new DefaultComboBoxModel(new String[] { "0-", "0+", "A-", "A+", "B-", "B+", "AB-", "AB+" }));
		comboBox_1.setBounds(196, 381, 162, 18);
		comboBox_1.setSelectedItem(null);
		getContentPane().add(comboBox_1);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd/MM/yyyy");
		dateChooser.setBounds(196, 412, 162, 18);
		getContentPane().add(dateChooser);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(196, 137, 162, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(196, 166, 162, 20);
		getContentPane().add(textField_1);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(196, 195, 162, 20);
		getContentPane().add(textField_2);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					e.consume();
				}
			}
		});
		textField_3.setColumns(10);
		textField_3.setBounds(196, 224, 162, 20);
		getContentPane().add(textField_3);

		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					e.consume();
				}
			}
		});
		textField_4.setColumns(10);
		textField_4.setBounds(196, 261, 162, 20);
		getContentPane().add(textField_4);

		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				char c = e.getKeyChar();
				if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					e.consume();
				}
			}
		});
		textField_5.setColumns(10);
		textField_5.setBounds(196, 290, 162, 20);
		getContentPane().add(textField_5);

		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					e.consume();
				}
			}
		});
		textField_6.setColumns(10);
		textField_6.setBounds(196, 321, 162, 20);
		getContentPane().add(textField_6);

		JLabel lblGender = new JLabel("GENDER");
		lblGender.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblGender.setBounds(34, 350, 97, 18);
		getContentPane().add(lblGender);

		JLabel lblBloodGroup = new JLabel("BLOOD GROUP");
		lblBloodGroup.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblBloodGroup.setBounds(34, 380, 156, 18);
		getContentPane().add(lblBloodGroup);

		JLabel lblAdmtDate = new JLabel("ADMITTED DATE");
		lblAdmtDate.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblAdmtDate.setBounds(34, 412, 169, 18);
		getContentPane().add(lblAdmtDate);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_2.setBounds(810, 198, 199, 18);
		getContentPane().add(comboBox_2);

		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setDateFormatString("dd/MM/yyyy");
		dateChooser_1.setBounds(196, 441, 162, 20);
		getContentPane().add(dateChooser_1);

		JButton btnShow = new JButton("SHOW");
		btnShow.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "select * from patient";
					PreparedStatement pst = con.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnShow.setBounds(422, 133, 202, 41);
		getContentPane().add(btnShow);

		JButton btnSave = new JButton("SAVE");
		btnSave.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				boolean status = email_validation(textField_2.getText());
				boolean status1 = identification_no_validation(textField_5.getText());
				boolean status2 = age_validation(textField_6.getText());


				if (status == true && status1 == true && status2 == true) {
					try {
						String query = "insert into patient (p_id,p_name,p_address,p_email,p_contact_no,ssn,p_identification_number,p_gender,p_age,blood_group,admit_date,app_date)"
								+ " values(SEQ_P_ID.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?)";
						PreparedStatement pst = con.prepareStatement(query);

						pst.setString(1, textField.getText());
						pst.setString(2, textField_1.getText());
						pst.setString(3, textField_2.getText());
						pst.setString(4, textField_3.getText());
						pst.setString(5, textField_4.getText());
						pst.setString(6, textField_5.getText());
						pst.setString(7, (String) comboBox.getSelectedItem());
						pst.setString(8, textField_6.getText());
						pst.setString(9, (String) comboBox_1.getSelectedItem());
						pst.setString(10, ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText());
						pst.setString(11, ((JTextField) dateChooser_1.getDateEditor().getUiComponent()).getText());

						ResultSet rs = pst.executeQuery();

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
							"Identification number is invalid.\n          Must be 11 digits");
				}
				 else if (status2 == false) {
						JOptionPane.showMessageDialog(null,"Age is invalid\n Please enter between 0-150");
					}
			}
		});
		btnSave.setBounds(422, 185, 202, 40);
		getContentPane().add(btnSave);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 508, 1205, 215);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		scrollPane.setViewportView(table);

		refresh();

		JButton btnDelete = new JButton("DELETE");
		btnDelete.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {

					String query = "delete from assigned where p_id=" + textField_8.getText();
					PreparedStatement pst = con.prepareStatement(query);
					ResultSet rs = pst.executeQuery();

					String query1 = "delete from bill where p_id=" + textField_8.getText();
					PreparedStatement pst1 = con.prepareStatement(query1);
					ResultSet rs1 = pst1.executeQuery();

					String query2 = "delete from diagnose where p_id=" + textField_8.getText();
					PreparedStatement pst2 = con.prepareStatement(query2);
					ResultSet rs2 = pst2.executeQuery();

					String query3 = "delete from patient where p_id=" + textField_8.getText();
					PreparedStatement pst3 = con.prepareStatement(query3);
					ResultSet rs3 = pst3.executeQuery();

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
		btnDelete.setBounds(422, 238, 202, 41);
		getContentPane().add(btnDelete);

		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean status = email_validation(textField_2.getText());
				boolean status1 = identification_no_validation(textField_5.getText());
				boolean status2 = age_validation(textField_6.getText());
				

				if (status == true && status1 == true && status2 == true) {

					try {
						String query = "update patient set p_name='" + textField.getText() + "', p_address='"
								+ textField_1.getText() + "', p_email='" + textField_2.getText() + "', p_contact_no="
								+ textField_3.getText() + ", ssn=" + textField_4.getText()
								+ ", p_identification_number=" + textField_5.getText() + ", p_age="
								+ textField_6.getText() + ", p_gender='" + (String) comboBox.getSelectedItem()
								+ "', blood_group='" + (String) comboBox_1.getSelectedItem() + "', admit_date='"
								+ ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText()
								+ "', app_date='"
								+ ((JTextField) dateChooser_1.getDateEditor().getUiComponent()).getText()
								+ "' where p_id=" + textField_8.getText();
						PreparedStatement pst = con.prepareStatement(query);

						ResultSet rs = pst.executeQuery();

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
		btnUpdate.setBounds(422, 290, 202, 41);
		getContentPane().add(btnUpdate);

		JButton btnAddToRoom = new JButton("ADD TO ROOM");
		btnAddToRoom.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnAddToRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String query2 = "select * from assigned where p_id=" + textField_8.getText();
					PreparedStatement pst2 = con.prepareStatement(query2);
					ResultSet rs2 = pst2.executeQuery();
					int count = 0;
					while (rs2.next()) {
						count = 1;
					}

					if (textField_9.getText().equals("EMPTY") && count == 0) {

						String query = "insert into assigned (p_id,room_no) values(?,?)";
						PreparedStatement pst = con.prepareStatement(query);

						pst.setString(1, textField_8.getText());
						pst.setString(2, comboBox_2.getSelectedItem().toString());

						ResultSet rs = pst.executeQuery();

						String query1 = "update room set status='FULL' where room_no=" + comboBox_2.getSelectedItem();
						PreparedStatement pst1 = con.prepareStatement(query1);
						ResultSet rs1 = pst1.executeQuery();

						textField_9.setText("FULL");

						JOptionPane.showMessageDialog(null, "Data Saved");
						refresh();

						pst.close();
						rs.close();

						pst1.close();
						rs1.close();
					}

					else if (textField_9.getText().equals("FULL")) {
						JOptionPane.showMessageDialog(null, "Room is Full");
					} else if (count == 1) {
						JOptionPane.showMessageDialog(null, "Patient is already registered to a room");
					}

				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Data don't Saved \n Fill in the blank.");
				}
			}
		});
		btnAddToRoom.setBounds(804, 280, 205, 28);
		getContentPane().add(btnAddToRoom);

		JLabel lblPd = new JLabel("P_ID");
		lblPd.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPd.setBounds(686, 166, 80, 18);
		getContentPane().add(lblPd);

		JButton btnDeleteToRoom = new JButton("DELETE TO ROOM");
		btnDeleteToRoom.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnDeleteToRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					try {

						String query = "delete from assigned where p_id=" + textField_8.getText();
						PreparedStatement pst = con.prepareStatement(query);
						ResultSet rs = pst.executeQuery();

						JOptionPane.showMessageDialog(null, "Data Deleted");

						String query1 = "update room set status='EMPTY' where room_no=" + comboBox_2.getSelectedItem();
						PreparedStatement pst1 = con.prepareStatement(query1);
						ResultSet rs1 = pst1.executeQuery();

						textField_9.setText("EMPTY");

						pst.close();
						rs.close();
						pst1.close();
						rs1.close();

					} catch (Exception e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Data don't Deleted\n Fill in the blank.");
					}
				
			}
		});
		btnDeleteToRoom.setBounds(804, 318, 205, 28);

		getContentPane().add(btnDeleteToRoom);

		JButton btnShowRoom = new JButton("HOSPITALIZATION PATIENT");
		btnShowRoom.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnShowRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String query = "select * from assigned";
					PreparedStatement pst = con.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		btnShowRoom.setBounds(804, 359, 205, 28);
		getContentPane().add(btnShowRoom);

		JLabel lblRoomNo = new JLabel("ROOM NO");
		lblRoomNo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblRoomNo.setBounds(686, 198, 162, 18);
		getContentPane().add(lblRoomNo);

		JLabel lblSeach = new JLabel("SEARCH");
		lblSeach.setFont(new Font("Times New Roman", Font.ITALIC, 22));
		lblSeach.setBounds(906, 51, 103, 19);
		getContentPane().add(lblSeach);

		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_7.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				try {
					String query = "select * from patient where p_name like '" + textField_7.getText()
							+ "%' or p_id like '" + textField_7.getText() + "%' ";
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
		textField_7.setBounds(996, 50, 156, 20);
		getContentPane().add(textField_7);
		textField_7.setColumns(10);

		textField_8 = new JTextField();
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_8.setEditable(false);
		textField_8.setBounds(810, 169, 199, 18);
		getContentPane().add(textField_8);
		textField_8.setColumns(10);

		JLabel lblADate = new JLabel("APPOINTMENT");
		lblADate.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblADate.setBounds(34, 441, 209, 18);
		getContentPane().add(lblADate);

		textField_9 = new JTextField();
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_9.setEditable(false);
		textField_9.setColumns(10);
		textField_9.setBounds(810, 227, 199, 18);
		getContentPane().add(textField_9);

		JButton btnClear = new JButton("CLEAR");
		btnClear.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				textField_5.setText(null);
				textField_6.setText(null);
				textField_8.setText(null);
				textField_9.setText(null);
				comboBox.setSelectedItem(null);
				comboBox_1.setSelectedItem(null);
				comboBox_2.setSelectedItem(null);

				dateChooser.setDate(null);
				dateChooser_1.setDate(null);

			}
		});
		btnClear.setBounds(422, 346, 202, 41);
		getContentPane().add(btnClear);

		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String query = "select * from room where room_no=" + comboBox_2.getSelectedItem();

					PreparedStatement pst = con.prepareStatement(query);
					ResultSet rs = pst.executeQuery();

					textField_9.setText(null);
					while (rs.next()) {
						textField_9.setText(rs.getString("status"));
					}

					pst.close();
					rs.close();

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});

		try {
			String query = "select * from room";
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				comboBox_2.addItem(rs.getString(1));
			}

			comboBox_2.setSelectedItem(null);

			JButton btnNewButton = new JButton("BACK");
			btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Homepage h = new Homepage();
					h.setVisible(true);
					dispose();
				}
			});
			btnNewButton.setBounds(0, 0, 114, 28);
			getContentPane().add(btnNewButton);
			
			JLabel lblStatus = new JLabel("STATUS");
			lblStatus.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lblStatus.setBounds(686, 229, 80, 18);
			getContentPane().add(lblStatus);
			
			JLabel lblDate = new JLabel("DATE");
			lblDate.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lblDate.setBounds(34, 457, 272, 18);
			getContentPane().add(lblDate);
			
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(getClass().getResource("/img/PineappleDesktop.jpg")));
			label.setBounds(0, 0, 1238, 758);
			getContentPane().add(label);

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {

					int i = table.getSelectedRow();
					TableModel model = table.getModel();

					textField.setText(model.getValueAt(i, 1).toString());
					textField_1.setText(model.getValueAt(i, 2).toString());
					textField_2.setText(model.getValueAt(i, 3).toString());
					textField_3.setText(model.getValueAt(i, 4).toString());
					textField_4.setText(model.getValueAt(i, 5).toString());
					textField_5.setText(model.getValueAt(i, 6).toString());
					textField_6.setText(model.getValueAt(i, 8).toString());
					comboBox.setSelectedItem(model.getValueAt(i, 7).toString());
					comboBox_1.setSelectedItem(model.getValueAt(i, 9).toString());
					textField_8.setText(model.getValueAt(i, 0).toString());

					Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) model.getValueAt(i, 10).toString());
					dateChooser.setDate(date);

					dateChooser_1.setDate(
							new SimpleDateFormat("yyyy-MM-dd").parse((String) model.getValueAt(i, 11).toString()));
					
					String query = "select * from assigned";
					PreparedStatement pst = con.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					
		
					comboBox_2.setSelectedItem(null);
					while (rs.next()) {
						
						if (rs.getString(1).equals(textField_8.getText())) {
							comboBox_2.setSelectedItem(rs.getString(2));
						
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
			String query = "select * from patient";
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
