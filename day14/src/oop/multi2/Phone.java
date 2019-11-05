package oop.multi2;

public class Phone implements GalaxyS10, IPhone10{
	
	public void call() {
		System.out.println("전화를 겁니다");
	}
	@Override
	public void airdrop() {
		// TODO Auto-generated method stub
		System.out.println("기능실행아이폰");
	}

	@Override
	public void bixby() {
		// TODO Auto-generated method stub
		System.out.println("기능실행갤럭시");
	}

}
