package Lab9_2;

import java.lang.annotation.IncompleteAnnotationException;
import java.security.DigestInputStream;

public class Student {
	public String name;
	public String grade;
	public Student(String name, String grade) {
		this.name = name;
		this.grade = grade;
	}
	
	public void greet(String name){
		if(Character.isDigit(name.charAt(i))){
			System.out.println("DigitException :(digit is not allowed in name) can not display");
		}
	}

  public void show() throws IncompleteException,DigitException,SpaceException,GradeException{

  }
	//getter & setter
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getGrade(){
		return grade;
	}
	public void setGrade(String grade){
		this.grade = grade;
	}

	/*
				* IncompleteException :(grade I is incomplete) can not display. 
			DigitException :(digit is not allowed in name) can not display. 
			SpaceException :(space is not allowed in name) can not display. 
			GradeException :(grade must be A B C D E F) can not display. 
			Tony registered 3 subjects and got GPA 3.0
	 */
}
