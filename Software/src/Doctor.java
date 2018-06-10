import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.event.AncestorListener;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.event.AncestorEvent;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JEditorPane;
import javax.swing.ImageIcon;

public class Doctor extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	Connection con = null;
	private JLabel lblNewLabel;
	private JLabel lblPd;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Doctor frame = new Doctor();
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
	public Doctor() {
		con = Homepage.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1287, 645);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblDoctor = new JLabel("DOCTOR");
		lblDoctor.setFont(new Font("OCR A Extended", Font.BOLD | Font.ITALIC, 40));
		lblDoctor.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctor.setBounds(396, 18, 312, 54);
		contentPane.add(lblDoctor);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 438, 1240, 145);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		scrollPane.setViewportView(table);
		refresh();

		JButton btnShowPatent = new JButton("SHOW PATIENT");
		btnShowPatent.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnShowPatent.addActionListener(new ActionListener() {
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
		btnShowPatent.setBounds(950, 115, 300, 45);
		contentPane.add(btnShowPatent);

		lblNewLabel = new JLabel("ADD DIAGNOSIS");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setBounds(95, 89, 193, 22);
		contentPane.add(lblNewLabel);

		lblPd = new JLabel("P_ID");
		lblPd.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblPd.setBounds(21, 147, 46, 22);
		contentPane.add(lblPd);

		JLabel lblEmpd = new JLabel("EMP_ID");
		lblEmpd.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblEmpd.setBounds(21, 180, 85, 22);
		contentPane.add(lblEmpd);

		JLabel lblDagnoss = new JLabel("DIAGNOSIS");
		lblDagnoss.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblDagnoss.setBounds(21, 213, 133, 22);
		contentPane.add(lblDagnoss);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setEditable(false);
		textField.setBounds(187, 148, 155, 22);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(187, 214, 155, 22);
		contentPane.add(textField_2);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_1.setBounds(187, 281, 155, 21);
		contentPane.add(comboBox_1);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setToolTipText("");
		dateChooser.setDateFormatString("dd/MM/yyyy");
		dateChooser.setBounds(187, 246, 155, 22);
		contentPane.add(dateChooser);

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setBounds(187, 182, 155, 21);
		contentPane.add(comboBox);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"X-RAY", "MR"}));
		comboBox_4.setBounds(600, 216, 203, 22);
		comboBox_4.setSelectedItem(null);
		contentPane.add(comboBox_4);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
		editorPane.setBounds(600, 247, 203, 100);
		contentPane.add(editorPane);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Stay in hospital", "Not stay in hospital"}));
		comboBox_2.setSelectedItem(null);
		comboBox_2.setBounds(600, 147, 203, 25);
		contentPane.add(comboBox_2);
		
		JLabel lblDepartmant = new JLabel("DEPARTMENT");
		lblDepartmant.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblDepartmant.setBounds(414, 184, 176, 22);
		contentPane.add(lblDepartmant);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_3.setBounds(600, 180, 203, 25);
		contentPane.add(comboBox_3);


		JButton btnAddDagnoss = new JButton("ADD DIAGNOSIS");
		btnAddDagnoss.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnAddDagnoss.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String query = "insert into diagnose (p_id,emp_id,d_name) values(?,?,?)";
					PreparedStatement pst = con.prepareStatement(query);

					pst.setString(1, textField.getText());
					pst.setString(2, (String) comboBox.getSelectedItem());
					pst.setString(3, textField_2.getText());
					ResultSet rs = pst.executeQuery();

					String query1 = "update patient set app_date='"
							+ ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText() + "' where p_id="
							+ textField.getText();
					PreparedStatement pst1 = con.prepareStatement(query1);

					ResultSet rs1 = pst1.executeQuery();

					String query2 = "insert into bill (m_code,p_id) values(?,?)";
					PreparedStatement pst2 = con.prepareStatement(query2);

					pst2.setString(1, (String) comboBox_1.getSelectedItem());
					pst2.setString(2, (String) textField.getText());

					ResultSet rs2 = pst2.executeQuery();

					JOptionPane.showMessageDialog(null, "Data Saved");
					refresh();

					pst.close();
					rs.close();

				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Data don't Saved\n Fill in the blank.");
				}
			}
		});
		btnAddDagnoss.setBounds(950, 168, 300, 45);
		contentPane.add(btnAddDagnoss);

		JLabel lblAppontmentDate = new JLabel("APPOINTMENT");
		lblAppontmentDate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblAppontmentDate.setBounds(21, 240, 203, 22);
		contentPane.add(lblAppontmentDate);

		JLabel lblDate = new JLabel("DATE");
		lblDate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblDate.setBounds(21, 257, 85, 22);
		contentPane.add(lblDate);

		JButton btnDelete = new JButton("DELETE");
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					String query = "delete from diagnose where p_id=" + textField.getText();
					PreparedStatement pst = con.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					
					String query1 = "delete from bill where p_id=" + textField.getText();
					PreparedStatement pst1 = con.prepareStatement(query1);
					ResultSet rs1 = pst1.executeQuery();
					
					String query2 = "delete from p_info where p_id=" + textField.getText();
					PreparedStatement pst2 = con.prepareStatement(query2);
					ResultSet rs2 = pst2.executeQuery();

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
		btnDelete.setBounds(950, 223, 300, 45);
		contentPane.add(btnDelete);

		JLabel lblMedcneCode = new JLabel("MEDICINE CODE");
		lblMedcneCode.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMedcneCode.setBounds(21, 279, 214, 22);
		contentPane.add(lblMedcneCode);

		try {
			String query = "select * from doctor";
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				comboBox.addItem(rs.getString(1));
			}
			comboBox.setSelectedItem(null);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		
		try {
			String query = "select * from medicine";
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				comboBox_1.addItem(rs.getString(1));
			}
			comboBox_1.setSelectedItem(null);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
			

			JButton btnNewButton = new JButton("UPDATE");
			btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 22));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					try {
						String query = "update diagnose set d_name='" + textField_2.getText() + "', emp_id="
								+ comboBox.getSelectedItem() + " where p_id=" + textField.getText();
						PreparedStatement pst = con.prepareStatement(query);

						ResultSet rs = pst.executeQuery();
						
						String query1 = "update patient set app_date='" + ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText() +
								"' where p_id=" + textField.getText();
						PreparedStatement pst1 = con.prepareStatement(query1);

						ResultSet rs1 = pst1.executeQuery();
						
						String query2 = "update bill set m_code='" + comboBox_1.getSelectedItem() +
								"' where p_id=" + textField.getText();
						PreparedStatement pst2 = con.prepareStatement(query2);

						ResultSet rs2 = pst2.executeQuery();

						JOptionPane.showMessageDialog(null, "Data Updated");
						refresh();

						pst.close();
						rs.close();

					} catch (Exception e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Data don't Updated\n Fill in the blank.");
					}
				}
			});
			btnNewButton.setBounds(950, 283, 300, 45);
			contentPane.add(btnNewButton);
			
			JButton btnClear = new JButton("CLEAR");
			btnClear.setFont(new Font("Times New Roman", Font.BOLD, 22));
			btnClear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					textField.setText(null);
					textField_2.setText(null);
					comboBox.setSelectedItem(null);
					comboBox_1.setSelectedItem(null);
					comboBox_2.setSelectedItem(null);
					comboBox_3.setSelectedItem(null);
					comboBox_4.setSelectedItem(null);
					editorPane.setText(null);
					dateChooser.setDate(null);
				}
			});
			btnClear.setBounds(950, 339, 300, 45);
			contentPane.add(btnClear);
			
			JLabel lblSearch = new JLabel("SEARCH");
			lblSearch.setFont(new Font("Times New Roman", Font.PLAIN, 24));
			lblSearch.setBounds(893, 40, 103, 22);
			contentPane.add(lblSearch);
			
			textField_1 = new JTextField();
			textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			textField_1.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent arg0) {
					

					try {
						String query = "select * from patient where p_name like '" + textField_1.getText()
								+ "%' or p_id like '" + textField_1.getText() + "%' ";
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
			textField_1.setColumns(10);
			textField_1.setBounds(993, 44, 155, 22);
			contentPane.add(textField_1);
			
			JLabel lblHosptalzatonStatu = new JLabel("HOSPITALIZATION");
			lblHosptalzatonStatu.setFont(new Font("Times New Roman", Font.BOLD, 20));
			lblHosptalzatonStatu.setBounds(414, 147, 214, 22);
			contentPane.add(lblHosptalzatonStatu);
			
			JLabel lblStatus = new JLabel("STATUS");
			lblStatus.setFont(new Font("Times New Roman", Font.BOLD, 20));
			lblStatus.setBounds(414, 161, 118, 22);
			contentPane.add(lblStatus);
			
	
		

		
		try {
			String query1 = "select * from hospital";

			PreparedStatement pst1 = con.prepareStatement(query1);
			ResultSet rs1 = pst1.executeQuery();

			
			while (rs1.next()) {
				comboBox_3.addItem(rs1.getString(1));
			}
			
			comboBox_3.setSelectedItem(null);
			
		}catch (Exception e1) {
				e1.printStackTrace();
			}
		
		

	  	
	
			
			
			JButton btnAdd = new JButton("SAVE");
			btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 20));
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
						
						String query = "select * from p_info";
						PreparedStatement pst = con.prepareStatement(query);
						ResultSet rs = pst.executeQuery();


						while (rs.next()) {

							if (rs.getString(5).equals(textField.getText())) {
								
								String query1 = "delete from p_info where p_id=" + textField.getText();
								PreparedStatement pst1 = con.prepareStatement(query1);
								ResultSet rs1 = pst1.executeQuery();
						
							}

						}
						
						String query1 = "insert into p_info (p_id,status,department,requests,explanation) values(?,?,?,?,?)";
						PreparedStatement pst1 = con.prepareStatement(query1);

						pst1.setString(1, textField.getText());
						pst1.setString(2, (String) comboBox_2.getSelectedItem());
						pst1.setString(3, (String) comboBox_3.getSelectedItem());
						pst1.setString(4, (String) comboBox_4.getSelectedItem());
						pst1.setString(5, editorPane.getText());
						ResultSet rs1 = pst1.executeQuery();
						


						JOptionPane.showMessageDialog(null, "Data Saved");
						refresh();

						pst1.close();
						rs1.close();

					} catch (Exception e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Data don't Saved\n Fill in the blank.");
					}
			
				}
			});
			btnAdd.setBounds(600, 361, 203, 23);
			contentPane.add(btnAdd);
			
			
			
			JLabel lblDe = new JLabel("EXPLANATION");
			lblDe.setFont(new Font("Times New Roman", Font.BOLD, 20));
			lblDe.setBounds(414, 246, 160, 22);
			contentPane.add(lblDe);
			
			JLabel lblRequests = new JLabel("REQUESTS");
			lblRequests.setFont(new Font("Times New Roman", Font.BOLD, 20));
			lblRequests.setBounds(414, 213, 118, 22);
			contentPane.add(lblRequests);
			
			JButton btnNewButton_1 = new JButton("BACK");
			btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Homepage h = new Homepage();
					h.setVisible(true);
					dispose();
				}
			});
			btnNewButton_1.setBounds(0, 0, 117, 32);
			contentPane.add(btnNewButton_1);
			
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(getClass().getResource("/img/makower-funky-fruit-2364-red-cherries-pink-flowers-on-cream-background-100-cotton-fabric-[2]-8522-p.jpg")));
			label.setBounds(0, 0, 1048, 611);
			contentPane.add(label);
			
			JLabel label_1 = new JLabel("");
			label_1.setIcon(new ImageIcon(getClass().getResource("/img/makower-funky-fruit-2364-red-cherries-pink-flowers-on-cream-background-100-cotton-fabric-[2]-8522-p.jpg")));
			label_1.setBounds(993, 0, 278, 611);
			contentPane.add(label_1);

		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				try {
					int i = table.getSelectedRow();
					TableModel model = table.getModel();

					textField.setText(model.getValueAt(i, 0).toString());
					
				
					
					Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) model.getValueAt(i, 11).toString());
					dateChooser.setDate(date);

					String query = "select * from diagnose";
					PreparedStatement pst = con.prepareStatement(query);
					ResultSet rs = pst.executeQuery();

					textField_2.setText(null);
					comboBox.setSelectedItem(null);

					while (rs.next()) {

						if (rs.getString(2).equals(textField.getText())) {
							textField_2.setText(rs.getString(1));
							comboBox.setSelectedItem(rs.getString(3));
						}

					}

					String query1 = "select * from bill";
					PreparedStatement pst1 = con.prepareStatement(query1);
					ResultSet rs1 = pst1.executeQuery();

					comboBox_1.setSelectedItem(null);
					while (rs1.next()) {

						if (rs1.getString(1).equals(textField.getText())) {

							comboBox_1.setSelectedItem(rs1.getString(2));
						}

					}
					
					String query2 = "select * from p_info";
					PreparedStatement pst2 = con.prepareStatement(query2);
					ResultSet rs2 = pst2.executeQuery();
					
					comboBox_2.setSelectedItem(null);
					comboBox_3.setSelectedItem(null);
					comboBox_4.setSelectedItem(null);
					editorPane.setText(null);
					
					while (rs2.next()) {

						if (rs2.getString(5).equals(textField.getText())) {

							comboBox_2.setSelectedItem(rs2.getString(1));
							comboBox_3.setSelectedItem(rs2.getString(2));
							comboBox_4.setSelectedItem(rs2.getString(3));
							editorPane.setText(rs2.getString(4));
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
}
