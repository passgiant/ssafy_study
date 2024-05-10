import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;
// 1860. 진기의 최고급 붕어빵

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt();
            int M = sc.nextInt();
            int K = sc.nextInt();
            
            int[] times = new int[N];
            for(int i=0; i<N; ++i) {
                times[i] = sc.nextInt();
            }
            
            Arrays.sort(times); // 반드시 정렬 해주어야 합니다
            
            // 사람들에게 붕어빵 나누어주기
            int curB = M; // 현재 가장 먼저 나온 붕어빵이 나온 시간
            int remainB = K; // 현재 남은 붕어빵 개수
            String can = "Possible";
            for(int i=0; i<N; ++i) {
                if(curB <= times[i]) { // 손님이 온 시점 이전에 만든 붕어빵이 있는 경우.
                    remainB--;
                    if(remainB == 0) { // curB시에 만든 붕어빵이 다 팔린 경우
                        curB += M;
                        remainB = K;
                    }
                } else {
                    can = "Impossible";
                    break;
                }
            }
            
            System.out.println("#" + test_case + " " + can);

		}
	}
}