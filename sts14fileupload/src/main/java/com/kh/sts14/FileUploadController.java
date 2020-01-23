package com.kh.sts14;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.sts14.service.FileService;
import com.kh.sts14.vo.FileVO;

@Controller
@RequestMapping("/upload")
public class FileUploadController {
	
	@GetMapping("/")
	public String home() {
		return "upload/home";
	}
	
	@PostMapping("/upload1")
	public String upload1(
				@RequestParam String name,
				@RequestParam MultipartFile file
			) throws IllegalStateException, IOException {
		System.out.println("name = "+name);
		System.out.println("file = "+file);
		
		//분석 : 이름, 종류, 크기, 실제데이터
		System.out.println("유무 : " + file.isEmpty());//비어있냐
		System.out.println("name : " + file.getName());//파라미터명
		System.out.println("origin : " + file.getOriginalFilename());//파일명
		System.out.println("size : " + file.getSize());//파일크기
		System.out.println("type : " + file.getContentType());//파일유형
		
		//파일 저장 : 저장을 할 가상의 파일 객체가 필요
		//저장경로 : D:/upload
		File dir = new File("D:/upload");
		dir.mkdirs();//디렉터리 생성

		File target = new File(dir, UUID.randomUUID().toString());
		file.transferTo(target);//파일 저장
		
		return "redirect:./";
	}
	
	//여러개 파일 업로드
	@PostMapping("/upload2")
	public String upload2(
				@RequestParam String name,
				@RequestParam List<MultipartFile> file
			) throws IllegalStateException, IOException {
		
		//저장 위치(D:/upload)에 파일을 저장
		
		File dir = new File("D:/upload");
		dir.mkdirs();//디렉터리 생성
		
		for(MultipartFile mf : file) {
			File target = new File(dir, UUID.randomUUID().toString());
			mf.transferTo(target);//파일 저장
		}
		
		return "redirect:./";
	}
	
	@Autowired
	private FileService fileService;
	
	//위의 경우는 일반데이터와 파일을 개별적으로 수신...
	// - 개수가 많아지면 번거롭다
	@PostMapping("/upload3")
	public String upload3(@ModelAttribute FileVO vo) throws IllegalStateException, IOException {
		fileService.store(vo);
		return "redirect:./";
	}
	
}

