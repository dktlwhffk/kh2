package update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) throws Exception{
//		사용자에게 학생번호와 변경할 포인트를 입력받아 kh_member의 정보를 수정하도록 구현
//		단, 존재하지 않는 학생번호의 경우 사용자에게 없음을 출력하도록 구현
		Scanner sc = new Scanner(System.in);
		
		System.out.println("포인트를 입력하세요");
		int point = sc.nextInt();
		
		System.out.println("학생번호를 입력하세요");
		String no = sc.next();
		
		sc.close();
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "sample", "sample");
		
		
		String sql = "update kh_member set point= ? where no=?";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, point);
		ps.setString(2, no);
		
		int count = ps.executeUpdate();
		if(count != 0) {
			System.out.println("변경 성공");
		} else {
			System.out.println("존재하지 않는 학생 번호 입니다");
		}
		con.close();
	}
}