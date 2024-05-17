import java.util.*;
import java.io.*;

/**
 * 구현
 * @author hyunkook
 * y축을 제외한 1사분면에서 존재할 수 있는 점의 수를 구한 후 90도씩 돌린다는 생각으로
 * 구한 수 * 4 + 1 (원점0,0 -> y축을 제외했기 때문에 어떠한 경우에도 원점은 포함되지 않지만 원점은 언제나 포함된다. -> 반지름이 0일 때, 0*0 + 0*0 >= 0*0 성립)
 */

class DotInCircle {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());
			int total = 0;
			
			// y축을 제외한 1사분면의 모든 가능 점 구하기 
			for (int x = 1; x <= n; x++) {
				int y = 0;
				while (x * x + y * y <= n * n) {
					total++;
					y++;
				}
			}
			
			total = total * 4 + 1;
			
			bw.write("#" + test_case + " " + total + "\n");
		}

		bw.close();
		br.close();
	}
}