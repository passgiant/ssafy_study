import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T;
		T = Integer.parseInt(br.readLine());		
		
		for (int test_case = 1; test_case <= T; test_case++) {
			byte[] answer = Base64.getDecoder().decode(br.readLine());
			bw.write("#" + test_case + " " + new String(answer) + "\n");
		}

		bw.close();
		br.close();
	}
}