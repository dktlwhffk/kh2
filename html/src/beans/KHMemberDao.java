package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class KHMemberDao {

//	필수기능 : 연결
//	이름 : getConnection
//	준비물(매개변수) : x
//	결과물(반환형) : 연결(Connection)
	public Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		return DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:xe", "sample", "sample");
	}
	
//	등록 기능
//	이름 : regist
//	매개변수 : 아이디(String) + 비밀번호(String) + 이름(String) = 회원(KHMemberDto)
//	반환형 : x(void)
	public void regist(KHMemberDto dto) throws Exception {
		Connection con = this.getConnection();								//연결하세요
		
		String sql = "insert into kh_member values("
						+ "kh_member_seq.nextval, ?, ?, ?, 0, sysdate)";	//전송명령
		PreparedStatement ps = con.prepareStatement(sql);			//전송도구 생성
		ps.setString(1, dto.getName());											//이름 설정
		ps.setString(2, dto.getId());													//아이디 설정
		ps.setString(3, dto.getPw());												//비밀번호 설정
		
		ps.execute();																		//실행
		
		con.close();
		System.out.println("접속종료");//연결 종료
	}
	
//	목록 기능
//	이름 			: getList
//	매개변수 	: x 
//	반환형 		: 데이터 목록(List<KHMemberDto>)
	public List<KHMemberDto> getList() throws Exception{
		Connection con = this.getConnection();
		
		String sql = "select * from kh_member order by no asc";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
//		ResultSet --> List
		List<KHMemberDto> list = new ArrayList<>();	//비어있는 리스트 생성
		
		while(rs.next()) {												//데이터가 존재한다면 반복
			KHMemberDto dto = new KHMemberDto();	//비어있는 인스턴스 생성
			
			dto.setNo(rs.getInt("no"));							//인스턴스에 번호를 추가
			dto.setName(rs.getString("name"));				//인스턴스에 이름을 추가
			dto.setId(rs.getString("id"));						//인스턴스에 아이디를 추가
			dto.setPw(rs.getString("pw"));						//인스턴스에 비밀번호를 추가
			dto.setPoint(rs.getInt("point"));					//인스턴스에 포인트를 추가 
			dto.setJoindate(rs.getString("joindate"));	//인스턴스에 등록일을 추가
			
			list.add(dto);												//리스트에 인스턴스를 추가
		}
		con.close();														//연결 끊고
		
		return list;														//리스트 반환
	}
	
//	카운트 기능
//	select count(*) from kh_member;
//	이름 : khCount
//	매개변수 : x
//	반환형 : int
	public int khCount() throws Exception{
		Connection con = getConnection();
		
		String sql = "select count(*) from kh_member";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
//		int count = ps.executeUpdate();//안됨
		
		rs.next();
//		int count = rs.getInt("count(*)");
		int count = rs.getInt(1);
		
		con.close();
		
		return count;
	}

//	검색 기능
//	이름 : search
//	매개변수 : 검색어(String)
//	반환형 : 회원목록(List<KHMemberDto>)
	public List<KHMemberDto> search(String name) throws Exception{
		Connection con = getConnection();
		
		String sql = "select * from kh_member "
							+ "where name like '%'||?||'%' "
							+ "order by name asc";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		
//		ResultSet --> List
		List<KHMemberDto> list = new ArrayList<>();	//비어있는 리스트 생성
		
		while(rs.next()) {												//데이터가 존재한다면 반복
			KHMemberDto dto = new KHMemberDto();	//비어있는 인스턴스 생성
			
			dto.setNo(rs.getInt("no"));							//인스턴스에 번호를 추가
			dto.setName(rs.getString("name"));				//인스턴스에 이름을 추가
			dto.setId(rs.getString("id"));						//인스턴스에 아이디를 추가
			dto.setPw(rs.getString("pw"));						//인스턴스에 비밀번호를 추가
			dto.setPoint(rs.getInt("point"));					//인스턴스에 포인트를 추가 
			dto.setJoindate(rs.getString("joindate"));	//인스턴스에 등록일을 추가
			
			list.add(dto);												//리스트에 인스턴스를 추가
		}
		
		con.close();														//연결 끊고
		
		return list;														//리스트 반환
	}
	
//	로그인 기능
//	이름 : login
//	매개변수 : (String, String) or (KHMemberDto)
//	반환형 : boolean
	public boolean login(String id,String pw) throws Exception{
		Connection con = getConnection();
		
		String sql = "select * from kh_member where id = ? and pw = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, pw);
		ResultSet rs = ps.executeQuery();//결과 개수는 0 or 1 : rs.next()로 파악 가능
		
		boolean result = rs.next();
		
		con.close();
		
		return result;
	}
	
	
//	정보수정 기능
//	이름 : changePassword
//	매개변수 : 아이디(String), 비밀번호(String), 바꿀비밀번호(String)
//	반환형 : boolean
	
	public boolean changePassword(String id, String pw, String newPw) throws Exception{
		Connection con = getConnection();
		
		String sql = "update kh_member set pw = ? where id = ? and pw = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, newPw);
		ps.setString(2, id);
		ps.setString(3, pw);
		
		int count = ps.executeUpdate();
		
		con.close();
		
		return count > 0;
//		if(count > 0) {
//			return true;
//		}
//		else {
//			return false;
//		}
	}

//	비밀번호 수정 기능2
//	이름 : changePassword
//	매개변수 : 아이디, 신규비밀번호 (로그인 한 뒤에 부를 예정이므로 기존 비밀번호는 필요가 없음)
//	반환형 : void(로그인 한 뒤 부를 예정이므로 100% 수정이 된다) 
	public void changePassword(String id, String newPw) throws Exception{
		Connection con = getConnection();
		
		String sql = "update kh_member set pw = ? where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, newPw);
		ps.setString(2, id);
		
		ps.execute();
		
		con.close();
	}
	
//	탈퇴 기능
//	이름 : exit
//	매개변수 : 아이디(String) - 로그인 후 탈퇴 처리할 예정이므로
//	반환형 : void - 로그인 후 탈퇴 처리할 예정이므로 안될리가 없다
	public void exit(String id) throws Exception {
		Connection con = getConnection();
		
		String sql = "delete kh_member where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		
		ps.execute();
//		int count = ps.executeUpdate();
		
		con.close();
	}
}