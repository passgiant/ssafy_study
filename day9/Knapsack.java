import java.util.*;
import java.io.*;

/**
 * �������� (���� �˰���)
 * @author hyunkook
 *
 * ì�� �� �ִ� ���԰� K�̰� N(���� w, ��ġ v)��° ���Ǳ��� ì���� ���� �ִ���
 * ���� ���� ������ ���� w�� K���� ũ�ٸ�, N-1��° ���Ǳ��� ì���� ���� �ִ��� �ȴ�. -> 1~N-1���� ��� ì�� �� �ִٴ� ���� �Ͽ� ������ �ִ��̱� ����, N�� �߰��ȴٰ� �ؼ� �޶����� ���� ����.
 * ���� ������ ���� w�� K���� �۰ų� ���ٸ�
 * 		1. N��° ������ ì��� ���� N-1������ ������ ������ �� K-w��ŭ�� ���Ը� ä�� ���� ��ġ �ִ񰪰� v�� ���� ��
 * 		2. N��° ������ ì���� �ʰ� N-1���� ì���� ���� �ִ�
 * 			-> ���� ���Կ��� 1~N-1�� ���� ���� �� N�� ì���� �ʰ� ��ġ�� �ִ����� ���� �� �ִ� ����� ���� ���� �� �ֱ� ����
 * 		1,2�� ���Ͽ� �� ū ��ġ�� N��° ���Ǳ��� ì���� �� ��ġ �ִ��� �ȴ�.
 * 
 * �� ���� ���Ը� ì��� ���� �� ���� ������ ��ġ�� �˾ƾ� �ϱ� ������ ��� ����� ���� ���ϴ� ����Ž������ �����ؾ� �Ѵ�.
 * 0��° ������ ���� 0��ŭ ì���� �� ~ N��° ������ ���� K��ŭ ì���� ���� ��� ���� �� ����� ���� ����
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