package oop.method1;

	public class Test01 {
		public static void main(String[] args) {
//			메세지 4개 생성 및 정보 설정 후 출력

//			생성
			message a = new message();
			message b = new message();
			message c = new message();
			message d = new message();

//			초기화
			a.name = "담임쌤";
			a.content = "민지야....";
			a.time = "오후 4:16";
//			a.remain = 0;

//			b.name = null;
			b.content = "네 알겠습니다 선생님";
			b.time = "오후 4:16";
//			b.remain = 0;

			c.name = "담임쌤";
			c.content = "지금 수업시간 아니냐?";
			c.time = "오후 4:17";
			c.remain = 1;

			d.name = "담임쌤";
			d.content = "너도 함께 교무실로 와라";
			d.time = "오후 4:17";
			d.remain = 1;

//			출력
			System.out.println(a.name);
			System.out.println(a.content);
			System.out.println(a.time);
			System.out.println(a.remain);

			System.out.println(b.name);
			System.out.println(b.content);
			System.out.println(b.time);
			System.out.println(b.remain);

			System.out.println(c.name);
			System.out.println(c.content);
			System.out.println(c.time);
			System.out.println(c.remain);

			System.out.println(d.name);
			System.out.println(d.content);
			System.out.println(d.time);
			System.out.println(d.remain);
		}
	}

