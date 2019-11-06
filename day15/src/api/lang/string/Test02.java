package api.lang.string;

public class Test02 {
	public static void main(String[] args) {
		String a = "Hello";
		
		byte[]by = new byte[] {104,101,108,108,111};
		String b = new String(by);
		
		System.out.println(a);
		System.out.println(b);
		
		System.out.println(a.equals(b)); //대소문자 구분
		System.out.println(a.equalsIgnoreCase(b)); //대소문자 구분 안함
		
		System.out.println(a.toUpperCase());//대문자 전환
		System.out.println(a.toLowerCase());//소문자 전환
		
		System.out.println(a.length());//글자수(한글이건 영어건 1글자)
		
		int al=a.length();
		int bl=b.length();
		if(al==bl) {
			System.out.println("글자수가 같아요");
		} else {
			System.out.println("글자수가 달라요");
		}
		
	}
}
