package api.io.multi;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test01 {
	public static void main(String[] args) throws IOException {
//		원시형 데이터 출력
//		-크기가 서로 다르다
//		-분해와 임시저장이 필요하다

		File target = new File("files", "multi.txt");

		FileOutputStream out = new FileOutputStream(target);
		BufferedOutputStream buffer = new BufferedOutputStream(out);
		DataOutputStream data = new DataOutputStream(buffer);

//		구조: 프로세스 ->data->buffer->out->target->multi.txt
		data.writeByte(100); // 100을 byte로 저장
		data.writeChar(100); // 100을 char로 저장
		data.writeInt(100); // 100을 int로 저장
		data.writeDouble(100); // 100을 double로 저장
//		반드시 버퍼에 남은 데이터를 비워서 전송해야함
//		-flush
//		data.flush();
		data.close(); // flush가 포함되어있음
	}
}
