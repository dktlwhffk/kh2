package select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Test05 {
	public static void main(String[] args) throws Exception {
//		사용자에게 검색어를 입력받아 해당하는 검색어가 이름, 아이디 중 하나에 포함되어 있는 결과를 출력
		
		Scanner sc = new Scanner(System.in);
		System.out.println("키워드를 입력하세요");
		String input = sc.next();
		sc.close();

		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sample", "sample");
		
		String sql = "select * from kh_member where name like ? or id like ?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, "%"+input+"%");
		ps.setString(2, "%"+input+"%");
		ResultSet rs = ps.executeQuery();
		int count = 0;
		while (rs.next()) {
			int no = rs.getInt("no");
			System.out.println(no);

			String name = rs.getString("name");
			System.out.println(name);

			String id = rs.getString("id");
			System.out.println(id);

			String pw = rs.getString("pw");
			System.out.println(pw);

			int point = rs.getInt("point");
			System.out.println(point);

			String date = rs.getString("joindate");
			System.out.println(date);
			System.out.println();

			count++;
		}
		if (count == 0) {
			System.out.println("검색 결과가 존재하지 않습니다");
		}
		con.close();
	}
}
