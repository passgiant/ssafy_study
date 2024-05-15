
import java.util.*;
import java.io.*;

/**
 * ����
 * @author hyunkook
 *
 * �̹� �˰� �ִ� �� : (A * B) % C == ((A % C) * (B % C)) % C
 * ��̴� �κ� :  A,B,C�� ������ �� �����ϱ� ������, ���ڿ� �и� �̸� �������� ����� �� �������� (A / B) % C�� �Ϸ��� �߾���
 * 			�� ����� �̹� ������������ ���� �и� ��е� �� �ִ� ��츦 ���ֱ� ������ ������ ��� �� ������ ����������� �ʴ� ������ �־���
 * 
 * ���� �˰Ե� �κ� : (A / B) % C�� ���ϴ� ��� - �丣���� ������ -> ���� �����ذ��� ��������, �ŵ����� ��������
 * 
 * 1. �丣���� ������
 * 
 * B�� �Ҽ��̰�, A�� B�� ����������� �ʴ´ٸ�
 * 
 * A^B-1 = 1 mod B (mod�� ���� ���� �ǿ����ڿ� �������� �� ������ ��� ��)
 * 
 * �̹��� ���Ϸ��� �� ���� (A * B^-1) % P �̱� ������, �̹� �˰� �ִ� ������ �и��ϸ�
 * 	�� 1)
 * 		((A % P) * (B^-1 % P)) % P
 * 
 * �� ���ϴ� ��
 * 
 * B^-1�� ���ϱ� ���� �丣���� �������� ���� ���ϸ�
 * B^(P-1) = 1 mod P
 * B * B^(P-2) = 1 mod P
 * B^(P-2) = B^-1 * 1 mod P
 * 
 * B^-1 = B^(P-2) % P�̶�� ���� �����, �̸� �� �� 1���� ġȯ�ϸ�
 * 	�� 2)
 *  	((A % P) * (B^(P-2) % P) % P) -> ((A % P) * (B^(P-2) % P)) % P
 *  
 *  �� ���� ����
 *  
 *  ���� A(����)���� B(�и�)���� �˸´� �������� ���ϸ鼭 ���� P�� ������� �����ϴ� ������ ���� �ʰ��� ����
 *  B�� P-2������ �����ش�.
 *  
 *   -> ������ �κ� : 1234567891�� �����ϰ� �Ǹ� �ð����⵵ ���鿡�� ������ �ʱ� ������ �ٸ� ����� �����ؾ� �ߴµ�, �� ����� �����س��� ����. �̿� �Ʒ��� ���� �ŵ����� ���ϴ� �������� ��� ����
 *   
 * 2. ��������(�ŵ�����)
 * 
 * ��ȭ���� �̿��� ���̳��� ���α׷����� Ǯ� ���� ������, �ŵ������� ������ �� �ִٴ� ������ ���� ������.
 * 
 * C^N = C(N/2) * C(N/2) * if(N % 2 == 1) C else 1;
 * N�� �Ҽ����� Ȯ���ϴ� ������ �ŵ������� �ƴ϶�� ������� �ʴ� �ϳ��� ���� ���� �����̴�.
 * 3 / 2 = 1
 * 3 = 3 / 2 + 3 / 2 + 1
 * ���� N�� �����ϱ� ���ؼ� C^1��ŭ �߰��� �����ִ� ��
 * 
 * �� ���� �ݺ��ϴ� ���� N�� 0�� ������ �����ϴµ�, �� �� 1�� �������ִ� ����Լ��� ����� ������������ �ذ��� �� �ִ�. �ð����⵵ O(logN)���� ������ ����, binarySearch�� ���� ������ �����
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
		   ���� ���� �׽�Ʈ ���̽��� �־����Ƿ�, ������ ó���մϴ�.
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
