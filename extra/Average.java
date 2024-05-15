import java.util.*;
import java.io.*;

class Average {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			String[] info = br.readLine().split(" ");
			
			double total = 0;
			for (int i = 0; i < info.length; i++) {
				int num = Integer.parseInt(info[i]);
				total += num;
			}
			double origin = total / (double) info.length;
			int exceptUnder = (int) origin;
			int answer = (int) origin;
			
			if (origin - exceptUnder >= 0.5) {
				answer += 1;
			}
			
			bw.write("#" + test_case + " " + answer + "\n");
		}

		bw.close();
		br.close();
	}
}