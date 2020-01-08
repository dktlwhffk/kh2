package home.util;

import java.util.Random;

public class StringUtil {
	//[1] 랜덤 문자열 생성 기능
	public static String generateRandomString(int size) {
		String base = "0123456789abcdefghijklmnopqrstuvwxyz!@#$";
		
		Random r = new Random();
		
//		size번 만큼 반복하며 문자열을 추출
		String result = "";
		for(int i=0; i < size; i++) {
			int index = r.nextInt(base.length());
			char c = base.charAt(index);
			result += c;
		}
		
		return result;
	}
}




