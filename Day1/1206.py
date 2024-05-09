import sys
sys.stdin = open("input.txt", "r")

T = 10
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):

    # 건물의 갯수
    N = int(input())
    # 건물의 높이 0 0 3 5 2 4 9 0 6 4 0 6 0 0
    lst = list(map(int, input().split()))
    # 조망
    v = 0
    for i in range(2, len(lst)-2):
        chk = lst[i]
        while lst[i-2] < chk and lst[i-1] < chk and lst[i+1] < chk and lst[i+2] < chk:
            v += 1
            chk -= 1
    print(f'#{test_case} {v}')
