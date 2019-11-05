package oop.poly2;

import java.util.Random;

public class Test01 {
public static void main(String[] args) {
	
	Cat a = new Cat();
	Dog b = new Dog();
	Lion c = new Lion();
	
	Random r = new Random();
	int type = r.nextInt(3)+1;
	int act = r.nextInt(2)+1;
	if(type==1) {
		if(act==1) {
			System.out.println("야옹~");
		} else {
			System.out.println("고양이입니다");
		}
	} else if(type==2) {
		b.bark();
	} else {
		c.bark();
	}
	
	
	
}
}
