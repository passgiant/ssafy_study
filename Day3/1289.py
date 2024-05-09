import sys
sys.stdin = open("input.txt", "r")

for tc in range(1, int(input()) +1):
    # 원래 메모리
    mmy = list(map(int, input()))
    # 망가진 메모리
    b_mmy = 0
    # 걸린 횟수
    ans = 0
    # 0000 -> 1101
    for i in mmy:
        if b_mmy != i:
            b_mmy = i
            ans +=1
            
    print(f"#{tc} {ans}")