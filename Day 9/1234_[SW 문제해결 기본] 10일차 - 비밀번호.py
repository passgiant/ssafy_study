
def solution():
    global num
    stack = []
    div = 10**(N - 1)
    for idx in range(N):
        now_num = num // div
        num %= div
        div //= 10

        if stack:
            if stack[-1] == now_num:
                stack.pop()
                continue

        stack.append(now_num)

    result = 0

    length = len(stack)
    for i in range(1, length + 1):
        result += stack[i - 1] * 10**(length - i)

    return result

T = 10

for t in range(1, T+1):
    N, num = map(int, input().split())
    print(f'#{t} {solution()}')