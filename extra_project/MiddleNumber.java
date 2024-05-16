import java.util.*;
import java.io.*;

class MiddleNumber {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T;
		T = Integer.parseInt(br.readLine());
		String[] info = br.readLine().split(" ");
		int[] arr = new int[info.length];
		
		for (int i = 0; i < info.length; i++) {
			int num = Integer.parseInt(info[i]);
			arr[i] = num;
		}
		
		Arrays.sort(arr);
		
		int answer = arr[arr.length / 2];
		
		System.out.println(answer);
		br.close();
	}
}