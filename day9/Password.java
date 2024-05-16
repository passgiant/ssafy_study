import java.util.*;
import java.io.*;

/**
 * 투포인터 기초
 * @author hyunkook
 *
 */

class Password {
	final static String err = "NaN";
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T;
		T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			String[] info = br.readLine().split(" ");
			int cnt = Integer.parseInt(info[0]);
			String encrypt = info[1];
			String answer = err;
			
			int[] arr = new int[cnt];
			
			for (int i = 0; i < cnt; i++) {
				arr[i] = Integer.parseInt(encrypt.charAt(i) + "");
			}
			
			while (answer == err) {
				boolean findSame = false;
				for (int i = 0; i < cnt - 1; i++) {
					if (answer != err) break;
					if (arr[i] == -1) continue;
					
					int end = i + 1;
					
					while (arr[end] == -1) {
						end+=1;
						if (end == cnt - 1) break;
					}
					
					if (arr[i] == arr[end]) {
						findSame = true;
						int startIdx = i;
						int endIdx = end;
						
						while (startIdx >= 0 && endIdx < cnt) {
							if (arr[startIdx] == arr[endIdx]) {
								arr[startIdx] = -1;
								arr[endIdx] = -1;
								
								startIdx++;
								endIdx++;
							} else {
								break;
							}
						}
					}
					
					if (findSame) {
						break;
					}
				}
				
				if (!findSame) {
					String temp = "";
					for (int i = 0; i < cnt; i++) {
						if (arr[i] != -1) {
							temp += arr[i];
						}
					}
					
					answer = temp;
				}
			}
			
			bw.write("#" + test_case + " " + answer + "\n");
		}

		bw.close();
		br.close();
	}
}