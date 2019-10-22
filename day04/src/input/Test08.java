package input;
import java.lang.*;
import java.util.*;
public class Test08 {
	public static void main(String[] args) {
//		비만에 대한 기준값 BMI=23
//		BMI 18.5미만은 저체중
//		사용자에게 키와 체중을 입력받아 BMI 지수를 계산하여 "정상"인지 판단 후 출력 (비만도=체중(kg)/키(m)*키(m))
			
		Scanner sc = new Scanner(System.in);
		
		System.out.println("키를 입력하세요.");
		double height = (0.01)*(sc.nextInt()); //바로 m로 출력
		
		System.out.println("체중을 입력하세요.");
		int weight = sc.nextInt();
		
		double bmi = weight/(height*height);
		
//		System.out.println(bmi);
		
		boolean normal = 23>=bmi && 18.5<bmi;
		boolean thick = 23<=bmi;
		boolean thin = 18.5>bmi;
		
		if (normal) {
			System.out.println("정상");
		}	
		if (thick)	{
			System.out.println("과체중");
		}
		if (thin)	{
			System.out.println("저체중");
		}
		sc.close();	
	}
}
