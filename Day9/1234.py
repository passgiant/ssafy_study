import sys
sys.stdin = open("input.txt", "r")

T = 10

for tc in range(1, T + 1):
    # 입력 받을 문자열의 길이, 문자열 입력
    N, lst = input().split()
    # 비밀번호
    pws = []

    for i in lst:
        # i 값이 ans리스트에 마지막 값이랑 다를 떄
        if not pws or pws[-1] != i:
            pws.append(i)
        # i값이 마지막 값이랑 같다면 제거해야한다.
        else:
            pws.pop()
    ans = "".join(pws)
    print(f"#{tc} {ans}")


