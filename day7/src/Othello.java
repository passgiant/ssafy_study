

import java.util.*;
import java.io.*;

/**
 * 풀이 전략
 * @author hyunkook
 *
 * 완전탐색
 * 착수 시 탐색해야 하는 상,하,좌,우,좌상,우상,좌하,우하를 모두 탐색하며
 * 1.빈 자리를 만났을 때 해당 방향 탐색 종료
 * 2.현재 턴의 돌을 만났을 때 continue
 * 3.현재 턴의 돌과 다른 돌을 만났을 때 해당 위치 기록 후 탐색 종료
 * 
 * 다른 돌을 기록해놓는 변수가 변경 전 값이라면 다음 방향으로 넘어가기
 * 그렇지 않다면
 * 		착수 지점부터 방향에 맞게 x,y좌표 증감하며 변경할 좌표를 배열에 집어넣기
 * 
 * 모든 방향을 탐색한 후 변경할 좌표를 순회하며 돌 변경해주기
 * 
 * 모든 착수에 대한 위 작업이 끝나면 보드판을 돌며 돌 수 세기
 */
class Othello {
	final static int b = 1;
	final static int w = 2;
	
	final static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {-1, -1}, {1, 1}, {1, -1}, {-1, 1}};
	
	public static void main(String args[]) throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());
		/*
		 * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		 */

		for (int test_case = 1; test_case <= T; test_case++) {
			String[] info = br.readLine().split(" ");
			int size = Integer.parseInt(info[0]);
			int cnt = Integer.parseInt(info[1]);
			int bTotal = 0;
			int wTotal = 0;
			int[][] board = new int[size][size];
			
			board[size / 2 - 1][size / 2 - 1] = w;
			board[size / 2 - 1][size / 2] = b;
			board[size / 2][size / 2 - 1] = b;
			board[size / 2][size / 2] = w;
			
			/** 
			 * 오답노트 1: 초반 4개의 돌을 기본으로 두는 것을 조건에 주어진 돌 개수에서 빼고 시작한 것
			 * -> 조건에서 주어진 M은 '착수'한 수를 의미하는 것으로 빼면 안됨 -> 문제 조건과 예시 더 정확하게 분석하기
			 **/
			for (int turn = 1; turn <= cnt; turn++) {
				String[] location = br.readLine().split(" ");
				final int x = Integer.parseInt(location[1]) - 1;
				final int y = Integer.parseInt(location[0]) - 1;
				int p = Integer.parseInt(location[2]);
				int[] cur = {x, y}; 
				// 변화해야 할 돌을 저장하는 배열
				// 오답노트 2: 한 턴에 변해야 하는 돌은 정해져 있는데 이것을 순차적으로 탐색하며 바꿔주게 되면 착수 시 두었던 배열에 변화가 생겨 변경되면 안되는 돌까지 변경됨
				// 변하는 조건 세울 때 이 부분을 누락했음, 좀 더 자세히 분석하기
				ArrayList<int[]> changeList = new ArrayList();
				
				for (int i = 0; i < dir.length; i++) {
					int[] endPoint = {x, y};
					int[] result = {-1, -1};
					while (true) {
						endPoint[0] += dir[i][0];
						endPoint[1] += dir[i][1];
						
						if (endPoint[0] >= size || endPoint[0] < 0 || endPoint[1] >= size || endPoint[1] < 0 || board[endPoint[0]][endPoint[1]] == 0) {
							break;
						}
						int enemy = p == w ? b : w;
						
						if (board[endPoint[0]][endPoint[1]] == enemy) continue;
						if (board[endPoint[0]][endPoint[1]] == p) {
							result = endPoint; break;
						}
					}
					
					if (result[0] >= size || result[0] < 0 || result[1] >= size || result[1] < 0) continue;
					
					int[] change = {x, y};
					
					while (!(change[0] == endPoint[0] && change[1] == endPoint[1])) {
						if(board[change[0]][change[1]] != p) {
							int[] addItem = {change[0], change[1]};
							changeList.add(addItem);
						}
						change[0] += dir[i][0];
						change[1] += dir[i][1];
					}
				}
				
				changeList.forEach(item -> board[item[0]][item[1]] = p);
			}
			
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					switch (board[i][j]) {
						case w : {
							wTotal++; break;
						}
						case b : {
							bTotal++; break;
						}
					}
				}
			}
			
			bw.write("#" + test_case + " " + bTotal + " " + wTotal + "\n");
		}
		
		br.close();
		bw.close();
	}
}
