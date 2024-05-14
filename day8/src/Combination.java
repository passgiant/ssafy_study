
import java.util.*;
import java.io.*;

/**
 * 조합
 * @author hyunkook
 *
 * 이미 알고 있던 것 : (A * B) % C == ((A % C) * (B % C)) % C
 * 헤맸던 부분 :  A,B,C가 정수일 때 가능하기 때문에, 분자와 분모를 미리 나눠가며 계산한 후 마지막에 (A / B) % C를 하려고 했었음
 * 			위 방법은 이미 나누어져버린 수와 분모가 약분될 수 있는 경우를 없애기 때문에 마지막 계산 시 정수로 나누어떨어지지 않는 문제가 있었음
 * 
 * 새로 알게된 부분 : (A / B) % C를 구하는 방법 - 페르마의 소정리 -> 직접 증명해가며 이해했음, 거듭제곱 분할정복
 * 
 * 1. 페르마의 소정리
 * 
 * B가 소수이고, A가 B에 나누어떨어지지 않는다면
 * 
 * A^B-1 = 1 mod B (mod의 뜻은 뒤의 피연산자와 나누었을 때 나머지 라는 뜻)
 * 
 * 이번에 구하려고 한 식은 (A * B^-1) % P 이기 때문에, 이미 알고 있던 원리로 분리하면
 * 	식 1)
 * 		((A % P) * (B^-1 % P)) % P
 * 
 * 을 구하는 것
 * 
 * B^-1을 구하기 위해 페르마의 소정리를 통해 구하면
 * B^(P-1) = 1 mod P
 * B * B^(P-2) = 1 mod P
 * B^(P-2) = B^-1 * 1 mod P
 * 
 * B^-1 = B^(P-2) % P이라는 식을 얻었고, 이를 위 식 1에서 치환하면
 * 	식 2)
 *  	((A % P) * (B^(P-2) % P) % P) -> ((A % P) * (B^(P-2) % P)) % P
 *  
 *  로 정리 가능
 *  
 *  따라서 A(분자)값과 B(분모)값을 알맞는 구간까지 곱하면서 몫을 P로 나누어가며 저장하는 것으로 범위 초과를 막고
 *  B의 P-2제곱을 구해준다.
 *  
 *   -> 막혔던 부분 : 1234567891번 연산하게 되면 시간복잡도 측면에서 무조건 늦기 때문에 다른 방법을 생각해야 했는데, 이 방법을 생각해내지 못함. 이에 아래와 같이 거듭제곱 구하는 분할정복 방법 공부
 *   
 * 2. 분할정복(거듭제곱)
 * 
 * 점화식을 이용한 다이나믹 프로그래밍을 풀어본 적이 있지만, 거듭제곱을 분할할 수 있다는 생각을 하지 못했음.
 * 
 * C^N = C(N/2) * C(N/2) * if(N % 2 == 1) C else 1;
 * N이 소수인지 확인하는 이유는 거듭제곱이 아니라면 계산하지 않는 하나의 수가 남기 때문이다.
 * 3 / 2 = 1
 * 3 = 3 / 2 + 3 / 2 + 1
 * 따라서 N을 만족하기 위해서 C^1만큼 추가로 곱해주는 것
 * 
 * 이 식을 반복하다 보면 N이 0인 지점에 도달하는데, 이 때 1을 리턴해주는 재귀함수를 사용한 분할정복으로 해결할 수 있다. 시간복잡도 O(logN)으로 굉장히 빠름, binarySearch가 빠른 원리와 비슷함
 */

class Combination
{
	final static long p = 1234567891;
	public static void main(String args[]) throws Exception
	{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T;
		T= Integer.parseInt(br.readLine());
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			String[] info = br.readLine().split(" ");
			int n = Integer.parseInt(info[0]);
			int r = Integer.parseInt(info[1]);
			
			long child = 1;
			long parent = 1;
			
			if (n / 2 < r) {
				r = n - r;
			}
			
			for (int i = 1; i <= r; i++) {
				long curC = n - i + 1;
				long curP = r - i + 1;
				
				child = (child * curC) % p;
				parent = (parent * curP) % p;
			}
			
			parent = calculate(parent, p - 2);
		
			long answer = (child * parent) % p;
			
			
			
			bw.write("#" + test_case + " " + answer + "\n");
		}
		
		br.close();
		bw.close();
	}
	
	public static long calculate(long operand, long top) {
		if (top == 0) {
			return 1;
		} else {
			long result = calculate(operand, top / 2);
			long total = (result * result) % p;
			if (top % 2 == 1) {
				return (total * operand) % p;
			} else {
				return total;
			}
		}
	}
}
