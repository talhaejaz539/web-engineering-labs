import java.util.*;

public class Task4 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);

		int n1 , n2;
		System.out.print("Enter Number One: ");
		n1 = in.nextInt();

		System.out.print("Enter Number Two: ");
		n2 = in.nextInt();		

		int ans = 0;
		if (args[0].equals("+"))
			ans = n1  +  n2;
		else if(args[0].equals("-"))
			ans = n1  -  n2;
		else if(args[0].equals("x"))
			ans = n1  *  n2;
		else if(args[0].equals("/"))
			ans = n1  /  n2;

		System.out.println("Answer: " + ans);
		in.close();
	}
}