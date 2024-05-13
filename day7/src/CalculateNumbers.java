
import java.util.*;
import java.io.*;

/**
 * 1493. 수의 새로운 연산
 * @author hyunkook
 *
 * 초기 설계 실패
 * 첫 설계 
 * 	1. 길이 1만의 배열을 만들고, 해당 번호의 좌표를 배열에 기록
 * 	2. 좌표 정보를 String에 담아 Map<String, Integer> 자료구조에 집어넣음
 * 	3. 이후 주어진 p,q를 차례로 연산하여 최종값 찾기
 * 
 * -> 오류점
 * 	1. 최대 포인트가 1만이라면, 구해야 하는 좌표는 무조건 1만 이상임
 *  2. 1만과 9999가 만났을 때가 최대값인데, 이 좌표의 결과값을 계산해서 배열을 늘려주는 것은 공간복잡도상 너무 비효율적임
 *  
 * 새 설계
 * 	1. p와 q의 좌표가 더해지면 결과값은 무조건 p와 q 이상인 부분을 도출
 * 	2. 이 점을 활용해서 x, y, n을 임계값으로 하는 find 함수 설계
 * 		a. p,q 중 작은 값에 대한 좌표값 계산
 * 		b. p,q 중 큰 값에 대한 좌표값 계산
 * 		c. 두 좌표의 x,y를 합한 값이 나올 때까지 반복문을 실행시켜 해당 x,y에 대한 결과값 도출
 * 
 *  
 * 패턴을 자세히 분석하여 확실한 논리를 세우는 것에 대한 중요성 인지하고 문제에 접근하기
 */

class CalculateNumbers
{
	public static void main(String args[]) throws Exception
	{
		ArrayList<int[]> scoreArr = new ArrayList();
		ArrayList<ArrayList<Integer>> pointArr = new ArrayList();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T=Integer.parseInt(br.readLine());
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			String[] info = br.readLine().split(" ");
			
			int firstPoint = Integer.parseInt(info[0]);
			int secondPoint = Integer.parseInt(info[1]);
			
			int p = Integer.min(firstPoint, secondPoint);
			int q = Integer.max(firstPoint, secondPoint);
			
			int result = find(p, q);
			
			bw.write("#" + test_case + " " + result + "\n");
		}
		
		bw.close();
		br.close();
	}
	
	public static int find(int p, int q) {
		int size = 1;
		int x = 1;
		int y = 1;
		int n = 1;
		
		boolean findP = false;
		int[] pPoint = new int[2];
		int[] qPoint = new int[2];
		boolean findQ = false;
		
		// p에 대한 좌표값 도출
		while (!findP) {
			while(y <= size) {
				if(n == p) {
					findP = true; break;
				} else {
					n++;
					y++;
					x--;
				}
			}
			
			if (findP) break;
			size += 1;
			x = size;
			y = 1;
		}
		
		pPoint[0] = x;
		pPoint[1] = y;
		
		// q에 대한 좌표값 도출
		while (!findQ) {
			while(y <= size) {
				if(n == q) {
					findQ = true; break;
				} else {
					n++;
					y++;
					x--;
				}
			}
			
			if (findQ) break;
			size += 1;
			x = size;
			y = 1;
		}
		
		qPoint[0] = x;
		qPoint[1] = y;
		
		// p와 q의 x,y 좌표를 더하여 해당 값이 나올 때까지 반복해서 결과 찾기
		while (!(x == pPoint[0] + qPoint[0] && y == pPoint[1] + qPoint[1])) {
			while(y <= size) {
				if(x == pPoint[0] + qPoint[0] && y == pPoint[1] + qPoint[1]) {
					break;
				} else {
					n++;
					y++;
					x--;
				}
			}
			
			if (x == pPoint[0] + qPoint[0] && y == pPoint[1] + qPoint[1]) break;
			
			size += 1;
			x = size;
			y = 1;				
		}
		
		return n;
	}
}
