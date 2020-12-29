package practest;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;

public class Solve_mcqs extends JFrame {

	private JPanel contentPane;
	private JLabel question;
	private JLabel option_A;
	private JLabel option_b;
	private JLabel option_C;
	private JLabel option_D;
	private JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
//01.------------------Instantiating the objects-------------------------------------------------//
					Solve_mcqs frame = new Solve_mcqs();
					soup_fun fun = new soup_fun();
					QueryClass list = new QueryClass();
//02.------------------Adjusting the frame-------------------------------------------------------//
					frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
//03.------------------Getting the list from the data base---------------------------------------//
					ArrayList<quesion_data> questions = list.Q_query("Abdominal cavity and Peritoneum (review)");
					quesion_data question = questions.get(4);					
//04.------------------Setting the text into the labels------------------------------------------//
					frame.question.setText(question.getQuestion());
					frame.option_A.setText(question.getOptionA());
					frame.option_b.setText(question.getOptionB());
					frame.option_C.setText(question.getOptionC());
					frame.option_D.setText(question.getOptionD());
//05.--------------------adding border to the question and MCQ's-----------------------------------//
					Border border = BorderFactory.createLineBorder(Color.BLACK);
					frame.question.setBorder(border);
					frame.option_A.setBorder(border);
					frame.option_b.setBorder(border);
					frame.option_C.setBorder(border);
					frame.option_D.setBorder(border);
					frame.lblNewLabel.setBorder(border);			
//06.--------------------setting image to the question-------------------------------------------//
					//1-get the URL for loading image
					String  link = fun.Q_mage(question);
					if(link != null) {
					//2-getting image from fly
					URL url = new URL(link);
					BufferedImage image = ImageIO.read(url);
					//3-Adjusting the image size
					Image dimg = image.getScaledInstance(frame.lblNewLabel.getWidth(), frame.lblNewLabel.getHeight(),Image.SCALE_SMOOTH);
					//4-setting image into the label
					frame.lblNewLabel.setIcon(new javax.swing.ImageIcon(dimg));					
					}else {
						frame.lblNewLabel.setVisible(false);
					}
					
		
					

					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Solve_mcqs() {
		setBackground(SystemColor.activeCaption);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 531);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.window);
		
		question = new JLabel("Question");
		option_A = new JLabel("option_a");
		option_b = new JLabel("optiob_b");
		option_C = new JLabel("option_c");
		option_D = new JLabel("option_d");
		lblNewLabel = new JLabel("");		
		question.setBackground(SystemColor.activeCaption);		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(option_C, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
								.addComponent(option_A, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(option_D, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
								.addComponent(option_b, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)))
						.addComponent(question, GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
					.addContainerGap())
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(75)
							.addComponent(question, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(option_A, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
								.addComponent(option_b, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(option_C, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
								.addComponent(option_D, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
							.addGap(24))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(58)
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
					.addGap(0))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
					.addGap(0))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
