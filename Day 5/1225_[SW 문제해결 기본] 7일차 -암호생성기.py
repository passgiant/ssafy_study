from collections import deque

def solution():
    arr = deque(map(int, input().split()))
    
    while True:
        for i in range(1, 6):
            temp = arr.popleft()
            temp -= i
            
            if temp <= 0:
                arr.append(0)
                return arr
            
            arr.append(temp)

T = 10

for _ in range(1, T + 1):
    test_case = int(input())
    result = solution()
    print(f'#{test_case}', end=" ")
    for re in result:
        print(re, end=" ")
    print()