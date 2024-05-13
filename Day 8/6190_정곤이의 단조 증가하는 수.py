from collections import deque

def solution():
    global result
    for i in range(N):
        for j in range(i + 1, N):
            multi = str(arr[i] * arr[j])
            if int(multi) > result:
                num = deque(list(multi))
                length = len(num)
                ans = ""
                while True:
                    if length == 1:
                        ans += num.popleft()
                        result = max(result, int(ans))
                        break
                    
                    temp = num.popleft()
                    ans += temp
                    length -= 1
                    
                    if temp > num[0]:
                        break


T = int(input())

for test_case in range(1, T + 1):
    N = int(input())

    arr = list(map(int, input().split()))
    result = -1

    if N == 1:
        if arr[0] < 10:
            result = arr[0]
        else:
            num = deque(list(str(arr[0])))
            length = len(num)
            ans = ""
            while True:
                if length == 1:
                    ans += num.popleft()
                    result = max(result, int(ans))
                    break
                
                temp = num.popleft()
                ans += temp
                length -= 1
                
                if temp > num[0]:
                    break
    else:  
        solution()

    print(f'#{test_case} {result}')