import java.util.*;

public class Task1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.print("Enter a Number: ");
		int num = in.nextInt();
	
		for(int i=1 ;i<=10; i++) {
			System.out.println(num + " X " + i + " = " + num * i);
		}
		in.close();
	}
}
