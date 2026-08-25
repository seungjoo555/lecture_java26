package account;

class Animal {
	String eye = "눈";
	String mouth = "주둥이";
	
	void eat() {
		System.out.println("먹이를 먹는다.");
	}
	
	void move () {
		System.out.println("움직여");
	}
	
	void sleep() {
		System.out.println("잠을 잔다.");
	}
}

class Eagle extends Animal {
	String wing = "날개";
	
	@Override
	void eat() {
		super.eat();
		System.out.println("쪼아 먹기!" + super.eye);
	}
	
	void move() {
		System.out.println("날아라 한화" + wing);
	}
}

class Tiger extends Animal {
	String reg = "앞다리";
	
	void move() {
		System.out.println("뻘짓좀 그만해 타이거즈" + reg);
	}
}

class Goldfish extends Animal {
	String wing = "지느러미";
	
	void move() {
		System.out.println("헤엄치는 금붕어" + wing);
	}
}

class Pig extends Animal {
	void move() {
		System.out.println("진흙에서 구른다.");
	}
	
	void eat() {
		System.out.println("돼지는 마구 먹는다 like Sim..");
	}
	
	void sleep() {
		System.out.println("돼지는 배불리 먹고 쿨쿨 잔다 like Sim..");
	}
	
	void kul() {
		System.out.println("꿀꿀");
	}
}




public class Example01 {

	public static void main(String[] args) {
		System.out.println(">>> 독수리");
		Eagle e = new Eagle();
		printDayLife(e);
		
		System.out.println(">>> 타이거즈");
		Tiger t = new Tiger();
		printDayLife(t);
		
		System.out.println(">>> 금붕어");
		Goldfish g = new Goldfish();
		printDayLife(g);
		
		System.out.println(">>> Animal a = new Eagle()");
		Animal a = new Eagle();
		printDayLife(a);
		
		System.out.println(">>> 돼지");
		Pig f = new Pig();
		printDayLife(f);
		
		System.out.println("================================================");
		Pig p = new Pig();
		Animal n = p;
		Pig p2 = (Pig)n;
		p.kul();
//		n.kul();	자식클래스의 메서드 실행불가
		p2.kul();
		
		
		
	}
	
	static void printDayLife (Animal a) {
		a.eat();
		a.move();
		a.sleep();
	}
	
	
	
	
}
