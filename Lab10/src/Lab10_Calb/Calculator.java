package Lab10_Calb;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.Stack;

public class Calculator extends JFrame implements ActionListener{

	int num1=0,num2=0,num3=0,result=0,calculation=0,repeat=0,chk=0;

	private JTextField textField;
	private Stack<String> stack = new Stack<>();

	public Calculator(String title){
		super(title);
	
		Container pane = getContentPane();
		textField = new JTextField();
		textField.setFont(new Font("",Font.PLAIN,60));
		pane.add(textField,BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4,4));
		/*for(String t : buttonText)
		{Á×´
			JButton b = new JButton(t);
			b.addActionListener(this);
			panel.add(b);
		}*/
		//JButton button0 = new JButton("0");
		JButton button1 = new JButton("1");
		JButton button2 = new JButton("2");
		JButton button3 = new JButton("3");
		JButton button4 = new JButton("4");
		JButton button5 = new JButton("5");
		JButton button6 = new JButton("6");
		JButton button7 = new JButton("7");
		JButton button8 = new JButton("8");
		JButton button9 = new JButton("9");
		//JButton buttondot = new JButton(".");
		JButton buttonequals = new JButton("=");
		JButton buttonplus = new JButton("+");
		JButton buttonminus = new JButton("-");
		JButton buttonMulti = new JButton("*");
		JButton buttonDiv = new JButton("/");
		JButton buttonClear = new JButton("C");
		JButton buttonDelete = new JButton("CE");
		//JButton buttonplusm = new JButton("+-");
		/*JButton buttonarr = new JButton("<");
		JButton buttonMod = new JButton("%");
		JButton buttonSQRT = new JButton("Sqrt");
		JButton buttonpow2 = new JButton("^2");
		JButton button1Divx = new JButton("1/x");*/
		
	
		/*panel.add(buttonMod);
		panel.add(buttonSQRT);
		panel.add(buttonpow2);
		panel.add(button1Divx);*/
		panel.add(buttonDelete);
		panel.add(buttonClear);
		//panel.add(buttonarr);
		panel.add(buttonDiv);
		panel.add(buttonMulti);
		panel.add(button7);
		panel.add(button8);
		panel.add(button9);
		panel.add(buttonplus);
		panel.add(button4);
		panel.add(button5);
		panel.add(button6);
		panel.add(buttonminus);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		/*panel.add(buttonplusm);
		panel.add(button0);
		panel.add(buttondot);*/
		panel.add(buttonequals);
		
		//button0.addActionListener(this);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
		button7.addActionListener(this);
		button8.addActionListener(this);
		button9.addActionListener(this);
		//buttondot.addActionListener(this);
		buttonequals.addActionListener(this);
		buttonplus.addActionListener(this);
		buttonminus.addActionListener(this);
		buttonMulti.addActionListener(this);
		buttonDiv.addActionListener(this);
		buttonClear.addActionListener(this);
		buttonDelete.addActionListener(this);
		/*buttonplusm.addActionListener(this);
		buttonarr.addActionListener(this);
		buttonMod.addActionListener(this);
		buttonSQRT.addActionListener(this);
		buttonpow2.addActionListener(this);
		button1Divx.addActionListener(this);*/
		
		
		
		pane.add(panel);
		
		
		setSize(300, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	 public void actionPerformed(ActionEvent e) {
		JButton b = (JButton)e.getSource();
		String c =b.getText();
		try {
			if(b.getText()=="C"){
				textField.setText("");
				num1=0;
				num2=0;
				num3=0;
				calculation=0;
				repeat=0;
				//chk=1;
		}
		else if(b.getText()=="CE"){
			textField.setText("");
		}
		else if(b.getText()=="+"){
			calculation = 1;
			num1 = Integer.parseInt(textField.getText());
			textField.setText("");
			repeat=0;
		}
		else if(b.getText()=="-"){
			calculation = 2;
			num1 = Integer.parseInt(textField.getText());
			textField.setText("");
			repeat=0;
		}
		else if(b.getText()=="*"){
			calculation = 3;
			num1 = Integer.parseInt(textField.getText());
			textField.setText("");
			repeat=0;
		}
		else if(b.getText()=="/"){
			calculation = 4;
			num1 = Integer.parseInt(textField.getText());
			textField.setText("");
			repeat=0;
		}
		else if(b.getText()=="="){
			
			if(textField.getText()=="") { //·ÓäÁèäÁèä´éÇÐÐÐÐ
				num2=num1;
			}
			else {
				num2 = Integer.parseInt(textField.getText());
			}
			if(repeat==0) {
				num3 = num2;
			}
			if(calculation == 0) {
				if(num1==0) {
					result = num2;
				}
			}
			if(calculation == 1) {
				if(repeat==0) {
					result = num1+num2;
				}
				
				else{
					result = num2+num3;
				}
				repeat++;
				
			}
			if(calculation == 2) {
				if(repeat==0) {
					result = num1-num2;
				}
				else{
					result = num2-num3;
				}
				repeat++;
				
			}
			if(calculation == 3) {
				if(repeat==0) {
					result = num1*num2;
				}
				
				else{
					result = num2*num3;
				}
				repeat++;
				
			}
			if(calculation == 4) {
				/*if(num1==0) {
					result = num2;
				}*/
				if(repeat==0) {
					result = num1/num2;
				}
				
				else{
					result = num2/num3;
				}
				repeat++;
				
			}
			textField.setText(Integer.toString(result));
		}
		else{
			textField.setText(textField.getText()+b.getText());
			stack.push(b.getText());
		}
	 	}catch(Exception ex){
	
	 	}
			
	}
 
 	public static void main(String[] args){
	 	JFrame frame = new Calculator("Calculator");
 	}
}