package oop.inherit4;

public class note10 extends phone{
	
	public note10(int memory) {
		super(memory);
		// TODO Auto-generated constructor stub
	}

	//상위 클래스에서 int memory를 요구합니다.
//	public note10(int memory) {
//		this.memory=memory;
//		super(memory);
//	}
	public void memo() {
		System.out.println("필기를 시작합니다");
	}
}
