package oop.test3;

public class Test02 {
	public static void main(String[] asrg) {
		
		kakao n =new kakao();
		kakao two =new kakao();
		kakao three =new kakao();
		kakao four =new kakao();
		
		n.name = "장영철";
		n.text = "스마트폰 구입을 축하하노라";
		n.time = "오후 7:29";
		
		two.name = "나";		two.text = "앜 영철앜ㅋㅋㅋㅋ";
		two.time = "오후 7:32";
		
		three.name = "나";
		three.text = "졸라 오랜만이다";
		three.time = "오후 7:32";
		
		four.name = "장영철";
		four.text = "작은아버지다";
		four.time = "오후 7:32";
		
		System.out.println(n.name+n.text+n.time);
		System.out.println(two.name+two.text+two.time);
		System.out.println(three.name+three.text+three.time);
		System.out.println(four.name+four.text+four.time);
		
	}
}
