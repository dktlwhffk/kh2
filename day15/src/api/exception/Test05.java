package api.exception;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Test05 {
	public static void main(String[] args) {
//		사용자에게 닉네임을 입력받아 등록하는 프로그램 구현
//		예외
//		-닉네임이 2~6글자가 아닌 경우
//		-닉네임에 "운영자"라는 단어가 포함된 경우
		System.out.println("닉네임을 입력하세요");
//		for(int i=1; i>0; i++) {
		try {
			Scanner sc = new Scanner(System.in);
			String nick = sc.next();
			boolean ex1 = nick.length() < 2 || nick.length() > 6;
			boolean ex2 = nick.contains("운영자");
			sc.close();
			if (ex1) {
				throw new Exception("글자수 오류");
			} 
			if (ex2) {
				throw new Exception("운영자라는 닉네임은 불가능합니다");
			}
			System.out.println("닉네임 설정 완료: "+nick);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
//			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}
