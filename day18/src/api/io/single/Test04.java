package api.io.single;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test04 {
	public static void main(String[] args) throws IOException {
//		byte를 한번에 여러개씩 입/출력
//		-> byte 배열이 준비물(buffer)
		
//		준비물: 파일,스트림,버퍼
		
		File target = new File("files","many.txt");
		FileOutputStream out = new FileOutputStream(target);
		
		byte[]buffer = new byte[] {104,101,108,108,111,10};
		
		out.write(buffer); //배열을 통째로 출력
		out.write(buffer,0,4); //배열의 0번째부터 4개를 출력
		
		out.close();
	}
}
