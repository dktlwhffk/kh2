package oop.method5;

public class Test01 {
	public static void main(String[] asrg) {
		
		game a=new game();
		game b=new game();
		game c=new game();
		
		
		
		a.set("1945",500);
		b.set("펌프", 1000);
		c.set("사격", 2000);
		
		a.play(20);
		b.play(15);
		c.play(1);
		
		a.print();
		b.print();
		c.print();
	}
}
