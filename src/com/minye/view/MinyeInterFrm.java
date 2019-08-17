package com.minye.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;


public class MinyeInterFrm extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MinyeInterFrm frame = new MinyeInterFrm();
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
	public MinyeInterFrm() {
		setClosable(true);
		setTitle("About MinyeGit");
		setBounds(100, 100, 450, 300);
		
		JLabel lblHttpsgithubcomminyegit = new JLabel("https://github.com/MinyeGit");
		lblHttpsgithubcomminyegit.setIcon(new ImageIcon(MinyeInterFrm.class.getResource("/images/profile.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(82)
					.addComponent(lblHttpsgithubcomminyegit)
					.addContainerGap(99, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(69)
					.addComponent(lblHttpsgithubcomminyegit)
					.addContainerGap(121, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

}
