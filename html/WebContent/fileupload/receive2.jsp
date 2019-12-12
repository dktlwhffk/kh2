<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//multipart/form-date 방식의 파일을 받기 위한 자바 코드
	//-기존의 request 에서는 더이상 전송데이터를 받을 수 없음
	//-cos.jar 파일에 있는 MultipartRequest 도구를 이용하여 데이터를 수신
	//-MultipartRequest를 만들려면 뭐가 필요한가?
	//-추출대상, 저장경로, 저장용량제한, 인코딩방식
	
	
	String path = "D:/upload/html";//저장위치(폴더)
	
	int max = 10*1024*1024; //최대허용량(10mb)
	
	String encoding = "UTF-8";
	
// 	업로드는 가능하지만 이름 중복 시 덮어쓰기를 수행
// 	MultipartRequest mRequest = 
// 			new MultipartRequest(request, path, max, encoding);

// 	덮어쓰기를 하지 않으려면 "작명 정책"을 만들어야함
	DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
	MultipartRequest mRequest = 
			new MultipartRequest(request, path, max, encoding, policy);
	
// 	전송된 정보를 추출(파일은 이미 저장이 끝난 상태)
// 	-파라미터는 기존과 동일하게 처리
// 	-파일은 다른 명령을 사용함
	String uploader = mRequest.getParameter("uploader");

	File test = mRequest.getFile("test"); //파일 꺼내기 (없으면 null)
	String filename = mRequest.getFilesystemName("test");//업로드된 파일 이름(실제)
	String origin = mRequest.getOriginalFileName("test"); //업로드한 파일 이름(사용자)
	String type = mRequest.getContentType("test"); //업로드한 파일 유형(MIME type)
	
	//파일 크기는 파일이 있을 때만 꺼낼 수 있다.
// 	long filesize = 0 or 실제크기;
	long filesize;
	if(test !=null){
		filesize = test.length();
	}
	else{
		filesize = 0L;
	}
	
%>

<h2>업로드 성공!</h2>
<h2>uploader: <%=uploader %></h2>
<h2>filename: <%=filename %></h2>
<h2>origin: <%=origin %></h2>
<h2>type: <%=type %></h2>
<h2>filesize: <%=filesize %></h2>