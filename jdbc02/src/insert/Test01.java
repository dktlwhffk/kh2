package insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test01 {
	public static void main(String[] args) throws Exception {
//		C(insert)코드 작성
		
		String name = "처음처럼";
		int price = 1300;
		int stock = 25;
		
		Class.forName("oracle.jdbc.OracleDriver"); // ojdbc6.jar
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "sample", "sample");

//		이제부터는 명령에서 채워줘야 할 데이터가 있는 자리는 ?로 처리한다.
//		주의: 이제부턴 명령의 완성형태를 볼 수 없다
		String sql = "insert into snack values(snack_seq.nextval, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,name); //1번 물음표에 String  형태로 name을 채우세요(따옴표 추가)
		ps.setInt(2, price); //2번 물음표에 int 형태로 price를 채우세요(따옴표 없음)
		ps.setInt(3, stock); //3번 물음표에 int 형태로 stock을 채우세요(따옴표 없음)
		
		ps.execute();
		
		
		con.close();
		System.out.println("처리 완료!");
	}
}
