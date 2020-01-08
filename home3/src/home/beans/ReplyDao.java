package home.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ReplyDao {
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
	
//	댓글등록
	public void replyInsert(ReplyDto dto) throws Exception{
		Connection con = getConnection();
		
		String sql = "insert into reply values(reply_seq.nextval,?,?,?,sysdate)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, dto.getNo());
		ps.setString(2, dto.getRwriter());
		ps.setString(3, dto.getRcontent());
		
		ps.execute();
		
		con.close();
	}
//	댓글 불러오기
	public List<ReplyDto> getreplylist(int no) throws Exception{
		Connection con = getConnection();
		
		String sql = "select*from reply where no = ? order by rno asc";
		PreparedStatement ps = con.prepareStatement(sql);
		List<ReplyDto> list = new ArrayList<ReplyDto>();
		ps.setInt(1, no);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			ReplyDto dto = new ReplyDto();
			dto.setRno(rs.getInt("rno"));
			dto.setRwriter(rs.getString("rwriter"));
			dto.setRcontent(rs.getString("rcontent"));
			dto.setRdate(rs.getString("rdate"));
			
			list.add(dto);
		}
		con.close();
		return list;
	}
//	댓글 불러오기
//	public ReplyDto get(int no) throws Exception {
//		Connection con = getConnection();
//
//		String sql = "select * from reply where no = ?";
//		PreparedStatement ps = con.prepareStatement(sql);
//		ps.setInt(1, no);
//		ResultSet rs = ps.executeQuery();
//		
//		// ResultSet ----> BoardDto 변환
//		ReplyDto dto;
//		if (rs.next()) {
//			int no1 = rs.getInt("no");
//			int rno = rs.getInt("rno");
//			String rwriter = rs.getString("rwriter");
//			String rcontent = rs.getString("rcontent");
//			String rdate = rs.getString("rdate");
//			
//			dto = new ReplyDto(no1,rno,rwriter,rcontent,rdate);
//		} else {
//			dto = null;
//		}
//
//		con.close();
//		return dto;
//	}
//	댓글 삭제
	public void replyDelete(int rno) throws Exception{
		Connection con = getConnection();
		String sql = "delete from reply where rno=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, rno);
		ps.executeQuery();
		
		con.close();
	}
	
}
