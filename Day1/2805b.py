import sys
sys.stdin = open("input.txt", "r")

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    # 농장의 크기
    N = int(input())
    # 농작물 입력
    arr = [list(map(int,input())) for _ in range(N)]
    # 농장의 중간
    M = N // 2
    # 총 농작물 수
    ans = 0
    # 열의 시작점, 열의 끝 초기화
    s = e = M
    for i in range(N):
        for j in range(s, e+1):
            ans += arr[i][j]
            
        if i < M:
            s -= 1
            e += 1
        else:
            s +=1
            e -= 1
    
    print(f'#{test_case} {ans}')