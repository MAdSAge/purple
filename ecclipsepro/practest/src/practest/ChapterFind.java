//select a chapter--

package practest;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import javax.swing.JButton;
import javax.swing.JList;


import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JScrollPane;

public class ChapterFind extends JPanel {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton btnNewButton;
	JList<String> list1;

	public ChapterFind(String subject) throws ClassNotFoundException, SQLException {
		setBackground(SystemColor.window);
		
		QueryClass sopia = new QueryClass();
		ArrayList<String> chapters = sopia.C_query(subject);
		
		
		JLabel lblNewLabel_2 = new JLabel("Choose A Chapter");
		lblNewLabel_2.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		
		btnNewButton = new JButton("Go back...");
		
		
		btnNewButton.setBackground(SystemColor.window);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(ChapterFind.class.getResource("/practest/resorces/images/3ice.jpeg")));
			
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setIcon(new ImageIcon(ChapterFind.class.getResource("/practest/resorces/images/3ice.jpeg")));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNewButton)
									.addPreferredGap(ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
									.addGap(2))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.UNRELATED)))
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(152)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 288, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 102, Short.MAX_VALUE)))))
		);
		
		list1 = new JList(chapters.toArray());
		list1.setBorder(null);
		scrollPane.setViewportView(list1);
		scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
		Border border = new LineBorder(Color.ORANGE, 0, true);
		scrollPane.setBorder(border);
		list1.setFont(new Font("Kristen ITC", Font.ITALIC, 14));
		setLayout(groupLayout);
		
		
		
	}
}
