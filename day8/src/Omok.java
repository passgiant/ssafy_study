import java.util.*;
import java.io.*;
 
class Omok {
    public static void main(String args[]) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());
 
        for (int test_case = 1; test_case <= T; test_case++) {
            int lineCnt = Integer.parseInt(br.readLine());
            String[] board = new String[lineCnt];
            Set<String> set = new HashSet();
            Queue<String> queue = new LinkedList();
             
            for (int i = 0; i < lineCnt; i++) {
                board[i] = br.readLine();
            }
            boolean result = false;
             
            for (int i = 0; i < lineCnt; i++) {
                String curLine = board[i];
                for (int j = 0; j < curLine.length(); j++) {
                	// ���� �ִ� ��ǥ�� set�� ����
                	// String�� new String���� �ʱ�ȭ�ϰ� �Ǹ� �ּҰ��� �޶��� set�� ���ڸ� ã�� �� ���� �ǹǷ� ""�� �ʱ�ȭ�Ѵ�.
                    if (board[i].charAt(j) == 'o') {
                        String point = i + "," + j;
                        set.add(point);
                        queue.offer(point);
                    }
                }
            }
             
            while(!queue.isEmpty() && !result) {
                String[] cur = queue.poll().split(",");
                int[] curPoint = {Integer.parseInt(cur[0]), Integer.parseInt(cur[1])};
                 
                result = search(set, curPoint[0], curPoint[1]);
            }
             
            String answer = result ? "YES" : "NO";
             
            bw.write("#" + test_case + " " + answer + "\n");
        }
         
        br.close();
        bw.close();
    }
     
    // ���� ��ġ���� 4������ Ž��
    public static boolean search(Set<String> set, int x, int y) {
        boolean col = true;
        boolean row = true;
        boolean r = true;
        boolean l = true;
        // �ð����⵵ ����ȭ : �� ���⸶�� i�� �°� ����Ͽ� ����,����,����,�»� �������� ���� �ִ��� �˻�
        // �־�� �ϴ� ��ǥ�� set���� �˻�, 1�� �˻��� �����ϰ�, ��Ģ�� �� ��Ű�� idx������ ���� �� �ִ�.
        for (int i = -2; i <= 2; i++) {
            if (row) {
                int searchX = x + i;
                String point = searchX + "," + y; 
                row = row && set.contains(point);               
            }
             
            if (col) {
                int searchY = y + i;
                String point = x + "," + searchY; 
                col = col && set.contains(point);
            }
             
            if (r) {
                int searchX = x + i;
                int searchY = y + i;
                String point = searchX + "," + searchY; 
                r = r && set.contains(point);
            }
             
            if(l) {
                int searchX = x + i;
                int searchY = y - i;
                String point = searchX + "," + searchY; 
                l = l && set.contains(point);
            }
        }
         
        // �� �����̶� 5���� �� ���� �ִٸ� true ��ȯ
        return col || row || r || l;
    }
}