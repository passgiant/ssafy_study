import java.util.*;
import java.io.*;

class IncreaseNumber {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int cnt = Integer.parseInt(br.readLine());
			String[] info = br.readLine().split(" ");
			int[] arr = new int[cnt];
			long answer = -1;
			
			for (int i = 0; i < info.length; i ++) {
				arr[i] = Integer.parseInt(info[i]);
			}
			
			Arrays.sort(arr);
			
			for (int i = arr.length - 1; i >= 1; i--) {				
				for (int  j = i - 1; j >= 0; j--) {
					long result = arr[i] * arr[j];
					String resultStr = Long.toString(result);
					boolean check = true;
					
					for (int k = 1; k < resultStr.length(); k++) {
						if (!check) break;
						
						check = Integer.parseInt(resultStr.charAt(k) + "") >= Integer.parseInt(resultStr.charAt(k-1) + "");
					}
					
					if (check && result > answer) {
						answer = result;
					}
				}
			}
			
			bw.write("#" + test_case + " " + answer + "\n");
		}

		bw.close();
		br.close();
	}
}