def back_tracking(now_idx, sum):
    global cnt
    
    # 합이 K면 cnt 1 증가시키고 종료
    if sum == K:
        cnt += 1
        return
    # 합이 K보다 커지면 해당 케이스는 불가능 -> 종료
    elif sum > K:
        return

    for i in range(now_idx + 1, N):
        back_tracking(i, sum + arr[i])
        
    

def solution():
    # 경우의 수 cnt
    global cnt

    cnt = 0
    
    # 배열의 각 요소부터 뒤의 요소들을 하나씩 더해보며 합이 어떻게 되는지 판단 -> 백트래킹
    for idx in range(N):
        back_tracking(idx, arr[idx])
    

    return cnt
    
T = int(input())

for test_case in range(1, T + 1):
    N, K = map(int, input().split())
    arr = list(map(int, input().split()))

    print(f'#{test_case} {solution()}')