
import java.util.*;
import java.io.*;

/**
 * 자료형 수정 및 탐색
 * @author hyunkook
 * 
 * 영어 문장이라는 제한이 있기 때문에 특정한 특수기호로 치환 시 해당 글자가 검색할 단어라는 것을 마킹할 수 있음
 * String의 replaceAll 메서드를 사용하여 검색어 치환
 * 해당 String의 인덱스를 돌며 해당 char이 지정한 특수기호인지 확인 후 맞으면 답 증가
 */

class TestString
{
	public static void main(String args[]) throws Exception
	{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			br.readLine();
			String query = br.readLine();
			String target = br.readLine();
			
			target = target.replaceAll(query, "*");
			int cnt = 0;
			for (int i = 0; i < target.length(); i++) {
				if (target.charAt(i) == '*') cnt++;
			}
			
			bw.write("#" + test_case + " " + cnt + "\n");
		}
		
		br.close();
		bw.close();
	}
}