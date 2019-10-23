package condition;
import java.lang.*;
import java.util.*;
public class Test05 {
	public static void main(String[] args) {
//		사용자에게 숫자 2개를 입력받습니다.
//		두 수의 차이를 구하여 화면에 출력
//		(숫자의 순서와 관계 없이 차이는 항상 0 이상으로 나와야 합니다.)
		
		Scanner sc = new Scanner(System.in);
		
		int n1 = sc.nextInt(); int n2 = sc.nextInt();
		
		sc.close();
		
		int a = n1-n2;
		int b = n2-n1;
		
		if (a>=0) {
			System.out.println(a);
		}
		if (a<0) {
			System.out.println(b);
			}
	}
}
