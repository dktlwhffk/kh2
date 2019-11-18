package insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.util.Calendar;
import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) throws Exception{
//		sample 계정에 있는 kh_member 테이블에 데이터를 추가하는 프로그램 구현
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		String id = sc.next();
		String pw = sc.next();
//		int point = sc.nextInt();
//		String joindate = sc.next();
		
		sc.close();
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "sample","sample");
		
		String sql = "insert into kh_member values(kh_member_seq.nextval, ?,?,?,0,sysdate)";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, name);
		ps.setString(2, id);
		ps.setString(3, pw);
//		ps.setInt(4, point);
//		ps.set(5, time);
		
		ps.execute();
		con.close();
		System.out.println("입력 완료");
	}
}
