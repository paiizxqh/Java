package Lab10_nm;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Expression;
import java.util.ArrayDeque;
import java.util.Deque;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalLab extends JFrame implements ActionListener {

	private JButton button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8, button_9, button_C, button_CE, button_Divide, button_Multipile, button_Sum, button_Sub, button_Equl;
	private JTextField t;
	private int c=0;

	public CalLab(String title) {

		t = new JTextField(16);
		button_C = new JButton("C");
		button_CE = new JButton("CE");
		button_Divide = new JButton("/");
		button_Sum = new JButton("+");
		button_Sub = new JButton("-");
		button_Multipile = new JButton("*");
		button_Equl = new JButton("=");
		button_1 = new JButton("1");
		button_2 = new JButton("2");
		button_3 = new JButton("3");
		button_4 = new JButton("4");
		button_5 = new JButton("5");
		button_6 = new JButton("6");
		button_7 = new JButton("7");
		button_8 = new JButton("8");
		button_9 = new JButton("9");

		JFrame frame = new JFrame("Calculator");
		frame.setSize(250, 300);
		frame.setEnabled(true);

		JPanel l = new JPanel();
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();

		l.setLayout(gb);

		c.fill = GridBagConstraints.HORIZONTAL;

		c.gridx = 1;
		c.gridy = 1;

		c.gridwidth = 4;
		l.add(t, c);
		c.weightx = 1;

		c.gridheight = 1;
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 2;
		l.add(button_C, c);
		c.gridx = 2;
		c.gridy = 2;
		l.add(button_CE, c);
		c.gridx = 3;
		c.gridy = 2;
		l.add(button_Divide, c);
		c.gridx = 4;
		c.gridy = 2;
		l.add(button_Multipile, c);

		c.gridx = 1;
		c.gridy = 3;
		l.add(button_1, c);
		c.gridx = 2;
		c.gridy = 3;
		l.add(button_2, c);
		c.gridx = 3;
		c.gridy = 3;
		l.add(button_3, c);
		c.gridx = 4;
		c.gridy = 3;
		l.add(button_Sum, c);

		c.gridx = 1;
		c.gridy = 4;
		l.add(button_4, c);
		c.gridx = 2;
		c.gridy = 4;
		l.add(button_5, c);
		c.gridx = 3;
		c.gridy = 4;
		l.add(button_6, c);
		c.gridx = 4;
		c.gridy = 4;
		l.add(button_Sub, c);

		c.gridx = 1;
		c.gridy = 5;
		l.add(button_7, c);
		c.gridx = 2;
		c.gridy = 5;
		l.add(button_8, c);
		c.gridx = 3;
		c.gridy = 5;
		l.add(button_9, c);
		c.gridx = 4;
		c.gridy = 5;
		l.add(button_Equl, c);

		button_C.addActionListener(this);
		button_CE.addActionListener(this);
		button_1.addActionListener(this);
		button_2.addActionListener(this);
		button_3.addActionListener(this);
		button_4.addActionListener(this);
		button_5.addActionListener(this);
		button_6.addActionListener(this);
		button_7.addActionListener(this);
		button_8.addActionListener(this);
		button_9.addActionListener(this);
		button_Sum.addActionListener(this);
		button_Sub.addActionListener(this);
		button_Divide.addActionListener(this);
		button_Equl.addActionListener(this);
		button_Multipile.addActionListener(this);

		frame.add(l);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		String s1, s2, s3;
		if (s.matches(".*[0-9,+,*,/].*") || s.contains("-")) {
			s1 = s;
			s2 = t.getText();
			if (s.matches(".*[+,*,/].*") || s.contains("-")) {
				c++;
				s3 = s2 + " " + s1 + " ";}
			else
				s3 = s2 + s1;
			t.setText(s3);
		} else if (s.contains("CE")) {
			s1 = s2 = s3 = "";
			t.setText("");
		} else if (s.matches("C")) {
			try {
				s2 = t.getText();
				int lenght = s2.length();
				s3 = s2.substring(0, lenght - 1);
				t.setText(s3);
			} catch (Exception ex) {
			}
		} else if (s.matches("=")) {
			try {
				if(c>1) {
					throw new Exception();
				}
			s1 = t.getText().trim();;
			s2 = cal(s1);
			c=0;
			t.setText(s2);
			}catch(Exception ex) {
				c=0;
				JOptionPane.showMessageDialog(null, "Error!! Syntax or more than 1 operation");
				t.setText("");
			}

		}

	}

	public String cal(String p) {
		try {
		String string[] = p.split(" ");
		int s1=0, s2=0, s3=0;

		for (String x : string) {
			if (x.matches(".*[0-9].*")) {
				if(s1==0)
				s1 = Integer.parseInt(x);
				else
				s2 = Integer.parseInt(x);

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
		}catch(Exception ex2) {
			JOptionPane.showMessageDialog(null, ex2.getMessage()+" Please enter again!!");
			return "";
		}
	}

}
