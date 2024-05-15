
import java.util.*;
import java.io.*;

class Battlefield
{
	// �Ӱ��ڿ��� �Ǽ��� �ٲ��� �ʵ��� final ó��
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
	
	// ��ź �߻� �޼���
	private static void shoot(char[][] board) {
		//��ũ�� �� ��ġ
		int[] tankIdx = new int[2];
		// ��ũ ����
		int[] dir = new int[2];
		// �Ѿ��� ��ġ
		int[] bullet = new int[2];
		boolean findTank = false;
		
		// ���忡�� ��ũ Ž��
		for (int i = 0; i < board.length; i++) {
			// ��ũ �߰� �� Ž�� ����
			if (findTank) break;
			
			for (int j = 0; j < board[i].length; j++) {
				Character curBoard = isTank(board[i][j]);
				
				// ��ũ�� �߰��ߴٸ� ����
				if(curBoard != null) {
					findTank = true;
					tankIdx[0] = i;
					tankIdx[1] = j;
					
					//���� ��ũ�� ���¿� ���� ��ź ���� ����
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
		
		// �Ѿ��� ���� ��ũ�������� ���۵ȴ�.
		bullet[0] = tankIdx[0];
		bullet[1] = tankIdx[1];
		
		while (true) {
			// 
			bullet[0] = bullet[0] + dir[0];
			bullet[1] = bullet[1] + dir[1];
			int x = bullet[0];
			int y = bullet[1];
			
			
			// ��ź�� ������ ���������� ����
			if (x == board.length || x < 0 || y == board[0].length || y < 0) {
				break;
			}
			
			// ��ź�� �μ� �� �ִ� ���� ������ �迭 ������Ʈ �� �޼��� ���� 
			if (board[x][y] == breakableWall) {
				board[x][y] = field; break;
			} 
			// ��ź�� �μ� �� ���� ���� ������ �޼��� ���� 
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
		
		// ��ũ�� �����̱�� �õ������� ��ũ�� ������ ������ �ٲ�� ������ ��ũ�� �� ���¸� �̸� �ľ�
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
		
		// ���� ��ũ�� �����δٸ� ��ġ�ϴ� x,y ���ϱ�
		int[] moveResult = new int[] {tankIdx[0] + dir[0], tankIdx[1] + dir[1]};
		int x = moveResult[0];
		int y = moveResult[1];
		
		// �ӽ÷� ������ ��ũ�� ��ġ�� �������� �� -> ���� ��ġ���� ��ũ�� ���¸� ������Ʈ
		if (x == board.length || x < 0 || y == board[0].length || y < 0 || board[x][y] != field) {
			board[tankIdx[0]][tankIdx[1]] = tank;
		} else {
			// �ӽ÷� ������ ��ũ�� ��ġ�� ������ �� -> ���� ��ġ�� �ʵ�� �������ְ� �ӽ� ��ġ�� ��ũ�� ����
			board[tankIdx[0]][tankIdx[1]] = field;
			board[x][y] = tank;
		}
	}
	
	private static Character isTank(char curBoard) {
		// ���� ��ġ�� �⹰�� ��ũ���� Ȯ��
		// �޼��� ���ϰ��� Character�� �����ؼ� ��ũ�� �ƴϸ� null ��ȯ�� �� �ֵ��� ����
		// Character�� char�� ���̴� ����Ÿ�԰� ���� �ڷ����� ���� -> �� �𸣸� �� Ű����� �˻��ϸ� ��
		return curBoard == up || curBoard == down || curBoard == left || curBoard == right ? curBoard : null;
	}
}