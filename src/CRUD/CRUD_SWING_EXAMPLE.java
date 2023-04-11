package CRUD;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.table.TableModel;

public class CRUD_SWING_EXAMPLE {

	private JFrame frmEmplyeeManagementSystem;
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtAge;
	private JTextField txtCity;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CRUD_SWING_EXAMPLE window = new CRUD_SWING_EXAMPLE();
					window.frmEmplyeeManagementSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CRUD_SWING_EXAMPLE() {
		initialize();
		connect();
		loadData();
	}

	// Database Connection purpose
	Connection con = null;
	PreparedStatement st = null;
	ResultSet rs;

	public void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/vignesh";
			String user = "root";
			String pwd = "tiger";
			con = DriverManager.getConnection(url, user, pwd);
		} catch (Exception e) {
			e.toString();
		}
	}

	// clear function
	public void clear() {
		txtId.setText("");
		txtName.setText("");
		txtAge.setText("");
		txtCity.setText("");
		txtName.requestFocus();
	}

	// Load Data
	public void loadData() {
		try {
			st = con.prepareStatement("Select * from users");
			rs = st.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e2) {
			e2.toString();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEmplyeeManagementSystem = new JFrame();
		frmEmplyeeManagementSystem.setTitle("Project");
		frmEmplyeeManagementSystem.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		frmEmplyeeManagementSystem.setBounds(100, 100, 800, 350);
		frmEmplyeeManagementSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEmplyeeManagementSystem.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("User Management System");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 11, 342, 40);
		frmEmplyeeManagementSystem.getContentPane().add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(10, 62, 300, 191);
		frmEmplyeeManagementSystem.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Id");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 11, 60, 25);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Name");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 47, 60, 25);
		panel_1.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Age");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(10, 83, 60, 25);
		panel_1.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("City");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(10, 119, 60, 25);
		panel_1.add(lblNewLabel_1_3);

		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtId.setBounds(65, 11, 225, 25);
		panel_1.add(txtId);
		txtId.setColumns(10);

		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtName.setColumns(10);
		txtName.setBounds(65, 47, 225, 25);
		panel_1.add(txtName);

		txtAge = new JTextField();
		txtAge.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAge.setColumns(10);
		txtAge.setBounds(65, 83, 225, 25);
		panel_1.add(txtAge);

		txtCity = new JTextField();
		txtCity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCity.setColumns(10);
		txtCity.setBounds(65, 119, 225, 25);
		panel_1.add(txtCity);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Id = txtId.getText();
				String Name = txtName.getText();
				String Age = txtAge.getText();
				String City = txtCity.getText();

				if (Name == null || Name.isEmpty() || Name.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter Name");
					txtName.requestFocus();
					return;
				}
				if (Age == null || Age.isEmpty() || Age.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter Age");
					txtAge.requestFocus();
					return;
				}
				if (City == null || City.isEmpty() || City.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter City");
					txtCity.requestFocus();
					return;
				}
				if (txtId.getText().isEmpty()) {
					try {
						String qry = "insert into users (Name,Age,City) values(?,?,?)";
						st = con.prepareStatement(qry);
						st.setString(1, Name);
						st.setString(2, Age);
						st.setString(3, City);
						st.executeUpdate();
						JOptionPane.showMessageDialog(null, "Data Inserted");
						clear();
						loadData();

					} catch (Exception e1) {
						e1.toString();
					}
				}
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSave.setBounds(10, 155, 80, 23);
		panel_1.add(btnSave);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Id = txtId.getText();
				String Name = txtName.getText();
				String Age = txtAge.getText();
				String City = txtCity.getText();

				if (Name == null || Name.isEmpty() || Name.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter Name");
					txtName.requestFocus();
					return;
				}
				if (Age == null || Age.isEmpty() || Age.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter Age");
					txtAge.requestFocus();
					return;
				}
				if (City == null || City.isEmpty() || City.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter City");
					txtCity.requestFocus();
					return;
				}
				if (!txtId.getText().isEmpty()) {
					try {
						String qry = "update users set Name=?,Age=?,City=? where Id=?";
						st = con.prepareStatement(qry);
						st.setString(1, Name);
						st.setString(2, Age);
						st.setString(3, City);
						st.setString(4, Id);
						st.executeUpdate();
						JOptionPane.showMessageDialog(null, "Data Updated");
						clear();
						loadData();

					} catch (Exception e1) {
						e1.toString();
					}
				}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUpdate.setBounds(109, 155, 80, 23);
		panel_1.add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Delete query
				String Id = txtId.getText();
				if (!txtId.getText().isEmpty()) {
					int result = JOptionPane.showConfirmDialog(null, "you want to delete this record?", "Delete",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

					if (result == JOptionPane.YES_NO_OPTION) {
						try {
							String qry = "delete from users where Id=?";
							st = con.prepareStatement(qry);
							st.setString(1, Id);
							st.executeUpdate();
							JOptionPane.showMessageDialog(null, "Data Deleted");
							clear();
							loadData();

						} catch (Exception e1) {
							e1.toString();
						}
					}
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelete.setBounds(210, 155, 80, 23);
		panel_1.add(btnDelete);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(320, 62, 454, 191);
		frmEmplyeeManagementSystem.getContentPane().add(scrollPane);

		table = new JTable();
		table.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setRowHeight(table.getRowHeight() + 10);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				TableModel model = table.getModel();
				// Get data
				txtId.setText(model.getValueAt(index, 0).toString());
				txtName.setText(model.getValueAt(index, 1).toString());
				txtAge.setText(model.getValueAt(index, 2).toString());
				txtCity.setText(model.getValueAt(index, 3).toString());
			}
		});
		scrollPane.setViewportView(table);
	}
}
