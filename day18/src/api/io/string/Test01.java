package api.io.string;

import java.util.Arrays;

public class Test01 {
	public static void main(String[] args) {
//		byte와 문자열의 관계
	
//		String을 byte배열로 변환
		String a = "hello";
		byte[] by = a.getBytes();
		System.out.println(Arrays.toString(by));
		
//		byte 배열을 문자열로 변환
		String c = new String(by);
		System.out.println(c);
		
		
	}
}
