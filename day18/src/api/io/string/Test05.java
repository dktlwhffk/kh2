package api.io.string;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Test05 {
	public static void main(String[] args) throws IOException {
//		String2.txt의 내용을 불러오는 코드
//		준비물: 파일, 입력스트림, 버퍼

		File target = new File("files", "string2.txt");

		FileReader fr = new FileReader(target);
		BufferedReader br = new BufferedReader(fr);

		while (true) {
			String n = br.readLine(); // 한줄을 읽는다
			if (n == null)
				break; // 읽은게 없으면 나가세요
			System.out.println(n); // 출력한다 (다른 작업도 가능)
		}
		br.close();
	}
}
