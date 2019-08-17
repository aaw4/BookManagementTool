package com.minye.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm();
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
	public MainFrm() {
		setTitle("Welcome to Book Manager!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Book Data Management");
		mnNewMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/base.png")));
		mnNewMenu.setHorizontalAlignment(SwingConstants.CENTER);
		mnNewMenu.setBackground(Color.WHITE);
		menuBar.add(mnNewMenu);
		
		JMenu mnG = new JMenu("Genre Management");
		mnG.setIcon(new ImageIcon(MainFrm.class.getResource("/images/bookTypeManager.png")));
		mnNewMenu.add(mnG);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Add New Genre");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				AddBookTypeInterFrm addBookTypeInterFrm = new AddBookTypeInterFrm();
				addBookTypeInterFrm.setVisible(true);
				table.add(addBookTypeInterFrm);
			}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/add.png")));
		mnG.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Genre Maintenance");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MaintainBookTypeInterFrm maintainBookTypeInterFrm = new MaintainBookTypeInterFrm();
				maintainBookTypeInterFrm.setVisible(true);
				table.add(maintainBookTypeInterFrm);
			}
		});
		mntmNewMenuItem_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/edit.png")));
		mnG.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_2 = new JMenu("Book Management");
		mnNewMenu_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/bookManager.png")));
		mnNewMenu.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Add New Book(s)");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBookInterFrm addBookInterFrm = new AddBookInterFrm();
				addBookInterFrm.setVisible(true);
				table.add(addBookInterFrm);
			}
		});
		mntmNewMenuItem_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/add.png")));
		mnNewMenu_2.add(mntmNewMenuItem_3);
		
		JMenuItem mntmBookMaintenance = new JMenuItem("Book Maintenance");
		mntmBookMaintenance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MaintainBookInterFrm maintainBookInterFrm = new MaintainBookInterFrm();
				maintainBookInterFrm.setVisible(true);
				table.add(maintainBookInterFrm);
			}
		});
		mntmBookMaintenance.setIcon(new ImageIcon(MainFrm.class.getResource("/images/edit.png")));
		mnNewMenu_2.add(mntmBookMaintenance);
		
		JMenuItem mntmSafeQuit = new JMenuItem("Safe Quit");
		mntmSafeQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				int result = JOptionPane.showConfirmDialog(null, "Are you sure that you want to quit the app?");
				System.out.println(result);
				if (result == 0) {
					dispose();
				}
			}
		});
		mntmSafeQuit.setIcon(new ImageIcon(MainFrm.class.getResource("/images/exit.png")));
		mnNewMenu.add(mntmSafeQuit);
		
		JMenu mnNewMenu_1 = new JMenu("About Me");
		mnNewMenu_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/about.png")));
		mnNewMenu_1.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("About MinyeGit");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				MinyeInterFrm minyeInterFrm = new MinyeInterFrm();
				minyeInterFrm.setVisible(true);
				table.add(minyeInterFrm); 
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/about.png")));
		mnNewMenu_1.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		table = new JDesktopPane();
		contentPane.add(table, BorderLayout.CENTER);
		
		// set Jframe to max
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

}
