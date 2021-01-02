package practest;


import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JEditorPane;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.ScrollPaneConstants;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class Solve_Mcqs extends JFrame {

	private JPanel contentPane;
	
	private JTextField txtExperimentText;
	private JEditorPane image;
	private JEditorPane explanation;
	//question tag
	private JTextArea question;
	//options 
	private JButton optionA; 
	private JButton optionB; 
	private JButton optionC; 
	private JButton optionD;
	private JButton back;
	private JButton Next;
	private int j=0;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Solve_Mcqs frame = new Solve_Mcqs();
					frame.setExtendedState(frame.getExtendedState()|JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
					frame.explanation.setContentType("text/html");
					QueryClass list = new QueryClass();
					ArrayList<quesion_data> qlist = list.Q_query("Abdominal cavity and Peritoneum (review)");
					quesion_data bob = qlist.get(frame.j);
					frame.show_question(bob, frame);
					
					
					frame.Next.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							frame.j=frame.j+1;
							quesion_data bob = qlist.get(frame.j);
							frame.show_question(bob, frame);
							frame.optionA.setBackground(null);
							frame.optionB.setBackground(null);
							frame.optionC.setBackground(null);
							frame.optionD.setBackground(null);
							frame.explanation.setText(null);
							
							
							
						}
					});
					
					frame.optionA.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							if(frame.check_answer(qlist,frame.optionA, frame.j)) {
								frame.optionA.setBackground(Color.green);
							}else {
								frame.optionA.setBackground(Color.red);
							}
							
							frame.explanation.setText(qlist.get(frame.j).getExplant());
							
							
							
							
							
						}
					});
					
					frame.optionB.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(frame.check_answer(qlist,frame.optionB, frame.j)) {
								frame.optionB.setBackground(Color.green);
							}else {
								frame.optionB.setBackground(Color.red);
							}
							frame.explanation.setText(qlist.get(frame.j).getExplant());
							
							
							
						}
					});
					
					frame.optionC.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(frame.check_answer(qlist,frame.optionC, frame.j)) {
								frame.optionC.setBackground(Color.green);
							}else {
								frame.optionC.setBackground(Color.red);
							}
							frame.explanation.setText(qlist.get(frame.j).getExplant());
							
							
							
						}
					});
					
					frame.optionD.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(frame.check_answer(qlist,frame.optionD, frame.j)) {
								frame.optionD.setBackground(Color.green);
							}else {
								frame.optionD.setBackground(Color.red);
							}
							frame.explanation.setText(qlist.get(frame.j).getExplant());
							
							
							
						}
					});
					
					
					
					
					
					
					
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	void show_question(quesion_data wow,Solve_Mcqs frame){
		
		String question = wow.getQuestion();		
		frame.question.setText(question);
		
		String optiona = wow.getOptionA();
		frame.optionA.setText(optiona);
		
		String optionb = wow.getOptionB();
		frame.optionB.setText(optionb);
		
		String optionc = wow.getOptionC();
		frame.optionC.setText(optionc);
		
		String optiond = wow.getOptionD();
		frame.optionD.setText(optiond);
		
		String images = wow.getImages();
		frame.image.setText(images);
		
		
	}
	
	boolean check_answer(ArrayList<quesion_data> wow,JButton c,int j) {
		boolean a;
		
		quesion_data wow2 = wow.get(j);
		
		String ansr = c.getText();
		
		
		String ans = wow2.getCorrOPT();
		
		if(ansr.equals(ans)) {
			a=true;
			
		}else {
			a=false;
		}		
		
		return a;
		
	}
	
	
	
	

	/**
	 * Create the frame.
	 */
	public Solve_Mcqs() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 736, 521);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		txtExperimentText = new JTextField();
		txtExperimentText.setFont(new Font("YouYuan", Font.BOLD, 20));
		txtExperimentText.setHorizontalAlignment(SwingConstants.CENTER);
		txtExperimentText.setText("experiment text");
		txtExperimentText.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setViewportBorder(null);
		
		Next = new JButton("NEXT");
	
		Next.setBackground(SystemColor.window);
		
		back = new JButton("BACK");
		back.setBackground(SystemColor.window);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane)
						.addComponent(back, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
						.addComponent(Next, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
				.addComponent(txtExperimentText, GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(txtExperimentText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
							.addGap(47))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(back)
								.addComponent(Next))
							.addGap(0))))
		);
		
		explanation = new JEditorPane();
		explanation.set
		explanation.setBorder(null);
		
		
		
		

		
		explanation.setEditable(false);
		scrollPane_1.setViewportView(explanation);
		scrollPane_1.setBorder(null);
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.window);
		scrollPane.setViewportView(panel);
		scrollPane.setBorder(null);
		
		question = new JTextArea("New label");
		question.setLineWrap(true);
		question.setFont(new Font("Tahoma", Font.BOLD, 16));
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		question.setBorder(border);
		
		image = new JEditorPane();
		image.setEditable(false);
		image.setContentType("text/html");
		
		optionA = new JButton("option A");

		optionA.setBackground(SystemColor.window);
		optionA.setHorizontalAlignment(SwingConstants.CENTER);
		
		optionB = new JButton("optiob B");
		optionB.setBackground(SystemColor.window);
		optionB.setHorizontalAlignment(SwingConstants.CENTER);
		
		optionC = new JButton("option C");
		optionC.setBackground(SystemColor.window);
		optionC.setHorizontalAlignment(SwingConstants.CENTER);
		
		optionD = new JButton("option D");
		optionD.setBackground(SystemColor.window);
		optionD.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addComponent(image, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(optionA, GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addComponent(optionC, GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addComponent(optionB, GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addComponent(optionD, GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(question, GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
							.addGap(11)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(question, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(image, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(optionA, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(optionB, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(optionC, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(optionD, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
					.addGap(142))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
