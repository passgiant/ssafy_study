import java.util.Scanner;
import java.io.FileInputStream;
// 2817. 부분 수열의 합
class Solution
{
    static int N;
    static int K;
    static int[] nums;
    static int ans;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            N = sc.nextInt();
            K = sc.nextInt();
            
            nums = new int[N];
            for(int i=0; i<N; ++i) {
                nums[i] = sc.nextInt();
            }
            
            ans = 0;
            dfs(0, 0);
            System.out.println("#" + test_case + " " + ans);
		}
	}
    
    static void dfs(int depth, int sum) {
        // depth가 N에 닿으면 빠져나가기
        if(depth == N && sum == K) {
            ans++;
            return;
        } else if(depth == N) {
            return;
        }
        
        dfs(depth+1, sum+nums[depth]); // 선택함
        dfs(depth+1, sum); // 선택 안함
    }
}