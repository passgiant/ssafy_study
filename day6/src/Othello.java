

import java.util.*;
import java.io.*;

/**
 * Ǯ�� ����
 * @author hyunkook
 *
 * ����Ž��
 * ���� �� Ž���ؾ� �ϴ� ��,��,��,��,�»�,���,����,���ϸ� ��� Ž���ϸ�
 * 1.�� �ڸ��� ������ �� �ش� ���� Ž�� ����
 * 2.���� ���� ���� ������ �� continue
 * 3.���� ���� ���� �ٸ� ���� ������ �� �ش� ��ġ ��� �� Ž�� ����
 * 
 * �ٸ� ���� ����س��� ������ ���� �� ���̶�� ���� �������� �Ѿ��
 * �׷��� �ʴٸ�
 * 		���� �������� ���⿡ �°� x,y��ǥ �����ϸ� ������ ��ǥ�� �迭�� ����ֱ�
 * 
 * ��� ������ Ž���� �� ������ ��ǥ�� ��ȸ�ϸ� �� �������ֱ�
 * 
 * ��� ������ ���� �� �۾��� ������ �������� ���� �� �� ����
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
		 * ���� ���� �׽�Ʈ ���̽��� �־����Ƿ�, ������ ó���մϴ�.
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
			 * �����Ʈ 1: �ʹ� 4���� ���� �⺻���� �δ� ���� ���ǿ� �־��� �� �������� ���� ������ ��
			 * -> ���ǿ��� �־��� M�� '����'�� ���� �ǹ��ϴ� ������ ���� �ȵ� -> ���� ���ǰ� ���� �� ��Ȯ�ϰ� �м��ϱ�
			 **/
			for (int turn = 1; turn <= cnt; turn++) {
				String[] location = br.readLine().split(" ");
				final int x = Integer.parseInt(location[1]) - 1;
				final int y = Integer.parseInt(location[0]) - 1;
				int p = Integer.parseInt(location[2]);
				int[] cur = {x, y}; 
				// ��ȭ�ؾ� �� ���� �����ϴ� �迭
				// �����Ʈ 2: �� �Ͽ� ���ؾ� �ϴ� ���� ������ �ִµ� �̰��� ���������� Ž���ϸ� �ٲ��ְ� �Ǹ� ���� �� �ξ��� �迭�� ��ȭ�� ���� ����Ǹ� �ȵǴ� ������ �����
				// ���ϴ� ���� ���� �� �� �κ��� ��������, �� �� �ڼ��� �м��ϱ�
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
