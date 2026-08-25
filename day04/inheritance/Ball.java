package inheritance;

public class Ball extends Circle{
	
	public Ball(double radius) {
		this.radius = radius;
	}

	public double getArea() {
		return radius * radius * PI * 4;
	}
}
