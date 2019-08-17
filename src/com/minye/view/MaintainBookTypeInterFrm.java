package com.minye.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.minye.dao.BookDao;
import com.minye.dao.BookTypeDao;
import com.minye.model.BookType;
import com.minye.util.DbUtil;
import com.minye.util.StringUtil;

public class MaintainBookTypeInterFrm extends JInternalFrame {
	private JTable bookTypeTable;
	
	private DbUtil dbUtil=new DbUtil();
	private BookTypeDao bookTypeDao=new BookTypeDao();
	private BookDao bookDao = new BookDao();
	private JTextField s_bookTypeNameTxt;
	private JTextField idTxt;
	private JTextField bookTypeNameTxt;
	private JTextArea bookTypeDescTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MaintainBookTypeInterFrm frame = new MaintainBookTypeInterFrm();
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
	public MaintainBookTypeInterFrm() {
		setResizable(true);
		setClosable(true);
		setIconifiable(true);
		setTitle("Book Genre Management");
		setBounds(100, 100, 599, 500);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblBookGenreMaintenance = new JLabel("Genre Name");
		
		s_bookTypeNameTxt = new JTextField();
		s_bookTypeNameTxt.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeSearchActionPerformed(e);
			}
		});
		btnSearch.setIcon(new ImageIcon(MaintainBookTypeInterFrm.class.getResource("/images/search.png")));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Genre Table Modification", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblBookGenreMaintenance)
							.addGap(18)
							.addComponent(s_bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
							.addComponent(btnSearch)
							.addGap(30))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBookGenreMaintenance)
						.addComponent(s_bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSearch))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JLabel lblId = new JLabel("ID :");
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		JLabel lblBookGenreName = new JLabel("Book Genre Name :");
		
		bookTypeNameTxt = new JTextField();
		bookTypeNameTxt.setColumns(10);
		
		JLabel lblBookGenreDescription = new JLabel("Book Genre Description :");
		
		bookTypeDescTxt = new JTextArea();
		
		JButton btnUpdate = new JButton("Update Genre !");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateBookTypeActionPerformed(e);
			}
		});
		btnUpdate.setIcon(new ImageIcon(MaintainBookTypeInterFrm.class.getResource("/images/modify.png")));
		
		JButton btnDelete = new JButton("Delete Genre");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				deleteBookTypeActionPerformed(evt);
			}
		});
		btnDelete.setIcon(new ImageIcon(MaintainBookTypeInterFrm.class.getResource("/images/delete.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(17)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(bookTypeDescTxt, Alignment.LEADING)
						.addComponent(lblBookGenreDescription, Alignment.LEADING)
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addComponent(lblId)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(lblBookGenreName)
							.addGap(18)
							.addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(20, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(47)
					.addComponent(btnDelete)
					.addPreferredGap(ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
					.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBookGenreName)
						.addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblBookGenreDescription)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(bookTypeDescTxt, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnUpdate)
						.addComponent(btnDelete))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		bookTypeTable = new JTable();
		bookTypeTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				bookTypeTableMousePressed(e);
			}
		});
		bookTypeTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Book Genre Name", "Genre Description"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		bookTypeTable.getColumnModel().getColumn(1).setPreferredWidth(110);
		bookTypeTable.getColumnModel().getColumn(2).setPreferredWidth(123);
		scrollPane.setViewportView(bookTypeTable);
		getContentPane().setLayout(groupLayout);
		
		this.fillTable(new BookType());

	}
	
	// delete genre event handler
	private void deleteBookTypeActionPerformed(ActionEvent evt) {
		String id = idTxt.getText();
		if (StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "Please select the genre you want to delete");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the selected genre?");
		if (n == 0) {
			Connection con = null;
			try {
				con = dbUtil.getCon();
				if (bookDao.existBookByBookTypeId(con, id)) {
					JOptionPane.showMessageDialog(null, "There exists at leats one book under this genre! Can't delete the genre for now!");
					return;
				}
				int result = bookTypeDao.delete(con, id);
				if (result == 1) {
					JOptionPane.showMessageDialog(null, "Selected genre deleted!");
					this.resetValue();
					this.fillTable(new BookType());
				} else {
					JOptionPane.showMessageDialog(null, "Deletion failed! Take the L");
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					dbUtil.closeCon(con);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	// Genre modification event handler
	private void updateBookTypeActionPerformed(ActionEvent evt) {
		String id = idTxt.getText();
		String bookTypeName = bookTypeNameTxt.getText();
		String bookTypeDesc = bookTypeDescTxt.getText();
		if (StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "Please select the genre you would like to modify");
			return;
		}
		if (StringUtil.isEmpty(bookTypeName)) {
			JOptionPane.showMessageDialog(null, "Genre Name can't be empty! Please try again");
			return;
		}
		BookType bookType = new BookType(Integer.parseInt(id), bookTypeName, bookTypeDesc);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int result = bookTypeDao.update(con, bookType);
			if (result == 1) {
				JOptionPane.showMessageDialog(null, "Book Genre was updated successfully");
				this.resetValue();
				this.fillTable(new BookType());
			} else {
				JOptionPane.showMessageDialog(null, "Sorry! Update failed. Take the L");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void resetValue() {
		this.idTxt.setText("");
		this.bookTypeNameTxt.setText("");
		this.bookTypeDescTxt.setText("");
	}

	/*
	 * handle event when a row of table is clicked
	 */
	private void bookTypeTableMousePressed(MouseEvent evt) {
		int row = bookTypeTable.getSelectedRow();
		idTxt.setText((String) bookTypeTable.getValueAt(row, 0));
		bookTypeNameTxt.setText((String) bookTypeTable.getValueAt(row, 1));
		bookTypeDescTxt.setText((String) bookTypeTable.getValueAt(row, 2));
	}

	// Search Book Genre
	private void bookTypeSearchActionPerformed(ActionEvent evt) {
		String s_bookTypeName=this.s_bookTypeNameTxt.getText();
		BookType bookType=new BookType();
		bookType.setBookTypeName(s_bookTypeName);
		this.fillTable(bookType);
	}

	// initialize table 
	private void fillTable(BookType bookType){
		DefaultTableModel dtm=(DefaultTableModel) bookTypeTable.getModel();
		dtm.setRowCount(0); 
		Connection con=null;
		try{
			con=dbUtil.getCon();
			ResultSet rs=bookTypeDao.list(con, bookType);
			while(rs.next()){
				Vector v=new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("bookTypeName"));
				v.add(rs.getString("bookTypeDesc"));
				dtm.addRow(v);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
