import sys
sys.stdin = open("input.txt", "r")

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    # 농장의 크기
    N = int(input())
    # 농장의 중간
    M = N // 2
    # 총 농작물 수
    ans = 0
    # 농작물 입력
    arr = [list(map(int,input())) for _ in range(N)]
    # 농작물 수확
    for i in range(N):
        if i <=M:
            for j in range(M-i, M+i+1):
                # 총 농작물 수에 누적
                ans += arr[i][j]
        else:
            for j in range(i-M, N-(i-M)):
                # 총 농작물 수에 누적
                ans += arr[i][j]
    print(f'#{test_case} {ans}')