
import java.util.*;
import java.io.*;

/**
 * 완전탐색
 * @author hyunkook
 *
 * 모든 경우의 수를 탐색해서 누가 이겼는지 알아야 함
 * 재귀를 통한 깊이 탐색 (너비탐색도 상관없음 dfs 구현하고 싶어서 선택함)
 * 
 * 규영이가 내는 카드가 고정이므로
 * 인영이가 각 턴에 내는 카드에 따라 다음 순서에 낼 수 있는 카드풀을 업데이트하고 탐색
 */

class CardBattle
{
	// dfs 끝점에서 승리 패배 횟수를 임계자원으로 두어 업데이트할 수 있도록 클래스 최상단에 위치
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
			// 인영이가 가진 카드를 파악하기 위해 전체 카드 수만큼의 길이의 boolean 배열 만들기
			boolean[] cardInfo = new boolean[18];
			for (int i = 0; i < gyu.length; i++) {
				// 규영이가 가진 카드 숫자에 1을 뺀 인덱스가 소유한 것이므로 방문처리
				// 규영이가 내는 순서가 중요하기 때문에 순서대로 배열에 업데이트
				int cardNum = Integer.parseInt(gyu[i]) - 1;
				cardInfo[cardNum] = true;
				gyuArr[i] = cardNum + 1;
			}
			
			for (int i = 0; i < cardInfo.length; i++) {
				// 카드풀을 보며 방문되지 않은 인덱스에 +1하여 인영이의 카드풀에 업데이트
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
		// 인영이가 가진 카드가 모두 소진되었다면 서로의 승점 비교 후 규영이의 승리 패배 횟수 업데이트
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
				// 현재 턴은 9턴에서 인영이가 지금까지 가지고 있던 카드 수만큼 빼준 후 1을 더한 값 -> 남은 카드에서 1장을 빼서 대결할 것이기 때문에
				// 규영이 카드의 인덱스는 턴보다 1 작아야 함
				int gyuCardIdx = 9 - inRemain.size();
				int gyuCard = gyuArr[gyuCardIdx];
				
				// 카드 승패 규칙에 따라 점수 업데이트 후 탐색 이어하기
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