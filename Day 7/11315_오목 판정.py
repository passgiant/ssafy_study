def isValid(row, col):
    if 0 <= row < N and 0 <= col < N and board[row][col] == "o":
        return True
    return False

def solution():
    for row in range(N):
        for col in range(N):
            if board[row][col] == "o":
                for i in range(8):
                    matched = 1
                    next_row = row
                    next_col = col

                    while matched <= 5:
                        next_row += d_row[i]
                        next_col += d_col[i]
                        if isValid(next_row, next_col):
                            matched += 1
                        else:
                            break
                
                    if matched == 5:
                        return "YES"
    
    return "NO"
                    

T = int(input())

# 동, 남동, 남, 남서, 서, 북서, 북, 북동
d_row = [0, 1, 1, 1, 0, -1, -1, -1]
d_col = [1, 1, 0, -1, -1, -1, 0, 1]

for test_case in range(1, T + 1):
    N = int(input())

    board = []

    for _ in range(N):
        board.append(input())

    print(f'#{test_case} {solution()}')