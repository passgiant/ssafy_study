def solution():
    for row in range(1, N + 1):
        for col in range(1, L + 1):
            if col >= calorie[row]:
                dp[row][col] = max(dp[row - 1][col] , dp[row - 1][col - calorie[row]] + score[row])
            else:
                dp[row][col] = dp[row - 1][col]
    
    return dp[N][L]

T = int(input())

for test_case in range(1, T + 1):
    N, L = map(int,input().split())

    dp = [[0 for _ in range(L + 1)] for _ in range(N + 1)]

    score = [-1]
    calorie = [-1]
    
    for _ in range(N):
        _score, _calorie = map(int, input().split())
        score.append(_score)
        calorie.append(_calorie)


    print(f'#{test_case} {solution()}')