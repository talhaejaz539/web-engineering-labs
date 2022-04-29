import java.util.*;
import java.io.*;

class AccountRecordSerializable implements Serializable {
	private int accountNumber, balance;
	private String firstName, lastName;

	public void set(String fN, String lN, int aN, int b) {
		firstName = fN;
		lastName = lN;
		accountNumber = aN;
		balance = b;
	}
	public int getAccount() {
		return accountNumber;
	}
	public String getFName() {
		return firstName;
	}
	public String getLName() {
		return lastName;
	}
	public int getBalance() {
		return balance;
	}
	public String toString() {
		return "\t\tAccount Number: " + accountNumber + "\n\t\tFirst Name: " + firstName + "\n\t\tLast Name: " + lastName + "\n\t\tBalance: " + balance;
	}
}

public class Bank {
	static Scanner in;
	AccountRecordSerializable person;

	public void openAccount() {
		String fN, lN; int aN, b;
		person = new AccountRecordSerializable();

		System.out.print("\tEnter First Name: ");
		fN = in.nextLine();
		System.out.print("\tEnter Last Name: ");
		lN = in.nextLine();
		System.out.print("\tEnter Account Number: ");
		aN = in.nextInt();
		System.out.print("\tEnter Balance: ");
		b = in.nextInt();

		in.nextLine();

		person.set(fN, lN, aN, b);

		try {

			//FileWriter fw = new FileWriter("data.txt", true);
			//FileOutputStream fos = new FileOutputStream(fw);
			FileOutputStream fos = new FileOutputStream("data.txt");
			
			ObjectOutputStream out = new ObjectOutputStream(fos);

			out.writeObject(person);

			out.close();
			fos.close();
			//fw.close();
		} catch (Exception ex){
			System.out.println(ex);
		}
		
	}
	
	public void Retrieve() {
		int aN;
		System.out.print("\tEnter Account Number: ");
		aN = in.nextInt();

		in.nextLine();

		try {
			FileInputStream fis = new FileInputStream("data.txt");

			ObjectInputStream in = new ObjectInputStream(fis);

			AccountRecordSerializable pRead = (AccountRecordSerializable) in.readObject();

			int s = pRead.getAccount();

			if(aN == s) {
				System.out.println(pRead);
			}

			in.close();
			fis.close();
		} catch (Exception ex){
			System.out.println(ex);
		}
	}

	public void RetrieveAll() {
		try {
	
			FileInputStream fis = new FileInputStream("data.txt");

			ObjectInputStream in = new ObjectInputStream(fis);

			AccountRecordSerializable temp;
			boolean isExist = true;

			while(isExist) {
				if(fis.available() != 0) {
					temp = (AccountRecordSerializable) in.readObject();	
					System.out.println(temp);
				} 
				else {
					isExist = false;
				}
			}
			in.close();
			fis.close();
		} catch (Exception ex){
			System.out.println(ex);
		}
	}
		
	public static void main(String[] args) {

		Bank b = new Bank();
		in = new Scanner(System.in);
		while(true) {
			System.out.println("\n 1- Open an Account");
			System.out.println(" 2- Retrieve and print the information of specific user");
			System.out.println(" 3- Retrieve and print the information of all the account holders");
			System.out.println(" 4- Exit");

			System.out.print("\n\tEnter Your Choice: ");
			int input = in.nextInt();
			in.nextLine();
			
			if(input == 1) {
				b.openAccount();
			}
			else if(input == 2) {
				b.Retrieve();
			}
			else if(input == 3) {
				b.RetrieveAll();
			}
			else if(input == 4) {
				System.out.println("Exiting");
				return;
			}
		}
	}
}
