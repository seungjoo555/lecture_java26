package abstractclass;

public class Bird extends Countable{
	
	public Bird(String name, int num) {
		this.name = name;
		this.num = num;
	}
	public void fly() {
		System.out.println(num + "마리 " + name + "가 날아간다.");
	}
	@Override
	public void count() {
		// TODO Auto-generated method stub
		System.out.println(name + "가 " + num + "마리 있다.");
	}
}
