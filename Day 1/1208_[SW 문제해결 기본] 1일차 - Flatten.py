def solution():
    for _ in range(dump):
        max_value = max(arr)
        min_value = min(arr)
        if max_value - min_value <= 1:
            return max_value - min_value
        
        max_idx = arr.index(max_value)
        min_idx = arr.index(min_value)

        arr[max_idx] -= 1
        arr[min_idx] += 1

    return max(arr) - min(arr)

T = 10

for test_case in range(1, T + 1):
    dump = int(input())
    # 0 ~ 100 높이의 박스 개수
    arr = list(map(int, input().split()))
    
    result = solution()
    print(f'#{test_case} {result}')