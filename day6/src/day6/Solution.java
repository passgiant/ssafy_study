package day6;

import java.util.*;
import java.io.*;

/**
 * 풀이방법
 * 
 * 건물의 정보를 담는 크기가 
 * 가로 길이 * 255 
 * 인 2차원 배열 생성
 * 
 * 가로 길이를 모두 돌며 칸마다 좌, 우 2칸에 건물 정보가 없으면 조망권 확보++
 * 
 * 최대 경우의 수 255 * 1000 * 2 이므로 제한시간 안에 가능한 방법
 * 
 **/

class Solution {
	public static void main(String args[]) throws Exception {
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T;
		T = 10;
		/*
		 * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		 */

		for (int test_case = 1; test_case <= T; test_case++) {
			int size = Integer.parseInt(br.readLine());
			boolean[][] field = new boolean[size][255];
			String[] info = br.readLine().split(" ");
			int answer = 0;
			
			for (int i = 0; i < size; i++) {
				int height = Integer.parseInt(info[i]);
				
				for (int h = 0; h < height; h++) {
					field[i][h] = true;
				}
			}
			
			for (int i = 2; i < size - 2; i++) {
				int height = 0;
				/**
				 * 오답노트
				 * 
				 * field[i][height] && height < 255 
				 * 로 처음에 작성
				 * 
				 * field[i]의 최대 인덱스를 초과하는지 먼저 계산해주지 않기 때문에 위 코드는 indexOutBoundException을 유발할 수밖에 없음
				 * 앞으로 최우선적으로 점검해야 할 부분부터 순서를 잘 정해서 조건식을 설정해주어야 한다.
				 */
				while (height < 255 && field[i][height]) {
					boolean left = !field[i-2][height] && !field[i - 1][height];
					boolean right = !field[i+2][height] && !field[i + 1][height];
					
					if (left && right) {
						answer++;
					}
					height++;
				}
			}
			
			bw.write("#" + test_case + " " + answer + "\n");
		}
		
		bw.close();
		br.close();
	}
}