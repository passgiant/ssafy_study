def isValid(row, col, i, color):
    global replace
    # 보드 범위 밖이라면 빈 배열 리턴
    if row + d_row[i] >= N or row + d_row[i] < 0 or  col + d_col[i] >= N or col + d_col[i] < 0:
        replace = []
        return 
    # 탐색하는 좌표가 빈 공간이면 빈 배열 리턴
    elif board[row + d_row[i]][col + d_col[i]] == 0:
        replace = []
        return 
    # 탐색하는 좌표가 다른 색상이면 계속 탐색하며 replace에 추가
    elif board[row + d_row[i]][col + d_col[i]] != color:
        replace.append([row + d_row[i], col + d_col[i]])
        while True:
            row += d_row[i]
            col += d_col[i]
            if row + d_row[i] >= N or row + d_row[i] < 0 or col + d_col[i] >= N or col + d_col[i] < 0:
                replace = []
                break
            elif board[row + d_row[i]][col + d_col[i]] == 0:
                replace = []
                break
            elif board[row + d_row[i]][col + d_col[i]] != color:
                replace.append([row + d_row[i], col + d_col[i]])
            elif board[row + d_row[i]][col + d_col[i]] == color:
                break
            else:
                replace = []
                break
        return
    # 탐색하는 좌표가 같은 색상이면 탐색 종료, replace 리턴
    else:
        return 

        

def solution():
    global replace

    for _ in range(M):
        row, col, color = map(int, input().split())
        # 2차원 배열 인덱스는 0부터 시작하기에 각 행과 열 번호를 1씩 차감
        row -= 1
        col -= 1

        # 위치에 돌 놓기
        board[row][col] = color
        
        for i in range(8):
            replace = []
            isValid(row, col, i, color)

            # 색 통일시키기
            while replace:
                v = replace.pop()
                board[v[0]][v[1]] = color

    black = 0
    white = 0
    for row in range(N):
        for col in range(N):
            if board[row][col] == 1:
                black += 1
            elif board[row][col] == 2:
                white += 1

    return black, white

T = int(input())

for test_case in range(1, T + 1):
    N, M = map(int, input().split())

    board = [[0 for _ in range(N)] for _ in range(N)]
    # 보드 초기상태 세팅
    board[N // 2 - 1][N // 2 - 1] = 2
    board[N // 2 - 1][N // 2] = 1
    board[N // 2][N // 2 - 1] = 1
    board[N // 2][N // 2] = 2

    # 동, 남동, 남, 남서, 서, 북서, 북, 북동
    d_row = [0, 1, 1, 1, 0, -1, -1, -1]    
    d_col = [1, 1, 0, -1, -1, -1, 0, 1]

    black, white = solution()
    

    print(f'#{test_case} {black} {white}')