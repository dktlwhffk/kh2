package api.io.string;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Test03 {
	public static void main(String[] args) throws IOException {
//		FileWriter를 이용한 문자열 출력
		
		File target = new File("files","string2.txt");
		
		FileWriter fw = new FileWriter(target);
		fw.write("가나다라마바사"+'\n');
		fw.write("hello"+'\n');
		fw.write("자바 너무 좋아"+'\n');
		
		fw.close();
	}
}
