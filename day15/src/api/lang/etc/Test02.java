package api.lang.etc;

public class Test02 {
	public static void main(String[] args) {
//		System 클래스
		System.out.println("hello");
		System.err.println("hello");
		
		System.out.println(System.getProperties());
		System.out.println(System.getProperty("os.name"));
		
		if(System.getProperty("os.name").toLowerCase().startsWith("windows")) {
			System.out.println("윈도우쓰네~");
		}else {
			System.out.println("윈도우 안쓰네~");
		}
		System.out.println(System.getenv());
		
//		강제종료: 0이 정상, 나머지는 비정상(정하기 나름)
		System.exit(0);
		System.gc();
		
		System.out.println("이 메시지는 나오지 않습니다");
	}
}
