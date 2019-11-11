package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class Test05 {
	public static void main(String[] args) throws IOException {
//		many.txt에 작성된 파일을 버퍼 크기 4로 입력받기
//		준비물: 파일, 스트림, 버퍼
		
		
		File target = new File("files","many.txt");
		FileInputStream in = new FileInputStream(target);
		
		byte[]buffer = new byte[4];
		System.out.println(buffer.length);
		
		while(true) {
			int n=in.read(buffer);
			if(n==-1) break; //EOF
			System.out.println(n);
			System.out.println(Arrays.toString(buffer));
		}
		
		in.close();
	}
}
