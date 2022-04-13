import java.util.*;

public class Cube extends ThreeDimensionalShape {
	public double getArea(double a){
		return 6 * a * a;
	}

	public double getVolume(double a) {
		return a * a * a;
	}

	public String toString(){  
  		return "Cube";  
 	}  
}