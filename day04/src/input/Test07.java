package input;
import java.lang.*;
import java.util.*;
public class Test07 {
	public static void main (String[] asrg) {
/*	주차장 정산 프로그램 개발
 * 	사용자에게 "진입시간"과 "진출시간"을 입력받아 주차요금을 계산하도록 구현
 * 	주차요금은 10분당 500원(9분까지는 무료)
 * 	시간은 "?시?분"의 형태이며 2개의 숫자를 입력받아서 구현
 */
		Scanner sc = new Scanner(System.in);
		
		System.out.println("진입시간을 입력하세요.");
		int in = sc.nextInt();
		int inhour = in/100;
		int inmin = in%100;
		
		System.out.println("진출시간을 입력하세요");
		int out = sc.nextInt();
		int outhour = out/100;
		int outmin = out%100;
		
		System.out.print(inhour+"시");
		System.out.println(inmin+"분");
		System.out.print(outhour+"시");
		System.out.println(outmin+"분");
		
		int totalt = (((outhour*60+outmin)-(inhour*60+inmin))/10); //주차시간
		
		int fee = totalt*500; //주차요금
		
		System.out.println("주차요금: "+fee+"원");
		sc.close();	
		
	}
}
