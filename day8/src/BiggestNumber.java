
import java.util.*;
import java.io.*;


class BiggestNumber
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T;
		T=Integer.parseInt(br.readLine());
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			br.readLine();
			int max = 0;
			int manyScore = 0;
			String[] info = br.readLine().split(" ");
			int[] scoreBoard = new int[101];
			
			for (int i = 0; i < info.length; i++) {
				int score = Integer.parseInt(info[i]);
				scoreBoard[score] += 1;
			}
			
			for (int idx = 0; idx < scoreBoard.length; idx++) {
				if (scoreBoard[idx] >= manyScore) {
					max = idx;
					manyScore = scoreBoard[idx];
				}
			}
			
			bw.write("#" + test_case + " " + max + "\n");
		}
		
		br.close();
		bw.close();
	}
}