
//selecting the subject
package practest;
//import  practest.resorces.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;


@SuppressWarnings("serial")
public class Select_a_sub extends JFrame {

	private JPanel contentPane;
	
	
	

	/**
	 * Launch the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Select_a_sub frame = new Select_a_sub();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Select_a_sub() throws ClassNotFoundException, SQLException {
		setBackground(SystemColor.window);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 833, 481);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Choose A Subject");
		lblNewLabel.setBackground(SystemColor.window);
		lblNewLabel.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		JButton btnNewButton = new JButton("IMAGES");
		btnNewButton.setBackground(SystemColor.window);
		btnNewButton.setFont(new Font("Segoe WP Light", Font.BOLD, 15));
		
		JButton btnNewButton_1 = new JButton("PEARLS");
		btnNewButton_1.setBackground(SystemColor.window);
		btnNewButton_1.setFont(new Font("Segoe WP Light", Font.BOLD, 15));
		QueryClass toppo = new QueryClass();
		ArrayList<String> abs=toppo.S_query();
		
		JLabel btnNewButton_2 = new JLabel("");
		
		
		btnNewButton_2.setIcon(new ImageIcon(getClass().getResource("resorces/images/OIP.jpeg")));
		btnNewButton_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		
		JButton lblNewLabel_1 = new JButton("Go Back");
		lblNewLabel_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				form1 hj1 = new form1();
				hj1.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_1.setBackground(SystemColor.window);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 9));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(10)
									.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 415, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton_2, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 362, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnNewButton_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton_2, 0, 0, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addGap(9)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(18)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JList<String> list = new JList(abs.toArray());
		scrollPane.setViewportView(list);
		scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
		Border border = new LineBorder(Color.ORANGE, 0, true);
		scrollPane.setBorder(border);
		
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				
				if (me.getClickCount() == 2) {				
				String a = getStringFromList(me);
				ChapterFind pin;
				try {
					pin = new ChapterFind(a);
					contentPane.setVisible(false);
					setContentPane(pin);
					
					pin.list1.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent ce) {
							
							String b = getStringFromList(ce);
							System.out.println(b);
							
							
							
						}
					});
					
					pin.btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							pin.setVisible(false);
							contentPane.setVisible(true);
							setContentPane(contentPane);

							
						}
					});
					
					
					
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
			}}
		});
		list.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
		contentPane.setLayout(gl_contentPane);
	}
	
	public String getStringFromList(MouseEvent me) {
		
		JList target = (JList) me.getSource();
		int index = target.locationToIndex(me.getPoint());
		Object item = target.getModel().getElementAt(index);
		return item.toString();
		
	}
}
