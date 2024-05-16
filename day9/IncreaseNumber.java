import java.util.*;
import java.io.*;

/**
 * 조합
 * @author hyunkook
 *
 * 최대 1000개의 숫자 배열 중 2개를 조합하여 수의 각 자리수가 오름차순인 가장 큰 수를 구하는 문제
 * 
 * 완전탐색 시 최악의 경우 1000C2 = 499500 -> 시간복잡도 내에 해결 가능
 * 
 * 이중 for문을 돌며 현재 인덱스보다 1이 큰 수부터 배열의 끝까지 순회
 * 	(코드에는 없지만 추가하면 좋은 것) 곱한 수가 현재 구한 최대값보다 작으면 continue;
 * 	크다면 -> 숫자를 String으로 변환 후 각 자리 수를 순회하며 다음 인덱스가 현재 인덱스보다 크거나 같은지 체크
 * 			작으면 성립 안되므로 continue;
 * 		위 반복문을 마치고 적합한 수라면 max 값 갱신
 * 
 * 완전탐색 후 기록된 최종값을 정답으로 제출
 */

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