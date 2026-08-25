package abstractclass;

public abstract class Animal {
	String meal;
	
	public Animal() {}
	
	public Animal(String meal) {
		this.meal = meal;
	}
	
	abstract public void eat();
	abstract public void move();
	public void sleep() {
		System.out.println("누워서 잠을 잔다.");
	}
}
