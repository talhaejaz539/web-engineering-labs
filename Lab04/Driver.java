import java.util.*;

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
	public double BMI;
	public double w, h;
	public void set(String na, String ww, String hh) {
		name = na;
		w = Double.parseDouble(ww);
		h = Double.parseDouble(hh);
		BMI = w / h;
	}
	public String toString() {
		return "BMI: " + BMI;
	}	
}



class Driver {

	public static void Save(Health h[], int index) {
		//h[index] = new Health();
		String na, ww, hh;
		
		Scanner in = new Scanner(System.in);	
			
		System.out.print("Enter Name: ");
		na = in.nextLine();
		System.out.print("Enter Weight: ");
		ww = in.nextLine();
		System.out.print("Enter Height: ");
		hh = in.nextLine();
		
		System.out.println();
		h[index].set(na, ww, hh);

		 
		
		in.close();
	}

	public static void Retrieve(Health h[], int index, int size) throws indexException {
		if(h[index] == null || index < 0 || index >= size) {
			throw new indexException(index);
		}
		else {
			System.out.println(h[index]);
		}
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int input;
		int size;
		
		try {
			System.out.print("Enter Size of Array: ");
			size = in.nextInt();
			
			if(size < 0) throw new NegativeArraySizeException(size);
			else {
				Health h[] = new Health[size]; 
				
				do {
					
					System.out.println(" 1- Add Value in the array");
					System.out.println(" 2- Retrieve & Print");
					System.out.println(" 3- Exit");
					System.out.print("\n\tEnter Your Choice: ");
					input = in.nextInt();

					int index;
					if(input == 1) {
						System.out.print("\n\tEnter Index: ");
						index = in.nextInt();
						try {
							if(index == size && index > size && h[index] != null) 	
								throw new indexOccupiedException(index);			
							h[index] = new Health();
							Save(h, index);
						}
						catch(indexOccupiedException e) {
							System.out.println("Error: " + e);
						}		
					}			
					else if(input == 2) {
						try {
							System.out.print("\n\tEnter Index: ");
							index = in.nextInt();
							
							Retrieve(h, index, size);
						}
						catch(indexException e) {
							System.out.println("Error: " + e);
						}
					}

				} while(input != 3);
			}
		}
		catch (NegativeArraySizeException e) {
			System.out.println("Error: " + e);
		}

		in.close();
	}
}