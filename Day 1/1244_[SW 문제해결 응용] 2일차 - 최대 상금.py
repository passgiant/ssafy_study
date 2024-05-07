def back_tracking(n):
    global result
    global num_arr
    if n == cnt:
        result = max(result, int("".join(map(str, num_arr))))
        return
    for i in range(length - 1):
        for j in range(i + 1, length):
            num_arr[i], num_arr[j] = num_arr[j], num_arr[i]

            num_str = "".join(map(str, num_arr))

            if (num_str, n) not in visited:
                back_tracking(n+1)
                visited.append((num_str, n))
            
            num_arr[i], num_arr[j] = num_arr[j], num_arr[i]


T = int(input())

for test_case in range(1, T + 1):
    _num, cnt = map(int, input().split())
    num_arr = list(str(_num))
    visited = []
    length = len(num_arr)
    result = 0

    back_tracking(0)

    print(f'#{test_case} {int(result)}')
