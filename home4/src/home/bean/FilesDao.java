package home.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class FilesDao {
	
	//자원접근객체 생성
	private static DataSource source;
	static {
		try {
			Context ctx = new InitialContext();
			source = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		}
		catch(NamingException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws Exception{
		return source.getConnection();
	}

	//저장(파일 저장이 아님을 유의할 것)
	public void insert(FilesDto fdto) throws Exception{
		Connection con = getConnection();
		
		String sql = "insert into files("
							+ "no, origin, uploadname, savename, filetype, filesize) "
							+ "values(files_seq.nextval, ?, ?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, fdto.getOrigin());
		ps.setString(2, fdto.getUploadname());
		ps.setString(3, fdto.getSavename());
		ps.setString(4, fdto.getFiletype());
		ps.setLong(5, fdto.getFilesize());
		ps.execute();
		
		con.close();
	}
	
	//조회 기능
	public List<FilesDto> getList(int origin) throws Exception{
		Connection con = getConnection();
		
		String sql = "select * from files where origin = ? order by no asc";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, origin);
		ResultSet rs = ps.executeQuery();
		
		List<FilesDto> list = new ArrayList<>();
		while(rs.next()) {
			FilesDto fdto = new FilesDto();
			fdto.setNo(rs.getInt("no"));
			fdto.setOrigin(rs.getInt("origin"));
			fdto.setUploadname(rs.getString("uploadname"));
			fdto.setSavename(rs.getString("savename"));
			fdto.setFiletype(rs.getString("filetype"));
			fdto.setFilesize(rs.getLong("filesize"));
			list.add(fdto);
		}
		
		con.close();
		return list;
	}

	//단일조회
	public FilesDto get(int no) throws Exception{
		Connection con = getConnection();
		
		String sql = "select * from files where no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, no);
		ResultSet rs = ps.executeQuery();
		
		FilesDto fdto = null;
		if(rs.next()) {
			fdto = new FilesDto();
			fdto.setNo(rs.getInt("no"));
			fdto.setOrigin(rs.getInt("origin"));
			fdto.setUploadname(rs.getString("uploadname"));
			fdto.setSavename(rs.getString("savename"));
			fdto.setFiletype(rs.getString("filetype"));
			fdto.setFilesize(rs.getLong("filesize"));
		}
		
		con.close();
		return fdto;
	}
}











