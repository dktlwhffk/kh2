package oop.inherit3;

public class browser {
	//겹치는 요소들
		private String url;
		private String version;
		
		public void move() {
			System.out.println("다른 페이지로 이동합니다.");
		}
		
		public void refresh() {
			System.out.println("새로고침을 시도합니다.");
		}
}
