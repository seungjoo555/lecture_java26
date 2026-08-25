package inheritance;

public class Circle {

	public static double PI = 3.14;
	double radius;
	
	public Circle() {}
	public Circle(double radius) { }
	
	public double getArea() {
		return radius * radius * PI;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}

}
