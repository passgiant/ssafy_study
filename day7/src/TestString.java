
import java.util.*;
import java.io.*;

/**
 * �ڷ��� ���� �� Ž��
 * @author hyunkook
 * 
 * ���� �����̶�� ������ �ֱ� ������ Ư���� Ư����ȣ�� ġȯ �� �ش� ���ڰ� �˻��� �ܾ��� ���� ��ŷ�� �� ����
 * String�� replaceAll �޼��带 ����Ͽ� �˻��� ġȯ
 * �ش� String�� �ε����� ���� �ش� char�� ������ Ư����ȣ���� Ȯ�� �� ������ �� ����
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