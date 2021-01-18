package calculator;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.*;

public class Cal_shape extends JFrame {	

	private static final long serialVersionUID = 1456881600611113423L;
	
	// 	화면 구현
	private JTextField inputSpace;
	
	public Cal_shape() {
		
//		계산기 화면과 버튼을 붙여줄 건데 별다른 레이아웃 관리자를 사용하지 않을 것이기 때문에
		setLayout(null);
		
//		사용자가 친 것이 보여지는 화면
		inputSpace = new JTextField();
		inputSpace.setEditable(false);
		inputSpace.setBackground(Color.WHITE);
		inputSpace.setHorizontalAlignment(JTextField.RIGHT);
		inputSpace.setFont(new Font("Arial",Font.BOLD,100));
		inputSpace.setBounds(8,10,270,70);
		
		JPanel buttonPanel = new JPanel();
//		격자무늬 만들기
		buttonPanel.setLayout(new GridLayout(4,4,10,10));
		buttonPanel.setBounds(8,90,270,235);
		
//		버튼 이름 만들기
		String button_names[] = {"C", "÷", "×", "=", "7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "0" };
		JButton buttons[] = new JButton[button_names.length];
		
//		for문으로 만든 배열로 버튼 만들기
		for (int i=0; i<button_names.length; i++) {
			buttons[i] = new JButton(button_names[i]);
			buttonPanel.add(buttons[i]);
			if (button_names[i] == "C") buttons[i].setBackground(Color.RED);
			else if ((i >= 4 && i <= 6) || (i >= 8 && i <= 10) || (i >= 12 && i <= 14)) buttons[i].setBackground(Color.BLACK);
			else buttons[i].setBackground(Color.GRAY);
			buttons[i].setForeground(Color.WHITE);
			buttons[i].setBorderPainted(false); // 테두리 없애기
			buttonPanel.add(buttons[i]);			
		}
		
		add(inputSpace);
		add(buttonPanel);
		
		setTitle("소라표 계산기");
		setVisible(true);
		setSize(300,500);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Cal_shape();
	}

}
