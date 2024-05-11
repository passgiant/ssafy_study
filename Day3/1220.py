import sys
sys.stdin = open("input.txt", "r")

T = 10
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    # 테이블 크기 입력받는다.
    N = int(input())
    # 테이블 안에 숫자 입력
    arr = [list(map(int,input().split())) for _ in range(N)]
    # arr의 각 행을 열로 변환하여 튜플의 리스트로 반환합니다.
    arr_t = list(zip(*arr))
    # 총 교착 수
    ans = 0
    for lst in arr_t:
        # 이전 값 초기화
        prev = 0
        for n in lst:
            if n:
                if n == 2 and prev == 1:
                    ans += 1
                prev = n
    print(f"#{test_case} {ans}")

