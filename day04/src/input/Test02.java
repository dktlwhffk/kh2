package input;
import java.lang.*;
import java.util.*;
public class Test02 {
	public static void main (String [] args) {
//		앞으로 사용할 입력방법
//		-기본적으로 제공되는 방법은 어렵기 때문에 별개의 "도구"를 사용	
//		-scanner 라는 도구를 사용(java.util 패키지)
//		-도구를 만들고 그 다음 입력을 진행한다.
		
//		도구 생성
//		-형태는 Scanner, 이름은 sc, 생성형태는 System.in과 합체된 형태
//		-참조형이기 때문에 각종 기능들을 이용할 수 있다.
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("입력하세요");
		String n = sc.next();
		
		System.out.println("n = " + n);
		
//		내가 만든 도구들은 정리해야 한다
		sc.close();
		
		
	}
}
