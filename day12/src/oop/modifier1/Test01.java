package oop.modifier1;

public class Test01 {
	public static void main(String[] asrg) {
		bank a = new bank();
		
//		a.name="유재셕";
//		a.money=-10000;
		a.setName("유재석");
		a.setMoney(10000);
		
//		System.out.println(a.name);
//		System.out.println(a.money);
		System.out.println(a.getName());
		System.out.println(a.getMoney());
	}
}
