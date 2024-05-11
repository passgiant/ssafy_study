import sys
sys.stdin = open("input.txt", "r")

T = 10
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    t = int(input())
    # 배열의 크기
    N = 100
    # 2차원 배열에 담을 숫자 입력받기
    arr = [list(map(int, input().split())) for _ in range(N)]
    # 좌 대각선, 우 대각선 합을 담을 변수 초기화
    s3 = s4 = ans = 0
    for i in range(N):
        s1 = s2 = 0
        for j in range(N):
            # 한 행의 합 초기화
            s1 += arr[i][j]
            # 한 열의 합 초기화
            s2 += arr[j][i]
            # 행, 열 중 최대값 업데이트
            ans = max(ans, s1, s2)
        # 좌 대각선 합 초기화
        s3 += arr[i][i]
        # 우 대각선 합 초기화
        s4 += arr[i][N-i-1]
        ans = max(ans, s3, s4)

    print(f"#{test_case} {ans}")