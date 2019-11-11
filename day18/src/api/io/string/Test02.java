package api.io.string;

import java.io.File;
import java.io.FileOutputStream;

public class Test02 {
	public static void main(String[] args) throws Exception {
//		byte방식으로 문자열을 저장
		String text = "파일 입출력 어려워요...진짜에요";
		
//		files/string.txt
		
		File f = new File("files", "string.txt");
		FileOutputStream out = new FileOutputStream(f);
		
//		프로세스 ->out->f->string.txt
		byte[]data=text.getBytes(); //MS949(윈도우니까)
		out.write(data);
		
		out.close();
		
	}
}
