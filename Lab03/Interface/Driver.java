import java.util.*;


public class Driver {

	public static void main(String []args) {
		ThreeDimensionalShape obj[] = {new Sphere(), new Cube(), new Tetrahedron()};

		
	
		Scanner in = new Scanner(System.in);

		System.out.println("Enter Radius/Side-Length: ");
		double r = in.nextDouble();

		for(int i=0; i<3; i++) {
			if(obj[i] instanceof Sphere) {
				System.out.println(obj[i]);
				System.out.println("Area of Sphere: " + obj[i].getArea(r));
				System.out.println("Volume of Sphere: " + obj[i].getVolume(r) + "\n");
			}
			else if(obj[i] instanceof Cube) {
				System.out.println(obj[i]);
				System.out.println("Area of Cube: " + obj[i].getArea(r));
				System.out.println("Volume of Cube: " + obj[i].getVolume(r) + "\n");
			}
			else if(obj[i] instanceof Tetrahedron) {
				System.out.println(obj[i]);
				System.out.println("Area of Tetrahedron: " + obj[i].getArea(r));
				System.out.println("Volume of Tetrahedron: " + obj[i].getVolume(r) + "\n");
			}
		}

		
		
		in.close();
		
 	}
}