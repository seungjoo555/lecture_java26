package abstractclass;

public class Horse extends Animal{
	
	public Horse(String meal) {
		this.meal = meal;
	}
	
	@Override
	public void eat() {
		System.out.println("먹이로 " + meal + "을 먹는다");
	}
	
	@Override
	public void move() {
		System.out.println("뛰어다닌다.");
	}
	
	@Override
	public void sleep() {
		System.out.println("서서 잠을 잔다.");
	}
}
