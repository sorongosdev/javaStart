package javaStart;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Frame1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JPanel btnPanel = new JPanel();
		JLabel label = new JLabel("some text");
		JButton btn1 = new JButton("Click me");
		JButton btn2 = new JButton("Exit");
//		여러줄의 텍스트를 넣을 때 사용
		JTextArea txtArea = new JTextArea();
//		한 줄 정도의 텍스트를 넣을 때 사용
//		JTextField txtField = new JTextField(200); 
		panel.setLayout(new BorderLayout());
		
//		보이지는 않지만 패널이 추가되었다.
		frame.add(panel);
		
		btnPanel.add(btn1);
		btnPanel.add(btn2);
		panel.add(label,BorderLayout.NORTH);
		panel.add(btnPanel,BorderLayout.WEST);
		panel.add(txtArea, BorderLayout.CENTER);
		
		btn1.addActionListener(new ActionListener(){
//			addActionListner의 필수 추가 요소
			@Override
			public void actionPerformed(ActionEvent e) {
//				텍스트 영역에 텍스트를 라벨에 넣기
				label.setText(txtArea.getText());
			}
			
		});
		
		btn2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
		
		frame.setTitle("상단 문구");
		frame.setVisible(true);
		frame.setSize(new Dimension(350,350));
//		terminating the program.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		centering.
		frame.setLocationRelativeTo(null);
		frame.setResizable(true);
		
	}

}
