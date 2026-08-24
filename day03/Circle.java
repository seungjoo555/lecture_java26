package start;

public class Circle {
	
	final double Pi = 3.14;
	double r;
	
	public Circle(double r){
		this.r = r;
	}

	double getExtent() {
		return (r * r) * Pi;
	}
}
