package abstractclass;

public class Goldfish extends Animal {

	public Goldfish(String meal) {
		this.meal = meal;
	}
	
	@Override
	public void eat() {
		System.out.println("먹이로 " + meal + "을 먹는다.");
	}

	@Override
	public void move() {
		System.out.println("헤엄친다.");
	}

}
