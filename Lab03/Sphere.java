import java.util.*;

public class Sphere extends ThreeDimensionalShape {

	public double getArea(double r){
		return 4 * Math.PI * r * r;
	}

	public double getVolume(double r) {
		return 4 / 3 * Math.PI * r * r * r;
	}
	public String toString(){  
  		return "Sphere";  
 	}
}