import sys
sys.stdin = open("sample_input.txt", "r")

def solve ():
    for si in range(N):
        for sj in range(N):
            for di,dj in ((0, 1), (1, 0), (1, 1), (-1, 1)):
                # 5번 연속된 돌을 찾아야 하니깐
                for mul in range(5):
                    ni, nj = si + di * mul, sj + dj * mul
                    if 0 <= ni < N and 0 <= nj < N and arr[ni][nj] == 'o':
                        pass
                    else:
                        break
                else:
                    return 'YES'
    return 'NO'

T = int(input())
for test_case in range(1, T + 1):
    # 보드판 줄의 길이
    N = int(input())
    # N번 만큼 입렵받는다.
    arr = [input() for _ in range(N)]
    #move = [(0, 1), (1, 0), (1, 1), (-1, 1)]

    ans = solve()
    print(f"#{test_case} {ans}")