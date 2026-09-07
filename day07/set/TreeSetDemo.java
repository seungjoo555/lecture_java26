package set;

import java.util.List;
import java.util.TreeSet;

public class TreeSetDemo {

	public static void main(String[] args) {
//		Set<String> f = Set.of();
		TreeSet<String> fruits = new TreeSet<>(List.of("포도", "수박", "사과", "키위", "망고"));
		
		System.out.println(fruits.first());
		System.out.println(fruits.last());
		
		System.out.println(fruits.lower("사과"));
		System.out.println(fruits.higher("사과"));
	}

}
