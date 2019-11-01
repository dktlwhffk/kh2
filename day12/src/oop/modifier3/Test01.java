package oop.modifier3;

public class Test01 {
public static void main(String[] args) {
//	> 아파트 분양가 정보
//	| 평형 | 방 개수 | 화장실 개수 | 베란다 확장여부 | 가격 |
//	| ---- | ------ | --------- | ------------ | ---- |
//	| 25평형 | 2 | 1 | X | 3억 |
//	| 28평형 | 2 | 2 | O | 3억 5천 |
//	| 31평형 | 3 | 2 | O | 4억 |
//	조건 
//	아파트 평형은 25/28/31/34
//	방 개수는 1개 이상
//	화장실 개수는 1개 이상
//	가격은 0원 이상이고 100만원 미만은 버리고 설정
	apart a=new apart();
	apart b=new apart();
	apart c=new apart();
	
	a.set(25, 2, 1, false, 300000000);
	b.set(28, 2, 2, true, 350000000);
	c.set(31, 3, 2, true, 443000000);
	
	a.print();
	b.print();
	c.print();
	
}
}
