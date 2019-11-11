package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test03 {
	public static void main(String[] args) throws IOException {
//		files/single.txt에 작성된 내용을 files/copy.txt에 복사하세요
		
		File read = new File("files","single.txt");
		File write = new File("files","copy.txt");
		
		FileInputStream in = new FileInputStream(read);
		FileOutputStream out = new FileOutputStream(write);
		int fileByte = 0; 
        // fis.read()가 -1 이면 파일을 다 읽은것
		
        while((fileByte = in.read()) != -1) {
            out.write(fileByte);
        }
        
		in.close();
		out.close();
		
	}
}
