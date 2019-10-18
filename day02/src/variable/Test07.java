package variable;

import java.lang.*;

public class Test07 {
	public static void main(String[] args) {
		
		/*삼각김밥이 1+1 행사중입니다. 한개의 가격은 900원일때
		 * 계산대에 7개의 삼각김밥을 들고가면 얼마를 계산해야하는지 출력
		 */
//		900 1800 2700 3600 4500 5400 6100 7000
//		       900   1800 1800 2700 2700 3600 3600
//		                  900                   3600                  4500
		
		
		int x = 7;
		int y = (7/2);
		int gimbap = 900;
		int totalprice = (x-y)*gimbap;
		
	
		System.out.print("김밥 "+ x +"개에 "+ totalprice+ " 입니다");
		

		
	}
}
