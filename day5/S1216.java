import java.util.Scanner;
import java.io.FileInputStream;

// 1216. [S/W 문제해결 기본] 3일차 - 회문2
class Solution
{
    public static String[][] arr;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int t = sc.nextInt();
            
            arr = new String[100][100];
            // 입력 받기
            for(int i=0; i<100; ++i) {
                arr[i] = sc.next().split("");
            }
            int ans = 0;
            
            // 행 검사
            for(int row=0; row < 100; ++row) {
                int maxRowPalLength = 0;
                for(int len = 100; len >= 1; --len) {
                    // 슬라이딩 윈도우처럼 검사
                    for(int start = 0; start + len <= 100; ++start) {
                        if(isRowPalindrome(row, start, len)) {
                            maxRowPalLength = len;
                            break;
                        }
                    }
                    
                    if(maxRowPalLength > 0) {
                        break;
                    }
                }
                
                ans = Math.max(ans, maxRowPalLength);
            }
            
            
             // 열 검사
            for(int col=0; col < 100; ++col) {
                int maxColPalLength = 0;
                for(int len = 100; len >= 1; --len) {
                    // 슬라이딩 윈도우처럼 검사
                    for(int start = 0; start + len <= 100; ++start) {
                        if(isColPalindrome(col, start, len)) {
                            maxColPalLength = len;
                            break;
                        }
                    }
                    
                    if(maxColPalLength > 0) {
                        break;
                    }
                }
                
                ans = Math.max(ans, maxColPalLength);
            }
            
            System.out.println("#" + t+ " " + ans);
		}
	}
    
    private static boolean isColPalindrome(int col, int start, int len) {
        // col번 열의 start ~ start + len이 회문인지 검사하기
        for(int i=0; i<len/2; ++i) {
            if(!arr[start + i][col].equals(arr[start + len - i - 1][col])) {
                return false;
            }
        }
        
        return true;
    }
    
    private static boolean isRowPalindrome(int row, int start, int len) {
        // row번 행의 start ~ start + len이 회문인지 검사하기
        for(int i=0; i<len/2; ++i) {
            if(!arr[row][start + i].equals(arr[row][start + len - i  - 1])) {
                return false;
            }
        }
        
        return true;
    }
}