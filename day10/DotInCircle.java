import java.util.*;
import java.io.*;

/**
 * ����
 * @author hyunkook
 * y���� ������ 1��и鿡�� ������ �� �ִ� ���� ���� ���� �� 90���� �����ٴ� ��������
 * ���� �� * 4 + 1 (����0,0 -> y���� �����߱� ������ ��� ��쿡�� ������ ���Ե��� ������ ������ ������ ���Եȴ�. -> �������� 0�� ��, 0*0 + 0*0 >= 0*0 ����)
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
			
			// y���� ������ 1��и��� ��� ���� �� ���ϱ� 
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