
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Queue;
import java.util.LinkedList;
// 1225.[S/W 문제해결 기본] 7일차 - 암호생성기

class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int t = sc.nextInt();
            
            // 입력을 받는 부분
            Queue<Integer> q = new LinkedList<>();
            for(int i=0; i<8; ++i) {
                int num = sc.nextInt();
                q.add(num);
            }
            
            // 사이클 시작
            int minus = 1;
            while(true) {
                int cur = q.poll(); // 큐의 맨 앞에 숫자를 뽑습니다.
                if(cur - minus <= 0) {
                    q.add(0); // 큐의 맨 뒤에 넣어줍니다.
                    break;
                }
                
                q.add(cur - minus++); // 큐 맨뒤에 넣어주며, minus를 증가시킵니다.
                if(minus  >= 6) minus = 1;
            }
            
            // 암호를 출력
            System.out.print("#" + test_case + " ");
            while(!q.isEmpty()) {
                System.out.print(q.poll() + " ");
            }
            System.out.println();
            

		}
	}
}