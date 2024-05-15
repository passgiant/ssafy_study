
import java.util.*;
import java.io.*;

class Battlefield
{
	// 임계자원은 실수로 바뀌지 않도록 final 처리
	final static char up = '^';
	final static char down = 'v';
	final static char left = '<';
	final static char right = '>';
	final static char breakableWall = '*';
	final static char unbreakableWall = '#';
	final static char water = '-';
	final static char field = '.';
	
	public static void main(String args[]) throws Exception
	{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T;
		T=Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			String[] info = br.readLine().split(" ");
			int height = Integer.parseInt(info[0]);
			int width = Integer.parseInt(info[1]);
			char[][] board = new char[height][width];
			
			for (int i = 0; i < height; i++) {
				String line = br.readLine();
				for (int j = 0; j < line.length(); j++) {
					board[i][j] = line.charAt(j);
				}
			}
			int orderCnt = Integer.parseInt(br.readLine());
			String orders = br.readLine();
			
			for (int i = 0; i < orders.length(); i++) {
				if (orders.charAt(i) == 'S') {
					shoot(board);
				} else {
					move(board, orders.charAt(i));
				}
			}
			
			String answer = "#" + test_case + " ";
			for (int i = 0; i < height; i++) {
				String line = "";
				for (int j = 0; j < board[i].length; j++) {
					line += board[i][j];
				}
				line += "\n";
				answer += line;
			}
			
			bw.write(answer);
		}
		
		br.close();
		bw.close();
	}
	
	// 포탄 발사 메서드
	private static void shoot(char[][] board) {
		//탱크의 현 위치
		int[] tankIdx = new int[2];
		// 탱크 방향
		int[] dir = new int[2];
		// 총알의 위치
		int[] bullet = new int[2];
		boolean findTank = false;
		
		// 보드에서 탱크 탐색
		for (int i = 0; i < board.length; i++) {
			// 탱크 발견 시 탐색 종료
			if (findTank) break;
			
			for (int j = 0; j < board[i].length; j++) {
				Character curBoard = isTank(board[i][j]);
				
				// 탱크를 발견했다면 진입
				if(curBoard != null) {
					findTank = true;
					tankIdx[0] = i;
					tankIdx[1] = j;
					
					//현재 탱크의 상태에 따라 포탄 방향 결정
					switch (curBoard) {
						case up : {
							dir[0] = -1;
							dir[1] = 0; break;
						}
						case down : {
							dir[0] = 1;
							dir[1] = 0; break;
						}
						case left : {
							dir[0] = 0;
							dir[1] = -1; break;
						}
						case right : {
							dir[0] = 0;
							dir[1] = 1; break;
						}
					}
					break;
				}
			}
		}
		
		// 총알은 현재 탱크에서부터 시작된다.
		bullet[0] = tankIdx[0];
		bullet[1] = tankIdx[1];
		
		while (true) {
			// 
			bullet[0] = bullet[0] + dir[0];
			bullet[1] = bullet[1] + dir[1];
			int x = bullet[0];
			int y = bullet[1];
			
			
			// 포탄이 밖으로 빠져나가면 종료
			if (x == board.length || x < 0 || y == board[0].length || y < 0) {
				break;
			}
			
			// 포탄이 부술 수 있는 벽을 만나면 배열 업데이트 후 메서드 종료 
			if (board[x][y] == breakableWall) {
				board[x][y] = field; break;
			} 
			// 포탄이 부술 수 없는 벽을 만나면 메서드 종료 
			else if (board[x][y] == unbreakableWall) break;
		}
	}
	
	private static void move(char[][] board, char dirChar) {
		int[] dir = new int[2];
		char tank = '@';
		int[] tankIdx = new int[2];
		boolean findTank = false;
		
		for (int i = 0; i < board.length; i++) {
			if (findTank) break;
			for (int j = 0; j < board[i].length; j++) {
				Character curBoard = isTank(board[i][j]);
				if(curBoard != null) {
					findTank = true;
					tankIdx[0] = i;
					tankIdx[1] = j;
					switch (curBoard) {
						case up : {
							dir[0] = -1;
							dir[1] = 0; break;
						}
						case down : {
							dir[0] = 1;
							dir[1] = 0; break;
						}
						case left : {
							dir[0] = 0;
							dir[1] = -1; break;
						}
						case right : {
							dir[0] = 0;
							dir[1] = 1; break;
						}
					}
					break;
				}
			}
		}
		
		// 탱크를 움직이기로 시도했으면 탱크의 방향은 무조건 바뀌기 때문에 탱크의 현 상태를 미리 파악
		switch (dirChar) {
			case 'U' : {
				tank = up;
				dir = new int[]{-1,0}; break;
			}
			case 'D' : {
				tank = down;
				dir = new int[]{1,0}; break;
			}
			case 'L' : {
				tank = left;
				dir = new int[]{0,-1}; break;
			}
			case 'R' : {
				tank = right;
				dir = new int[]{0,1}; break;
			}
		}
		
		// 만약 탱크가 움직인다면 위치하는 x,y 구하기
		int[] moveResult = new int[] {tankIdx[0] + dir[0], tankIdx[1] + dir[1]};
		int x = moveResult[0];
		int y = moveResult[1];
		
		// 임시로 움직인 탱크의 위치가 부적절할 때 -> 현재 위치에서 탱크의 상태만 업데이트
		if (x == board.length || x < 0 || y == board[0].length || y < 0 || board[x][y] != field) {
			board[tankIdx[0]][tankIdx[1]] = tank;
		} else {
			// 임시로 움직인 탱크의 위치가 적절할 때 -> 현재 위치를 필드로 변경해주고 임시 위치를 탱크로 갱신
			board[tankIdx[0]][tankIdx[1]] = field;
			board[x][y] = tank;
		}
	}
	
	private static Character isTank(char curBoard) {
		// 현재 위치의 기물이 탱크인지 확인
		// 메서드 리턴값을 Character로 지정해서 탱크가 아니면 null 반환할 수 있도록 구성
		// Character와 char의 차이는 원시타입과 래핑 자료형의 차이 -> 잘 모르면 이 키워드로 검색하면 됨
		return curBoard == up || curBoard == down || curBoard == left || curBoard == right ? curBoard : null;
	}
}