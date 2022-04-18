import java.util.Scanner;

class NegativeArraySizeException extends Exception {

	int value;

	NegativeArraySizeException(int v) {
		value = v;
	}

	public String toString() {
		return "Array Size can't be negative like " + value;
	}

}

class indexOccupiedException extends Exception {
	int value;

	indexOccupiedException(int v) {
		value = v;
	}

	public String toString() {
		return "The index " + value + " is already taken!";
	}
}

class indexException extends Exception {
	int value;

	indexException(int v) {
		value = v;
	}

	public String toString() {
		return "The index " + value + " is invalid!";
	}
}

class Health {

	public String name;
	public int BMI;
	public int weight, height;
	
	public String toString() {
		return "\tName: " + name + "\n\tBMI: " + BMI;
	}	
}



class Driver {

	static int max_index;
	static Health people[];
	static Scanner in;

	public static void Save(int index) throws indexOccupiedException {
		if(index < 0 || index >= max_index || people[index] != null) {
			throw new indexOccupiedException(index);
		}
		
		people[index] = new Health();	
			
		System.out.print("Enter Name: ");
		people[index].name = in.nextLine();
	
		System.out.print("Enter Weight: ");
		people[index].weight = in.nextInt();

		System.out.print("Enter Height: ");
		people[index].height = in.nextInt();
			 
		in.nextLine();

		people[index].BMI = (people[index].weight / people[index].height);
	}

	public static void Retrieve(int index) throws indexException {
		if(index < 0 || index >= max_index || people[index] == null) {
			throw new indexException(index);
		}
		else {
			System.out.println(people[index]);
		}
	}

	public static void main(String[] args) {

		in = new Scanner(System.in);
		Driver driver = new Driver();
		
		System.out.print("Enter Size of Array: ");
		max_index = in.nextInt();
		in.nextLine();
			
		try {
			if(max_index < 0) {
				in.close();
				throw new NegativeArraySizeException(max_index);
			}
		}
		catch(NegativeArraySizeException e) { 
			System.out.println("Error: " + e);
		}
		people = new Health[max_index]; 
		
				
		while(true) {
					
					System.out.println(" 1- Add Value in the array");
					System.out.println(" 2- Retrieve & Print");
					System.out.println(" 3- Exit");
					System.out.print("\n\tEnter Your Choice: ");
					int input = in.nextInt();
					in.nextLine();

					int index = -1;
					if(input == 1) {
						System.out.print("\n\tEnter Index to Save: ");
						index = in.nextInt();
						in.nextLine();
						try {
							driver.Save(index);
						}
						catch(indexOccupiedException e) {
							System.out.println("Error: " + e);
						}		
					}			
					else if(input == 2) {
						System.out.print("\n\tEnter Index to Retrieve: ");
						index = in.nextInt();
						in.nextLine();
						try {
							driver.Retrieve(index);
						}
						catch(indexException e) {
							System.out.println("Error: " + e);
						}
					}
					
					else if(input == 3) {
						in.close();
						return;
					}
					else {
						System.out.println("Invalid Option!");
					}
		}

	}
}