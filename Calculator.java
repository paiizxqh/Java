package Lab10;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Calculator extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private JButton button_6;
	private JButton button_7;
	private JButton button_8;
	private JButton button_9;
	private JButton button_c;
	private JButton button_ce;
	private JButton button_add;
	private JButton button_minus;
	private JButton button_multiply;
	private JButton button_divide;
	private JButton button_equal;
	private JTextField tf;
	
	public Calculator(){
		//Container
		Container pane = getContentPane();
		
		//JTextField
		tf = new JTextField();
		tf.setFont(new Font("Courier",Font.BOLD,40));
		pane.add(tf,BorderLayout.NORTH);
		
		//JPanel
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4,4));
		setTitle("Calculator");
		setSize(400, 400);
		
		//JButton
		button_c = new JButton("C");
		button_c.addActionListener(this);
		button_ce = new JButton("CE");
		button_ce.addActionListener(this);
		button_divide = new JButton("/");
		button_divide.addActionListener(this);
		button_multiply = new JButton("*");
		button_multiply.addActionListener(this);
		button_add = new JButton("+");
		button_add.addActionListener(this);
		button_minus = new JButton("-");
		button_minus.addActionListener(this);
		button_equal = new JButton("=");
		button_equal.addActionListener(this);
		button_1 = new JButton("1");
		button_1.addActionListener(this);
		button_2 = new JButton("2");
		button_2.addActionListener(this);
		button_3 = new JButton("3");
		button_3.addActionListener(this);
		button_4 = new JButton("4");
		button_4.addActionListener(this);
		button_5 = new JButton("5");
		button_5.addActionListener(this);
		button_6 = new JButton("6");
		button_6.addActionListener(this);
		button_7 = new JButton("7");
		button_7.addActionListener(this);
		button_8 = new JButton("8");
		button_8.addActionListener(this);
		button_9 = new JButton("9");
		button_9.addActionListener(this);

		panel.add(button_c);
		panel.add(button_ce);
		panel.add(button_divide);
		panel.add(button_multiply);
		panel.add(button_1);
		panel.add(button_2);
		panel.add(button_3);
		panel.add(button_add);
		panel.add(button_4);
		panel.add(button_5);
		panel.add(button_6);
		panel.add(button_minus);
		panel.add(button_7);
		panel.add(button_8);
		panel.add(button_9);
		panel.add(button_equal);
		
		add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton b =(JButton)e.getSource();
		String text = b.getText();
		char input = text.charAt(0);
		int length = text.length();
		//double num1 = Double.parseDouble(tf.getText());
		
		if(length == 1){
			if(Character.isDigit(input)){
				tf.setText(tf.getText()+b.getText());
			}
			else{
				switch(input) {
				case '+':
					break;
				case '-':
					break;
				case 'X':
					break;
				case '/':
					break;
				case 'C':
					tf.setText("");
				}
			}
		}
		else if(text.equals("CE")) {
			tf.setText(tf.getText().substring(0,tf.getText().length()-1));
			//Try-catch ;; StringIndexOutOfBoundsException
		}
			
	}
	
	public static void main(String arg[]){
		new Calculator();
	}
}