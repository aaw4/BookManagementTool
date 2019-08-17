package com.minye.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import com.minye.dao.BookDao;
import com.minye.dao.BookTypeDao;
import com.minye.model.Book;
import com.minye.model.BookType;
import com.minye.util.DbUtil;
import com.minye.util.StringUtil;

public class AddBookInterFrm extends JInternalFrame {
	
	private DbUtil dbUtil=new DbUtil();
	private BookTypeDao bookTypeDao=new BookTypeDao();
	private BookDao bookDao=new BookDao();
	
	private JTextField bookNameTxt;
	private JTextField authorTxt;
	private JTextField priceTxt;
	
	private JTextArea bookDescTxt;
	
	private JRadioButton maleJrb;
	private JRadioButton femaleJrb;
	
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	private JComboBox bookTypeJcb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBookInterFrm frame = new AddBookInterFrm();
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
	public AddBookInterFrm() {
		setResizable(true);
		setClosable(true);
		setIconifiable(true);
		setTitle("Add Book");
		setBounds(100, 100, 753, 466);
		
		JLabel lblBookName = new JLabel("Book Name :");
		
		bookNameTxt = new JTextField();
		bookNameTxt.setColumns(10);
		
		JLabel lblAuthor = new JLabel("Author :");
		
		authorTxt = new JTextField();
		authorTxt.setColumns(10);
		
		JLabel lblAuthorGender = new JLabel("Author's Gender :");
		
		
		maleJrb = new JRadioButton("M");
		buttonGroup.add(maleJrb);
		maleJrb.setSelected(true);
		
		femaleJrb = new JRadioButton("F");
		buttonGroup.add(femaleJrb);
		
		JLabel lblBookPrice = new JLabel("Book Price :");
		
		priceTxt = new JTextField();
		priceTxt.setColumns(10);
		
		JLabel lblBookDescription = new JLabel("Book Description :");
		
		bookDescTxt = new JTextArea();
		
		JLabel lblBookGenre = new JLabel("Book Genre :");
		
	    bookTypeJcb = new JComboBox();
		
		JButton btnAddBook = new JButton("Add Book!");
		btnAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBookActionPerformed(e);
			}
		});
		btnAddBook.setIcon(new ImageIcon(AddBookInterFrm.class.getResource("/images/add.png")));
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		btnReset.setIcon(new ImageIcon(AddBookInterFrm.class.getResource("/images/reset.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblBookGenre)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblBookName)
								.addComponent(lblAuthorGender)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(btnReset)
									.addComponent(lblBookDescription)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(maleJrb)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(femaleJrb))
										.addComponent(bookTypeJcb, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
											.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblBookPrice)
										.addComponent(lblAuthor))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(priceTxt, 0, 0, Short.MAX_VALUE)
										.addComponent(authorTxt, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)))
								.addComponent(btnAddBook)
								.addComponent(bookDescTxt, Alignment.LEADING))))
					.addGap(221))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAuthor)
						.addComponent(lblBookName)
						.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(maleJrb)
						.addComponent(femaleJrb)
						.addComponent(lblBookPrice)
						.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAuthorGender))
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBookGenre)
						.addComponent(bookTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblBookDescription)
						.addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnReset)
						.addComponent(btnAddBook))
					.addGap(15))
		);
		getContentPane().setLayout(groupLayout);

		bookDescTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185), 1, false));

		
		fillBookType();

	}
	
	private void resetValueActionPerformed(ActionEvent e) {
		this.resetValue();
	}

	private void addBookActionPerformed(ActionEvent evt) {
		String bookName=this.bookNameTxt.getText();
		String author=this.authorTxt.getText();
		String price=this.priceTxt.getText();
		String bookDesc=this.bookDescTxt.getText();
		
		try {
			Float f = Float.valueOf(price);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Price has to be a number");
			return;
		}
		
		if(StringUtil.isEmpty(bookName)){
			JOptionPane.showMessageDialog(null, "Book name can't be empty!");
			return;
		}
		
		if(StringUtil.isEmpty(author)){
			JOptionPane.showMessageDialog(null, "Author name can't be empty!");
			return;
		}
		
		if(StringUtil.isEmpty(price)){
			JOptionPane.showMessageDialog(null, "Price can't be empty");
			return;
		}
		
		String sex="";
		if(maleJrb.isSelected()){
			sex="Male";
		}else if(femaleJrb.isSelected()){
			sex="Female";
		}
		
		BookType bookType=(BookType) bookTypeJcb.getSelectedItem();
		int bookTypeId=bookType.getId();
		
		Book book=new Book(bookName,author, sex, Float.parseFloat(price) , bookTypeId,  bookDesc);
		
		Connection con=null;
		try{
			con=dbUtil.getCon();
			int result=bookDao.add(con, book);
			if(result==1){
				JOptionPane.showMessageDialog(null, "Book added successfully! Yikes!");
				resetValue();
			}else{
				JOptionPane.showMessageDialog(null, "Sorry! Failed to add the book");
			}
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Sorry! Failed to add the book");
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	// reset Table
	private void resetValue(){
		this.bookNameTxt.setText("");
		this.authorTxt.setText("");
		this.priceTxt.setText("");
		this.maleJrb.setSelected(true);
		this.bookDescTxt.setText("");
		if(this.bookTypeJcb.getItemCount()>0){
			this.bookTypeJcb.setSelectedIndex(0);
		}
	}

	// Fill the J combo box with values
	private void fillBookType(){
		Connection con=null;
		BookType bookType=null;
		try{
			con=dbUtil.getCon();
			ResultSet rs=bookTypeDao.list(con, new BookType());
			while(rs.next()){
				bookType=new BookType();
				bookType.setId(rs.getInt("id"));
				bookType.setBookTypeName(rs.getString("bookTypeName"));
				this.bookTypeJcb.addItem(bookType);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
	}

}
