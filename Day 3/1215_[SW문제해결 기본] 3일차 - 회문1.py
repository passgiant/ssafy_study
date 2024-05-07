def isValid(arr):
    i = 1
    while i < length // 2:
        if arr[i] != arr[length - i - 1]:
            return False
        i += 1
    return True


def solution():
    cnt = 0
    # 각 행 탐색
    for row in range(8):
        for col in range(8 - length + 1):
            if board[row][col] == board[row][col + length - 1]:
                temp = board[row][col : col + length]
                if isValid(temp):
                    cnt += 1

    # 각 열 탐색
    for col in range(8):
        for row in range(8 - length + 1):
            if board[row][col] == board[row + length - 1][col]:
                temp = []
                for i in range(row, row + length):
                    temp.append(board[i][col])
                if isValid(temp):
                    cnt += 1

    return cnt

T = 10

for test_case in range(1, T + 1):
    length = int(input())
    board = []
    for _ in range(8):
        board.append(list(input()))

    print(f'#{test_case} {solution()}')