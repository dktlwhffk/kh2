package api.lang.object;

public class Test02 {
	public static void main(String[] args) {
		Person p = new Person();
		
		System.out.println(p.getClass());
		System.out.println(p.hashCode());
		System.out.println(p.toString());
//		System.out.println(p.equals(obj));
	}
}
