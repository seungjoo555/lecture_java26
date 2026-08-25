package abstractclass;

public class Eagle extends Animal {

	public Eagle(String meal) {
		//자식클래스의 생성자엔 super();가 있어 부모클래스에 빈생성자가 없다면 에러남
		//하지만 부모클래스에 생성자가 한개도 없다면 자식클래스의 생성자를 실행해 에러나지 않음
		//super(meal);
		this.meal = meal;
	}
	
	@Override
	public void eat() {
		System.out.println("먹이로 " + meal + "을 먹는다.");
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub

	}

}
