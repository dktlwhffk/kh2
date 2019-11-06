package api.lang.string;

public class Test05 {
	public static void main(String[] args) {
//		문자열 편집
		String url = "                    http://www.naver.com              ";
		System.out.println(url);
		System.out.println(url.trim());//좌우 여백 제거
		
//		문자열 자르기
//		url=url.trim();
		url = "https://www.naver.com";
		System.out.println(url.substring(12,17));
		
		url = url.substring(url.indexOf("naver"), url.indexOf(".com"));
		System.out.println(url);
		
		String song = "학교종이 땡땡땡 어서모여라";
		String[]result=song.split(" ");
		
		for(int i=0; i<result.length; i++) {
			System.out.println(result[i]);
		}

//		치환 .replace()
		String str = "나는 카레가 싫어요";
		System.out.println(str.replace("싫어요", "좋아요"));
		System.out.println(str.replace("카레", "자바"));
		
//		체이닝(chaining): 메소드를 연쇄적으로 사용하는 것
		System.out.println(str.replace("카레", "자바").replace("싫어요", "좋아요"));
}
}
