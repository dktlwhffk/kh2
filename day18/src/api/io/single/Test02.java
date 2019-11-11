package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class Test02 {
	public static void main(String[] args) throws IOException {
//		files/single.txt 에 작성된 내용을 읽어와서 화면에 출력 
//		byte 입력: 출력을 반대로 진행
//		준비물: 대상(file), 통로(FileInputStream)
		
		File target = new File("files","single.txt");
		
		FileInputStream in = new FileInputStream(target);
		
//		구조: [프로세스]<-[in]<-[target]<-[single.txt]
		
//		FileReader n = new FileReader("single.txt");

//		n.read();
		
//		in.read();
		for(int i = 0; i<target.length(); i++) {
			int a=in.read();
			System.out.println((char)a);
		}
		
		in.close();
	}
}
