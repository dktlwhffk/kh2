package loop;

import java.lang.*;
import java.util.*;
import java.util.*;

public class Test21__1 {
	public static void main(String[] asrg) {
		for (int i = 4; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				System.out.print("●");
			}
			System.out.println();
		}
	}
}