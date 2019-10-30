package array;
import java.lang.*;
import java.util.*;
public class Test18_1 {
	public static void main(String[] asrg) {
//		3,5,2,1,4를 배열에 저장하고 "가장 작은 값을 맨 앞에 위치"하도록 구현
//		"두번째 작은 값은 두 번째에 위치"하도록 구현
//		위와같이 진행하여 전체가 정렬되도록 구현하는 것이 목표
		int[] data=new int[] {3,5,2,1,4};
//정렬
//		1.data[0]~data[4] 사이에서 가장 작은 수의 위치를 찾는다
//		2. 1번에서 찾은 위치와 data[0]을 교체한다.
		int index = 0;
		for(int i=1; i<data.length; i++) {
			if(data[index]>data[i]) {
				index = i;
			}
		}
		System.out.println("index= "+index);
		
		int t = data[0];
		data[0] = data[index];
		data[index]=t;
		
//		2번째 자리 정렬
//		1.data[1]~data[4] 사이에서 가장 작은 수의 위치를 찾는다
//		2. 1번에서 찾은 위치와 data[1]을 교체한다.
		index=1;
		for(int i=2; i<data.length; i++) {
			if(data[index]>data[i]) {
				index=i;
			}
		}
		System.out.println("index= "+index);
		
		t=data[1];
		data[1]=data[index];
		data[index]=t;
		
		for(int n : data) {
			System.out.println(n);
		}
	}
}
//for(int n : data) {
//	System.out.println(n);    확장 for:저장소의 전체 데이터 추출만 가능
//}