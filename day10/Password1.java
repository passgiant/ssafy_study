import java.util.*;
import java.io.*;

/**
 * ����
 * @author hyunkook
 *
 * �����迭 ArrayList�� ����� �� ��ɸ��� �����͸� �����ϰ� ������ �����͸� �̾���̸鼭 �Ӱ谪 ����
 * ���Լ��� �ڷᱸ�� queue�� ����ؼ� ���� ���ʰ� I�� ������ �̴� ������� ���� �ܼ�ȭ
 * 
 * -> ����� �տ������� ���������� ������Ѿ� �ϱ� ����
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
			// ����� ���� queue
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
				
				// ť�� ������ ��� null�� ��ȯ�ǰų�, ť�� ������ ����� �������� �� ���� ����
				while (queue.peek() != null && !queue.peek().equals("I")) {
					arr.add(queue.poll());
				}
				
				// ����� ������ ����� �ӽ������ϴ� �迭
				ArrayList<String> temp = new ArrayList<>();
				
				for (int i = 0; i < result.size(); i++) {
					// �ش� �ε������� ���� ��, ���� �迭�� ��� �������
					if (i == idx) {
						temp.addAll(arr);
					}
					
					//���� �ε����� ������ ����
					temp.add(result.get(i));
				}
				
				// �ӽ������ص� �迭�� �Ӱ谪 ����
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