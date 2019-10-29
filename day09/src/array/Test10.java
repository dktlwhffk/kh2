package array;
import java.lang.*;
import java.util.*;
public class Test10 {
	public static void main(String[] asrg) {
//		사용자에게 5개의 숫자를 입력받아 저장하고 복사본을 생성
//		기존에 입력받은 배열의 모든 데이터에 +1 작업을 수행
//		원본과 복사본을 모두 출력
		Scanner sc=new Scanner(System.in);
		System.out.println("숫자 5개 입력");
		int[]a=new int[5];
		for(int i=0; i<a.length; i++) {
			a[i]=sc.nextInt();
			System.out.println(a[i]);
		}
//		a[0]=sc.nextInt();
//		a[1]=sc.nextInt();
//		a[2]=sc.nextInt();
//		a[3]=sc.nextInt();
//		a[4]=sc.nextInt();
		sc.close();
		int[]b=new int[a.length];
		
		for(int i=0; i<b.length; i++) {
			b[i]=a[i];
			System.out.println(b[i]);
		}
//		b[0]=a[0];
//		b[1]=a[1];
//		b[2]=a[2];
//		b[3]=a[3];
//		b[4]=a[4];
		
//		a[0]++;
//		a[1]++;
//		a[2]++;
//		a[3]++;
//		a[4]++;
		for(int i=0; i<a.length; i++) {
			a[i]++;
			System.out.println(a[i]);
		}
	}
}
