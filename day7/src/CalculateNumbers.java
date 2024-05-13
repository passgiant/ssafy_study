
import java.util.*;
import java.io.*;

/**
 * 1493. ���� ���ο� ����
 * @author hyunkook
 *
 * �ʱ� ���� ����
 * ù ���� 
 * 	1. ���� 1���� �迭�� �����, �ش� ��ȣ�� ��ǥ�� �迭�� ���
 * 	2. ��ǥ ������ String�� ��� Map<String, Integer> �ڷᱸ���� �������
 * 	3. ���� �־��� p,q�� ���ʷ� �����Ͽ� ������ ã��
 * 
 * -> ������
 * 	1. �ִ� ����Ʈ�� 1���̶��, ���ؾ� �ϴ� ��ǥ�� ������ 1�� �̻���
 *  2. 1���� 9999�� ������ ���� �ִ밪�ε�, �� ��ǥ�� ������� ����ؼ� �迭�� �÷��ִ� ���� �������⵵�� �ʹ� ��ȿ������
 *  
 * �� ����
 * 	1. p�� q�� ��ǥ�� �������� ������� ������ p�� q �̻��� �κ��� ����
 * 	2. �� ���� Ȱ���ؼ� x, y, n�� �Ӱ谪���� �ϴ� find �Լ� ����
 * 		a. p,q �� ���� ���� ���� ��ǥ�� ���
 * 		b. p,q �� ū ���� ���� ��ǥ�� ���
 * 		c. �� ��ǥ�� x,y�� ���� ���� ���� ������ �ݺ����� ������� �ش� x,y�� ���� ����� ����
 * 
 *  
 * ������ �ڼ��� �м��Ͽ� Ȯ���� ���� ����� �Ϳ� ���� �߿伺 �����ϰ� ������ �����ϱ�
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
		   ���� ���� �׽�Ʈ ���̽��� �־����Ƿ�, ������ ó���մϴ�.
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
		
		// p�� ���� ��ǥ�� ����
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
		
		// q�� ���� ��ǥ�� ����
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
		
		// p�� q�� x,y ��ǥ�� ���Ͽ� �ش� ���� ���� ������ �ݺ��ؼ� ��� ã��
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
