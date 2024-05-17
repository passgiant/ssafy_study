import java.util.*;
import java.io.*;

/**
 * ����
 * @author hyunkook
 *
 * �������� ��� ��� �ϴ� ������ �б��Ͽ� �ذ��ϴ� ����
 * ���� ���� �ϼ��� �����Ͽ� ���� �� �ִ� ���� ������ �۰ų� ���� �� ������ ��� ������ ������ ���� �ϼ��� �޶�����.
 * 1. ��ü ���� �ϼ��� ������ �����ϼ����� ���� ��
 * 		�� �ֿ� �ִ��� ���� ���� �� �ִ� �� ã��
 * 2. ��ü ���� �ϼ��� ������ �����ϼ����� ũ�� ��ü ���� �ϼ��� ������ ���� �ϼ��� �������� �� �������� 0�� ��
 * 		�������� ��� ����ϴ� ���� �ϼ��� (��ü �����ϼ�  - ������ ���� �ϼ�) -> ������ �� �ִ� ��𿡼� ������ ��� �����ϴ°��� ���� �ʿ� �ϼ��� �޶����� ����
 * 3. ��ü ���� �ϼ��� ������ �����ϼ����� ũ�� ��ü ���� �ϼ��� ������ ���� �ϼ��� �������� �� �������� 0�� �ƴ� ��
 * 		������ �ϼ���ŭ�� ��� ��� �����Ͽ������� ���� �ٸ��� �̸� ���� ������ �ϼ��� ��� �������� �� ��߸� ���� �� ����
 * 		
 */

class ChangeStudent {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int totalClass = Integer.parseInt(br.readLine());
			String[] timeTable = br.readLine().split(" ");
			int weekClassCnt = 0;
			int answer = 0;
			
			// �����Ͽ� ���� �� �ִ� ���� �� ���ϱ�
			for (int i = 0; i < timeTable.length; i++) {
				if (timeTable[i].equals("1")) {
					weekClassCnt++;
				}
			}
			
			// 1. ��ü ���� �ϼ��� ������ �����ϼ����� ���� ��
			if (totalClass <= weekClassCnt) {
				answer = getExCnt(timeTable, totalClass);
			} 
			// 2. ��ü ���� �ϼ��� ������ �����ϼ����� ũ�� ��ü ���� �ϼ��� ������ ���� �ϼ��� �������� �� �������� 0�� ��
			else if (totalClass % weekClassCnt == 0) {
				answer = ((totalClass - weekClassCnt) / weekClassCnt) * 7 + getExCnt(timeTable, weekClassCnt);
			} 
			// 3. ��ü ���� �ϼ��� ������ �����ϼ����� ũ�� ��ü ���� �ϼ��� ������ ���� �ϼ��� �������� �� �������� 0�� �ƴ� ��
			else {
				answer = (totalClass / weekClassCnt) * 7 + getExCnt(timeTable, totalClass % weekClassCnt);
			}
			
			bw.write("#" + test_case + " " + answer + "\n");
		}

		bw.close();
		br.close();
	}
	
	// ���� �ϼ��� ä�� �� �ִ� ���� ���� �ϼ� ���ϱ�
	public static int getExCnt(String[] timeTable, int remainCnt) {
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < timeTable.length; i++) {
			int tempCnt = 0;
			for (int j = 0; j < timeTable.length; j++) {
				// �˻� ������ ���Ͽ�.. ���� idx�� �Ѿ�� ��� ���� ���������� �˻� idx
				int searchIdx = (i + j) % 7;
				if (timeTable[searchIdx].equals("1")) {
					tempCnt += 1;
				}
				
				if (tempCnt == remainCnt && j + 1 < min) {
					min = j + 1; break;
				}
			}			
		}
		
		return min;
	}
}