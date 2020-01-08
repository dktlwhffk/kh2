package home.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import home.beans.BoardDao;
import home.beans.BoardDto;
import home.beans.FilesDao;
import home.beans.FilesDto;

@WebServlet(urlPatterns = "/board/write.do")
public class BoardWriteServlet extends HttpServlet{
	@Override
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//multipart/form-data로 전송되는 데이터를 수신하도록 코드를 작성
//		-cos.jar 필요
//		-저장위치: D:/upload/home
//		-용량제한:10mb
//		-인코딩방식: utf-8
		MultipartRequest mRequest = 
				new MultipartRequest
				(req, "D:/upload/home", 10*1024*1024, "utf-8", 
				new DefaultFileRenamePolicy());
		
		
		
		try {
//			[1]수신->[2]등록->[3]이동
			BoardDao dao = new BoardDao();
			BoardDto dto = new BoardDto();
			
//			추가되는 내용
//			답글일 경우에는 파라미터에 no가 추가된다
//			no가 있다면 받아서 해당글의 정보를 불러온 뒤 dto에 설정한다
			
			if(mRequest.getParameter("superno") !=null) {
				int no = Integer.parseInt(mRequest.getParameter("superno"));
				BoardDto target = dao.get(no);
				dto.setSuperno(target.getNo());	//no복사
				dto.setGroupno(target.getGroupno());	//groupno 복사
				dto.setDepth(target.getDepth());	//depth 복사
			}
			
			String id = (String) req.getSession().getAttribute("id");
			String head = mRequest.getParameter("head");
			String title = mRequest.getParameter("title");
			String writer = id;
			String content = mRequest.getParameter("content");
			
			
			int no = dao.getSequence(); 
			dto.setNo(no);
			
			
			dto.setHead(head);
			dto.setTitle(title);
			dto.setWriter(writer);
			dto.setContent(content);
			dao.write(dto);
			
//		게시글 등록을 마친 뒤에 "파일 등록"을 진행
			File file = mRequest.getFile("file");
			if(file !=null) {
				FilesDto fdto = new FilesDto();
				fdto.setOrigin(no); //게시글번호
				fdto.setUploadname(mRequest.getOriginalFileName("file")); //업로드이름
				fdto.setSavename(mRequest.getFilesystemName("file")); //실저장이름
				fdto.setFiletype(mRequest.getContentType("file"));
				fdto.setFilesize(file.length()); //파일크기		
				
				FilesDao fdao = new FilesDao();
				fdao.fileupload(fdto);
			} 

			resp.sendRedirect("content.do?no="+no);
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
