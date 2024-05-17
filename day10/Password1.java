import java.util.*;
import java.io.*;

/**
 * 구현
 * @author hyunkook
 *
 * 가변배열 ArrayList를 사용해 각 명령마다 데이터를 삽입하고 나머지 데이터를 이어붙이면서 임계값 갱신
 * 선입선출 자료구조 queue를 사용해서 다음 차례가 I일 때까지 뽑는 방법으로 로직 단순화
 * 
 * -> 명령을 앞에서부터 순차적으로 실행시켜야 하기 때문
 */

class Password1 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T;
		T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			br.readLine();
			String[] origin = br.readLine().split(" ");
			int orderCnt = Integer.parseInt(br.readLine());
			String[] orders = br.readLine().split(" ");
			// 명령을 담을 queue
			Queue<String> queue = new LinkedList();
			ArrayList<String> result = new ArrayList();
			
			for (int i = 0; i < origin.length; i++) {
				result.add(origin[i]);
			}
			
			for (int i = 0; i < orders.length; i++) {
				queue.offer(orders[i]);
			}
			
			while(!queue.isEmpty()) {
				String order = queue.poll();
				int idx = Integer.parseInt(queue.poll());
				int addCnt = Integer.parseInt(queue.poll());
				ArrayList<String> arr = new ArrayList<>();
				
				// 큐의 다음이 없어서 null이 반환되거나, 큐의 다음이 명령의 시작점일 때 추출 종료
				while (queue.peek() != null && !queue.peek().equals("I")) {
					arr.add(queue.poll());
				}
				
				// 명령을 수행한 결과를 임시저장하는 배열
				ArrayList<String> temp = new ArrayList<>();
				
				for (int i = 0; i < result.size(); i++) {
					// 해당 인덱스까지 왔을 때, 삽입 배열을 모두 집어넣음
					if (i == idx) {
						temp.addAll(arr);
					}
					
					//원래 인덱스의 데이터 삽입
					temp.add(result.get(i));
				}
				
				// 임시저장해둔 배열로 임계값 갱신
				result = temp;
			}
			
			String answer = "#" + test_case + " ";
			for (int i = 0; i < 10; i++) {
				answer += result.get(i) + " ";
			}
			
			answer += "\n";
			
			bw.write(answer);
		}

		bw.close();
		br.close();
	}
}