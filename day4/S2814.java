import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;
// 최장 경로 구하기
class Solution
{
    static int N, M;
    static List<List<Integer>> adj;
    static boolean[] vis;
    static int ans;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            N = sc.nextInt();
            M = sc.nextInt();
            vis = new boolean[N+1];
            
            adj = new ArrayList<>();
            for(int i=0; i<=N; ++i) {
                adj.add(new ArrayList<>());
            }
            
            for(int i=0; i<M; ++i) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                
                adj.get(x).add(y);
                adj.get(y).add(x);
            }
            
            ans = 0;
            for(int i=1; i<=N; ++i) {
                if(vis[i]) continue;
                dfs(i, 1);
            }
            
            System.out.println("#" + test_case + " " + ans);
		}
	}
    
    private static void dfs(int node, int dist) {
        ans = Math.max(ans, dist);
        vis[node] = true;
        
        List<Integer> nexts = adj.get(node);
        for(int next : nexts) {
            if(vis[next]) continue;
            dfs(next, dist+1);
        }
        
        vis[node] = false;
    }
}