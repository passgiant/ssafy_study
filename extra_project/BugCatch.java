import java.util.*;
import java.io.*;

class BugCatch {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			String[] info = br.readLine().split(" ");
			int n = Integer.parseInt(info[0]);
			int m = Integer.parseInt(info[1]);
			int[][] board = new int[n][n]; 
			
			for (int i = 0; i < n; i++) {
				String[] line = br.readLine().split(" ");
				for (int j = 0; j < n; j++) {
					board[i][j] = Integer.parseInt(line[j]); 
				}
			}
			
			int max = 0;
			
			for (int i = 0; i <= n - m; i++) {
				for (int j = 0; j <= n - m; j++) {
					int curCnt = 0;
					for (int k = i; k < i + m; k++) {
						for (int l = j; l < j + m; l++) {
							curCnt += board[k][l];
						}
					}
					
					if (curCnt > max) {
						max = curCnt;
					}
				}
			}
			
			bw.write("#" + test_case + " " + max + "\n");
		}

		bw.close();
		br.close();
	}
}