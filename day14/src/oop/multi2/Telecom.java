package oop.multi2;

public class Telecom extends Phone implements SKT,KT,LGT{

	
	@Override
	public void sktfunction() {//tmap
		// TODO Auto-generated method stub
		System.out.println("tmap 기능을 사용합니다");
	}

	@Override
	public void lgtfunction() {//올레스토어
		// TODO Auto-generated method stub
		System.out.println("올레스토어 기능을 사용합니다");
	}

	@Override
	public void ktfunction() {
		// TODO Auto-generated method stub
		System.out.println("유플티비를 실행합니다");
	}
}
