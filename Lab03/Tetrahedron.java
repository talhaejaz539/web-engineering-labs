import java.util.*;

public class Tetrahedron extends ThreeDimensionalShape {

	public double getArea(double a){
		return Math.sqrt(3) * a * a;
	}

	public double getVolume(double a) {
		return 	(a * a * a) / (6 * Math.sqrt(2));
	}
	public String toString(){  
  		return "Tetrahedron";  
 	}
}