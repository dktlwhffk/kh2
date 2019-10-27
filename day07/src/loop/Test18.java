package loop;
import java.lang.*;
import java.util.*;
public class Test18 {
	public static void main(String[] asrg) {
//		소수 찾기 프로그램
//소수는 1과 자기자신을 빼고는 나누어 떨어지지 않는 수를 말합니다.
//소수가 아닌 숫자는 합성수라고 부릅니다.
//소수의 대표적인 예로 2, 3, 5, 7, 11, 13 등의 수가 있습니다.
//합성수의 대표적인 예로 4, 6, 8, 9, 10, 12 등의 수가 있습니다.
//1은 소수도 아니고 합성수도 아닙니다.
//사용자가 숫자를 입력했을 때, 입력한 숫자가 소수인지 아닌지 판정하여 출력
	Scanner sc=new Scanner(System.in);
	System.out.println("숫자를 입력하세요");
	
	int n = sc.nextInt();
	int count=0; //약분 가능한 개수에 대한 변수
	
	for(int i=1; i<=n; i++) {
		if(n%i==0) {
			count++;
		}
	}
	if (count==2) {
		System.out.println("소수입니다."); //약수가 2개 == 소수
	}
	else if(count>2){
		System.out.println("합성수입니다."); 
	}
	else {
		System.out.println("소수도 합성수도 아닙니다.");
	}	
	sc.close();
	}
} 