import java.util.*;
import java.io.*;

class SnailNumber {
	final static int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};
	
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][n];
			boolean[][] visited = new boolean[n][n];
			
			int dirIdx = 0;
			int[] curDir = dir[dirIdx];
			int cnt = 1;
			int[] cur = {0,0};
			arr[0][0] = 1;
			
			while (cnt <= n*n) {
				int x = cur[0];
				int y = cur[1];
				arr[x][y] = cnt;
				visited[x][y] = true;
				
				if(cnt == n*n) break;
				
				if (
						x + dir[dirIdx][0] < 0 ||
						x + dir[dirIdx][0] >= n || 
						y + dir[dirIdx][1] < 0 ||
						y + dir[dirIdx][1] >= n ||
						visited[x + dir[dirIdx][0]][y + dir[dirIdx][1]]
				) {
					dirIdx = (dirIdx + 1) % 4;
				}
				
				cur[0] = x + dir[dirIdx][0];
				cur[1] = y + dir[dirIdx][1];
				
				cnt++;
			}
			
			String answer = "#" + test_case + "\n";
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					answer += arr[i][j] + " ";
				}
				answer += "\n";
			}
			
			bw.write(answer);
		}

		bw.close();
		br.close();
	}
} 