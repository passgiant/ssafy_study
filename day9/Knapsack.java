import java.util.*;
import java.io.*;

/**
 * 분할정복 (냅색 알고리즘)
 * @author hyunkook
 *
 * 챙길 수 있는 무게가 K이고 N(무게 w, 가치 v)번째 물건까지 챙겼을 때의 최댓값은
 * 만약 현재 물건의 무게 w가 K보다 크다면, N-1번째 물건까지 챙겼을 때의 최댓값이 된다. -> 1~N-1까지 모두 챙길 수 있다는 가정 하에 산정된 최댓값이기 때문, N이 추가된다고 해서 달라지는 것이 없다.
 * 현재 물건의 무게 w가 K보다 작거나 같다면
 * 		1. N번째 물건을 챙기기 전인 N-1까지의 물건을 포함할 때 K-w만큼의 무게를 채울 때의 가치 최댓값과 v를 더한 값
 * 		2. N번째 물건을 챙기지 않고 N-1까지 챙겼을 때의 최댓값
 * 			-> 현재 무게에서 1~N-1의 무게 조합 중 N을 챙기지 않고도 가치를 최댓값으로 가질 수 있는 경우의 수가 있을 수 있기 때문
 * 		1,2를 비교하여 더 큰 가치가 N번째 물건까지 챙겼을 때 가치 최댓값이 된다.
 * 
 * 더 많은 무게를 챙기기 위해 더 작은 단위의 가치를 알아야 하기 때문에 모든 경우의 수를 구하는 완전탐색으로 구현해야 한다.
 * 0번째 물건을 무게 0만큼 챙겼을 때 ~ N번째 물건을 무게 K만큼 챙겼을 때를 모두 구한 후 도출된 답을 제출
 */

class Knapsack {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			String[] info = br.readLine().split(" ");
			int itemCnt = Integer.parseInt(info[0]);
			int bagStorage = Integer.parseInt(info[1]);
			
			int[][] dp = new int[itemCnt+1][bagStorage+1];
			int[] itemWeight = new int[itemCnt+1];
			int[] itemValue = new int[itemCnt+1];
			
			for (int i = 1; i <= itemCnt; i++) {
				String[] itemInfo = br.readLine().split(" ");
				int weight = Integer.parseInt(itemInfo[0]);
				int value = Integer.parseInt(itemInfo[1]);
				
				itemWeight[i] = weight;
				itemValue[i] = value;
			}
			
			for (int totalWeight = 1; totalWeight <= bagStorage; totalWeight++) {
				for (int itemIdx = 1; itemIdx <= itemCnt; itemIdx++) {
					int curWeight = itemWeight[itemIdx];
					int curValue = itemValue[itemIdx];
					int beforeValue = dp[itemIdx - 1][totalWeight];
					
					if (totalWeight >= curWeight) {					
						int exceptCurWeightMax = dp[itemIdx - 1][totalWeight - curWeight];
						if (beforeValue < exceptCurWeightMax + curValue) {
							dp[itemIdx][totalWeight] = exceptCurWeightMax + curValue;
						} else {
							dp[itemIdx][totalWeight] = beforeValue;
						}
					} else {
						dp[itemIdx][totalWeight] = beforeValue;
					}
				}
			}
			
			bw.write("#" + test_case + " " + dp[itemCnt][bagStorage] + "\n");
		}

		bw.close();
		br.close();
	}
}