package api.io.string;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Test04 {
	public static void main(String[] args) throws IOException {
//		FileWriter+BufferedWriter(외장버퍼)+PrintWriter(엔터생성기)
		
		
		File target = new File("files","string2.txt");
		
		FileWriter fw = new FileWriter(target); //인코딩 + 통로
		BufferedWriter bw = new BufferedWriter(fw); //임시저장
		PrintWriter pw = new PrintWriter(bw); //출력형태를 여러개 제공
		
//		fw.write("가나다라마바사"+'\n');
//		fw.write("hello"+'\n');
//		fw.write("자바 너무 좋아"+'\n');
		pw.println("가나다라마바사");
		pw.println("hello");
		pw.println("자바 너무 좋아");
		
		pw.close();
	}
}
