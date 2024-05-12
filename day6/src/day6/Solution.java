package day6;

import java.util.*;
import java.io.*;

/**
 * Ǯ�̹��
 * 
 * �ǹ��� ������ ��� ũ�Ⱑ 
 * ���� ���� * 255 
 * �� 2���� �迭 ����
 * 
 * ���� ���̸� ��� ���� ĭ���� ��, �� 2ĭ�� �ǹ� ������ ������ ������ Ȯ��++
 * 
 * �ִ� ����� �� 255 * 1000 * 2 �̹Ƿ� ���ѽð� �ȿ� ������ ���
 * 
 **/

class Solution {
	public static void main(String args[]) throws Exception {
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T;
		T = 10;
		/*
		 * ���� ���� �׽�Ʈ ���̽��� �־����Ƿ�, ������ ó���մϴ�.
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
				 * �����Ʈ
				 * 
				 * field[i][height] && height < 255 
				 * �� ó���� �ۼ�
				 * 
				 * field[i]�� �ִ� �ε����� �ʰ��ϴ��� ���� ��������� �ʱ� ������ �� �ڵ�� indexOutBoundException�� ������ ���ۿ� ����
				 * ������ �ֿ켱������ �����ؾ� �� �κк��� ������ �� ���ؼ� ���ǽ��� �������־�� �Ѵ�.
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