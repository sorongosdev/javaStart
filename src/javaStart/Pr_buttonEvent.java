package javaStart;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;

public class Pr_buttonEvent {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pr_buttonEvent window = new Pr_buttonEvent();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Pr_buttonEvent() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel StartPage = new JPanel();
		StartPage.setBounds(0, 0, 436, 263);
		frame.getContentPane().add(StartPage);
		StartPage.setLayout(null);
		
		JButton btnNext = new JButton("go to next");
		btnNext.setBounds(257, 88, 100, 23);
		StartPage.add(btnNext);
		
		JPanel EndPage = new JPanel();
		EndPage.setBounds(0, 0, 436, 263);
		frame.getContentPane().add(EndPage);
		EndPage.setLayout(null);
		
		JButton btnLast = new JButton("go to last");
		btnLast.setBounds(257, 88, 100, 23);
		EndPage.add(btnLast);
		
//		endpage 처음에는 보이지 않기
		EndPage.setVisible(false);
		
		btnNext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				EndPage.setVisible(true);
				StartPage.setVisible(false);
			}
		});
		
		btnLast.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				StartPage.setVisible(true);
				EndPage.setVisible(false);
			}
		});
		
	}

}
