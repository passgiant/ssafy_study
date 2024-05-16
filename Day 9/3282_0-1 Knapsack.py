
def solution():
    for row in range(1, N + 1):
        for col in range(1, K + 1):
            # 가방 한계 무게보다 현재 물건의 무게가 크면 어떤 경우든 넣지 못함
            if col < v[row]:
                dp[row][col] = dp[row - 1][col]
            else:
                dp[row][col] = max(dp[row - 1][col], dp[row - 1][col - v[row]] + c[row])

    print(dp)
    return dp[N][K]

T = int(input())

for t in range(1, T+1):
    N, K = map(int, input().split())


    dp = [[0 for _ in range(K + 1)] for _ in range(N + 1)]

    # 0번째 인덱스는 더미값
    v = [0]
    c = [0]

    for _ in range(N):
        _v, _c = map(int, input().split())
        v.append(_v)
        c.append(_c)

    print(f'#{t} {solution()}')