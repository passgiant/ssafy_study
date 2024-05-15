
import java.util.*;
import java.io.*;

class PasswordCode
{
	static ArrayList<int[]> numbers = new ArrayList();
	
	public static void main(String args[]) throws Exception
	{
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] zero = {0,0,0,1,1,0,1};
		int[] one = {0,0,1,1,0,0,1};
		int[] two = {0,0,1,0,0,1,1};
		int[] three = {0,1,1,1,1,0,1};
		int[] four = {0,1,0,0,0,1,1};
		int[] five = {0,1,1,0,0,0,1};
		int[] six = {0,1,0,1,1,1,1};
		int[] seven = {0,1,1,1,0,1,1};
		int[] eight = {0,1,1,0,1,1,1};
		int[] nine = {0,0,0,1,0,1,1};
		
		numbers.add(zero);
		numbers.add(one);
		numbers.add(two);
		numbers.add(three);
		numbers.add(four);
		numbers.add(five);
		numbers.add(six);
		numbers.add(seven);
		numbers.add(eight);
		numbers.add(nine);
		
		int T;
		T=Integer.parseInt(br.readLine());
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			String[] info = br.readLine().split(" ");
			
			int x = Integer.parseInt(info[0]);
			int y = Integer.parseInt(info[1]);
			int answer = 0;
			
			String[] board = new String[x];
			
			for (int i = 0; i < x; i++) {
				board[i] = br.readLine();
			}
			
			String line = "";
			for (int i = x - 1; i >= 0; i--) {
				if (!line.isEmpty()) break;
				String searchLine = board[i];
				for (int j = y - 1; j >= 0; j--) {
					if (searchLine.charAt(j) == '1') {
						for (int k = j - 55; k <= j; k++) {
							line += searchLine.charAt(k);
						}
						break;
					}
				}
			}
			
			int[] decryptArr = new int[8];
			for (int i = 0; i < 8; i++) {
				int[] temp = new int[7];
				
				for (int j = 0; j < 7; j++) {
					temp[j] = Integer.parseInt(line.charAt(i * 7 + j) + "");
				}
				
				int num = find(temp);
				decryptArr[i] = num;
			}
			
			int doubleUp = 0;
			int origin = 0;
			for (int i = 1; i <= 8; i++) {
				
				if (i % 2 == 1) {
					doubleUp += decryptArr[i - 1];
				} else {
					origin += decryptArr[i - 1];
				}
			}
			int total = doubleUp * 3 + origin;
			
			if (total % 10 == 0) {
				answer = doubleUp + origin;
			}
			
			bw.write("#" + test_case + " " + answer + "\n");
		}
		
		bw.close();
		br.close();
	}
	
	public static int find(int[] tempArr) {
		for (int idx = 0; idx < numbers.size(); idx++) {
			boolean check = true;
			for (int pattern = 0; pattern < 7; pattern++) {
				if(!check) break;
				check = check && (tempArr[pattern] == numbers.get(idx)[pattern]);
			}
			
			if (check) {
				return idx;
			}
		}
		
		return -1;
	}
}
