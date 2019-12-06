package home.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BoardDao {
	
	private static DataSource source;
	static {
		try {
			InitialContext ctx = new InitialContext();
			source = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	public Connection getConnection() throws Exception {
		return source.getConnection();
	}

//	글목록 기능
	public List<BoardDto> getList(int start, int finish) throws Exception {
		Connection con = this.getConnection();
		
//		--board의 모든 데이터를 조회하는데
//		select*from board 
//		--no와 superno가 연결되어있고
//		connect by  prior no=superno
//		--superno가 null인 항목이 시작점이야
//		start with superno is null
//		--전체 데이터는 groupno 역방향, no 정방향순이야
//		order siblings by groupno desc, no asc;
		
		String sql = "select*from("
				+ " select rownum rn, A.* from("
				+ "select*from board "
				+ "connect by  prior no=superno "
				+ "start with superno is null "
				+ "order siblings by groupno desc, no asc"
				+ ")A"
				+ ")where rn between ? and ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, start);
		ps.setInt(2, finish);
		ResultSet rs = ps.executeQuery();

		List<BoardDto> list = new ArrayList<>();

		while (rs.next()) {
			BoardDto dto = new BoardDto();
			
			dto.setRn(rs.getInt("rn"));
			dto.setNo(rs.getInt("no"));
			dto.setHead(rs.getString("head"));
			dto.setTitle(rs.getString("title"));
			dto.setReplycount(rs.getInt("replycount"));
			dto.setWriter(rs.getString("writer"));
			dto.setDate(rs.getString("wdate"));
			dto.setReadcount(rs.getInt("readcount"));
			dto.setContent(rs.getString("content"));
			
			dto.setGroupno(rs.getInt("groupno"));
			dto.setSuperno(rs.getInt("superno"));
			dto.setDepth(rs.getInt("depth"));

			list.add(dto);
		}
		con.close();
		return list;
	}

//	검색
	public List<BoardDto> search(String type, String keyword, int start, int finish) throws Exception {
		Connection con = getConnection();
		
//		String sql = "select * from board " + "where " + type + " like '%'||?||'%' order by no desc";
		String sql = "select*from("
				+ " select rownum rn, A.* from("
				+ "select * from board " + "where " + type + " like '%'||?||'%' "
				+ "connect by  prior no=superno "
				+ "start with superno is null "
				+ "order siblings by groupno desc, no asc"
				+ ")A"
				+ ")where rn between ? and ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, keyword);
		ps.setInt(2, start);
		ps.setInt(3, finish);
		ResultSet rs = ps.executeQuery();

		List<BoardDto> list = new ArrayList<>();

		while (rs.next()) {
			int rn = rs.getInt("rn");
			int no = rs.getInt("no");
			String head = rs.getString("head");
			String writer = rs.getString("writer");
			String wdate = rs.getString("wdate");
			String title = rs.getString("title");
			String content = rs.getString("content");
			int readcount = rs.getInt("readcount");
			int replycount = rs.getInt("replycount");
			
			int groupno = rs.getInt("groupno");
			int superno = rs.getInt("superno");
			int depth = rs.getInt("depth");
			
			BoardDto dto = new BoardDto(
					rn, no, head, title, readcount, 
					wdate, writer, replycount, content, groupno, superno, depth
					);
			list.add(dto);

		}
		con.close();
		return list;
	}

//	글추가 기능
//	새글도 등록하고 답글도 등록해야함
//	새글일 경우 no head title content
//	답글일 경우 no groupno superno depth head title content가 추가된다
	public void write(BoardDto dto) throws Exception {
		Connection con = getConnection();

		String sql = "insert into board values(?,?,?,0,?,sysdate,0,?,?,?,?)";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setInt(1, dto.getNo());
		ps.setString(2, dto.getHead());
		ps.setString(3, dto.getTitle());
		ps.setString(4, dto.getWriter());
		ps.setString(5, dto.getContent());
		if(dto.getGroupno()==0) {//새글
			ps.setInt(6, dto.getNo());
			ps.setNull(7, Types.INTEGER);
			ps.setInt(8, 0);
		}
		else {//답글
			ps.setInt(6, dto.getGroupno());
			ps.setInt(7, dto.getSuperno());
			ps.setInt(8, dto.getDepth()+1);
		}
		ps.execute();

		con.close();
		System.out.println("글 업로드 완료");

	}

	// 시퀀스 생성명령
	public int getSequence() throws Exception {
		Connection con = getConnection();

		String sql = "select board_seq.nextval from dual";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		rs.next();
		int seq = rs.getInt(1);

		con.close();

		return seq;

	}

	// 단일조회
	public BoardDto get(int no) throws Exception {
		Connection con = getConnection();

		String sql = "select * from board where no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, no);
		ResultSet rs = ps.executeQuery();

		// ResultSet ----> BoardDto 변환
		BoardDto dto;
		if (rs.next()) {
			int no2 = rs.getInt("no");
			String head = rs.getString("head");
			String writer = rs.getString("writer");
			String wdate = rs.getString("wdate");
			String title = rs.getString("title");
			String content = rs.getString("content");
			int readcount = rs.getInt("readcount");
			int replycount = rs.getInt("replycount");
			
			int groupno = rs.getInt("groupno");
			int superno = rs.getInt("superno");
			int depth = rs.getInt("depth");
			dto = new BoardDto(no2, head, title, replycount, writer, wdate, readcount, content, groupno, superno, depth);
		} else {
			dto = null;
		}

		con.close();
		return dto;
	}
//	조회수 증가
	public void cu(int no) throws Exception{
		Connection con = getConnection();
		
		String sql = "update board set readcount= readcount+1 where no=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, no);
		ps.execute();
		
		con.close();
	}
//	삭제메소드
	public void delete(int no) throws Exception{
		Connection con = getConnection();
		
		String sql = "delete board where no=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, no);
		ps.execute();
		
		con.close();
	}
//	수정메소드
	public void edit(BoardDto dto) throws Exception{
		Connection con = getConnection();
		
		String sql = "update board set head=?, title=?, content=? where no=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getHead());
		ps.setString(2, dto.getTitle());
		ps.setString(3, dto.getContent());
		ps.setInt(4, dto.getNo());
		
		ps.execute();
		
		con.close();
	}
	
	//글 개수 구하기
	public int getCount(String type, String keyword) throws Exception{
		Connection con = getConnection();
		
//		String sql = "select count(*) from board";
//		String sql = "select count(*) from board where "+type+" like '%'||?||'%'";
		boolean isSearch=type !=null && keyword !=null;
		
		String sql = "select count(*) from board";
		if(isSearch) {
			sql +=" where "+type+" like '%'||?||'%'";
		}
		
		PreparedStatement ps = con.prepareStatement(sql);
		if(isSearch) {
			ps.setString(1, keyword);
		}
		
		ResultSet rs = ps.executeQuery();
		rs.next();
		int count = rs.getInt(1);
		
		con.close();
		
		return count;
	}
}
