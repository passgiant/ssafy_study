
import java.util.Scanner;

class RepeatFunction
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=10;
		String answer = "";
		/*
		   ���� ���� �׽�Ʈ ���̽��� �־����Ƿ�, ������ ó���մϴ�.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			sc.nextLine();
			String input = sc.nextLine();
			int[] info = new int[2];
			int spaceIdx = -1;
			for (int i = 0; i < input.length(); i++) {
				if (input.charAt(i) == ' ') {
					spaceIdx = i; break;
				}
			}
			
			String first = "";
			String second = "";
			
			for (int i = 0; i < spaceIdx; i++) {
				first += input.charAt(i);
			}
			for (int i = spaceIdx + 1; i < input.length(); i++) {
				second += input.charAt(i);
			}
			info[0] = Integer.parseInt(first);
			info[1] = Integer.parseInt(second);
			
			int operand = info[0];
			int maxCnt = info[1];
			int result = search(operand, maxCnt, 1, 1);
			
			answer += "#" + test_case + " " + result + "\n";
		}
		
		System.out.println(answer);
	}
	
	// ��� ���� ���� : ���� Ƚ���� �ְ�ġ�� �Ѿ ��
	// ���� �Լ��� ���ݱ��� ����� ������� �Ѱ��ְ� Ƚ���� 1 �������Ѽ� �ٽ� �Լ� ����
	public static int search(int operand, int maxCnt, int curCnt, int result) {
		if (maxCnt >= curCnt) {
			return search(operand, maxCnt, curCnt + 1, result * operand);
		} else {
			return result;
		}
	}
}