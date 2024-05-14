import sys
sys.stdin = open("test_input.txt", "r")

T = 10

for test_case in range(1, T + 1):
    # 테스트 케이스의 번호
    t = int(input())
    # 찾을 문자열
    target = input()
    # 입력받을 문자열
    st = input()
    # 찾은 문장에 개수
    ans = 0
    for i in range(len(st)):
        if st[i] ==target[0]:
            if st[i : i + len(target)] == target:
                ans += 1
    print(f"#{t} {ans}")