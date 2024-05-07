def solution():
    global price
    mid = N // 2
    for i in range(N):
        price += int(board[mid][i])
    
    
    _idx = 1
    now = mid
    while now >= 0:
        now = mid - _idx
        for i in range(_idx, N - _idx):
            price += int(board[now][i])
    
        _idx += 1

    _idx = 1
    now = mid
    while now < N:
        now = mid + _idx
        for i in range(_idx, N - _idx):
            price += int(board[now][i])

        _idx += 1



T = int(input())

for test_case in range(1, T + 1):
    N = int(input())
    board = []
    for _ in range(N):
        board.append(input())
    
    price = 0
    
    solution()
    print(f'#{test_case} {price}')