
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
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
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
	
	// 재귀 종료 조건 : 연산 횟수가 최고치를 넘어갈 때
	// 다음 함수에 지금까지 계산한 결과값을 넘겨주고 횟수를 1 증가시켜서 다시 함수 실행
	public static int search(int operand, int maxCnt, int curCnt, int result) {
		if (maxCnt >= curCnt) {
			return search(operand, maxCnt, curCnt + 1, result * operand);
		} else {
			return result;
		}
	}
}