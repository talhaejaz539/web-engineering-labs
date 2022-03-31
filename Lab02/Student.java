import javax.swing.*;

public class Student {

	String rollNo, name, age, gender, cgpa;	
	
	int addStudent() {
		this.rollNo = JOptionPane.showInputDialog("Enter Your Roll No: ");
		this.name = JOptionPane.showInputDialog("Enter Your Name: ");
		this.age = JOptionPane.showInputDialog("Enter Your Age: ");
		this.gender = JOptionPane.showInputDialog("Enter Your Gender(Male/Female): ");
		this.cgpa = JOptionPane.showInputDialog("Enter Your CGPA: ");
		
		index = index + 1;
		return index - 1; ///Change index

	}
	void viewStudent() {	
		JOptionPane.showMessageDialog(null, "Roll No: " + rollNo + "\nName: " + name + "\nAge: " + age + "\nGender: " + gender + "\nCGPA: " + cgpa);
	}
	void deleteStudent() {
		this.rollNo = null;
		this.name = null;
		this.age = null;
		this.gender = null;
		this.cgpa = null;

		index = index - 1;
	}
	void updateStudent() {
		this.rollNo = JOptionPane.showInputDialog("Enter Your Roll No: ");
		this.name = JOptionPane.showInputDialog("Enter Your Name: ");
		this.age = JOptionPane.showInputDialog("Enter Your Age: ");
		this.gender = JOptionPane.showInputDialog("Enter Your Gender(Male/Female): ");
		this.cgpa = JOptionPane.showInputDialog("Enter Your CGPA: ");
	}

	static int index = 0;

	static int getIndex() {
		return index;
	}

	static void menu() {
		JOptionPane.showMessageDialog(null, "1- Add Student\n2- View Student\n3- Delete Student\n4- Update Student");
	}

	public static void main(String[] args) {
		
		String sizeS = JOptionPane.showInputDialog("Enter Class Strength: ");
		int size = Integer.parseInt(sizeS);

		Student s[] = new Student[size];	
		
		while(true) {
			Student.menu();
			String inputS = JOptionPane.showInputDialog("Enter Choice: ");
			int input = Integer.parseInt(inputS);
			int index = getIndex();
		
			if(input == 1) {
				
				if(index < size) {
					s[index] = new Student(); 
					s[index].addStudent();
					JOptionPane.showMessageDialog(null, "Student added at index " + index + ".");
				}
				else 
					JOptionPane.showMessageDialog(null, "Space Required for adding student in a class!");
			}
			else if(input == 2) {
				String inp = JOptionPane.showInputDialog("Enter Your ID: ");
				int id = Integer.parseInt(inp);
				if(id > index)
					JOptionPane.showMessageDialog(null, "Error!");
				else
					s[id].viewStudent();
			}
			else if(input == 3) {
				String inp = JOptionPane.showInputDialog("Enter Your ID: ");
				int id = Integer.parseInt(inp);
				if(id > index)
					JOptionPane.showMessageDialog(null, "Error!");
				else
					s[id].deleteStudent();
			}
			else if(input == 4) {
				String inp = JOptionPane.showInputDialog("Enter Your ID: ");
				int id = Integer.parseInt(inp);
				if(id > index)
					JOptionPane.showMessageDialog(null, "Error!");
				else
					s[id].updateStudent();
			}	
		}
		
	}

}