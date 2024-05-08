def solution():
    cnt = 0
    board = []
    for _ in range(N):
        board.append(list(map(int, input().split())))
    
    for col in range(N):
        stack = []
        for row in range(N):
            if board[row][col] == 1:
                    stack.append(1)
            
            elif board[row][col] == 2:
                if stack:
                    cnt += 1
                    stack.clear()
    
    return cnt


T = 10

for test_case in range(1, T + 1):
    N = int(input())
    print(f'#{test_case} {solution()}')