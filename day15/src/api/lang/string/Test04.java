package api.lang.string;

public class Test04 {
	public static void main(String[] args) {
//		일부 검사
		String url = "https://www.naver.com";
		
//		시작검사
		if(url.startsWith("https://")) {
			System.out.println("이 사이트는 보안 연결 방식을 사용중입니다");
		} else {
			System.out.println("이 사이트는 보안 연결 방식을 사용하지 않고 있습니다.");
		}
		
//		종료검사
		System.out.println(url.endsWith(".com"));
		
//		포함검사
		System.out.println(url.contains("naver"));//있어요?
		System.out.println();
		System.out.println(url.indexOf("naver"));//어디에?
		System.out.println(url.indexOf("."));
		System.out.println(url.lastIndexOf("."));
		System.out.println(url.indexOf("?"));
		System.out.println(url.indexOf("w", 11));
	}
}
