import javax.swing.*;

public class Task2 {
	public static void main(String[] args) {
		String name, rollno, ageS;
		int age;
		name = JOptionPane.showInputDialog("Enter Your Name: ");
		rollno = JOptionPane.showInputDialog("Enter Your Roll No: ");

		ageS = JOptionPane.showInputDialog("Enter Your Age: ");
		age = Integer.parseInt(ageS);

		JOptionPane.showMessageDialog(null, "Name: " + name + "\nRoll No: " + rollno + "\nAge: " + age);
	}	
}
