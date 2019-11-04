package oop.inherit4;

public class Test01 {
public static void main(String[] args) {
//	### 갤럭시 s10(GalaxyS10)
//	저장할 데이터
//	- 전화번호(number) 
//	- 메모리 용량(memory) : 128, 256, 512GB 중에서만 설정 가능
//	필요한 기능
//	- 전화걸기(call) : 화면에 "전화를 걸고 있습니다" 출력
//	- 문자보내기(sms) : 화면에 "문자메시지를 전송합니다" 출력
//	- 사진찍기(photo) : 화면에 "사진 촬영을 시작합니다" 출력
	
//	### 갤럭시 노트 10(GalaxyNote10)
//	저장할 데이터 : 갤럭시s10과 동일
//	필요한 기능
//	- 전화걸기(call) : 화면에 "전화를 걸고 있습니다" 출력
//	- 문자보내기(sms) : 화면에 "문자메시지를 전송합니다" 출력
//	- 사진찍기(photo) : 화면에 "사진 촬영을 시작합니다" 출력
//	- 필기(memo) : 화면에 "필기를 시작합니다" 출력
	s10 s = new s10(0);
	s.set("01088453718", 256);
	System.out.println("제품명: 갤럭시 S10");
	System.out.print("번호: "); s.number();
	s.getNumber();
	s.call(); s.sms(); s.photo();
	System.out.println();
	
	note10 n = new note10(0);
	n.set("01058930117", 512);
	System.out.println("제품명: 갤럭시 노트10");
	System.out.print("번호: "); n.number();
	n.call(); n.sms(); n.photo(); n.memo();
	System.out.println();
	
}
}
