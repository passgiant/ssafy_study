import sys
sys.stdin = open("input.txt", "r")
# 화문의 길이를 입력받는다.
# 테스트 케이스 횟수는 10
T = 10
for tc in range(1, T+1):
    n = int(input())
    # 평면 글자판은 8x8
    N = 8
    # 8x8 크기의 글자판에 들어갈 문자를 입력받는다.
    arr = [list(input()) for _ in range(N)]
    # 회문의 갯수
    ans = 0

    # 가로 회문 찾기
    for i in range(N):
        for j in range(N - n + 1):
            if arr[i][j:j+n] == arr[i][j:j+n][::-1]:
                ans += 1

    # 세로 회문 찾기
    for j in range(N):
        for i in range(N - n + 1):
            # 열을 슬라이싱하여 문자열을 만든 후 회문인지 확인
            col_string = ''.join(arr[k][j] for k in range(i, i+n))
            if col_string == col_string[::-1]:
                ans += 1       

    print(f"#{tc} {ans}")
