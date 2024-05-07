def solution():
    max_sum = 0
    board = []
    for _ in range(100):
        arr = list(map(int, input().split()))
        sum_row = sum(arr)
        max_sum = max(max_sum, sum_row)
        board.append(arr)
    
    cross_sum = 0
    re_cross_sum = 0

    for col in range(100):
        sum_col = 0
        for row in range(100):
            sum_col += board[row][col]
            if row == col:
                cross_sum += board[row][col]
            elif row == (col - 100):
                re_cross_sum += board[row][col]
        max_sum = max(max_sum, sum_col)
    max_sum = max(max_sum, cross_sum, re_cross_sum)
    
    return max_sum
    
T =10

for _ in range(T):
    test_case = int(input())
    print(f'#{test_case} {solution()}')