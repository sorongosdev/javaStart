package calculator;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Cal_exception extends JFrame{

	private static final long serialVersionUID = 1456881600611113423L;
	
	// 	화면 구현
	private JTextField inputSpace;
//	방금 누른 버튼 기억하도록 변수 지정
	private String prev_operation = "";
	private ArrayList<String> equation = new ArrayList<String>();
	private String num = "";
	public JTextField answer;
	boolean focusJtf = false;	
	
	public Cal_exception() {
		
//		계산기 화면과 버튼을 붙여줄 건데 별다른 레이아웃 관리자를 사용하지 않을 것이기 때문에
		getContentPane().setLayout(null);
		
//		사용자가 친 것이 보여지는 화면
		inputSpace = new JTextField();
		inputSpace.setEditable(true);
		inputSpace.setBackground(Color.WHITE);
		inputSpace.setHorizontalAlignment(JTextField.RIGHT);
		inputSpace.setFont(new Font("Arial",Font.BOLD,30));
		inputSpace.setBounds(8,10,270,50);
		
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
			buttons[i].addActionListener(new PadActionListener());
			buttonPanel.add(buttons[i]);
		}
//		esc 누르면 c버튼이 눌리고, 엔터키를 누르면 결과값이 나온다.
		inputSpace.addKeyListener(new KeyAdapter(){
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					buttons[0].doClick();
				}				
				else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					buttons[3].doClick();
				}				
			}
		});
				
		answer = new JTextField();
		answer.setHorizontalAlignment(SwingConstants.RIGHT);
		answer.setBounds(150, 65, 123, 21);
		getContentPane().add(answer);
		answer.setColumns(10);
		
		getContentPane().add(inputSpace);
		getContentPane().add(buttonPanel);
		
		setTitle("소라표 계산기");
		setVisible(true);
		setSize(300,500);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}	

//	키별 명령
	class PadActionListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String operation = e.getActionCommand(); //getActionCommand() : 이벤트를 발생시킨 객체의 문자열을 가져온다.
			if (operation.equals("C")) { //C는 모두 지워주는 키
				inputSpace.setText("");
				}
			else if (operation.equals("=") | focusJtf) { //=을 누르면 계산결과를 보여주어야한다.
				String result = Double.toString(calculate(inputSpace.getText()));
				answer.setText(""+result);
				num = "";
			}
//			지금 누른 버튼이 연산자일 때 조건문
			else if (operation.equals("+") || operation.equals("-") || operation.equals("×") || operation.equals("÷")) {
				// 이전 누른 버튼이 연산자가 아니고, 계산식이 비어있지 않을때의 조건문 => 즉, 계산식이 비어있지 않고, 연산자를 중복으로 입력하지 않을때 정상 실행
				if (inputSpace.getText().equals("") && operation.equals("-")) { // 첫항이 음수일 때 계산할 수 있게 함.
					inputSpace.setText(inputSpace.getText() + e.getActionCommand());
				}
				if (!inputSpace.getText().equals("") && !prev_operation.equals("+") && !prev_operation.equals("-") && !prev_operation.equals("×") && !prev_operation.equals("÷")) {
					inputSpace.setText(inputSpace.getText() + e.getActionCommand()); // 다른 경우에는 문자를 추가한다
				}
			}
			else {
				inputSpace.setText(inputSpace.getText() + e.getActionCommand()); // 다른 경우에는 문자를 추가한다
			}
			prev_operation = e.getActionCommand();
		}
	}
				
	private void fullTextParsing(String inputText) {
		equation.clear();
		
		for (int i=0; i < inputText.length(); i++ ) {
			char ch = inputText.charAt(i);
			
			if (ch == '-' | ch == '+' | ch == '×' | ch == '÷' | ch == '*' | ch == '/') {
				equation.add(num);
				num = ""; // num을 초기화, 연산기호를 arraylist에 추가
				equation.add(ch + "");
				
			} else {
				num = num + ch; //연산기호가 나올 시 arraylist에 추가되고 초기화
			}
			
		}
		equation.add(num);
		equation.remove("");
	}
	
	public double calculate(String inputText) { // 계산기능
		fullTextParsing(inputText);
		
		double prev = 0 ;
		double current = 0;
		String mode = ""; // 연산자 모드
		
		for (String s : equation) {
			if (s.equals("+")) {
				mode = "add";				
			}
			else if (s.equals("-")) {
				mode = "sub";				
			}
			else if (s.equals("×") | s.equals("*")) {
				mode = "mul";				
			}
			else if (s.equals("÷") | s.equals("/")) {
				mode = "div";				
			}
			else {
				current = Double.parseDouble(s); // 문자열은 double형으로 바꾸어주어야 함.
				if (mode == "add") {
					prev += current;
				}
				else if (mode == "sub") {
					prev -= current;
				}
				else if (mode == "mul") {
					prev *= current;
				}
				else if (mode == "div") {
					prev /= current;
				}
				else {
					prev = current;
				}
			}
			prev = Math.round(prev * 1000000000)/1000000000.0; //자릿수 표현
		}
		
		return prev;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Cal_exception();
	}
}

