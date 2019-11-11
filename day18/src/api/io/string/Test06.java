package api.io.string;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Test06 {
	public static void main(String[] args) throws Exception {

		File target = new File("D:\\", "sample.csv");
//		boolean a = target.exists();
//		System.out.println(a);

		FileReader fr = new FileReader(target);
		BufferedReader br = new BufferedReader(fr);
		String except = br.readLine();
		except = br.readLine();
		int toS;
		int count = 0;
		while (true) {
			String n = br.readLine();
			if (n == null)
				break;
			String[] x = n.split(",");
			
			System.out.println(x[2]);
			toS = Integer.parseInt(x[2]);
			if (!(toS==0)) {
				count++;
			}
		}
		System.out.println("총 연도 개수: "+count);
		br.close();
	}
}
