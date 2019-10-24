package loop;
import java.lang.*;
public class Test04 {
	public static void main(String[] args) {
//		1~100미만 3,6,9만 출력
				
for (int i=1; i<1000; i++) {
if(i%10==3 || i%10==6 || i%10==9 || i/10==3 || i/10==6 || i/10==9 ||
(i/10)%10==3 || (i/10)%10==6 || (i/10)%10==9) 
{
System.out.println(i);
}
}
}
}