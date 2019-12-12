package select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Test09 {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sample", "sample");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디를 입력하세요");
		String id = sc.next();
		System.out.println("비밀번호를 입력하세요");
		String pw = sc.next();
		sc.close();

		String sql = "select id,pw from kh_member where id=?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		
		int count = 0;

		while (rs.next()) {
			String idt = rs.getString("id");
			String pwt = rs.getString("pw");	
			count++;
			if(count !=0 && pw.equalsIgnoreCase(pwt)) {
				System.out.println("로그인 성공!");
			} else {
				System.out.println("로그인 실패!");
			}			
		}	
		System.out.println("count: "+count);
		con.close();
	}
}
