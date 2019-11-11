package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Test02_1 {
	public static void main(String[] args) throws IOException, InterruptedException {
//		files/single.txt 에 작성된 내용을 읽어와서 화면에 출력 
//		byte 입력: 출력을 반대로 진행
//		준비물: 대상(file), 통로(FileInputStream)

		File target = new File("files", "single.txt");

		FileInputStream in = new FileInputStream(target);

//		구조: [프로세스]<-[in]<-[target]<-[single.txt]

//		in을 이용한 입력
//		EOF(End Of File) 값인 -1이 나오면 종료
		while (true) {
			int a = in.read();			
			if(a==-1) break;
			System.out.println(a);

//			Thread.sleep(1000);
		}
		in.close();
	}
}