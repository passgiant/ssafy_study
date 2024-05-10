from collections import deque

def solution():
    arr = list(map(int, input().split()))
    queue = deque(sorted(arr))

    last = queue[-1]
    # 현재 붕어빵 개수
    fish_bread = 0
    # 흐른 시간
    time = 0

    while time <= last:
        if time != 0 and time % M == 0:
            fish_bread += K
        
        now_arrive = []
        while queue:
            if queue[0] == time:
                now_arrive.append(queue.popleft())
            else:
                break
        
        while now_arrive:
            if fish_bread <= 0:
                return "Impossible"
            now_arrive.pop()
            fish_bread -= 1
        
        time += 1
    
    return "Possible"


T = int(input())

for test_case in range(1, T + 1):
    N, M, K = map(int, input().split())

    print(f'#{test_case} {solution()}')
