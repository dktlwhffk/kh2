package api.io.multi;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test02 {
	public static void main(String[] args) throws IOException {

		File target = new File("files", "multi.txt");

		FileInputStream in = new FileInputStream(target);
		BufferedInputStream buffer = new BufferedInputStream(in);
		DataInputStream data = new DataInputStream(buffer);

		char b = data.readChar();
		byte a = data.readByte();
//		data.readByte();
//		data.readChar();
		int c = data.readInt();
//		data.readInt();
		double d = data.readDouble();
//		data.readDouble();

		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);

		data.close();
	}
}
