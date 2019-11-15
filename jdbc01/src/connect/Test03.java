package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test03 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "sample", "sample");
			
//		DB에 명령을 전달하고 싶다면 이 사이에서 수행
//		insert into snack(no,name,price,stock) values(5,'허니버터칩',2000,10);
		String sql = "insert into snack(no,name,price,stock) values(snack_seq.nextval,'허니버터칩',2000,10)";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.execute();
		
		
		con.close();
		System.out.println("등록 완료");
}
}
