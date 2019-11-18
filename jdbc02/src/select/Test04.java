package select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test04 {
	public static void main(String[] args) throws Exception {
//		kh member 에서 원하는 이름에 해당하는 정보를 화면에 출력

		String keyword = "김용범";

		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sample", "sample");

		String sql = "select * from kh_member where name = ?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, keyword);
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
		}	if(count==0) {
			System.out.println("검색결과가 존재하지 않습니다");
		}
		con.close();
	}
}
