import java.util.*;

class Student {
	String name, rollno, cgpa, degree;
		
	void setVal(String name, String rollno, String cgpa, String degree) {
		this.name = name;
		this.rollno = rollno;
		this.cgpa = cgpa;
		this.degree = degree; 
	}
	String getName() {
		return name;
	}
	String getRollNo() {
		return rollno;
	}
	String getCgpa() {
		return cgpa;
	}
	String getDegree() {
		return degree;
	}
	void display() {
		System.out.println("\tData of Object:-");
		System.out.println(" Name: " + getName());
		System.out.println(" Roll No: " + getRollNo());
		System.out.println(" CGPA: " + getCgpa());
		System.out.println(" Degree: "+ getDegree());
	}
}

public class Driver {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);

		int size;	String val;
		System.out.print("Enter Input Size: ");
		val = in.nextLine();
		size = Integer.parseInt(val);		

		Student c[] = new Student[size];
		String name, rollNo, cgpa, degree;

		for (int i = 0; i < size; i++)  {
			c[i] = new Student();

			System.out.print(" Enter Your Name: ");
			name = in.nextLine();
			
			System.out.print(" Enter Your Roll No: ");
			rollNo = in.nextLine();

			System.out.print(" Enter Your CGPA: ");
			cgpa = in.nextLine();

			System.out.print(" Enter Your Degree: ");
			degree = in.nextLine();

			c[i].setVal(name, rollNo, cgpa, degree);
			
			if(i != (size - 1)) {
				System.out.println("Give Input for next Student!");
			}
		}			

		for (int i = 0; i < size; i++)  {
			System.out.print(" " + (i+1) + " - ");
			c[i].display();
		}

		in.close();
		
	}
}