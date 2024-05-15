import java.util.*;
import java.io.*;

class Flatten {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T;
		T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int cnt = Integer.parseInt(br.readLine());
			String[] info = br.readLine().split(" ");
			
			int[] arr = new int[100];
			
			for (int i = 0; i < info.length;i++) {
				arr[i] = Integer.parseInt(info[i]);
			}
			
			for (int i = 1; i <= cnt; i++) {
				int min = Integer.MAX_VALUE;
				int max = 0;
				int minIdx = 0;
				int maxIdx = 0;
				
				for (int j = 0; j < arr.length; j++) {
					if (arr[j] > max) {
						max = arr[j];
						maxIdx = j;
					}
					
					if (arr[j] < min) {
						min = arr[j];
						minIdx = j;
					}
				}
				
				arr[minIdx] += 1;
				arr[maxIdx] -= 1;
			}

			int min = Integer.MAX_VALUE;
			int max = 0;
			int minIdx = 0;
			int maxIdx = 0;
			
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] > max) {
					max = arr[j];
					maxIdx = j;
				}
				
				if (arr[j] < min) {
					min = arr[j];
					minIdx = j;
				}
			}
			
			int answer = max - min;
			
			bw.write("#" + test_case + " " + answer + "\n");
		}

		bw.close();
		br.close();
	}
}