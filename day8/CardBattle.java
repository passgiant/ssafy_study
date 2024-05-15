
import java.util.*;
import java.io.*;

/**
 * ����Ž��
 * @author hyunkook
 *
 * ��� ����� ���� Ž���ؼ� ���� �̰���� �˾ƾ� ��
 * ��͸� ���� ���� Ž�� (�ʺ�Ž���� ������� dfs �����ϰ� �; ������)
 * 
 * �Կ��̰� ���� ī�尡 �����̹Ƿ�
 * �ο��̰� �� �Ͽ� ���� ī�忡 ���� ���� ������ �� �� �ִ� ī��Ǯ�� ������Ʈ�ϰ� Ž��
 */

class CardBattle
{
	// dfs �������� �¸� �й� Ƚ���� �Ӱ��ڿ����� �ξ� ������Ʈ�� �� �ֵ��� Ŭ���� �ֻ�ܿ� ��ġ
	static int win = 0;
	static int defeat = 0;
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T;
		T=Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			win = 0;
			defeat = 0;
			ArrayList<Integer> inArr = new ArrayList();
			int[] gyuArr = new int[9];
			
			String[] gyu = br.readLine().split(" ");
			// �ο��̰� ���� ī�带 �ľ��ϱ� ���� ��ü ī�� ����ŭ�� ������ boolean �迭 �����
			boolean[] cardInfo = new boolean[18];
			for (int i = 0; i < gyu.length; i++) {
				// �Կ��̰� ���� ī�� ���ڿ� 1�� �� �ε����� ������ ���̹Ƿ� �湮ó��
				// �Կ��̰� ���� ������ �߿��ϱ� ������ ������� �迭�� ������Ʈ
				int cardNum = Integer.parseInt(gyu[i]) - 1;
				cardInfo[cardNum] = true;
				gyuArr[i] = cardNum + 1;
			}
			
			for (int i = 0; i < cardInfo.length; i++) {
				// ī��Ǯ�� ���� �湮���� ���� �ε����� +1�Ͽ� �ο����� ī��Ǯ�� ������Ʈ
				if (!cardInfo[i]) {
					inArr.add(i + 1);
				}
			}
			
			dfs(gyuArr, inArr, 0, 0);
			
			bw.write("#" + test_case + " " + win + " " + defeat + "\n");
		}
		
		br.close();
		bw.close();
	}
	
	public static void dfs(
			int[] gyuArr, 
			ArrayList<Integer> inRemain, 
			final int gyuScore, 
			final int inScore
	) {
		// �ο��̰� ���� ī�尡 ��� �����Ǿ��ٸ� ������ ���� �� �� �Կ����� �¸� �й� Ƚ�� ������Ʈ
		if (inRemain.isEmpty()) {
			if (gyuScore > inScore) {
				win++;
			} else if (inScore > gyuScore) {
				defeat++;
			}
		} else {
//			Set<Integer> nextSet = new HashSet();
//			int remainTurn = inRemain.size();
			
			for (int i = 0; i < inRemain.size(); i++) {
				ArrayList<Integer> nextArr = new ArrayList();
				for (int j = 0; j < inRemain.size(); j++) {
					if (i != j) {
						nextArr.add(inRemain.get(j));
					}
				}
				int inCard = inRemain.get(i);
				// ���� ���� 9�Ͽ��� �ο��̰� ���ݱ��� ������ �ִ� ī�� ����ŭ ���� �� 1�� ���� �� -> ���� ī�忡�� 1���� ���� ����� ���̱� ������
				// �Կ��� ī���� �ε����� �Ϻ��� 1 �۾ƾ� ��
				int gyuCardIdx = 9 - inRemain.size();
				int gyuCard = gyuArr[gyuCardIdx];
				
				// ī�� ���� ��Ģ�� ���� ���� ������Ʈ �� Ž�� �̾��ϱ�
				if (inCard > gyuCard) {
					int inNewScore = inScore + inCard + gyuCard;
					dfs(gyuArr, nextArr, gyuScore, inNewScore);
				} else {
					int gyuNewScore = gyuScore + inCard + gyuCard;
					dfs(gyuArr, nextArr, gyuNewScore, inScore);
				}
			}
		}
	}
}