package Lab10;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayDeque;
import java.util.Deque;

import javax.swing.*;


public class Calculator extends JFrame implements ActionListener {
	
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
	private int clr = 0;
	
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
		String input = e.getActionCommand();
		String s1, s2, s3;
		if(input.matches(".*[0-9,+,*,/].*") || input.contains("-")) {
			s1 = input;
			s2 = tf.getText();
			if(input.matches(".*[+,*,/].*") || input.contains("-")) {
				s3 = s2 + " " + s1 + " ";
			}
			else{
				s3 = s2 + s1;
				tf.setText(s3);
			}
		}
		else if(input.contains("CE")) {
			s1 = s2 = s3 = "";
			tf.setText("");
		}
		else if(input.matches("C")) {
			try{
				s2 = tf.getText();
				int lenght = s2.length();
				s3 = s2.substring(0, lenght - 1);
				tf.setText(s3);
			}
			catch(Exception ex) {
				
			}
		}
		else if(input.matches("=")) {
			try {
				if(clr>1) {
					throw new Exception();
				}
			s1 = tf.getText().trim();
			s2 = Postfix(s1);
			s2 = Cal(s1);
			s3 = postfixToValue(s2);
			tf.setText(s3);
			clr=0;
			}
			catch(Exception ex) {
				clr=0;
				JOptionPane.showMessageDialog(null, "Error!! Syntax or more than 1 operation");
				tf.setText("");
			}
		}
	}
	
	private int Symbol(String ch) {
		switch(ch) {
			case "+":
			case "-":
				return 1;
			case "*":
			case "/":
				return 2;
		}
		return -1;
	}
	
	public String Postfix(String exp) {
		String result = new String("");
		String op1[];
		Deque<String> stack = new ArrayDeque<String>();
		stack.clear();
		op1 = exp.split(" ");
		for(String x : op1){
			if(x.matches(".*[0-9].*")) {
				result += x + " ";
			}
			else {
				while(!stack.isEmpty()&&Symbol(x) <= Symbol(stack.peek())){
					result += stack.peek() + " ";
					stack.pop();
				}
				stack.push(x);
			}
		}
		while(!stack.isEmpty()){
			result += stack.peek() + " ";
			stack.pop();
		}
		return result;
	}
	
	public String postfixToValue(String post){
		try {
			String op2[] = post.split(" ");
			int s1, s2, s3;
			Deque<String> stack = new ArrayDeque<String>();
			stack.clear();
			for(String x : op2) {
				if(x.matches(".*[0-9].*")) {
					stack.push(x);
				} else {
					switch(x) {
						case "+":
							s1 = Integer.parseInt(stack.peek());
							stack.pop();
							s2 = Integer.parseInt(stack.peek());
							stack.pop();
							s3 = s1 + s2;
							stack.push(s3 + "");
							break;
						case "-":
							s1 = Integer.parseInt(stack.peek());
							stack.pop();
							s2 = Integer.parseInt(stack.peek());
							stack.pop();
							s3 = s2 - s1;
							stack.push(s3 + "");
							break;
						case "*":
							s1 = Integer.parseInt(stack.peek());
							stack.pop();
							s2 = Integer.parseInt(stack.peek());
							stack.pop();
							s3 = s1 * s2;
							stack.push(s3 + "");
							break;
						case "/":
							s1 = Integer.parseInt(stack.peek());
							stack.pop();
							s2 = Integer.parseInt(stack.peek());
							stack.pop();
							s3 = s2 / s1 ;
							stack.push(s3 + "");
							break;
					}
				}
			}
			return stack.peek();
		}
		catch(Exception ex2) {
			JOptionPane.showMessageDialog(null, ex2.getMessage()+" Please enter again!!");
			return "";
		}
	}
	/*-----------------------------------------------------------------*/

	public String Cal(String p) {
		try {
			String string[] = p.split(" ");
			int s1=0, s2=0, s3=0;
		for (String x : string) {
			if (x.matches(".*[0-9].*")) {
				if(s1==0) {
					s1 = Integer.parseInt(x);
				}
				else {
				s2 = Integer.parseInt(x);
				}
			}
		}
		switch (string[1]) {
			case "+":					
				s3 = s1 + s2;					
				break;
			case "-":
				s3 = s1 - s2 ;					
				break;
			case "*":
				s3 = s1 * s2;
				break;
			case "/":
				s3 = s1 / s2  ;
				break;
		}
		return s3+"";
		}
		catch(Exception ex2) {
			JOptionPane.showMessageDialog(null, ex2.getMessage()+" Please enter again!!");
			return "";
		}
	}
	
	public static void main(String arg[]){
		new Calculator();
	}
}