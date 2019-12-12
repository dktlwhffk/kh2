package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

//DAO(DATA ACCESS OBJECT)
// db의 각종 처리를 메소드 형태로 지원하는 도구 클래스
// -일반적으로 테이블당 1개 이상 생성
public class Dao {

//	연결 대행 메소드(getConnection)
//	매개변수: 없음, 반환형: Connection 
	
	public Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe","sample","sample");
		return con;
	}
	
//	등록 기능(oracle)
//	매개변수	: 이름(String), 아이디(String), 비밀번호(String) 
//	반환형	: void
	public void oracle(String name, String id, String pw) throws Exception {
		Connection con = this.getConnection();
		
		String sql = "insert into kh_member values(kh_member_seq.nextval,?,?,?,0,sysdate)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, id);
		ps.setString(3, pw);
		
		ps.execute();
		
		con.close();
	} //kh member용 insert 메소드
	
	
	public void insertAdmin(String name, String id, String pw, int point) throws Exception{
		Connection con = this.getConnection();
		
		String sql = "insert into kh_member values(kh_member_seq.nextval,?,?,?,?,sysdate)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, id);
		ps.setString(3, pw);
		ps.setInt(4, point);
//		ps.setString(5, date);
		
		ps.execute();
		
		con.close();
	}
}
