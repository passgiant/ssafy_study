import java.util.*;
import java.io.*;

/**
 * 투포인터 기초
 * @author hyunkook
 *
 * 비밀번호에 양 옆이 중복된 비밀번호가 없을 때의 상태가 진짜 비밀번호
 * 
 * 소거된 비밀번호를 -1로 업데이트하여 분간할 수 있도록 하기
 * 암호의 탐색을 끝까지 할 수 있을 때까지 반복
 *		 현재 자리가  -1이 아니라면
 *			다음 인덱스가 -1이 아닐 때까지 탐색
 *			탐색된 값이 현재 인덱스의 값과 같다면
 *			소거 시작, 끝지점 저장
 *				반복
	 *				암호 길이 범위를 넘어가지 않는 선에서 시작,끝점 증감
	 *				두 수가 같다면 소거, 아니라면 소거 함수 종료
	 *			소거작업이 있었다면 root 탐색문을 다시 실행하여 0번째 인덱스부터 위 작업 반복
	 *
 * 소거작업이 모두 끝난 배열을 돌며 -1을 제외한 다른 수를 답 변수에 이어붙이기
 */

class Password {
	final static String err = "NaN";
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T;
		T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			String[] info = br.readLine().split(" ");
			int cnt = Integer.parseInt(info[0]);
			String encrypt = info[1];
			String answer = err;
			
			int[] arr = new int[cnt];
			
			for (int i = 0; i < cnt; i++) {
				arr[i] = Integer.parseInt(encrypt.charAt(i) + "");
			}
			
			while (answer == err) {
				boolean findSame = false;
				for (int i = 0; i < cnt - 1; i++) {
					if (answer != err) break;
					if (arr[i] == -1) continue;
					
					int end = i + 1;
					
					while (arr[end] == -1) {
						end+=1;
						if (end == cnt - 1) break;
					}
					
					if (arr[i] == arr[end]) {
						findSame = true;
						int startIdx = i;
						int endIdx = end;
						
						while (startIdx >= 0 && endIdx < cnt) {
							if (arr[startIdx] == arr[endIdx]) {
								arr[startIdx] = -1;
								arr[endIdx] = -1;
								
								startIdx++;
								endIdx++;
							} else {
								break;
							}
						}
					}
					
					if (findSame) {
						break;
					}
				}
				
				if (!findSame) {
					String temp = "";
					for (int i = 0; i < cnt; i++) {
						if (arr[i] != -1) {
							temp += arr[i];
						}
					}
					
					answer = temp;
				}
			}
			
			bw.write("#" + test_case + " " + answer + "\n");
		}

		bw.close();
		br.close();
	}
}