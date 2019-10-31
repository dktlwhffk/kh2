package oop.method1;

	public class Test02 {
		public static void main(String[] args) {
//			메세지 4개 생성 및 정보 설정 후 출력

//			생성
			message a = new message();
			message b = new message();
			message c = new message();
			message d = new message();

//			초기화
			a.set("담임쌤","민지야...","오후 4:16",0); //인자(arguments)
			b.set(null,"네 알겠습니다 선생님","오후 4:16",0);
			c.set("담임쌤","지금 수업시간 아니냐?","오후 4:17",1);
			d.set("담임쌤","너도 함께 교무실로 와라","오후 4:17",1);



//			출력
			a.print();
			b.print();
			c.print();
			d.print();
		}
	}

