package Lab10_nm;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {

	private JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, bC, bCE, bDiv, bMul, bSum, bSub, bEqul;
	private JTextField text;

	public Calculator(String title) {

		text = new JTextField(16);
		text.setEditable(false);
		bC = new JButton("C");
		bCE = new JButton("CE");
		bDiv = new JButton("/");
		bSum = new JButton("+");
		bSub = new JButton("-");
		bMul = new JButton("*");
		bEqul = new JButton("=");
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");

		JFrame frame = new JFrame("Calculator");
		frame.setSize(250, 300);
		frame.setEnabled(true);

		JPanel layout1 = new JPanel();
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();

		layout1.setLayout(gbl);

		gbc.fill = GridBagConstraints.HORIZONTAL;

		gbc.insets = new Insets(3, 3, 3, 3);

		gbc.gridx = 1;
		gbc.gridy = 1;

		gbc.gridwidth = 4;
		layout1.add(text, gbc);
		gbc.weightx = 1;

		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.gridx = 1;
		gbc.gridy = 2;
		layout1.add(bC, gbc);
		gbc.gridx = 2;
		gbc.gridy = 2;
		layout1.add(bCE, gbc);
		gbc.gridx = 3;
		gbc.gridy = 2;
		layout1.add(bDiv, gbc);
		gbc.gridx = 4;
		gbc.gridy = 2;
		layout1.add(bMul, gbc);

		gbc.gridx = 1;
		gbc.gridy = 3;
		layout1.add(b1, gbc);
		gbc.gridx = 2;
		gbc.gridy = 3;
		layout1.add(b2, gbc);
		gbc.gridx = 3;
		gbc.gridy = 3;
		layout1.add(b3, gbc);
		gbc.gridx = 4;
		gbc.gridy = 3;
		layout1.add(bSum, gbc);

		gbc.gridx = 1;
		gbc.gridy = 4;
		layout1.add(b4, gbc);
		gbc.gridx = 2;
		gbc.gridy = 4;
		layout1.add(b5, gbc);
		gbc.gridx = 3;
		gbc.gridy = 4;
		layout1.add(b6, gbc);
		gbc.gridx = 4;
		gbc.gridy = 4;
		layout1.add(bSub, gbc);

		gbc.gridx = 1;
		gbc.gridy = 5;
		layout1.add(b7, gbc);
		gbc.gridx = 2;
		gbc.gridy = 5;
		layout1.add(b8, gbc);
		gbc.gridx = 3;
		gbc.gridy = 5;
		layout1.add(b9, gbc);
		gbc.gridx = 4;
		gbc.gridy = 5;
		layout1.add(bEqul, gbc);

		bC.addActionListener(this);
		bCE.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		bSum.addActionListener(this);
		bSub.addActionListener(this);
		bDiv.addActionListener(this);
		bEqul.addActionListener(this);
		bMul.addActionListener(this);

		frame.add(layout1);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		String input = e.getActionCommand();
		String s1, s2, s3;
		if (input.matches(".*[0-9,+,*,/].*") || input.contains("-")) {
			s1 = input;
			s2 = text.getText();
			if (input.matches(".*[+,*,/].*") || input.contains("-")) {
				s3 = s2 + " " + s1 + " ";
			}
			else {
				s3 = s2 + s1;
				text.setText(s3);
			}
		}
		else if (input.contains("CE")) {
			s1 = s2 = s3 = "";
			text.setText("");
		}
		else if (input.matches("C")) {
			try {
				s2 = text.getText();
				int lenght = s2.length();
				s3 = s2.substring(0, lenght - 1);
				text.setText(s3);
			}
			catch (Exception ex) {
			}
		}
		else if (input.matches("=")) {
			s1 = text.getText().trim();
			s2 = toPostfix(s1);
			s3 = postfixToValue(s2);
			text.setText(s3);
		}

	}

	private int Prec(String ch) {
		switch (ch) {
		case "+":
		case "-":
			return 1;

		case "*":
		case "/":
			return 2;
		}
		return -1;
	}

	public String toPostfix(String exp) {

		String result = new String("");
		String op1[];
		Deque<String> stack = new ArrayDeque<String>();
		stack.clear();
		op1 = exp.split(" ");
		for (String x : op1) {
			if (x.matches(".*[0-9].*"))
				result += x + " ";
			else {
				while (!stack.isEmpty() && Prec(x) <= Prec(stack.peek())) {

					result += stack.peek() + " ";
					stack.pop();
				}
				stack.push(x);
			}
		}
		while (!stack.isEmpty()) {
			result += stack.peek() + " ";
			stack.pop();
		}
		return result;
	}

	public String postfixToValue(String post) {
		try {
		String op2[] = post.split(" ");
		int s1, s2, s3;
		Deque<String> stack = new ArrayDeque<String>();
		stack.clear();
		for (String x : op2) {
			if (x.matches(".*[0-9].*")) {
				stack.push(x);
			} else {
				switch (x) {
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
		}catch(Exception ex2) {
			JOptionPane.showMessageDialog(null, ex2.getMessage()+" Please enter again!!");
			return "";
		}
	}

}