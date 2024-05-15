
import java.util.*;
import java.io.*;

/**
 * 풀이 
 * @author hyunkook
 * 핵심 생각 : 목표값에 도달한 후 남은 카운트가 2로 나누었을 때 0이면 도달 가능, 이 외 경우 도달할 수 없음
 * 두 개의 자리가 바뀌기 때문에 남은 카운트가 홀수라면 두 자리끼리 계속 바꾸기 불가능, 홀수 번 남았을 때 돌아갈 수 있는 방법이 없음
 */

class BestPrice
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T;
		T=sc.nextInt();
		sc.nextLine();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			String[] info = sc.nextLine().split(" ");
			int[] origin = new int[info[0].length()];
			int chance = Integer.parseInt(info[1]);
			ArrayList<Integer> remain = new ArrayList();
			Set<Integer> set = new HashSet();
			boolean isSameNum = false;
			
			for (int i = 0; i < info[0].length(); i++) {
				final int cur = Integer.parseInt(info[0].charAt(i) + "");
				origin[i] = cur;
				if (set.contains(cur)) {
					isSameNum = true;
				} else {
					set.add(cur);
				}
				remain.add(Integer.parseInt(info[0].charAt(i) + ""));
			}
			int answer = 0;
			
			collectAvailable("", remain, set);
			
			ArrayList<Integer> available = new ArrayList();
			
			set.forEach(item -> available.add(item));
			available.sort(null);
			
			for (int i = available.size() - 1; i >= 0; i--) {
				String target = Integer.toString(available.get(i));
				int[] temp = new int[target.length()];
				Set<Integer> dupSet = new HashSet<>();
				for (int j = 0; j < target.length(); j++) {
					int targetNum = Integer.parseInt(target.charAt(j) + "");
					temp[j] = targetNum;
				}
				int[] originTemp = origin.clone();
				int forcedChangeCnt = sort(originTemp, temp);
				
				if (forcedChangeCnt <= chance) {
					if (forcedChangeCnt == chance) {
						answer = available.get(i); break;
					} else {
						if (isSameNum) {
							answer = available.get(i); break;
						} else {
							if ((forcedChangeCnt - chance) % 2 == 0) {
								answer = available.get(i); break;
							}
						}
					}
				}
			}
			
			bw.write("#" + test_case + " " + answer + "\n");
		}
		
		bw.close();
	}
	
	public static void collectAvailable(String made, ArrayList<Integer> remain, Set<Integer> set) {
		if (remain.size() == 0) {
			set.add(Integer.parseInt(made));
		} else {
			for (int i = 0; i < remain.size(); i++) {
				String nextMade = made;
				nextMade += remain.get(i);
				ArrayList<Integer> nextArr = new ArrayList<>();
				for (int j = 0; j < remain.size(); j++) {
					if (i != j) {
						nextArr.add(remain.get(j));						
					}
				}
				
				collectAvailable(nextMade, nextArr, set);
			}
		}
	}
	
	public static int sort(int[] cur, int[] target) {
		int cnt = 0;
		boolean complete = false;
		while (!complete) {
			for (int i = 0; i < cur.length; i++) {
				if (cur[i] == target[i]) {
					if (i == cur.length - 1) {
						complete = true; break;
					}
					continue;
				} else {
					boolean alreadyChange = false;
					ArrayList<Integer> idxs = new ArrayList();
					for (int j = cur.length - 1; j >= 0; j--) {
						if (cur[j] == target[i]) {
							if (cur[i] == target[j]) {
								int temp = cur[j];
								cur[j] = cur[i];
								cur[i] = temp;
								alreadyChange = true;
								break;								
							} else {
								idxs.add(j);								
							}
						}
					}
					
					if (!alreadyChange) {
						int temp = cur[idxs.get(0)];
						cur[idxs.get(0)] = cur[i];
						cur[i] = temp;
					}
					cnt++;
					break;
				}
			}			
		}
		
		return cnt;
	}
}