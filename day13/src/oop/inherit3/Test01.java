package oop.inherit3;

public class Test01 {
public static void main(String[] args) {
	//다음 내용을 수행할 수 있는 클래스 구조를 구현하고 객체 생성 및 기능을 실행하시오.
//	크롬 브라우저(chrome)
//	저장할 데이터: 주소(url), 버전(version)
//	필요한 기능: 	이동기능(move):화면에 "다른 페이지로 이동합니다" 출력
//				새로고침 기능(refresh): 화면에 "새로고침을 시도합니다" 출력
//				개발자 도구 기능(develop): 화면에 "개발자도구를 실행합니다" 출력
	
//	엣지 부라우저(edge)
//	저장할 데이터: 주소, 버전
//	필요한 기능:	이동기능(move):화면에 "다른 페이지로 이동합니다" 출력
//				새로고침 기능(refresh): 화면에 "새로고침을 시도합니다" 출력
//				윈도우 연동 기능(windows): 화면에 "윈도우와 연동을 시도합니다" 출력
	
	chrome c=new chrome();
	c.move();
	c.refresh();
	c.develop();
	System.out.println();
	
	edge e=new edge();
	e.move();
	e.refresh();
	e.windows();
	System.out.println();
	
	
//	겹치는 요소들
//	String url;
//	int version;
//	String move;
//	String refresh;
//	System.out.println("다른 페이지로 이동합니다.");
//	System.out.println("새로고침을 시도합니다.");
	
}
}
