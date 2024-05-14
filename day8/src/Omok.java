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
                	// 돌이 있는 좌표를 set에 저장
                	// String을 new String으로 초기화하게 되면 주소값이 달라져 set의 인자를 찾을 수 없게 되므로 ""로 초기화한다.
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
     
    // 현재 위치에서 4방향을 탐색
    public static boolean search(Set<String> set, int x, int y) {
        boolean col = true;
        boolean row = true;
        boolean r = true;
        boolean l = true;
        // 시간복잡도 최적화 : 각 방향마다 i에 맞게 계산하여 가로,세로,우하,좌상 방향으로 돌이 있는지 검색
        // 있어야 하는 좌표를 set에서 검색, 1로 검색이 가능하고, 규칙을 잘 지키면 idx오류를 피할 수 있다.
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
         
        // 한 방향이라도 5개가 된 곳이 있다면 true 반환
        return col || row || r || l;
    }
}