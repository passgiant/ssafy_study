import java.util.Scanner;
import java.io.FileInputStream;
// 1209. sum
class Solution
{
    static int[][] arr;
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=10;
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
             
            // 테케를 입력 받기
            int t = sc.nextInt();
             
            arr = new int[100][100];
             
            // 1. 입력 받기
            for(int i=0; i<100; ++i) {
                for(int j=0; j<100; ++j) {
                    arr[i][j] = sc.nextInt();
                }
            }
             
            int ans = Integer.MIN_VALUE; // int 최솟값
            
            // 2. 행과 열의 합들을 구하기
            for(int i=0; i<100; ++i) {
                ans = Math.max(ans, Math.max(calRowSum(i), calColSum(i)));
            }
             
            // 3. 대각선의 합 구하기
            ans = Math.max(ans, Math.max(calDaeSum1(), calDaeSum2()));
             
            System.out.println("#" + test_case + " " + ans);
        }
    }
     
    private static int calRowSum(int row) {
        int ret = 0;
        for(int i=0; i<100; ++i) {
            ret += arr[row][i];
        }
        return ret;
    }
     
     
        private static int calColSum(int col) {
        int ret = 0;
        for(int i=0; i<100; ++i) {
            ret += arr[i][col];
        }
        return ret;
    }
     
    // 왼 위 -> 오른 아래로 향하는 대각선
    private static int calDaeSum1() {
        int ret = 0;
        for(int i=0; i<100; ++i) {
            ret += arr[i][i];
        }
        return ret;
    }
     
     // 오른 위 -> 왼 아래로 향하는 대각선
    private static int calDaeSum2() {
        int ret = 0;
        for(int i=0; i<100; ++i) {
            ret += arr[100 - i - 1][i];
        }
        return ret;
    }
}