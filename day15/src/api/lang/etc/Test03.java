package api.lang.etc;

import java.io.IOException;

public class Test03 {
	public static void main(String[] args) throws IOException {
//		Runtime 클래스
//		-싱글톤(생성제한)
//		-반드시 생성명령이 존재 	.getInstance() 또는 .get클래스명()
		Runtime r = Runtime.getRuntime();
		r.exec("notepad");
//		r.exec("cmd /C start http://naver.com"); //네이버 홈페이지 실행
		
	}
}
