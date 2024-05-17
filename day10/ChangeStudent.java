import java.util.*;
import java.io.*;

/**
 * 구현
 * @author hyunkook
 *
 * 일주일을 모두 써야 하는 조건을 분기하여 해결하는 문제
 * 남은 수업 일수가 일주일에 들을 수 있는 수업 수보다 작거나 같을 때 수업을 듣기 시작한 지점에 따라 일수가 달라진다.
 * 1. 전체 수업 일수가 일주일 수업일수보다 작을 때
 * 		한 주에 최대한 빨리 들을 수 있는 날 찾기
 * 2. 전체 수업 일수가 일주일 수업일수보다 크고 전체 수업 일수가 일주일 수업 일수로 나누었을 때 나머지가 0일 때
 * 		일주일을 모두 사용하는 수업 일수는 (전체 수업일수  - 일주일 수업 일수) -> 마지막 한 주는 어디에서 수업을 듣기 시작하는가에 따라 필요 일수가 달라지기 때문
 * 3. 전체 수업 일수가 일주일 수업일수보다 크고 전체 수업 일수가 일주일 수업 일수로 나누었을 때 나머지가 0이 아닐 때
 * 		나머지 일수만큼만 어디서 듣기 시작하였는지에 따라 다르고 이를 제한 나머지 일수는 모두 일주일을 다 써야만 들을 수 있음
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
			
			// 일주일에 들을 수 있는 수업 수 구하기
			for (int i = 0; i < timeTable.length; i++) {
				if (timeTable[i].equals("1")) {
					weekClassCnt++;
				}
			}
			
			// 1. 전체 수업 일수가 일주일 수업일수보다 작을 때
			if (totalClass <= weekClassCnt) {
				answer = getExCnt(timeTable, totalClass);
			} 
			// 2. 전체 수업 일수가 일주일 수업일수보다 크고 전체 수업 일수가 일주일 수업 일수로 나누었을 때 나머지가 0일 때
			else if (totalClass % weekClassCnt == 0) {
				answer = ((totalClass - weekClassCnt) / weekClassCnt) * 7 + getExCnt(timeTable, weekClassCnt);
			} 
			// 3. 전체 수업 일수가 일주일 수업일수보다 크고 전체 수업 일수가 일주일 수업 일수로 나누었을 때 나머지가 0이 아닐 때
			else {
				answer = (totalClass / weekClassCnt) * 7 + getExCnt(timeTable, totalClass % weekClassCnt);
			}
			
			bw.write("#" + test_case + " " + answer + "\n");
		}

		bw.close();
		br.close();
	}
	
	// 남은 일수를 채울 수 있는 가장 빠른 일수 구하기
	public static int getExCnt(String[] timeTable, int remainCnt) {
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < timeTable.length; i++) {
			int tempCnt = 0;
			for (int j = 0; j < timeTable.length; j++) {
				// 검색 순서가 토일월.. 같이 idx가 넘어가는 경우 나눈 나머지값이 검색 idx
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